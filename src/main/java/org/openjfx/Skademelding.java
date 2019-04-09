package org.openjfx;

import java.time.LocalDate;  // import the LocalDate class
import java.time.format.DateTimeFormatter; // Import the DateTimeFormatter class


public class Skademelding {

    private DateTimeFormatter mittFormat = DateTimeFormatter.ofPattern("dd/MM/yyyy");

    private LocalDate skadeDato;
    private String skadenummer;
    private String skadeType;
    private String skadeBeskrivelse;
    private String vitner_kontaktinformasjon;
    private int takseringsbeløp;
    private int utbetalt_erstatningsbeløp; //kan være lavere enn taksert beløp

    public Skademelding(String skadeDato,
                        String skadenummer,
                        String skadeType,
                        String skadeBeskrivelse,
                        String vitner_kontaktinformasjon,
                        int takseringsbeløp) {
        this.skadeDato = LocalDate.parse(skadeDato, mittFormat);
        this.skadenummer = skadenummer;
        this.skadeType = skadeType;
        this.skadeBeskrivelse = skadeBeskrivelse;
        this.vitner_kontaktinformasjon = vitner_kontaktinformasjon;
        this.takseringsbeløp = takseringsbeløp;
    }
}
