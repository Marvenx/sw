package TP2.DataBase;

import java.sql.*;

public class EtudiantManager {
    Connection connection = null;
    Statement statement = null;
    EtudiantManager() {
        // Loading Driver
        try {
            Class.forName(Config.DRIVERName);
            System.out.println("Driver Loaded");
        } catch (ClassNotFoundException e) {
            System.out.println("Driver Not Loaded, Error: " + e.getMessage());
        }
        // Connecting to Database
        try {
            connection= DriverManager.getConnection(Config.URLDataBase,Config.username,Config.password);
            statement = connection.createStatement();
            System.out.println("Connected to Database");
        } catch (SQLException e) {
            System.out.println("Connection Failed, Error: " + e.getMessage());
        }
    }

    int insertStudent(int CIN, String nom, String prenom, double moyenne) {
        if (statement != null) {
            try {
                String sql = "INSERT INTO etudiant(CIN,nom,prenom,moyenne) VALUES (CIN,nom,prenom,moyenne)";
                return statement.executeUpdate(sql);
            } catch (SQLException e) {
                System.out.println("Data Not Inserted, Error: " + e.getMessage());
            }
        }
        return 0;
    }

    void getStudents() {
        if (statement != null) {
            try {
                String selectQuery = "SELECT * FROM etudiant";
                java.sql.ResultSet resultSet = statement.executeQuery(selectQuery);
                java.sql.ResultSetMetaData resultSetMetaData = resultSet.getMetaData();
                int columnsNumber = resultSetMetaData.getColumnCount();
                for (int i = 1; i <= columnsNumber; i++) {
                    System.out.print(resultSetMetaData.getColumnName(i) + "\t");
                }
                System.out.println();
                while (resultSet.next()) {
                    for (int i = 1; i <= columnsNumber; i++) {
                        System.out.print(resultSet.getObject(i) + "\t\t");
                    }
                    System.out.println();
                }
            } catch (SQLException e) {
                System.out.println("Data Not Selected, Error: " + e.getMessage());
            }
        }
    }
    ResultSet selectEtudiant (String req){
        if (req != null){
            try {
                return statement.executeQuery(req);
            } catch (SQLException e) {
                throw new RuntimeException(e);
            }
        }
        return null;
    }
}

