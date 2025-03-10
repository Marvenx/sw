package TP2;

import javax.swing.*;
import java.awt.*;

public class ProfileFormPanel extends JPanel {
    JPanel pn,ps;
    JButton validerbtn;

    public ProfileFormPanel(Profil p) {
        this.setLayout(new BorderLayout());
        pn = new JPanel();
        pn.setLayout(new FlowLayout());
        pn.add(new JLabel("Bienvenue! "+p.nom+" "+p.prenom));
        this.add(pn, BorderLayout.NORTH);
        ps= new JPanel();
        ps.setLayout(new FlowLayout());
        validerbtn = new JButton("Valider");
        ps.add(validerbtn);
        this.add(ps, BorderLayout.SOUTH);
    }
}
