package Grp4;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

public class CurriculumForm extends JFrame {
    JLabel lb_titre;
    JTextField nom, prenom, dateNaissance, email, telephone, education, experience;
    JButton btnvalider, btnquitter;

    CurriculumForm() {
        this.setTitle("Curriculum Vitae");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        this.setLayout(new FlowLayout());

        lb_titre=new JLabel("Curriculum Vitae");
        lb_titre.setForeground(Color.white);
        lb_titre.setFont(new Font (Font.MONOSPACED, Font.BOLD|Font.ITALIC,36));
        lb_titre.setOpaque(true);
        lb_titre.setBackground(Color.green);
        lb_titre.setPreferredSize(new Dimension(780,100));
        lb_titre.setHorizontalAlignment(JLabel.CENTER);
        this.add(lb_titre);

        this.add(new JLabel("Nom:"));
        nom = new JTextField(20);
        this.add(nom);

        this.add(new JLabel("Prénom:"));
        prenom = new JTextField(20);
        this.add(prenom);

        this.add(new JLabel("Date de naissance:"));
        dateNaissance = new JTextField(20);
        this.add(dateNaissance);

        this.add(new JLabel("Email:"));
        email = new JTextField(20);
        this.add(email);

        this.add(new JLabel("Téléphone:"));
        telephone = new JTextField(20);
        this.add(telephone);

        this.add(new JLabel("Éducation:"));
        education = new JTextField(20);
        this.add(education);

        this.add(new JLabel("Expérience Professionnelle:"));
        experience = new JTextField(20);
        this.add(experience);

        btnvalider = new JButton("Valider");
        btnquitter = new JButton("Quitter");
        this.add(btnvalider);
        this.add(btnquitter);

        btnquitter.addActionListener(new Ecouteur());
        btnvalider.addActionListener(new Ecouteur());
    }

    class Ecouteur implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (e.getSource() == btnquitter) {
                System.exit(0);
            }
            if (e.getSource() == btnvalider) {
                File f = new File("cv.html");
                try {
                    FileWriter fw = new FileWriter(f, false);
                    fw.write("<html><head><title>Votre CV</title></head><body>" +
                            "<h1><strong> Nom et prénom: </strong>" + nom.getText() + " " + prenom.getText() + "</h1>" +
                            "<p><strong>Date de naissance:</strong> " + dateNaissance.getText() + "</p>" +
                            "<p><strong>Email:</strong> " + email.getText() + "</p>" +
                            "<p><strong>Téléphone:</strong> " + telephone.getText() + "</p>" +
                            "<h2>Éducation:</h2><br><p>" + education.getText() + "</p>" +
                            "<h2>Expérience Professionnelle:</h2><br><p>" + experience.getText() + "</p>" +
                            "</body></html>");
                    fw.close();
                    Desktop.getDesktop().open(f);
                } catch (IOException ex) {
                    throw new RuntimeException(ex);
                }
            }
        }
    }
}
