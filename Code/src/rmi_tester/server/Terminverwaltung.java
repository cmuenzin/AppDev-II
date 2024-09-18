package rmi_tester.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import rmi_tester.daten.Termin;

public interface Terminverwaltung extends Remote{
    //Bewerber
    List<Termin> getTermineByBewerberId(int bewerbungsid) throws RemoteException;
    boolean bestätigeTermin(int terminid) throws RemoteException;
    boolean lehneTerminAb(int terminid) throws RemoteException;
    void neueEinladung(int bewerbungsid) throws RemoteException;

    //Mitarbeiter
    List<Termin> getTermineByMitarbeiterId(int mitarbeiterid) throws RemoteException;
    boolean nichtErschienen(int terminid) throws RemoteException;
    boolean empfehleTermin(int terminid, boolean empfohlen) throws RemoteException;
    String bewerteTermin(int terminid, String bewertung) throws RemoteException;
    int getBewerbungsidByTerminiD(int terminid) throws RemoteException;
}
