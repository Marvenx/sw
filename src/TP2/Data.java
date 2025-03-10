package TP2;

import java.util.ArrayList;

public class Data {
    public static ArrayList <Profil> data = new ArrayList<Profil>();
    //check if pseudo is unique
    public static Profil rechercheSelonPseudo(String pseudo){
        for (int i=0; i<Data.data.size(); i++){
            if (Data.data.get(i).pseudo.equalsIgnoreCase(pseudo))
                return Data.data.get(i);
        }
        return null;
    }

}
