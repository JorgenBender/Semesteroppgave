package org.Forsikringsregister.Programlogikk;

import java.io.Serializable;
import java.time.LocalDate;  // import the LocalDate class



public class Skademelding implements Serializable {

    private LocalDate skadeDato;
    private String skadenummer;
    private String skadeType;
    private String skadeBeskrivelse;
    private String vitner_kontaktinformasjon;
    private int takseringsbelop;
    private int utbetalt_erstatningsbelop; //kan være lavere enn taksert beløp

    public Skademelding(LocalDate skadeDato,
                        String skadenummer,
                        String skadeType,
                        String skadeBeskrivelse,
                        String vitner_kontaktinformasjon,
                        int takseringsbelop) {
        this.skadeDato = skadeDato;
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

    @Override
    public String toString(){
        return String.format("Skademelding:\n Skadedato: %s\n Skadenummer: %s\n Skadetype: %s\n" +
                            "Skadebeskrivelse: %s\n Vitner: %s\n Takseringsbeløp: %d \n Utbetalst Erstatningsbeløp: %d",
                            getSkadeDato().toString(),getSkadenummer(), getSkadeType(), getSkadeBeskrivelse(),
                            getVitner_kontaktinformasjon(), getTakseringsbelop(), getUtbetalt_erstatningsbelop());
    }

}
