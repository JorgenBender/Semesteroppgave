package org.openjfx;

//import javafx.collections.ObservableList;

import javafx.stage.FileChooser;

import java.io.*;
import java.util.ArrayList;

public class KunderegisterIO /*implements IOInterface*/ {

    //.csv skriver
    //@Override
    public void skrivKundelisteCsv(ArrayList<Kunde> kundeliste) throws IOException {
        PrintWriter writer = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        fileChooser.setInitialFileName("kunderegister.csv");


        try {
            writer = new PrintWriter(fileChooser.showSaveDialog(null), "UTF-8");

            for (Kunde kunde : kundeliste) {
                writer.println(kunde);
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }

    //.csv leser
    //@Override
    //public void lesKundelisteCsv()

    //}



    //.jobj skriver
    public static void exporterKundeliste(ArrayList<Kunde> kundeliste) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        fileChooser.setInitialFileName("kunderegister.jobj");

        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fileChooser.showSaveDialog(null)))) {
            ous.writeObject(kundeliste);
        } catch (IOException e) {
            e.printStackTrace(); // This should not happen, so we print debug information here.
        }
    }

    //.jobj leser
    public static ArrayList<Kunde> importerKundeliste(){

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        ArrayList<Kunde> importertListe = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileChooser.showOpenDialog(null)))){
           importertListe = ArrayList.class.cast(ois.readObject());
        } catch(IOException e) {
            System.err.println("Could not read file. Cause: " + e.getCause());
        } catch(ClassNotFoundException e) {
            System.err.println("Could not convert Object");
        }
        return importertListe;
    }
}
