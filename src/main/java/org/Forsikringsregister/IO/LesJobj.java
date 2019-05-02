package org.Forsikringsregister.IO;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import org.Forsikringsregister.Exceptions.InvalidFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;

public class LesJobj extends Task<Void> implements Reader{

    private File file;

    public LesJobj(File file) {
        this.file=file;
    }


    @Override
    public ObservableList<Kunde> lesKundeliste() throws IOException, InvalidFormatException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        ObservableList<Kunde> importertListe = null;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            importertListe = ObservableList.class.cast(ois.readObject());
        } catch(ClassNotFoundException e) {
            System.err.println("Could not convert Object");
        }
        return importertListe;
    }

    @Override
    protected Void call() throws Exception {
        try { lesKundeliste(); }
        catch (Exception e) {}
        return null;
    }

    @Override
    protected void succeeded(){}
}
