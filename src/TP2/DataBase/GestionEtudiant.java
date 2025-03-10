package TP2.DataBase;

import javax.swing.*;
import java.awt.*;
import java.sql.ResultSet;

public class GestionEtudiant extends JFrame {
    MyTableModel Model;
    JTextField nom, prenom, moyenne, CIN;
    JButton saveButton;
    JTable jt;
    JPanel pn;
    public GestionEtudiant(){
        this.setTitle("GestionEtudiant");
        this.setSize(700, 450);
        this.setLocation(100,100);
        this.setVisible(true);
        this.setResizable(true);
        this.setLayout(new BorderLayout());

        String req = "select * from Etudiant";
        EtudiantManager manager = new EtudiantManager();
        ResultSet rs = manager.selectEtudiant(req);
        Model = new MyTableModel(rs, manager);
        jt = new JTable();
        jt.setModel(Model);
        this.add(new JScrollPane(jt));


        pn = new JPanel();
        pn.setLayout(new FlowLayout());
        pn.add(new JLabel("Nom:"));
        nom = new JTextField(8);
        pn.add(nom);
        pn.add(new JLabel("Prenom:"));
        prenom = new JTextField(8);
        pn.add(prenom);
        pn.add(new JLabel("CIN:"));
        CIN = new JTextField(8);
        pn.add(CIN);
        pn.add(new JLabel("moyenne:"));
        moyenne = new JTextField(8);
        pn.add(moyenne);
        saveButton = new JButton("Enregistrer");
        pn.add(saveButton);
        this.add(pn, BorderLayout.NORTH);

    }


}
