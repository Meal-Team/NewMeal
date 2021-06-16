package com.igeek.meal.controller;

import com.igeek.meal.entity.Food;
import com.igeek.meal.service.FoodKindService;
import com.igeek.meal.service.FoodService;
import com.igeek.meal.vo.PageVo;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/7/007 23:34
 * @Version
 */
@WebServlet(name = "FoodServlet",urlPatterns = "/food")
public class FoodServlet extends BasicServlet{
    private FoodService foodService = new FoodService();
    private FoodKindService foodKindService = new FoodKindService();

    public void index(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        List<Food> cheapFood = foodService.findCheapFood();
        List<Food> newFood = foodService.findNewFood();

        request.setAttribute("cheapFood",cheapFood);
        request.setAttribute("newFood",newFood);
        request.getRequestDispatcher("index.jsp").forward(request,response);
    }

    public void findFood(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String food_kind_id = request.getParameter("food_kind_id");
        String name = request.getParameter("food_name");
        String page = request.getParameter("pageNow");

        if (food_kind_id != null && !food_kind_id.equals("")){
            String food_kind_name = foodKindService.findKindName(food_kind_id);
            if (food_kind_id != null){
                request.setAttribute("food_kind_name",food_kind_name);
            }
        }

        String food_name = "";
        if (name == null){
            food_name = "";
        }else{
            food_name = name;
        }

        int pageNow = 1;
        if (page == null){
            pageNow = 1;
        }else{
            pageNow = Integer.parseInt(page);
        }

        PageVo<Food> vo = foodService.findFood(food_kind_id,food_name,pageNow);
        request.setAttribute("vo",vo);

        Cookie[] cookies = request.getCookies();
        List<Food> historyList = new ArrayList<>();
        if (cookies!=null){
            for (Cookie cookie:cookies
                 ) {
                if (cookie!=null && cookie.getName().equals("food_ids")){
                    String food_ids = cookie.getValue();
                    String[] split = food_ids.split("-");
                    for (int i = 0; i < split.length; i++) {
                        String food_id = split[1];
                        historyList.add(foodService.findFoodByFoodId(food_id));
                    }
                }
            }
        }
        request.setAttribute("historyList",historyList);

        request.getRequestDispatcher("product_list.jsp").forward(request,response);
    }
    public void findFoodByFoodId(HttpServletRequest request,HttpServletResponse response) throws ServletException,IOException{
        String food_id = request.getParameter("food_id");
        Food food = foodService.findFoodByFoodId(food_id);
        request.setAttribute("food",food);

        String food_kind_name = request.getParameter("food_kind_name");
        if (food_kind_name!=null&& !food_kind_name.equals("")){
            request.setAttribute("food_kind_name",food_kind_name);
        }
        String food_kind_id = request.getParameter("food_kind_id");
        String food_name = request.getParameter("food_name");
        String pageNow = request.getParameter("pageNow");

        request.setAttribute("food_kind_id",food_kind_id);
        request.setAttribute("food_name",food_name);
        request.setAttribute("pageNow",pageNow);

        String value = food_id;
        Cookie[] cookies = request.getCookies();
        if (cookies!=null){
            for (Cookie cookie:cookies
                 ) {
                if (cookie!=null && cookie.getName().equals("food_ids")){
                    List<String> list = Arrays.asList(cookie.getValue().split("-"));
                    LinkedList<String> food_id_list = new LinkedList<>(list);
                    if (food_id_list.contains(food_id)){
                        food_id_list.remove(food_id);
                    }
                    food_id_list.addFirst(food_id);

                    value = "";
                    for (String s:food_id_list
                         ) {
                        value += s+"-";
                    }
                }
            }
        }

        Cookie cookie = new Cookie("food_ids",value.substring(0,value.length()-1));
        cookie.setMaxAge(7*24*60*60);
        response.addCookie(cookie);

        request.getRequestDispatcher("product_info.jsp").forward(request,response);
    }
}
