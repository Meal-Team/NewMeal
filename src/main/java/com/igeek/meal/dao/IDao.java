package com.igeek.meal.dao;

import java.util.List;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/7/007 23:12
 * @Version
 */
public interface IDao<T> {
    T selectOne(Object...Params) throws Exception;
    List<T> selectAll(Object...Params) throws Exception;
    Object selectValue(Object...Params) throws Exception;
    int update(Object...Params) throws Exception;
    int delete(String id) throws Exception;
    int insert(T t) throws Exception;
}
