package com.igeek.meal.dao;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.meal.entity.Food;

import java.util.List;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/7/007 23:17
 * @Version
 */
public class FoodDao extends BasicDao<Food> implements IDao<Food> {

    public List<Food> selectCheap() throws Exception {
        String sql = "select food_id , food_name , food_photo , food_price , food_kind_id , food_info \n" +
                "from m_food \n" +
                "ORDER BY food_price\n" +
                "limit 0,9";
        List<Food> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Food.class);
        return list;
    }

    public List<Food> selectNew() throws Exception {
        String sql = "select food_id , food_name , food_photo , food_price , food_kind_id , food_info \n" +
                "from m_food \n" +
                "ORDER BY food_date\n" +
                "limit 0,9";
        List<Food> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Food.class);
        return list;
    }

    @Override
    public Food selectOne(Object... Params) throws Exception {
        String sql = "select food_id,food_name,food_photo,food_price,food_kind_id\n" +
                "FROM m_food\n" +
                "WHERE food_id=?;";
        Food food = this.getBean(DataSourceUtils.getConnection(), sql, Food.class, Params);
        return food;
    }

    @Override
    public List<Food> selectAll(Object... Params) throws Exception {
        Object food_kind_id = Params[0];
        String sql = "";
        if (food_kind_id==null || food_kind_id.equals("")){
            sql = "SELECT food_id,food_name,food_photo,food_price,food_kind_id\n" +
                    "FROM m_food\n" +
                    "WHERE food_name like CONCAT('%',?,'%') LIMIT ?,12";
            List<Food> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Food.class, Params[1], Params[2]);
            return list;
        }else{
            sql = "SELECT food_id,food_name,food_photo,food_price,food_kind_id\n" +
                    "FROM m_food\n" +
                    "WHERE food_kind_id = ? and food_name like CONCAT('%',?,'%') LIMIT ?,12";
            List<Food> list = this.getBeanList(DataSourceUtils.getConnection(), sql, Food.class, Params);
            return list;
        }
    }

    @Override
    public Long selectValue(Object... Params) throws Exception {
        Object food_kind_id = Params[0];
        String sql = "";
        if (food_kind_id==null || food_kind_id.equals("")){
            sql = "SELECT count(*) FROM m_food WHERE food_name like CONCAT('%',?,'%')";
            Long value = (Long)this.getSingleValue(DataSourceUtils.getConnection(), sql, Params[1]);
            return value;
        }else{
            sql = "SELECT count(*) FROM m_food WHERE food_kind_id = ? and food_name like CONCAT('%',?,'%')";
            Long value = (Long)this.getSingleValue(DataSourceUtils.getConnection(), sql, Params);
            return value;
        }
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
    public int insert(Food food) throws Exception {
        return 0;
    }

}
