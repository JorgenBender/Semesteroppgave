package org.Forsikringsregister.IO;

import org.Forsikringsregister.Exceptions.InvalidKundeFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.IOException;
import java.util.ArrayList;

public interface IOInterface {
    void skrivKundeliste(ArrayList<Kunde> kundeliste) throws IOException;
    ArrayList<Kunde> lesKundeliste() throws IOException , InvalidKundeFormatException;
}

