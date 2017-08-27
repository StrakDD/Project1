package com.project.chef.dao;

import com.project.chef.model.entity.*;

import javax.naming.NameNotFoundException;
import javax.naming.NamingException;
import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by Denis Starovoitenko on 26.08.2017.
 */
public class DAOUtils {

    public static Salad findSalad(Connection connection, String name) throws SQLException, NameNotFoundException {
        final String QUERYName = "SELECT id FROM salad WHERE name=?";
        PreparedStatement preparedStatement = connection.prepareStatement(QUERYName);
        preparedStatement.setString(1, name);

        if (preparedStatement.executeQuery().next()){
            return makeSalad(connection, name);
        }
        throw new NameNotFoundException();
    }

    public static Salad makeSalad(Connection connection, String name) throws SQLException {
       final String QUERY = "SELECT vegetable.name, vegetable.calories, vegetable.protein, vegetable.fat, vegetable.carbohydrate"
                            + ", weight, vegetative_vegetable.type, fruit_vegetable.type FROM salad_ingridients"
                            +" JOIN vegetable ON salad_ingridients.id_vegetable = vegetable.id"
                            +" LEFT JOIN vegetative_vegetable ON vegetable.id_vegetative = vegetative_vegetable.id"
                            +" LEFT JOIN fruit_vegetable ON vegetable.id_fruit = fruit_vegetable.id"
                            +" WHERE salad_ingridients.id_salad = (SELECT id FROM salad WHERE name=?)";

        Salad salad = new Salad(name);
        String vname;
        int calories;
        double protein;
        double fat;
        double carbohydrate;
        double weight;
        String vegetative;
        String fruit;
        Map<Vegetable, Double> ingredients = new HashMap<>();
        Vegetable vegetable;

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();

        while (resultSet.next()){
            vname = resultSet.getString(1);
            calories = resultSet.getInt(2);
            protein = resultSet.getDouble(3);
            fat = resultSet.getDouble(4);
            carbohydrate = resultSet.getDouble(5);
            weight = resultSet.getDouble(6);
            vegetative = resultSet.getString(7);
            fruit = resultSet.getString(8);

            if (vegetative != null){
                vegetable = new VegetativeVegetable(vname,calories,protein,fat,carbohydrate, Vegetative.valueOf(vegetative));
            }else if (fruit != null){
                vegetable = new FruitVegetable(vname,calories,protein,fat,carbohydrate, Fruit.valueOf(fruit));
            }else {
                vegetable = new Vegetable(vname,calories,protein,fat,carbohydrate);
            }
            ingredients.put(vegetable, weight);
        }
        salad.setIngredients(ingredients);
        return salad;
    }

    public static void inputSalad(Connection connection, Salad salad) throws SQLException, NamingException {

        if (checkSalad(connection, salad.getName())){
            throw new NamingException("Name already exists");
        }
        final String QUERYNAME = "INSERT INTO salad(name) VALUES(?)";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERYNAME);
        preparedStatement.setString(1, salad.getName());
        preparedStatement.executeUpdate();

        final String QUERYVEGETABALE = "INSERT INTO vegetable(name, calories, protein, fat, carbohydrate, id_vegetative, id_fruit)"
                                        + "VALUES (?, ?, ?, ? ,?, ?, ?)";

        for (Vegetable vegetable : salad.getIngredients().keySet()) {
            if (!checkVegetable(connection, vegetable.getName())){
                preparedStatement = connection.prepareStatement(QUERYVEGETABALE);
                preparedStatement.setString(1, vegetable.getName());
                preparedStatement.setInt(2, vegetable.getCalorie());
                preparedStatement.setDouble(3, vegetable.getProtein());
                preparedStatement.setDouble(4, vegetable.getFat());
                preparedStatement.setDouble(5, vegetable.getCarbohydrate());

                if (vegetable.getClass() == VegetativeVegetable.class){
                    preparedStatement.setInt(6, getIdVegetative(connection, ((VegetativeVegetable) vegetable).getEatablePart().toString()));
                    preparedStatement.setNull(7, Types.NULL);
                }else if (vegetable.getClass() == FruitVegetable.class){
                    preparedStatement.setNull(6, Types.NULL);
                    preparedStatement.setInt(7, getIdFruit(connection,((FruitVegetable) vegetable).getEatablePart().toString()));
                }else {
                    preparedStatement.setNull(6, Types.NULL);
                    preparedStatement.setNull(7, Types.NULL);
                }
                preparedStatement.executeUpdate();
            }
        }

        final String QUERYINGREDIENTS = "INSERT INTO salad_ingridients(id_salad, id_vegetable, weight)"
                                        + " VALUES (?, ?, ?)";

        for (Map.Entry<Vegetable, Double> vegetableDoubleEntry : salad.getIngredients().entrySet()) {
            preparedStatement = connection.prepareStatement(QUERYINGREDIENTS);
            preparedStatement.setInt(1, getIdSalad(connection, salad.getName()));
            preparedStatement.setInt(2, getIdVegetable(connection, vegetableDoubleEntry.getKey().getName()));
            preparedStatement.setDouble(3, vegetableDoubleEntry.getValue());
            preparedStatement.executeUpdate();
        }
    }

    public static int getIdSalad(Connection connection, String name) throws SQLException {
        final String QUERY = "SELECT salad.id FROM salad WHERE salad.name=?";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt(1);
    }

    public static int getIdVegetable(Connection connection, String name) throws SQLException {
        final String QUERY = "SELECT vegetable.id FROM vegetable WHERE vegetable.name=?";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt(1);
    }

    public static int getIdFruit(Connection connection, String name) throws SQLException {
        final String QUERY = "SELECT fruit_vegetable.id FROM fruit_vegetable"
                + " WHERE fruit_vegetable.type=?";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt(1);
    }

    public static int getIdVegetative(Connection connection, String name) throws SQLException {
        final String QUERY = "SELECT vegetative_vegetable.id FROM vegetative_vegetable"
                            + " WHERE vegetative_vegetable.type=?";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, name);
        ResultSet resultSet = preparedStatement.executeQuery();
        resultSet.next();

        return resultSet.getInt(1);
    }

    public static boolean checkVegetable(Connection connection, String vegetable) throws SQLException {
        final String QUERY = "SELECT * FROM vegetable WHERE vegetable.name=?";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, vegetable);

        return preparedStatement.executeQuery().next();

    }

    public static boolean checkSalad(Connection connection, String salad) throws SQLException {
        final String QUERY = "SELECT * FROM salad WHERE salad.name=?";

        PreparedStatement preparedStatement = connection.prepareStatement(QUERY);
        preparedStatement.setString(1, salad);

        return preparedStatement.executeQuery().next();
    }

    public static List<String> getSaladNames(Connection connection) {
        List<String> names = new ArrayList<>();
        final String QUERY = "SELECT salad.name FROM salad";

        try {
            Statement statement = connection.createStatement();
            ResultSet resultSet = statement.executeQuery(QUERY);
            while (resultSet.next()){
                names.add(resultSet.getString(1));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return names;
    }
}
