package org.Forsikringsregister.IO;

import javafx.stage.FileChooser;
import org.Forsikringsregister.Exceptions.InvalidKundeFormatException;
import org.Forsikringsregister.Programlogikk.Kunde;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;

import java.util.ArrayList;

public class lesCsv implements Reader {
    @Override
    public ArrayList<Kunde> lesKundeliste() throws IOException, InvalidKundeFormatException {
        FileChooser fileChooser = new FileChooser();
        fileChooser.setInitialDirectory(new File(("data/")));
        ArrayList<Kunde> importertListe = null;
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(fileChooser.showOpenDialog(null)));
            String line = null;


            while((line=reader.readLine()) != null) {
                importertListe.add(parseLine(line));
            }
        } finally {
            if(reader != null) {
                reader.close();
            }
        }

        return importertListe;
    }

    private static Kunde parseLine(String line) throws InvalidKundeFormatException {
        // split line string into three using the separator ";"
        String[] split = line.split(";");
        if(split.length != 3) {
            throw new InvalidKundeFormatException("Must use semicolon ; to separate the three data fields");
        }

        String name = split[0];
        int age = parseNumber(split[1], "Age (second field) is not a number");
        int id = parseNumber(split[2], "Id (third field) is not a number");

        return null;
    }

    private static int parseNumber(String str, String errorMessage) throws InvalidKundeFormatException{
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new InvalidKundeFormatException(errorMessage);
        }

        return number;
    }
}
