package rmi_tester.daten;

import java.io.Serializable;
import java.sql.Date;

public class Termin implements Serializable {
    private int terminid;
    private int mitarbeiterid;
    private Date datum;
    private int bewerbungsid;
    private String bewerbername;
    private boolean bestätigt;
    private String bewertung;
    private boolean empfehlung;

    public Termin(int terminid, int mitarbeiterid, Date datum, int bewerbungsid, String bewerbername, boolean bestätigt) {
        this.terminid = terminid;
        this.mitarbeiterid = mitarbeiterid;
        this.datum = datum;
        this.bewerbungsid = bewerbungsid;
        this.bewerbername = bewerbername;
        this.bestätigt = bestätigt;
    }

    public Termin(int terminid, int mitarbeiterid, Date datum, int bewerbungsid, String bewerbername, boolean bestätigt, String bewertung, boolean empfehlung) {
        this.terminid = terminid;
        this.mitarbeiterid = mitarbeiterid;
        this.datum = datum;
        this.bewerbungsid = bewerbungsid;
        this.bewerbername = bewerbername;
        this.bestätigt = bestätigt;
    }

    public int getTerminid() {
        return terminid;
    }

    public int getMitarbeiterid() {
        return mitarbeiterid;
    }

    public Date getDatum() {
        return datum;
    }

    public int getBewerbungsid() {
        return bewerbungsid;
    }

    public String getBewerbername() {
        return bewerbername;
    }

    public boolean isBestätigt() {
        return bestätigt;
    }

    public String getBewertung() {
        return bewertung;
    }

    public boolean getEmpfehlung() {
        return empfehlung;
    }

    @Override
    public String toString() {
        return "Termin ID: " + terminid + ", Mitarbeiter ID: " + mitarbeiterid + ", Datum: " + datum + 
               ", Bewerbungs ID: " + bewerbungsid + ", Bewerbername: " + bewerbername + ", Bestätigt: " + bestätigt;
    }
}
