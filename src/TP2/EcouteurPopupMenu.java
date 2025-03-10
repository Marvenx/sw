package TP2;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JLabel;

public class EcouteurPopupMenu implements ActionListener {
    GestionProfil gp;

    public EcouteurPopupMenu(GestionProfil gp) {
        this.gp = gp;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == gp.SupprimerTout) {
            Data.data.clear();
            gp.model.clear();
            gp.jtp.removeAll();
            gp.tabulationListe.clear();
        }

        if (e.getSource() == gp.SupprimerItem) {
            int selectedIndex = gp.jl.getSelectedIndex();
            if (selectedIndex >= 0) {
                String pseudo = gp.model.get(selectedIndex);

                Data.data.removeIf(p -> p.getPseudo().equals(pseudo));

                gp.model.remove(selectedIndex);
                gp.jtp.remove(gp.jtp.indexOfTab(pseudo));

                gp.tabulationListe.removeIf(panel ->
                        panel != null
                                && panel.pn.getComponent(0) instanceof JLabel
                                && ((JLabel) panel.pn.getComponent(0)).getText().contains(pseudo)
                );
            }
        }

        if (e.getSource() == gp.modifierItem) {
            int selectedIndex = gp.jl.getSelectedIndex();
            if (selectedIndex >= 0) {
                String pseudo = gp.model.get(selectedIndex);

                for (Profil p : Data.data) {
                    if (p.getPseudo().equals(pseudo)) {

                        gp.nom.setText(p.getNom());
                        gp.nom.setForeground(Color.BLACK);
                        gp.prenom.setText(p.getPrenom());
                        gp.prenom.setForeground(Color.BLACK);
                        gp.pseudo.setText(p.getPseudo());
                        gp.pseudo.setForeground(Color.BLACK);
                        break;
                    }
                }

                gp.model.remove(selectedIndex);

                int tabIndex = gp.jtp.indexOfTab(pseudo);
                if (tabIndex >= 0) {
                    gp.jtp.remove(tabIndex);
                }
            }
        }

        if (e.getSource() == gp.saveButton) {
            String newNom = gp.nom.getText();
            String newPrenom = gp.prenom.getText();
            String newPseudo = gp.pseudo.getText();

            Profil profilToModify = null;
            for (Profil p : Data.data) {
                if (p.getPseudo().equals(gp.pseudo.getText())) {
                    profilToModify = p;
                    break;
                }
            }

            if (profilToModify != null) {
                profilToModify.setNom(newNom);
                profilToModify.setPrenom(newPrenom);
                profilToModify.setPseudo(newPseudo);

                gp.model.addElement(newPseudo);

                gp.nom.setText("");
                gp.prenom.setText("");
                gp.pseudo.setText("");

                int tabIndex = gp.jtp.indexOfTab(profilToModify.getPseudo());
                if (tabIndex >= 0) {
                    gp.jtp.setTitleAt(tabIndex, newPseudo);
                }
            }
        }
    }
}
