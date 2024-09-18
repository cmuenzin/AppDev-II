package rmi_tester.server;

import rmi_tester.daten.Bewerber;
import rmi_tester.daten.Mitarbeiter;

import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Die AnmeldungImpl-Klasse implementiert die Methoden zur Verwaltung von Bewerbern
 * und Mitarbeitern über RMI (Remote Method Invocation).
 * <p>
 * Diese Klasse stellt Methoden zur Verfügung, um alle Bewerber und Mitarbeiter
 * aus der Datenbank abzurufen.
 * </p>
 */
public class AnmeldungImpl extends UnicastRemoteObject implements Anmeldung {

    /**
     * Konstruktor für AnmeldungImpl.
     * 
     * @throws java.rmi.RemoteException wenn ein RMI-Fehler auftritt.
     */
    protected AnmeldungImpl() throws java.rmi.RemoteException {
        super();
    }

    /**
     * Ruft eine Liste aller Bewerber aus der Datenbank ab.
     * 
     * @return Eine Liste von Bewerbern.
     * @throws java.rmi.RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public List<Bewerber> getAllBewerber() throws java.rmi.RemoteException {
        List<Bewerber> bewerber = new ArrayList<>();
        String sql = "SELECT bewerberid, vorname, nachname, adresse, email FROM bewerber";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("bewerberid");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                String adresse = rs.getString("adresse");
                String email = rs.getString("email");

                Bewerber b = new Bewerber(id, vorname, nachname, adresse, email);
                bewerber.add(b);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bewerber;
    }

    /**
     * Ruft eine Liste aller Mitarbeiter aus der Datenbank ab.
     * 
     * @return Eine Liste von Mitarbeitern.
     * @throws java.rmi.RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public List<Mitarbeiter> getAllMitarbeiter() throws java.rmi.RemoteException {
        List<Mitarbeiter> mitarbeiter = new ArrayList<>();
        String sql = "SELECT mitarbeiterid, vorname, nachname, email FROM mitarbeiter";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();

            PreparedStatement pstmt = conn.prepareStatement(sql);
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int id = rs.getInt("mitarbeiterid");
                String vorname = rs.getString("vorname");
                String nachname = rs.getString("nachname");
                String email = rs.getString("email");

                Mitarbeiter m = new Mitarbeiter(id, vorname, nachname, email);
                mitarbeiter.add(m);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return mitarbeiter;
    }

    /**
     * Überprüft, ob die Mitarbeiter-ID gültig ist.
     * 
     * @param mitarbeiterid Die Mitarbeiter-ID, die überprüft werden soll
     * @param mitarbeiterList Eine Liste von Mitarbeitern
     * @return true, wenn die Mitarbeiter-ID gültig ist, andernfalls false
     */
    @Override
    public boolean isValidMitarbeiterId(int mitarbeiterid, List<Mitarbeiter> mitarbeiterList) throws java.rmi.RemoteException{
        
        for (Mitarbeiter mitarbeiter : mitarbeiterList) {
            if (mitarbeiter.getMitarbeiterid() == mitarbeiterid) {
                return true;
            }
        }
        return false;
    }
}
