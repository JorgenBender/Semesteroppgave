package org.Forsikringsregister.IO;


import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.IOException;
import java.util.ArrayList;

public interface Writer {
    void skrivKundeliste(ArrayList<Kunde> kundeliste) throws IOException;
}

