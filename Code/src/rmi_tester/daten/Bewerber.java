package rmi_tester.daten;

import java.io.Serializable;

public class Bewerber implements Serializable {
    private int bewerberid;
    private String vorname;
    private String nachname;
    private String adresse;
    private String email;

    public Bewerber(int bewerberid, String vorname, String nachname, String adresse, String email) {
        this.bewerberid = bewerberid;
        this.vorname = vorname;
        this.nachname = nachname;
        this.adresse = adresse;
        this.email = email;
    }

    public int getBewerberid() {
        return bewerberid;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getAdresse() {
        return adresse;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ID: " + bewerberid + ", Name: " + vorname + " " + nachname;
    }
}
