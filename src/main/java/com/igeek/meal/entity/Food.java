package com.igeek.meal.entity;

import java.util.Date;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/7/007 22:17
 * @Version
 */
public class Food {
    private String food_id;
    private String food_name;
    private String food_info;
    private String food_photo;
    private Double food_price;
    private Integer food_kind_id;
    private Date food_date;
    private Integer food_flag;


    public Food() {
    }

    public Food(String food_id, String food_name, String food_info, String food_photo, Double food_price, Integer food_kind_id, Date food_date, Integer food_flag) {
        this.food_id = food_id;
        this.food_name = food_name;
        this.food_info = food_info;
        this.food_photo = food_photo;
        this.food_price = food_price;
        this.food_kind_id = food_kind_id;
        this.food_date = food_date;
        this.food_flag = food_flag;
    }

    /**
     * 获取
     * @return food_id
     */
    public String getFood_id() {
        return food_id;
    }

    /**
     * 设置
     * @param food_id
     */
    public void setFood_id(String food_id) {
        this.food_id = food_id;
    }

    /**
     * 获取
     * @return food_name
     */
    public String getFood_name() {
        return food_name;
    }

    /**
     * 设置
     * @param food_name
     */
    public void setFood_name(String food_name) {
        this.food_name = food_name;
    }

    /**
     * 获取
     * @return food_info
     */
    public String getFood_info() {
        return food_info;
    }

    /**
     * 设置
     * @param food_info
     */
    public void setFood_info(String food_info) {
        this.food_info = food_info;
    }

    /**
     * 获取
     * @return food_photo
     */
    public String getFood_photo() {
        return food_photo;
    }

    /**
     * 设置
     * @param food_photo
     */
    public void setFood_photo(String food_photo) {
        this.food_photo = food_photo;
    }

    /**
     * 获取
     * @return food_price
     */
    public Double getFood_price() {
        return food_price;
    }

    /**
     * 设置
     * @param food_price
     */
    public void setFood_price(Double food_price) {
        this.food_price = food_price;
    }

    /**
     * 获取
     * @return food_kind_id
     */
    public Integer getFood_kind_id() {
        return food_kind_id;
    }

    /**
     * 设置
     * @param food_kind_id
     */
    public void setFood_kind_id(Integer food_kind_id) {
        this.food_kind_id = food_kind_id;
    }

    /**
     * 获取
     * @return food_date
     */
    public Date getFood_date() {
        return food_date;
    }

    /**
     * 设置
     * @param food_date
     */
    public void setFood_date(Date food_date) {
        this.food_date = food_date;
    }

    /**
     * 获取
     * @return food_flag
     */
    public Integer getFood_flag() {
        return food_flag;
    }

    /**
     * 设置
     * @param food_flag
     */
    public void setFood_flag(Integer food_flag) {
        this.food_flag = food_flag;
    }

    public String toString() {
        return "Food{food_id = " + food_id + ", food_name = " + food_name + ", food_info = " + food_info + ", food_photo = " + food_photo + ", food_price = " + food_price + ", food_kind_id = " + food_kind_id + ", food_date = " + food_date + ", food_flag = " + food_flag + "}";
    }
}
