package rmi_tester.server;

import java.rmi.Naming;
import java.rmi.registry.LocateRegistry;

/**
 * Die Server-Klasse startet den RMI-Server und bindet die Remote-Objekte im RMI-Registry.
 * <p>
 * Diese Klasse erstellt Instanzen der Implementierungsklassen und registriert diese
 * im RMI-Registry, um Remote-Methodenaufrufe zu ermöglichen.
 * </p>
 */
public class Server {
    /**
     * Der Einstiegspunkt des Servers, der das RMI-Registry erstellt und die Remote-Objekte bindet.
     * 
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        try {
            // Erstelle das RMI-Registry auf Port 1099
            LocateRegistry.createRegistry(1099);

            // Instanzen der Implementierungsklassen erstellen
            AnmeldungImpl anmeldung = new AnmeldungImpl();
            TerminverwaltungImpl terminverwaltung = new TerminverwaltungImpl();
            BewertungslogikImpl bewertungslogik = new BewertungslogikImpl();

            // Die Remote-Objekte im RMI-Registry binden
            Naming.rebind("//localhost/Anmeldung", anmeldung);
            Naming.rebind("//localhost/Terminverwaltung", terminverwaltung);
            Naming.rebind("//localhost/Bewertungslogik", bewertungslogik);

            System.out.println("Der BMS Server ist ready.");
        } catch (Exception e) {
            System.out.println("BMS Server failed: " + e);
        }
    }
}
