package com.project.chef.controller;

import com.project.chef.dao.DAOUtils;
import com.project.chef.dao.MySQLConnection;
import com.project.chef.model.entity.Salad;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

/**
 * Created by Denis Starovoitenko on 27.08.2017.
 */
@WebServlet(name = "SaladList", urlPatterns = "/saladList")
public class SaladList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MySQLConnection.getMySQLConnection();
        List<String> saladList = DAOUtils.getSaladNames(connection);

        request.setAttribute("saladList", saladList);
        request.getServletContext().getRequestDispatcher("/view/saladList.jsp").forward(request, response);
    }
}
