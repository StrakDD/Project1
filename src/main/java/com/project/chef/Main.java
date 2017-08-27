package com.project.chef;

import com.project.chef.dao.DAOUtils;
import com.project.chef.dao.MySQLConnection;
import com.project.chef.model.entity.FruitVegetable;
import com.project.chef.model.entity.Salad;
import com.project.chef.model.entity.Vegetable;
import com.project.chef.model.entity.VegetativeVegetable;
import com.project.chef.utility.searching.FindVegetablesCalorie;

import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import java.sql.*;
import java.util.Map;

/**
 * Created by Denis Starovoitenko on 20.08.2017.
 */
public class Main {

    public static void main(String[] args) throws SQLException, NamingException {
        Connection connection = MySQLConnection.getMySQLConnection();

        Salad salad = DAOUtils.findSalad(connection, "Caesar");

        /*System.out.println("Salad name: " + salad.getName());
        for (Map.Entry<Vegetable, Double> vegetableDoubleEntry : salad.getIngredients().entrySet()) {
            System.out.println(vegetableDoubleEntry.getKey() + "---- " + vegetableDoubleEntry.getValue());
        }*/

        //salad.setName("NewCaesar");
        //System.out.println(DAOUtils.getIdVegetative(connection, "stems"));
        //System.out.println(DAOUtils.getIdFruit(connection, "seed"));

       /* for (String s : DAOUtils.getSaladNames(connection)) {
            System.out.println(s);
        }
        connection.close();*/

        for (Map.Entry<Vegetable, Double> vegetableDoubleEntry : salad.getIngredients().entrySet()) {
            System.out.println(vegetableDoubleEntry.getKey());
            System.out.println(vegetableDoubleEntry.getValue());
        }

        FindVegetablesCalorie findVegetablesCalorie = new FindVegetablesCalorie();
        Map<Vegetable, Double> map = findVegetablesCalorie.find(salad, 200.3, 500.3);

        for (Map.Entry<Vegetable, Double> vegetableDoubleEntry : map.entrySet()) {
            System.out.println(vegetableDoubleEntry.getKey());
            System.out.println(vegetableDoubleEntry.getValue());
        }
    }
}
