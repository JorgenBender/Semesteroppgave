package org.Forsikringsregister.IO;


import javafx.collections.ObservableList;
import org.Forsikringsregister.Programlogikk.Kunde;
import java.io.IOException;


public interface Writer {
    void skrivKundeliste(ObservableList<Kunde> kundeliste) throws IOException;
}

