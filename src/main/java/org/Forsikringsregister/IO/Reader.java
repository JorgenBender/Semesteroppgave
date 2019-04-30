package org.Forsikringsregister.IO;

import org.Forsikringsregister.Exceptions.InvalidKundeFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.IOException;
import java.util.ArrayList;

public interface Reader {
    ArrayList<Kunde> lesKundeliste() throws IOException , InvalidKundeFormatException;
}

