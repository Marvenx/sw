package TP2.DataBase;

import javax.swing.table.AbstractTableModel;
import java.sql.ResultSet;
import java.sql.ResultSetMetaData;
import java.sql.SQLException;
import java.util.ArrayList;

public class MyTableModel extends AbstractTableModel {
    ResultSetMetaData rsmd;
    EtudiantManager manager;
    ArrayList<Object[]> data = new ArrayList<>();
    public MyTableModel(){}
    public MyTableModel (ResultSet rs, EtudiantManager manager){
        this.manager=manager;
        try {
            rsmd = rs.getMetaData();
            while(rs.next()) {
                Object[] ligne = new Object[rsmd.getColumnCount()];
                for(int i=0;i< rsmd.getColumnCount();i++) {
                    ligne[i]=rs.getObject(i++);
                }
                data.add(ligne);

            }
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }
    @Override
    public int getRowCount() {
        return data.size();
    }

    @Override
    public int getColumnCount() {
        return 5;
    }

    @Override
    public Object getValueAt(int row, int col) {
        return data.get(row)[col];
    }

}
