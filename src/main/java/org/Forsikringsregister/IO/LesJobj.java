package org.Forsikringsregister.IO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import org.Forsikringsregister.Exceptions.DeserializingFailedException;
import org.Forsikringsregister.Exceptions.InvalidFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;
import org.Forsikringsregister.Programlogikk.Kunderegister;

import java.io.*;
import java.util.ArrayList;

public class LesJobj implements Reader{

    private File file;

    public LesJobj(File file) {
        this.file=file;
    }


    @Override
    public ObservableList<Kunde> lesKundeliste() throws IOException, DeserializingFailedException {

        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        ObservableList<Kunde> importertListe;

        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file))){
            ArrayList<Kunde> arrayList = ArrayList.class.cast(ois.readObject());
            importertListe = FXCollections.observableArrayList(arrayList);
        }
        catch(ClassNotFoundException  | ClassCastException e) {
            throw new DeserializingFailedException("Filen er ikke en kundeliste");
        }
        catch(StreamCorruptedException e){
            throw new DeserializingFailedException("Filen er korrupt");
        }
        return importertListe;
    }
}
