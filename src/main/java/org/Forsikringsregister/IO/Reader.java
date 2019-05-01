package org.Forsikringsregister.IO;

import javafx.collections.ObservableList;
import org.Forsikringsregister.Exceptions.InvalidKundeFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.IOException;


public interface Reader {
    ObservableList<Kunde> lesKundeliste() throws IOException , InvalidKundeFormatException;
}

