package org.Forsikringsregister.IO;

import javafx.stage.FileChooser;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.File;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

public class skrivCsv implements Writer{
    @Override
    public void skrivKundeliste(ArrayList<Kunde> kundeliste) throws IOException {
        PrintWriter writer = null;
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        fileChooser.setInitialFileName("kunderegister.csv");


        try {
            writer = new PrintWriter(fileChooser.showSaveDialog(null), "UTF-8");

            for (Kunde kunde : kundeliste) {
                writer.println(kunde.toCsv());
            }
        } finally {
            if (writer != null) {
                writer.close();
            }
        }
    }
}
