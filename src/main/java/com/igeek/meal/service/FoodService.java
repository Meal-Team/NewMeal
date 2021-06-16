package com.igeek.meal.service;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.meal.dao.FoodDao;
import com.igeek.meal.entity.Food;
import com.igeek.meal.vo.PageVo;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/8/008 19:31
 * @Version
 */
public class FoodService {
    private FoodDao dao = new FoodDao();
    public List<Food> findCheapFood(){
        try {
            return dao.selectCheap();
        } catch (Exception e) {
            e.printStackTrace();
        }finally{
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public List<Food> findNewFood(){
        try {
            return dao.selectNew();
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    public PageVo<Food> findFood(String food_kind_id,String food_name,Integer pageNow){
        try {
            int myCounts = dao.selectValue(food_kind_id,food_name).intValue();
            int myPages = (int)(myCounts%12==0?myCounts/12:Math.ceil(myCounts/12.0));
            int begin = (pageNow-1)*12;
            List<Food> list = dao.selectAll(food_kind_id, food_name, begin);
            PageVo<Food> vo = new PageVo<>(pageNow,myCounts,myPages,food_kind_id,food_name,list);
            return vo;
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
    public Food findFoodByFoodId(String food_id){
        try {
            return dao.selectOne(food_id);
        } catch (Exception e) {
            e.printStackTrace();
        }finally {
            try {
                DataSourceUtils.closeConnection();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return null;
    }
}
