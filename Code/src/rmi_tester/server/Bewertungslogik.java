package rmi_tester.server;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Bewertungslogik extends Remote {

    void starteErstenDurchlauf(int bewertungsid) throws RemoteException;
    String starteZweitenDurchlauf(int bewertungsid) throws RemoteException;

    void finaleBewertung(int bewertungsid) throws RemoteException;
    void zusageFürStelle(int bewertungsid) throws RemoteException;
    void bewerbungAblehnen(int bewertungsid) throws RemoteException;

    String getStatusByBewerbungsId(int bewertungsid) throws RemoteException;
}