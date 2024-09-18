package rmi_tester.daten;

import java.io.Serializable;

import javax.xml.crypto.Data;

public class Bewerbung implements Serializable {
    private int bewerbungsid;
    private int bewerberid;
    Data datum;
    String status;

    public Bewerbung(int bewerbungsid, int bewerberid, Data datum, String status) {
        this.bewerbungsid = bewerbungsid;
        this.bewerberid = bewerberid;
        this.datum = datum;
        this.status = status;
    }


    public int getBewerbungsid() {
        return bewerbungsid;
    }

    public int getBewerberid() {
        return bewerberid;
    }

    public Data getDatum() {
        return datum;
    }

    public String getStatus() {
        return status;
    }
}
