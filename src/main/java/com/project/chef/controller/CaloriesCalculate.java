package com.project.chef.controller;

import com.project.chef.model.entity.Salad;
import com.project.chef.utility.calories.CaloriesCounterImp;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created by Denis Starovoitenko on 27.08.2017.
 */
@WebServlet(name = "CaloriesCalculate", urlPatterns = "/calories")
public class CaloriesCalculate extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Salad salad = (Salad) session.getAttribute("salad");
        double calories = CaloriesCounterImp.getCalories(salad);

        request.setAttribute("name", salad.getName());
        request.setAttribute("calories", calories);
        request.getRequestDispatcher("/view/calories.jsp").forward(request, response);
    }
}
