package es.daw.jakarta.DAO;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

import es.daw.jakarta.models.Animal;

public class AnimalDAO {
    private static final String URL = "jdbc:mysql://mysql:3306/animales";
    private static final String USER = "root";
    private static final String PASSWORD = "master";
    
    public List<Animal> obtenerAnimales() throws ClassNotFoundException {
        List<Animal> animales = new ArrayList<>();

        System.out.println("intento conexion a base de datos");

        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = DriverManager.getConnection(URL, USER, PASSWORD); 
            System.out.println("se ha conectado a la base de datos de animales...");

            String query = "SELECT * FROM animal";

            try (Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(query)) {

                while (rs.next()) {
                    int id = rs.getInt("id");
                    String especie = rs.getString("especie");
                    animales.add(new Animal(id, especie));
                }

            }

        } catch (SQLException e) {
            e.printStackTrace();
            System.out.println("no se ha conectado a la base de datos...");
        }

        return animales;
    }

}