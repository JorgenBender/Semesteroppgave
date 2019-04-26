package org.openjfx;

import java.io.IOException;
import java.util.ArrayList;

public interface KundelisteSkriver {
    void skrivKundeliste(ArrayList<Kunde> kundeliste) throws IOException;
}
