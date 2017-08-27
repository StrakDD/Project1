package com.project.chef.controller;

import com.project.chef.dao.DAOUtils;
import com.project.chef.dao.MySQLConnection;
import com.project.chef.model.entity.Salad;

import javax.naming.NameNotFoundException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.Connection;
import java.sql.SQLException;

/**
 * Created by Denis Starovoitenko on 27.08.2017.
 */
@WebServlet(name = "PrintList", urlPatterns = "/printList")
public class PrintList extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        Connection connection = MySQLConnection.getMySQLConnection();
        String name = (String) request.getParameter("name");

        Salad salad = null;
        try {
            salad = DAOUtils.findSalad(connection, name);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NameNotFoundException e) {
            e.printStackTrace();
        }

        request.setAttribute("salad", salad);
        HttpSession session = request.getSession();
        session.setAttribute("salad", salad);
        request.getServletContext().getRequestDispatcher("/view/printList.jsp").forward(request,response);
    }
}
