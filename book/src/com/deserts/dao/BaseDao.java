package com.deserts.dao;

import com.deserts.utils.JdbcUtils;
import org.apache.commons.dbutils.DbUtils;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.lang.reflect.ParameterizedType;
import java.lang.reflect.Type;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @ClassName BaseDao
 * @Description TODO
 * @Author deserts
 * @Date 2020/8/11 18:04
 */
public abstract class BaseDao<T> {
    private QueryRunner runner = new QueryRunner();
    private Class<T> clazz = null;

    public BaseDao() {
        //获取当前BaseDAO的子类继承的父类中的泛型
        Type genericSuperclass = this.getClass().getGenericSuperclass();
        ParameterizedType paramType = (ParameterizedType) genericSuperclass;
        //获取了父类的泛型参数
        Type[] typeArguments = paramType.getActualTypeArguments();
        //泛型的第一个参数
        clazz = (Class<T>) typeArguments[0];
    }

    /**
     * 封装通用的增删改
     * @param sql
     * @param params
     * @return
     */
    public int update(String sql, Object...params){
        Connection conn = JdbcUtils.getConnection();
        int update = 0;
        try {
            update = runner.update(conn, sql, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return update;
    }

    /**
     * 查询单条记录
     * @param sql
     * @param params
     * @return
     */
    public T queryBean(String sql, Object...params){
        Connection conn = JdbcUtils.getConnection();
        BeanHandler<T> handler = new BeanHandler<>(clazz);
        T t = null;
        try {
            t = runner.query(conn, sql, handler, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return t;
    }

    /**
     * 查询多条记录
     * @param sql
     * @param params
     * @return
     */
    public List<T> queryBeanList(String sql, Object...params){
        Connection conn = JdbcUtils.getConnection();
        BeanListHandler<T> handler = new BeanListHandler<>(clazz);
        List<T> tList = null;
        try {
            tList = runner.query(conn, sql, handler, params);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return tList;
    }

    public Object querySingleValue(String sql, Object... param){
        Connection conn = JdbcUtils.getConnection();
        Object query = null;
        ScalarHandler handler = new ScalarHandler();
        try {
            query = runner.query(conn, sql, handler, param);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
        }finally {
            DbUtils.closeQuietly(conn);
        }
        return query;
    }
}
