package com.igeek.meal.service;

import com.igeek.common.utils.DataSourceUtils;
import com.igeek.meal.dao.FoodKindDao;
import com.igeek.meal.entity.FoodKind;

import java.sql.SQLException;
import java.util.List;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/9/009 21:09
 * @Version
 */
public class FoodKindService {
    private FoodKindDao dao = new FoodKindDao();
    public List<FoodKind> findAllFoodKinds(){
        try {
            return dao.selectAll();
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
    public String findKindName(String food_kind_name){
        try {
            return dao.selectValue(food_kind_name);
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
