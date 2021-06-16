package com.igeek.meal.dao;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.meal.entity.FoodKind;

import java.util.List;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/9/009 20:58
 * @Version
 */
public class FoodKindDao extends BasicDao<FoodKind> implements IDao<FoodKind> {

    @Override
    public FoodKind selectOne(Object... Params) throws Exception {
        return null;
    }

    @Override
    public List<FoodKind> selectAll(Object... Params) throws Exception {
        String sql = "select * from m_food_kind;";
        List<FoodKind> list = this.getBeanList(DataSourceUtils.getConnection(), sql, FoodKind.class, Params);
        return list;
    }

    @Override
    public String selectValue(Object... Params) throws Exception {
        String sql = "select food_kind_name from m_food_kind where food_kind_id=?";
        String value = this.getSingleValue(DataSourceUtils.getConnection(), sql, Params).toString();
        return value;
    }

    @Override
    public int update(Object... Params) throws Exception {
        return 0;
    }

    @Override
    public int delete(String id) throws Exception {
        return 0;
    }

    @Override
    public int insert(FoodKind foodKind) throws Exception {
        return 0;
    }

}
