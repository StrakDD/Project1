package com.project.chef.controller;

import com.project.chef.model.entity.Salad;

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
@WebServlet(name = "CreateSalad", urlPatterns = "/createSaladName")
public class CreateSaladName extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();

        String name = request.getParameter("saladName");
        Salad salad = new Salad(name);
        session.setAttribute("newSalad", salad);
        request.getRequestDispatcher("/view/createSaladVegetable.jsp").forward(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doPost(request, response);
    }
}
