package org.Forsikringsregister.IO;

import javafx.stage.FileChooser;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

public class skrivJobj implements IOInterface{

    @Override
    public void skrivKundeliste(ArrayList<Kunde> kundeliste) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        fileChooser.setInitialFileName("kunderegister.jobj");

        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fileChooser.showSaveDialog(null)))) {
            ous.writeObject(kundeliste);
        } catch (IOException e) {
            e.printStackTrace(); // This should not happen, so we print debug information here.
        }
    }
    @Override
    public ArrayList<Kunde> lesKundeliste() throws IOException {
        return new ArrayList<>();
    }
}
