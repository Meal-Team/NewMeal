package com.igeek.meal.entity;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/8/008 21:17
 * @Version
 */
public class FoodKind {
    private String food_kind_id;
    private String food_kind_name;
    private String food_kind_info;


    public FoodKind() {
    }

    public FoodKind(String food_kind_id, String food_kind_name, String food_kind_info) {
        this.food_kind_id = food_kind_id;
        this.food_kind_name = food_kind_name;
        this.food_kind_info = food_kind_info;
    }

    /**
     * 获取
     * @return food_kind_id
     */
    public String getFood_kind_id() {
        return food_kind_id;
    }

    /**
     * 设置
     * @param food_kind_id
     */
    public void setFood_kind_id(String food_kind_id) {
        this.food_kind_id = food_kind_id;
    }

    /**
     * 获取
     * @return food_kind_name
     */
    public String getFood_kind_name() {
        return food_kind_name;
    }

    /**
     * 设置
     * @param food_kind_name
     */
    public void setFood_kind_name(String food_kind_name) {
        this.food_kind_name = food_kind_name;
    }

    /**
     * 获取
     * @return food_kind_info
     */
    public String getFood_kind_info() {
        return food_kind_info;
    }

    /**
     * 设置
     * @param food_kind_info
     */
    public void setFood_kind_info(String food_kind_info) {
        this.food_kind_info = food_kind_info;
    }

    public String toString() {
        return "FoodKind{food_kind_id = " + food_kind_id + ", food_kind_name = " + food_kind_name + ", food_kind_info = " + food_kind_info + "}";
    }
}
