package org.example;

import java.sql.*;

public class Main {
    public static void main(String[] args) {

        String url = "jdbc:mysql://localhost:3306/books";
        String username = "root";
        String password = "";
        String query = "SELECT * FROM books.novels";

        /*try {                             // just to test if driver is working
            Class.forName(("com.mysql.cj.jdbc.Driver"));
            System.out.println("Successfully imported driver!");
        } catch (ClassNotFoundException e) {
            System.err.println("Importing error!");
            e.printStackTrace();
        }*/

        try {

            Connection conn = DriverManager.getConnection(url, username, password);
            Statement statement = conn.createStatement();
            ResultSet result = statement.executeQuery(query);

            while (result.next()) {  //reading lines
                /*String listOfNovels = "";
                for (int i = 1; i < 4; i++) {
                    listOfNovels += result.getString(i) + ":"; //reading columns and concatenating into string with colon
                }
                System.out.println(listOfNovels);*/

                String author_name = result.getString("author_name");
                String author_lastname = result.getString("author_lastname");
                String title = result.getString("title");
                String publisher = result.getString("publisher");
                int year = result.getInt("year");

                System.out.println(String.format("%s, %s, %s, %s, %d", author_name, author_lastname, title, publisher, year));

            }
            statement.close();
            conn.close();

        } catch (SQLException e) {
            e.printStackTrace();
        }

    }
}