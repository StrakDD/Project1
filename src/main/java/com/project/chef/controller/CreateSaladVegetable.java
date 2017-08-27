package com.project.chef.controller;

import com.project.chef.model.entity.*;

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
@WebServlet(name = "CreateSaladVegetable", urlPatterns = "/createSaladVegetable")
public class CreateSaladVegetable extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Salad salad = (Salad) session.getAttribute("newSalad");

        String name = request.getParameter("nameVegetable");
        int calories = Integer.parseInt(request.getParameter("calories"));
        double protein = Double.parseDouble(request.getParameter("protein"));
        double fat = Double.parseDouble(request.getParameter("fat"));
        double carbohydrate = Double.parseDouble(request.getParameter("carbohydrate"));
        String type = request.getParameter("type");
        String typeVegetable = request.getParameter("typeVegetable");
        double weight = Double.parseDouble(request.getParameter("weight"));
        Vegetable vegetable;

        if (type.equals("fruit")){
             vegetable = new FruitVegetable(name, calories, protein, fat, carbohydrate, Fruit.valueOf(typeVegetable));
        }else if (type.equals("vegetative")){
            vegetable = new VegetativeVegetable(name, calories, protein, fat, carbohydrate, Vegetative.valueOf(typeVegetable));
        }else {
            vegetable = new Vegetable(name, calories, protein, fat, carbohydrate);
        }
        salad.addIngredient(vegetable, weight);
        session.setAttribute("newSalad", salad);
        request.getRequestDispatcher("/view/createSaladVegetable.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
