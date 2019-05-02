package org.Forsikringsregister.IO;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.concurrent.Task;
import javafx.stage.FileChooser;
import org.Forsikringsregister.Exceptions.InvalidFormatException;
import org.Forsikringsregister.Programlogikk.*;

import java.io.BufferedReader;
import java.io.*;
import java.io.IOException;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class LesCsv extends Task<Void> implements Reader {

    private static DateTimeFormatter mittFormat = DateTimeFormatter.ofPattern("yyyy-DD-mm");

    private File file;

    public LesCsv(File file) {
        this.file = file;
    }

    @Override
    public ObservableList<Kunde> lesKundeliste() throws IOException, InvalidFormatException {
        ObservableList<Kunde> importertListe = FXCollections.observableArrayList();
        BufferedReader reader = null;

        try {
            reader = new BufferedReader(new FileReader(file));
            String line = null;
            int lineNumber = 0;
            while ((line = reader.readLine()) != null) {
                lineNumber++;
                String[] lineArr = line.split(";");
                int lastIndex = importertListe.size() - 1;
                switch (lineArr[0]) {
                    case "Kunde":
                        importertListe.add(parseKunde(lineArr, lineNumber));
                        break;
                    case "Batforsikring":
                        importertListe.get(lastIndex).addForsikring(parseBatforsikring(lineArr, lineNumber));
                        break;
                    case "Husforsikring":
                        importertListe.get(lastIndex).addForsikring(parseHusforsikring(lineArr, lineNumber));
                        break;
                    case "Fritidsboligforsikring":
                        importertListe.get(lastIndex).addForsikring(parseFritidsboligforsikring(lineArr, lineNumber));
                        break;
                    case "Reiseforsikring":
                        importertListe.get(lastIndex).addForsikring(parseReiseforsikring(lineArr, lineNumber));
                        break;
                    case "Skademelding":
                        importertListe.get(lastIndex).addSkademelding(parseSkademelding(lineArr, lineNumber));
                        break;
                    case "Erstatning":
                        importertListe.get(lastIndex).setUbetalteErstatninger(parseErstatning(lineArr));
                        break;
                    default:

                        break;
                }
            }
        } finally {
            if (reader != null) {
                reader.close();
            }
        }

        return importertListe;
    }

    private static Kunde parseKunde(String[] lineArr, int lineNumber) throws InvalidFormatException {

        if (lineArr.length != 5) {
            throw new InvalidFormatException("Feil Format på Kunde i linje:" + lineNumber);
        }
        LocalDate dato = LocalDate.parse(lineArr[2], mittFormat);
        Kunde kunde = new Kunde(lineArr[1], dato, lineArr[3], lineArr[4]);

        return kunde;
    }

    private static Batforsikring parseBatforsikring(String[] lineArr, int lineNumber) throws InvalidFormatException {

        if (lineArr.length != 13) {
            throw new InvalidFormatException("Feil Format på Batforsikring i linje:" + lineNumber);
        }
        LocalDate dato = LocalDate.parse(lineArr[3], mittFormat);
        Batforsikring batforsikring = new Batforsikring(
                parseNumber(lineArr[1], "Feil Format på arlig premie i linje:" + lineNumber),
                parseNumber(lineArr[2], "Feil Format på forsikringsbelop i linje:" + lineNumber),
                dato,
                lineArr[4],
                lineArr[5],
                lineArr[6],
                lineArr[7],
                lineArr[8],
                parseNumber(lineArr[1], "Feil Format på lengde i fot i linje:" + lineNumber),
                lineArr[10],
                lineArr[11],
                lineArr[12]
        );

        return batforsikring;
    }

    private static Fritidsboligforsikring parseFritidsboligforsikring(String[] lineArr, int lineNumber) throws InvalidFormatException {

        if (lineArr.length != 13) {
            throw new InvalidFormatException("Feil Format på Batforsikring i linje:" + lineNumber);
        }
        LocalDate dato = LocalDate.parse(lineArr[3], mittFormat);
        Fritidsboligforsikring fritidsboligforsikring = new Fritidsboligforsikring(
                parseNumber(lineArr[1], "Feil Format på arlig premie i linje:" + lineNumber),
                parseNumber(lineArr[2], "Feil Format på forsikringsbelop i linje:" + lineNumber),
                dato,
                lineArr[4],
                lineArr[5],
                lineArr[6],
                lineArr[7],
                lineArr[8],
                lineArr[9],
                parseNumber(lineArr[10], "Feil Format på kvadratmeter i linje:" + lineNumber),
                parseNumber(lineArr[11], "Feil Format på forsikringsbeløp(hus) i linje:" + lineNumber),
                parseNumber(lineArr[12], "Feil Format på forsikringsbeløp(innbo) i linje:" + lineNumber)
        );

        return fritidsboligforsikring;
    }

    private static Husforsikring parseHusforsikring(String[] lineArr, int lineNumber) throws InvalidFormatException {
        Husforsikring husforsikring = (Husforsikring) parseFritidsboligforsikring(lineArr, lineNumber);
        return husforsikring;
    }

    private static Reiseforsikring parseReiseforsikring(String[] lineArr, int lineNumber) throws InvalidFormatException {

        if (lineArr.length != 7) {
            throw new InvalidFormatException("Feil Format på Batforsikring i linje:" + lineNumber);
        }
        LocalDate dato = LocalDate.parse(lineArr[3], mittFormat);
        Reiseforsikring reiseforsikring = new Reiseforsikring(
                parseNumber(lineArr[1], "Feil Format på arlig premie i linje:" + lineNumber),
                parseNumber(lineArr[2], "Feil Format på forsikringsbelop i linje:" + lineNumber),
                dato,
                lineArr[4],
                lineArr[5],
                parseNumber(lineArr[6], "Feil Format på Forsikringssum i linje:" + lineNumber)
        );

        return reiseforsikring;
    }

    private static Skademelding parseSkademelding(String[] lineArr, int lineNumber) throws InvalidFormatException {

        if (lineArr.length != 7) {
            throw new InvalidFormatException("Feil Format på Batforsikring i linje:" + lineNumber);
        }
        LocalDate dato = LocalDate.parse(lineArr[1], mittFormat);
        Skademelding skademelding = new Skademelding(
                dato,
                lineArr[2],
                lineArr[3],
                lineArr[4],
                lineArr[5],
                parseNumber(lineArr[6], "Feil Format på takseringsbelop i linje:" + lineNumber)
        );

        return skademelding;
    }

    private static ArrayList<String> parseErstatning(String[] lineArr) throws InvalidFormatException {

        ArrayList<String> erstatninger = new ArrayList<>();

        for (String erstatning : lineArr) {
            erstatninger.add(erstatning);
        }

        return erstatninger;
    }

    private static int parseNumber(String str, String errorMessage) throws InvalidFormatException {
        int number;
        try {
            number = Integer.parseInt(str);
        } catch (NumberFormatException e) {
            throw new InvalidFormatException(errorMessage);
        }

        return number;
    }

    @Override
    protected Void call() throws Exception {
        try {
            lesKundeliste();
        } catch (Exception e) {
            System.out.println("Noe gikk galt"+e.getMessage()+e.getCause());
        }

        return null;
    }

    @Override
    protected void succeeded(){
        System.out.println("Succeeded");
    }
}