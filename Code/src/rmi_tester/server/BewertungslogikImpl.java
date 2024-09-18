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
 * Die BewertungslogikImpl-Klasse implementiert die Methoden zur Bewertungslogik
 * über RMI (Remote Method Invocation).
 * <p>
 * Diese Klasse stellt Methoden zur Verfügung, um den ersten und zweiten
 * Durchlauf
 * der Bewerbung sowie die finale Bewertung zu starten.
 * </p>
 */
public class BewertungslogikImpl extends UnicastRemoteObject implements Bewertungslogik {

    /**
     * Konstruktor für BewertungslogikImpl.
     * 
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    protected BewertungslogikImpl() throws RemoteException {
        super();
    }

    /**
     * Startet den ersten Durchlauf der Bewerbung.
     * 
     * @param bewerbungsid Die Bewerbungs-ID.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public void starteErstenDurchlauf(int bewerbungsid) throws RemoteException {
        List<Termin> termine = new ArrayList<>();
        String sql = "SELECT t.terminid, t.bewerberid, t.mitarbeiterid, t.datum, t.bewerbungsid, b.vorname, b.nachname, t.bestätigt "
                +
                "FROM termin t " +
                "JOIN bewerber b ON t.bewerberid = b.bewerberid " +
                "WHERE t.mitarbeiterid = ?";
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

            int terminid = termine.get(0).getTerminid();
            String sql2 = "UPDATE termin SET bewerbungsid = ? WHERE terminid = ?";
            PreparedStatement pstmt2 = conn.prepareStatement(sql2);
            pstmt2.setInt(1, bewerbungsid);
            pstmt2.setInt(2, terminid);
            pstmt2.executeUpdate();

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Startet den zweiten Durchlauf der Bewerbung.
     * 
     * @param bewerbungsid Die Bewerbungs-ID.
     * @return Eine Nachricht, ob der zweite Durchlauf gestartet wurde oder ein
     *         Fehler auftrat.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public String starteZweitenDurchlauf(int bewerbungsid) throws RemoteException {
        String statusCheckSql = "SELECT status FROM bewerbung WHERE bewerbungsid = ?";
        String updateSql = "UPDATE termin SET bewerbungsid = ? WHERE terminid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();

            PreparedStatement pstmtCheck = conn.prepareStatement(statusCheckSql);
            pstmtCheck.setInt(1, bewerbungsid);
            ResultSet rsCheck = pstmtCheck.executeQuery();
            if (rsCheck.next()) {
                String status = rsCheck.getString("status");
                if ("1. Termin erfolgreich".equals(status)) {
                    List<Termin> termine = new ArrayList<>();
                    String sql = "SELECT t.terminid, t.bewerberid, t.mitarbeiterid, t.datum, t.bewerbungsid, b.vorname, b.nachname, t.bestätigt "
                            +
                            "FROM termin t " +
                            "JOIN bewerber b ON t.bewerberid = b.bewerberid " +
                            "WHERE t.mitarbeiterid = ?";
                    try {
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

                            Termin termin = new Termin(terminid, mitarbeiterid, datum, sql_bewerbungsid, bewerbername,
                                    bestätigt);
                            termine.add(termin);
                        }
                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                    PreparedStatement pstmtUpdate = conn.prepareStatement(updateSql);
                    pstmtUpdate.setInt(1, bewerbungsid);
                    pstmtUpdate.setInt(2, termine.get(1).getTerminid());
                    pstmtUpdate.executeUpdate();
                    pstmtUpdate.close();

                    rsCheck.close();
                    pstmtCheck.close();
                    conn.close();
                    return "Zweiten Durchlauf gestartet";
                } else {
                    rsCheck.close();
                    pstmtCheck.close();
                    conn.close();
                    return "Fehler bei der Verarbeitung. Status ist: " + status;
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "Fehler bei der Verarbeitung";
    }

    /**
     * Führt die finale Bewertung der Bewerbung durch.
     * 
     * @param bewertungsid Die Bewertungs-ID.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public void finaleBewertung(int bewertungsid) throws RemoteException {
        String status = getStatusByBewerbungsId(bewertungsid);
        if (status.equals("2. Termin erfolgreich")) {
            zusageFürStelle(bewertungsid);
        } else {
            bewerbungAblehnen(bewertungsid);
        }
    }

    /**
     * Gibt eine Zusage für die Stelle, wenn die finale Bewertung positiv ist.
     * 
     * @param bewertungsid Die Bewertungs-ID.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public void zusageFürStelle(int bewertungsid) throws RemoteException {
        System.out.println("Zusage für Stelle.");
    }

    /**
     * Lehnt die Bewerbung ab, wenn die finale Bewertung negativ ist.
     * 
     * @param bewertungsid Die Bewertungs-ID.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public void bewerbungAblehnen(int bewertungsid) throws RemoteException {
        System.out.println("Bewerbung abgelehnt.");
    }

    /**
     * Holt den Status der Bewerbung anhand der Bewerbungs-ID.
     * 
     * @param bewertungsid Die Bewertungs-ID.
     * @return Der Status der Bewerbung.
     * @throws RemoteException wenn ein RMI-Fehler auftritt.
     */
    @Override
    public String getStatusByBewerbungsId(int bewertungsid) throws RemoteException {
        String sql = "SELECT status FROM bewerbung WHERE bewerbungsid = ?";
        try {
            DatabaseConnection dbCon = new DatabaseConnection();
            Connection conn = dbCon.getConnection();
            PreparedStatement pstmt = conn.prepareStatement(sql);
            pstmt.setInt(1, bewertungsid);

            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                String status = rs.getString("status");
                return status;
            }

            rs.close();
            pstmt.close();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }
}
