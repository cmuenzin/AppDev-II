package rmi_tester.server;

import rmi_tester.daten.Termin;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.Connection;
import java.sql.Date;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

/**
 * Die TerminverwaltungImpl-Klasse implementiert die Methoden zur Verwaltung von
 * Terminen
 * über RMI (Remote Method Invocation).
 * <p>
 * Diese Klasse stellt Methoden zur Verfügung, um Termine zu erstellen, zu
 * ändern und zu verwalten.
 * </p>
 */
public class TerminverwaltungImpl extends UnicastRemoteObject implements Terminverwaltung {

    /**
     * Konstruktor für TerminverwaltungImpl.
     * 
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    protected TerminverwaltungImpl() throws RemoteException {
        super();
    }

    /**
     * Markiert einen Termin als "nicht erschienen".
     * 
     * @param terminid Die ID des Termins.
     * @return true, wenn der Termin erfolgreich aktualisiert wurde, sonst false.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public boolean nichtErschienen(int terminid) throws RemoteException {
        String sql = "UPDATE termin SET erschienen = 1 WHERE terminid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, terminid);

            int rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Bewertet einen Termin.
     * 
     * @param terminid  Die ID des Termins.
     * @param bewertung Die Bewertung des Termins.
     * @return Eine Nachricht, ob die Bewertung erfolgreich war oder nicht.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public String bewerteTermin(int terminid, String bewertung) throws RemoteException {
        String sql = "UPDATE termin SET bewertung = ? WHERE terminid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, bewertung);
            pstmt.setInt(2, terminid);

            int rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return rows > 0 ? "Bewertung erfolgreich" : "Bewertung fehlgeschlagen";
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Bewertung fehlgeschlagen";
    }

    /**
     * Empfiehlt oder empfiehlt einen Termin nicht.
     * 
     * @param terminid  Die ID des Termins.
     * @param empfohlen Der Empfehlungsstatus.
     * @return true, wenn der Empfehlungsstatus erfolgreich aktualisiert wurde,
     *         sonst false.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public boolean empfehleTermin(int terminid, boolean empfohlen) throws RemoteException {
        String sql = "UPDATE termin SET empfehlung = ? WHERE terminid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setBoolean(1, empfohlen);
            pstmt.setInt(2, terminid);

            int rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Holt die Termine für eine bestimmte Bewerbungs-ID.
     * 
     * @param bewerbungsid Die Bewerbungs-ID.
     * @return Eine Liste von Terminen.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public List<Termin> getTermineByBewerberId(int bewerbungsid) throws RemoteException {
        List<Termin> termine = new ArrayList<>();
        String sql = "SELECT t.terminid, t.bewerberid, t.mitarbeiterid, t.datum, t.bewerbungsid, b.vorname, b.nachname, t.bestätigt "
                +
                "FROM termin t " +
                "JOIN bewerber b ON t.bewerberid = b.bewerberid " +
                "WHERE t.bewerberid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bewerbungsid);

            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int terminid = rs.getInt("terminid");
                int mitarbeiterid = rs.getInt("mitarbeiterid");
                Date datum = rs.getDate("datum");
                int sql_bewerbungsid = rs.getInt("bewerberid");
                String bewerbername = rs.getString("vorname") + " " + rs.getString("nachname");
                boolean bestätigt = rs.getBoolean("bestätigt");

                Termin termin = new Termin(terminid, mitarbeiterid, datum, sql_bewerbungsid, bewerbername, bestätigt);
                termine.add(termin);
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return termine;
    }

    /**
     * Bestätigt einen Termin.
     * 
     * @param terminid Die ID des Termins.
     * @return true, wenn der Termin erfolgreich bestätigt wurde, sonst false.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public boolean bestätigeTermin(int terminid) throws RemoteException {
        String sql = "UPDATE termin SET bestätigt = 1 WHERE terminid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, terminid);

            int rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();
            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Lehnt einen Termin ab.
     * 
     * @param terminid Die ID des Termins.
     * @return true, wenn der Termin erfolgreich abgelehnt wurde, sonst false.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public boolean lehneTerminAb(int terminid) throws RemoteException {
        String sql = "UPDATE termin SET bestätigt = 0 WHERE terminid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, terminid);

            int rows = pstmt.executeUpdate();
            pstmt.close();
            conn.close();

            return rows > 0;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return false;
    }

    /**
     * Holt die Termine für eine bestimmte Mitarbeiter-ID.
     * 
     * @param mitarbeiterid Die Mitarbeiter-ID.
     * @return Eine Liste von Terminen.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public List<Termin> getTermineByMitarbeiterId(int mitarbeiterid) throws RemoteException {
        List<Termin> termine = new ArrayList<>();
        String sql = "SELECT t.terminid, t.bewerberid, t.mitarbeiterid, t.datum, t.bewerbungsid, b.vorname, b.nachname, t.bestätigt, t.bewertung, t.empfehlung " +
                     "FROM `termin` AS `t` " +
                     "JOIN `bewerber` AS `b` ON `t`.`bewerberid` = `b`.`bewerberid` " +
                     "WHERE `t`.`mitarbeiterid` = ?";
    
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, mitarbeiterid);
    
            ResultSet rs = pstmt.executeQuery();
            while (rs.next()) {
                int terminid = rs.getInt("terminid");
                int mid = rs.getInt("mitarbeiterid");
                Date datum = rs.getDate("datum");
                int bewerbungsid = rs.getInt("bewerbungsid");
                String bewerbername = rs.getString("vorname") + " " + rs.getString("nachname");
                boolean bestätigt = rs.getBoolean("bestätigt");
                String bewertung = rs.getString("bewertung");
                boolean empfehlung = rs.getBoolean("empfehlung");
    
                Termin termin = new Termin(terminid, mid, datum, bewerbungsid, bewerbername, bestätigt, bewertung, empfehlung);
                termine.add(termin);
            }
    
            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return termine;
    }
    

    /**
     * Setzt ein neues Datum für eine Einladung.
     * 
     * @param bewerbungsid  Die Bewerbungs-ID.
     * @param mitarbeiterid Die Mitarbeiter-ID.
     * @param datum         Das neue Datum der Einladung.
     * @return Das neue Datum.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public void neueEinladung(int bewerbungsid) throws RemoteException {
        int terminid = 0;

        String sqlGetTerminID = "SELECT terminid FROM termin WHERE bewerbungsid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlGetTerminID);
            pstmt.setInt(1, 0);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                terminid = rs.getInt("terminid");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        String sqlUpdate = "UPDATE termin SET bewerbungsid WHERE terminid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sqlUpdate);
            pstmt.setInt(1, terminid);

            pstmt.executeUpdate();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Override
    public int getBewerbungsidByTerminiD(int terminid) throws RemoteException {
        int bewerbungsid = 0;
        String sql = "SELECT bewerbungsid FROM termin WHERE terminid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, terminid);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                bewerbungsid = rs.getInt("bewerbungsid");
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return bewerbungsid;
    }
}
