package org.Forsikringsregister.IO;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.*;
import java.util.ArrayList;


public class SkrivJobj extends Task<Void> implements Writer{

    private ObservableList<Kunde> kundeliste;
    private File file;

    public SkrivJobj(ObservableList<Kunde> kundeliste, File file) {
        this.kundeliste = kundeliste;
        this.file=file;
    }

    @Override
    public void skrivKundeliste() {
        try (ObjectOutputStream ous = new ObjectOutputStream(new FileOutputStream(file))){
            ous.writeObject(new ArrayList<>(kundeliste));
        } catch (IOException e) {
            e.printStackTrace(); // This should not happen, so we print debug information here.
        }
    }
    @Override
    protected Void call() throws Exception {
        try {
            skrivKundeliste();
        } catch (Exception e) {
        }

        return null;
    }

    @Override
    protected void succeeded(){}
}
