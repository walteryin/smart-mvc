package com.smart.core.provider;

import java.io.Serializable;
import java.lang.reflect.Field;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

import javax.persistence.Table;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.smart.core.model.BasePersistent;
import com.smart.core.resovler.TableResolver;
import com.smart.core.resovler.TableResolver.TableColumn;
import com.smart.core.resovler.TableResolver.TableInfo;

/**
 * 动态Sql提供者
 * 
 * @author Joe
 */
public class DynamicSqlProvider {
	
	private static final Logger logger = LoggerFactory.getLogger(DynamicSqlProvider.class);
	
	public static final String ID = "id";
	
	public static final String TABLE_NAME = "@tableName";
	
	public static final String SELECT_COLUMNS = "@selectColumns";
	
	public String get(Serializable id) {
		return new StringBuilder().append("SELECT ").append(SELECT_COLUMNS).append(" FROM ").append(TABLE_NAME)
				.append(" WHERE ").append(ID).append(" = #{").append(ID).append("}").toString();
	}
	
	public String selectByCondition(Map<String, Object> map) {
		return new StringBuilder().append("<script>SELECT ").append(SELECT_COLUMNS).append(" FROM ").append(TABLE_NAME)
				.append(condition()).append("</script>").toString();
	}
	
	public String deleteByCondition(Map<String, Object> map) {
		return new StringBuilder().append("<script>DELETE FROM ").append(TABLE_NAME).append(condition())
				.append("</script>").toString();
	}
	
	public String insert(Object t) {
		TableInfo table = getTable(t.getClass());
		List<TableColumn> notNullColumnList = getNotNullColumnList(t, table.getColumnList());
		return TableResolver.generateInsertSql(table.getTableName(), notNullColumnList);
	}

	private List<TableColumn> getNotNullColumnList(Object t, List<TableColumn> columnList) {
		return columnList.stream().filter(c -> getValueByFieldName(t, c.getField()) != null)
				.collect(Collectors.toList());
	}

	private Object getValueByFieldName(Object object, String fieldName) {
		try {
			Field field = object.getClass().getDeclaredField(fieldName);
			field.setAccessible(true);
			return field.get(object);
		}
		catch (Exception e) {
			logger.error("getValueByFieldName excepiton, Class: {}, fieldName: {}", object.getClass(), fieldName, e);
			return null;
		}
	}
	
	public String update(Object t) {
		return getTable(t.getClass()).getUpdateSql();
	}
	
	private TableInfo getTable(Class<?> clazz) {
		Class<?> modelClass = getModelClass(clazz);
		if (modelClass == null) {
			throw new IllegalArgumentException("非法持久化class:" + clazz);
		}
		return TableResolver.resolve(modelClass);
	}
	
	private Class<?> getModelClass(Class<?> clazz) {
		if (clazz.getAnnotation(Table.class) != null) {
			return clazz;
		}
		Class<?> parent = clazz.getSuperclass();
		if (parent.equals(BasePersistent.class)) {
			return clazz;
		}
		else if (parent.equals(Object.class)) {
			return null;
		}
		else {
			return getModelClass(parent);
		}
	}
	
	private String condition() {
		StringBuilder c = new StringBuilder();
		c.append("<if test=\"condition != null\">");
		c.append("	<if test=\"condition.criteriaList != null\">");
		c.append("		<where>");
		c.append("			<foreach collection=\"condition.criteriaList\" item=\"criteria\">");
		c.append("				<choose>");
		c.append("					<when test=\"criteria.noValue\">");
		c.append("						and ${criteria.label}");
		c.append("					</when>");
		c.append("					<when test=\"criteria.singleValue\">");
		c.append("						and ${criteria.label} #{criteria.value}");
		c.append("					</when>");
		c.append("					<when test=\"criteria.twoValue\">");
		c.append("						and ${criteria.label} #{criteria.value[0]} and #{criteria.value[1]}");
		c.append("					</when>");
		c.append("					<when test=\"criteria.collectionValue\">");
		c.append("						and ${criteria.label} <foreach close=\")\" collection=\"criteria.value\" item=\"item\" open=\"(\" separator=\",\">#{item}</foreach>");
		c.append("					</when>");
		c.append("				</choose>");
		c.append("			</foreach>");
		c.append("		</where>");
		c.append("	</if>");
		c.append("	<if test=\"condition.orderBy != null\">");
		c.append("		ORDER BY ${condition.orderBy}");
		c.append("	</if>");
		c.append("</if>");
		return c.toString();
	}
}
