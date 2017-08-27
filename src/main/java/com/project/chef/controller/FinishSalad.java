package com.project.chef.controller;

import com.project.chef.dao.DAOUtils;
import com.project.chef.dao.MySQLConnection;
import com.project.chef.model.entity.Salad;

import javax.naming.NamingException;
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
@WebServlet(name = "FinishSalad", urlPatterns = "/finishSalad")
public class FinishSalad extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        doGet(request, response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        HttpSession session = request.getSession();
        Salad salad = (Salad) session.getAttribute("newSalad");
        session.setAttribute("salad", salad);

        Connection connection = MySQLConnection.getMySQLConnection();
        try {
            DAOUtils.inputSalad(connection, salad);
        } catch (SQLException e) {
            e.printStackTrace();
        } catch (NamingException e) {
            e.printStackTrace();
        }

        StringBuilder builder = new StringBuilder("/printList?name=");
        builder.append(salad.getName());
        request.getServletContext().getRequestDispatcher(builder.toString()).forward(request, response);
    }
}
