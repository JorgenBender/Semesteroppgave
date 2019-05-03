package org.Forsikringsregister.IO;

import javafx.collections.ObservableList;
import org.Forsikringsregister.Exceptions.DeserializingFailedException;
import org.Forsikringsregister.Exceptions.InvalidFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.File;
import java.io.IOException;


public interface Reader {
    ObservableList<Kunde> lesKundeliste() throws IOException , InvalidFormatException, DeserializingFailedException;
}

