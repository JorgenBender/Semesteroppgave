package org.openjfx;

import java.io.IOException;
import java.util.ArrayList;

public interface IOInterface {
    void skrivKundelisteCsv(ArrayList<Kunde> kundeliste) throws IOException;
    void skrivKundelisteJobj(ArrayList<Kunde> kundeliste) throws IOException;
    void lesKundelisteCsv(ArrayList<Kunde> kundeliste) throws IOException;
    void lesKundelisteJobj(ArrayList<Kunde> kundeliste) throws IOException;
}

