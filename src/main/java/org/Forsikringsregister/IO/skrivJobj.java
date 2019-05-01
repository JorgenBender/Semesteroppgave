package org.Forsikringsregister.IO;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;


public class skrivJobj implements Writer{

    @Override
    public void skrivKundeliste(ObservableList<Kunde> kundeliste) {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        fileChooser.setInitialFileName("kunderegister.jobj");

        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(fileChooser.showSaveDialog(null)))) {
            ous.writeObject(kundeliste);
        } catch (IOException e) {
            e.printStackTrace(); // This should not happen, so we print debug information here.
        }
    }
}
