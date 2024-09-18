package rmi_tester.server;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

import rmi_tester.daten.Mitarbeiter;
import rmi_tester.daten.Bewerber;

public interface Anmeldung extends Remote {
    //Bewerber
    List<Bewerber> getAllBewerber() throws RemoteException;

    //Mitarbeiter
    List<Mitarbeiter> getAllMitarbeiter() throws RemoteException;

    boolean isValidMitarbeiterId(int mitarbeiterid, List<Mitarbeiter> mitarbeiterList) throws RemoteException;
}
