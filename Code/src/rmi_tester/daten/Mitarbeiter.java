package rmi_tester.daten;

import java.io.Serializable;

public class Mitarbeiter implements Serializable {
    private int mitarbeiterid;
    private String vorname;
    private String nachname;
    private String email;

    public Mitarbeiter(int mitarbeiterid, String vorname, String nachname, String email) {
        this.mitarbeiterid = mitarbeiterid;
        this.vorname = vorname;
        this.nachname = nachname;
        this.email = email;
    }

    public int getMitarbeiterid() {
        return mitarbeiterid;
    }

    public String getVorname() {
        return vorname;
    }

    public String getNachname() {
        return nachname;
    }

    public String getEmail() {
        return email;
    }

    @Override
    public String toString() {
        return "ID: " + mitarbeiterid + ", Name: " + vorname + " " + nachname;
    }
}
