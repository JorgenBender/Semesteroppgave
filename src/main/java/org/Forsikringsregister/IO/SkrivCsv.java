package org.Forsikringsregister.IO;

import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;

public class SkrivCsv extends Task<Void> implements Writer{

    private ObservableList<Kunde> kundeliste;
    private File file;

    public SkrivCsv(ObservableList<Kunde> kundeliste, File file) {
        this.kundeliste = kundeliste;
        this.file=file;
    }

    @Override
    public void skrivKundeliste() throws IOException {
        PrintWriter writer = null;
        try {
            writer = new PrintWriter(file);//fileChooser.showSaveDialog(null), "UTF-8");

            for (Kunde kunde : kundeliste) {
                writer.println(kunde.toCsv());
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
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
