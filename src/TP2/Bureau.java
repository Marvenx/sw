package TP2;

import javax.swing.*;
import java.awt.*;

public class Bureau extends JFrame {
    JMenuBar mb;
    JMenu tps,tpb;
    JMenuItem item1,item2,item3;
    JDesktopPane desktop;
    public Bureau(){
        mb = new JMenuBar();
        tps=new JMenu ("TP swing");
        tpb=new JMenu("TP Base");
        item1=new JMenuItem("TP1");
        item2=new JMenuItem("TP2");
        item3=new JMenuItem("TP3");
        mb.add(tps);
        mb.add(tpb);
        tps.add(item1);
        tps.add(item3);
        tps.add(item2);
        this.setJMenuBar(mb);
        this.setTitle("Bureau TP Java");
        this.setSize(800, 600);
        this.setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
        desktop = new JDesktopPane();
        desktop.add(new GestionProfil());
        desktop.add(new CurriculumForm());
        this.add(desktop);

    }
}
