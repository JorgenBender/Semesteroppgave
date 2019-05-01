package org.Forsikringsregister.Programlogikk;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;

public class Kunderegister {

    private static ObservableList<Kunde> kundeliste = FXCollections.observableArrayList();

    public static void nyKunde(Kunde kunde){
        kundeliste.add(kunde);
    }

    public static ObservableList<Kunde> getKundeliste(){
        return kundeliste;
    }

    public static void setKundeliste(ObservableList<Kunde> enKundeliste){
        kundeliste = enKundeliste;
    }

    @Override
    public String toString(){
        String out = "";
        for(Kunde kunde : kundeliste){
            out += kunde.toString() + "\n";
        }
        return out;
    }
}
