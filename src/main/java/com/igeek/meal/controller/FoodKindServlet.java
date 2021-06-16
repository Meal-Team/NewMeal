package com.igeek.meal.controller;

import com.google.gson.Gson;
import com.igeek.meal.entity.FoodKind;
import com.igeek.meal.service.FoodKindService;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.List;

/**
 * @Author: TaoXiaoFan
 * @ClassName:
 * @Description:
 * @Date: 2021/6/9/009 21:14
 * @Version
 */
@WebServlet(name = "FoodKindServlet",urlPatterns = "/FoodKind")
public class FoodKindServlet extends BasicServlet {
    private FoodKindService foodKindService = new FoodKindService();
    public void findAllFoodKinds(HttpServletRequest request, HttpServletResponse response) throws ServletException , IOException {
        List<FoodKind> allFoodKinds = foodKindService.findAllFoodKinds();
        Gson gson = new Gson();
        String json = gson.toJson(allFoodKinds);
        response.getWriter().write(json);
    }
}
