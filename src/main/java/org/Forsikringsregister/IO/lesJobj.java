package org.Forsikringsregister.IO;

import javafx.collections.ObservableList;
import javafx.stage.FileChooser;
import org.Forsikringsregister.Exceptions.InvalidKundeFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;

public class lesJobj implements Reader {

    @Override
    public ObservableList<Kunde> lesKundeliste() throws IOException, InvalidKundeFormatException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        ObservableList<Kunde> importertListe = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileChooser.showOpenDialog(null)))){
            importertListe = ObservableList.class.cast(ois.readObject());
        } catch(IOException e) {
            System.err.println("Could not read file. Cause: " + e.getCause());
        } catch(ClassNotFoundException e) {
            System.err.println("Could not convert Object");
        }
        return importertListe;
    }
}
