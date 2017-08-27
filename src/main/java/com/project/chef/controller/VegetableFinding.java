package com.project.chef.controller;

import com.project.chef.model.entity.Salad;
import com.project.chef.model.entity.Vegetable;
import com.project.chef.utility.searching.FindVegetablesCalorie;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Map;

/**
 * Created by Denis Starovoitenko on 27.08.2017.
 */
@WebServlet(name = "VegetableFinding", urlPatterns = "/findVegetable")
public class VegetableFinding extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Salad salad = (Salad) session.getAttribute("salad");

        FindVegetablesCalorie find = new FindVegetablesCalorie();
        double min = Double.parseDouble(request.getParameter("min"));
        double max = Double.parseDouble(request.getParameter("max"));
        Map<Vegetable, Double> result = find.find(salad, min, max);

        request.setAttribute("result", result);
        request.getRequestDispatcher("/view/printFind.jsp").forward(request, response);
    }
}
