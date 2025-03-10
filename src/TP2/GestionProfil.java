package TP2;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class GestionProfil extends JInternalFrame {
    JPanel pn,pc;
    JTextField nom, prenom, pseudo;
    JButton saveButton;
    JLabel help;
    JSplitPane jsp;
    JTabbedPane jtp;
    JList jl;
    DefaultListModel<String> model;
    JMenuItem modifierItem,SupprimerItem,SupprimerTout;
    String text;
    Profil pr;
    ArrayList<ProfileFormPanel> tabulationListe = new ArrayList<ProfileFormPanel>();
    public void setHelpText(String text) {
        help.setText(text);
    }
    public GestionProfil(){
        this.setTitle("Gestion Profil");
        this.setSize(600, 400);
        this.setLocation(100,100);
        this.setVisible(true);
        this.setResizable(true);;
        this.setMaximizable(true);
        this.setIconifiable(true);
        this.setClosable(true);
        this.setLayout(new BorderLayout());

        pn = new JPanel();
        pn.setLayout(new FlowLayout());
        pn.add(new JLabel("Nom:"));
        nom = new JTextField(8);
        pn.add(nom);
        pn.add(new JLabel("Prenom:"));
        prenom = new JTextField(8);
        pn.add(prenom);
        pn.add(new JLabel("Pseudo:"));
        pseudo = new JTextField(8);
        pn.add(pseudo);
        saveButton = new JButton("Enregistrer");
        pn.add(saveButton);
        this.add(pn, BorderLayout.NORTH);

        jl=new JList<>();
        model=new DefaultListModel<>();
        jl.setModel(model);
        jl.setPreferredSize(new Dimension(150,200));

        jtp = new JTabbedPane();

        jsp=new JSplitPane();
        jsp.setLeftComponent(jl);
        jsp.setRightComponent(jtp);

        this.add(jsp, BorderLayout.CENTER);

        help = new JLabel("help: ");
        this.add(help, BorderLayout.SOUTH);

        //event
        saveButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Profil p= new Profil(nom.getText(),prenom.getText(),pseudo.getText());
                model.addElement(pseudo.getText());
                Data.data.add(p);
                nom.setText("Tapez nom");
                nom.setForeground(Color.GRAY);
                prenom.setText("Tapez prenom");
                prenom.setForeground(Color.GRAY);
                pseudo.setText("Tapez pseudo");
                pseudo.setForeground(Color.GRAY);
            }
        });

        nom.setText("Tapez nom");
        nom.setForeground(Color.GRAY);
        prenom.setText("Tapez prenom");
        prenom.setForeground(Color.GRAY);
        pseudo.setText("Tapez pseudo");
        pseudo.setForeground(Color.GRAY);

        nom.addFocusListener(new EcouteurFocus(this));
        prenom.addFocusListener(new EcouteurFocus(this));
        pseudo.addFocusListener(new EcouteurFocus(this));


        nom.addMouseListener(new EcouteurLabel(this, nom));
        prenom.addMouseListener(new EcouteurLabel(this, prenom));
        pseudo.addMouseListener(new EcouteurLabel(this, pseudo));

        jl.addMouseListener(new MouseAdapter() {
            @Override
            public void mouseClicked(MouseEvent e) {
                if (e.getClickCount()==2){
                    Profil profil = Data.rechercheSelonPseudo(jl.getSelectedValue()+"");
                    ProfileFormPanel pn = new ProfileFormPanel(profil);
                    int selectedIndex=jl.getSelectedIndex();
                    String pseudo=model.get(selectedIndex);
                    jtp.addTab(pseudo, pn);
                }
                if (e.getButton()==MouseEvent.BUTTON3){
                    JPopupMenu popupMenu= new JPopupMenu("Actions");
                    modifierItem = new JMenuItem("Modifier");
                    SupprimerItem = new JMenuItem("Supprimer");
                    SupprimerTout = new JMenuItem("Supprimer Tout");
                    popupMenu.add(modifierItem);
                    popupMenu.add(SupprimerItem);
                    popupMenu.add(SupprimerTout);
                    popupMenu.show(jl,e.getX(),e.getY());
                    modifierItem.addActionListener(new EcouteurPopupMenu(GestionProfil.this));
                    SupprimerItem.addActionListener(new EcouteurPopupMenu(GestionProfil.this));
                    SupprimerTout.addActionListener(new EcouteurPopupMenu(GestionProfil.this));


                }
            }
        });
    }
}
