package org.openjfx;

//import javafx.collections.ObservableList;

import java.io.*;
import java.util.ArrayList;

public class KunderegisterIO implements KundelisteSkriver {

    //.csv skriver
    @Override
    public void skrivKundeliste(ArrayList<Kunde> kundeliste) throws IOException {
        PrintWriter writer = null;

        try {
            writer = new PrintWriter("kunderegister.csv", "UTF-8");

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
    public static void lesKundeliste(){

    }



    //.jobj skriver
    public static void exporterKundeliste(ArrayList<Kunde> kundeliste) {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream("kunderegister.jobj"))) {
            ous.writeObject(kundeliste);
        } catch (IOException e) {
            e.printStackTrace(); // This should not happen, so we print debug information here.
        }
    }

    //.jobj leser
    public static ArrayList<Kunde> importerKundeliste(){

        ArrayList<Kunde> importertListe = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream("kunderegister.jobj"))){
           importertListe = ArrayList.class.cast(ois.readObject());
        } catch(IOException e) {
            System.err.println("Could not read file. Cause: " + e.getCause());
        } catch(ClassNotFoundException e) {
            System.err.println("Could not convert Object");
        }
        return importertListe;
    }
}
