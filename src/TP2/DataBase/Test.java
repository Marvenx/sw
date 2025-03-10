package TP2.DataBase;

import TP2.DataBase.GestionEtudiant;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class Test {
    public static void main(String[] args) {
        EtudiantManager manager = new EtudiantManager();
        manager.insertStudent(14896523,"marwen","x",12);
        manager.getStudents();
        GestionEtudiant f=new GestionEtudiant();

        f.setVisible(true);
    }



}
