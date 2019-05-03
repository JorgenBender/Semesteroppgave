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
    private int utbetaltErstatningsbelop; //kan være lavere enn taksert beløp

    public Skademelding(LocalDate skadeDato,
                        String skadenummer,
                        String skadeType,
                        String skadeBeskrivelse,
                        String vitner_kontaktinformasjon,
                        int takseringsbelop,
                        int utbetaltErstatningsbelop) {
        this.skadeDato = skadeDato;
        this.skadenummer = skadenummer;
        this.skadeType = skadeType;
        this.skadeBeskrivelse = skadeBeskrivelse;
        this.vitner_kontaktinformasjon = vitner_kontaktinformasjon;
        this.takseringsbelop = takseringsbelop;
        this.utbetaltErstatningsbelop = utbetaltErstatningsbelop;
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

    public int getUtbetaltErstatningsbelop() {
        return utbetaltErstatningsbelop;
    }

    public void setUtbetaltErstatningsbelop(int utbetaltErstatningsbelop) {
        this.utbetaltErstatningsbelop = utbetaltErstatningsbelop;
    }

    public void setSkadeDato(LocalDate skadeDato) {
        this.skadeDato = skadeDato;
    }

    public void setSkadenummer(String skadenummer) {
        this.skadenummer = skadenummer;
    }

    public void setSkadeType(String skadeType) {
        this.skadeType = skadeType;
    }

    public void setSkadeBeskrivelse(String skadeBeskrivelse) {
        this.skadeBeskrivelse = skadeBeskrivelse;
    }

    public void setVitner_kontaktinformasjon(String vitner_kontaktinformasjon) {
        this.vitner_kontaktinformasjon = vitner_kontaktinformasjon;
    }

    public void setTakseringsbelop(int takseringsbelop) {
        this.takseringsbelop = takseringsbelop;
    }

    @Override
    public String toString(){
        return String.format("Skademelding:\n Skadedato: %s\n Skadenummer: %s\n Skadetype: %s\n" +
                            "Skadebeskrivelse: %s\n Vitner: %s\n Takseringsbeløp: %d \n Utbetalt Erstatningsbeløp: %d",
                            getSkadeDato().toString(),getSkadenummer(), getSkadeType(), getSkadeBeskrivelse(),
                            getVitner_kontaktinformasjon(), getTakseringsbelop(), getUtbetaltErstatningsbelop());
    }
    public String toCsv(){
        return String.format("Skademelding;%s;%s;%s;%s;%s;%d;%d",
                getSkadeDato().toString(),getSkadenummer(), getSkadeType(), getSkadeBeskrivelse(),
                getVitner_kontaktinformasjon(), getTakseringsbelop(), getUtbetaltErstatningsbelop());
    }

}
