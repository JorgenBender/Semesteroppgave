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
    private int takseringsbelop;
    private int utbetalt_erstatningsbelop; //kan være lavere enn taksert beløp

    public Skademelding(String skadeDato,
                        String skadenummer,
                        String skadeType,
                        String skadeBeskrivelse,
                        String vitner_kontaktinformasjon,
                        int takseringsbelop) {
        this.skadeDato = LocalDate.parse(skadeDato, mittFormat);
        this.skadenummer = skadenummer;
        this.skadeType = skadeType;
        this.skadeBeskrivelse = skadeBeskrivelse;
        this.vitner_kontaktinformasjon = vitner_kontaktinformasjon;
        this.takseringsbelop = takseringsbelop;
    }

    public LocalDate getSkadeDato() {
        return skadeDato;
    }

    public String getSkadenummer() {
        return skadenummer;
    }

    public String getSkadeType() {
        return skadeType;
    }

    public String getSkadeBeskrivelse() {
        return skadeBeskrivelse;
    }

    public String getVitner_kontaktinformasjon() {
        return vitner_kontaktinformasjon;
    }

    public int getTakseringsbelop() {
        return takseringsbelop;
    }

    public int getUtbetalt_erstatningsbelop() {
        return utbetalt_erstatningsbelop;
    }
}
