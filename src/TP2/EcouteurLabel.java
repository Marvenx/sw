package TP2;

import java.awt.Color;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.JLabel;
import javax.swing.JTextField;

//lorsque la souris passe sur l'un des champs, sa couleur change. Lorsqu'elle quitte, elle revient nulle.
//lorsque la souris passe sur l'un des champs de saisie, label help affiche "saisir"

public class EcouteurLabel implements MouseListener {
    private GestionProfil gestionProfil;
    private JTextField textField;

    public EcouteurLabel(GestionProfil gestionProfil, JTextField textField) {
        this.gestionProfil = gestionProfil;
        this.textField = textField;
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        gestionProfil.setHelpText("Help: Saisir");
    }

    @Override
    public void mouseExited(MouseEvent e) {
        gestionProfil.setHelpText("Help:");
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}