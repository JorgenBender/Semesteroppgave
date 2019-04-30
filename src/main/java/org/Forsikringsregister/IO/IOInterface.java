package org.Forsikringsregister.IO;

import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.IOException;
import java.util.ArrayList;

public interface IOInterface {
    void skrivKundeliste(ArrayList<Kunde> kundeliste) throws IOException;
    void lesKundeliste(ArrayList<Kunde> kundeliste) throws IOException;
}

