package com.igeek.meal.dao;

import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;
import org.apache.commons.dbutils.handlers.ScalarHandler;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/7/007 22:58
 * @Version
 */
public class BasicDao<T> {
    private QueryRunner runner = new QueryRunner();
    public Object getSingleValue(Connection conn,String sql,Object...Params) throws SQLException {
        Object value = runner.query(conn,sql,new ScalarHandler<>(),Params);
        return value;
    }
    public T getBean(Connection conn,String sql,Class<T> clazz,Object...Params) throws SQLException {
        T t = runner.query(conn, sql, new BeanHandler<>(clazz), Params);
        return t;
    }
    public List<T> getBeanList(Connection conn,String sql,Class<T> clazz,Object...Params) throws SQLException {
        List<T> list = runner.query(conn,sql,new BeanListHandler<>(clazz),Params);
        return list;
    }
    public int update(Connection conn,String sql,Object...Params) throws SQLException {
        int i = runner.update(conn, sql, Params);
        return i;
    }
}
