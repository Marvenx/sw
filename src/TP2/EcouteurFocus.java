package TP2;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;
import javax.swing.JTextField;

public class EcouteurFocus implements FocusListener {

    public EcouteurFocus(GestionProfil gestionProfil) {
    }

    @Override
    public void focusGained(FocusEvent e) {
        JTextField textField = (JTextField) e.getSource();
        if (textField.getForeground().equals(Color.GRAY)) {
            textField.setText("");
            textField.setForeground(Color.BLACK);
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        JTextField textField = (JTextField) e.getSource();
        if (textField.getText().trim().isEmpty()) {
            textField.setText("Veuillez taper");
            textField.setForeground(Color.GRAY);
        }
    }
}
