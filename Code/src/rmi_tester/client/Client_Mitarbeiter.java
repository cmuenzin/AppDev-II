package rmi_tester.client;

import rmi_tester.daten.Mitarbeiter;
import rmi_tester.daten.Termin;
import rmi_tester.server.Anmeldung;
import rmi_tester.server.Bewertungslogik;
import rmi_tester.server.Terminverwaltung;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

/**
 * Die Client_Mitarbeiter-Klasse repräsentiert den Client für Mitarbeiter,
 * der es ihnen ermöglicht, sich anzumelden, Feedback und Empfehlungen zu
 * Terminen zu geben.
 * <p>
 * Diese Klasse interagiert mit den Remote-Objekten Anmeldung und
 * Terminverwaltung,
 * um die erforderlichen Daten zu erhalten und zu speichern.
 * </p>
 */
public class Client_Mitarbeiter {
    int mitarbeiterid = 0;

    /**
     * Die main-Methode ist der Einstiegspunkt der Anwendung.
     * Sie startet das Mitarbeiterportal und zeigt das Menü für den Benutzer an.
     * 
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        System.out.println("System: Mitarbeiterportal gestartet");

        Client_Mitarbeiter mitarbeiter = new Client_Mitarbeiter();
        mitarbeiter.printMenu();

        System.out.println("System: Mitarbeiterportal beendet");
    }

    /**
     * Zeigt das Hauptmenü des Mitarbeiterportals an und ermöglicht dem Benutzer,
     * verschiedene Aktionen auszuwählen.
     */
    public void printMenu() {
        System.out.println("Willkommen im Mitarbeiterportal");

        if (mitarbeiterid == 0) {
            mitarbeiterid = anmelden();
        }

        Scanner scanner = new Scanner(System.in);
        int choice = 0;

        while (choice != 3) {
            System.out.println("Bitte wählen Sie eine Option:");
            System.out.println("1. Feedback geben");
            System.out.println("2. Empfehlung geben");
            System.out.println("3. Ausloggen");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    bewertungGeben(mitarbeiterid);
                    break;
                case 2:
                    empfehlungGeben(mitarbeiterid);
                    break;
                case 3:
                    System.out.println("Sie wurden abgemeldet.");
                    mitarbeiterid = 0;
                    printMenu();
                default:
                    System.out.println("Ungültige Option. Bitte wählen Sie erneut.");
                    break;
            }
        }
    }

    /**
     * Meldet den Mitarbeiter an und gibt die Mitarbeiter-ID zurück.
     * 
     * @return Die Mitarbeiter-ID des angemeldeten Mitarbeiters
     */
    public int anmelden() {
        try {
            Anmeldung anmeldung = (Anmeldung) Naming.lookup("//localhost/Anmeldung");
            List<Mitarbeiter> mitarbeiterList = anmeldung.getAllMitarbeiter();

            if (mitarbeiterList.isEmpty()) {
                System.out.println("Keine Mitarbeiter gefunden.");
                return 0;
            }

            int mitarbeiterid = 0;
            while (mitarbeiterid == 0) {
                do {
                    System.out.println("Wählen Sie Ihre Mitarbeiter-ID");
                    for (Mitarbeiter mitarbeiter : mitarbeiterList) {
                        System.out.println(mitarbeiter);
                    }
                    System.out.println("ID:");
                    Scanner scanner = new Scanner(System.in);
                    mitarbeiterid = scanner.nextInt();
                    Anmeldung anmeldung2 = (Anmeldung) Naming.lookup("//localhost/Anmeldung");
                    if (!anmeldung2.isValidMitarbeiterId(mitarbeiterid, mitarbeiterList)) {
                        System.out.println("Ungültige Mitarbeiter-ID. Bitte wählen Sie erneut.");
                        mitarbeiterid = 0;
                    }
                } while (mitarbeiterid == 0);
                return mitarbeiterid;
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return 0;
    }

    /**
     * Holt die Termine für den Mitarbeiter und gibt sie zurück.
     * 
     * @param mitarbeiterid Die Mitarbeiter-ID des angemeldeten Mitarbeiters
     * @return Eine Liste von Terminen für den Mitarbeiter
     */
    public List<Termin> termineHolen(int mitarbeiterid) {
        try {
            Terminverwaltung terminverwaltung = (Terminverwaltung) Naming.lookup("//localhost/Terminverwaltung");
            List<Termin> termine = terminverwaltung.getTermineByMitarbeiterId(mitarbeiterid);

            if (!termine.isEmpty()) {
                System.out.println("> Ihre Termine");
                for (Termin termin : termine) {
                    System.out.println("Termin ID: " + termin.getTerminid() + ", Datum: " + termin.getDatum()
                            + ", Name: " + termin.getBewerbername() + ", Bestätigt: " + termin.isBestätigt()
                            + ", Bewertet: " + termin.getBewertung() + ", Empfohlen: " + termin.getEmpfehlung());
                }
            } else {
                System.out.println("Sie haben noch keinen Termin");
                return null;
            }
            return termine;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Holt die Termine, die noch nicht bewertet wurden, für den Mitarbeiter und gibt sie zurück.
     * 
     * @param mitarbeiterid Die Mitarbeiter-ID des angemeldeten Mitarbeiters
     * @return Eine Liste von Terminen ohne Bewertung für den Mitarbeiter
     */
    public List<Termin> termineOhneBewertungHolen(int mitarbeiterid) {
        List<Termin> termine = termineHolen(mitarbeiterid);
        return termine == null ? List.of() : termine.stream().filter(termin -> termin.getBewertung() == null || termin.getBewertung().isEmpty()).collect(Collectors.toList());
    }

    /**
     * Holt die Termine, die noch nicht empfohlen wurden, für den Mitarbeiter und gibt sie zurück.
     * 
     * @param mitarbeiterid Die Mitarbeiter-ID des angemeldeten Mitarbeiters
     * @return Eine Liste von Terminen ohne Empfehlung für den Mitarbeiter
     */
    public List<Termin> termineOhneEmpfehlungHolen(int mitarbeiterid) {
        List<Termin> termine = termineHolen(mitarbeiterid);
        return termine == null ? List.of() : termine.stream().filter(termin -> !termin.getEmpfehlung()).collect(Collectors.toList());
    }

    /**
     * Ermöglicht dem Mitarbeiter, eine Bewertung für einen Termin abzugeben.
     * 
     * @param mitarbeiterid Die Mitarbeiter-ID des angemeldeten Mitarbeiters
     */
    public void bewertungGeben(int mitarbeiterid) {
        System.out.println("--------------- Feedback Geben ----------------");
        System.out.println("              > Terminauswahl <");

        List<Termin> termine = termineOhneBewertungHolen(mitarbeiterid);

        if (termine.isEmpty()) {
            System.out.println("Keine Termine ohne Bewertung vorhanden.");
            return;
        }

        System.out.println("Bitte geben Sie die ID des Termins ein, zu dem Sie eine Bewertung abgeben möchten:");
        Scanner scanner = new Scanner(System.in);
        int terminid = scanner.nextInt();
        scanner.nextLine(); // Clear the newline character

        System.out.println("Bitte geben Sie Ihre Bewertung zu dem Termin mit der ID " + terminid + " ein:");
        String bewertung = scanner.nextLine();

        try {
            Terminverwaltung termin = (Terminverwaltung) Naming.lookup("//localhost/Terminverwaltung");
            termin.bewerteTermin(terminid, bewertung);
            System.out.println("Bewertung erfolgreich gespeichert.");

        } catch (Exception e) {
            System.out.println("Warnung: Speichern fehlgeschlagen");
            e.printStackTrace();
        }
    }

    /**
     * Ermöglicht dem Mitarbeiter, eine Empfehlung für einen Termin abzugeben.
     * 
     * @param mitarbeiterid Die Mitarbeiter-ID des angemeldeten Mitarbeiters
     */
    public void empfehlungGeben(int mitarbeiterid) {
        System.out.println("-------------- Empfehlung Geben ----------------");
        System.out.println("              > Terminauswahl <");

        List<Termin> termine = termineOhneEmpfehlungHolen(mitarbeiterid);

        if (termine.isEmpty()) {
            System.out.println("Keine Termine ohne Empfehlung vorhanden.");
            return;
        }

        System.out.println("Bitte geben Sie die ID des Termins ein, zu dem Sie eine Empfehlung abgeben möchten:");
        Scanner scanner = new Scanner(System.in);
        int terminid = scanner.nextInt();

        boolean empfehlung = false;
        System.out.println("Bitte geben Sie Ihre Empfehlung zu dem Termin mit der ID " + terminid + " ein:");
        System.out.println("[1] Einstellen");
        System.out.println("[2] Nicht Einstellen");
        int empfehlungInt = scanner.nextInt();
        if (empfehlungInt == 1) {
            empfehlung = true;
        } else {
            empfehlung = false;
        }

        try {
            Terminverwaltung termin = (Terminverwaltung) Naming.lookup("//localhost/Terminverwaltung");
            termin.empfehleTermin(terminid, empfehlung);
            System.out.println("Empfehlung erfolgreich gespeichert.");

            int bewerbungsid = termin.getBewerbungsidByTerminiD(terminid);
            Bewertungslogik bewertungslogik = (Bewertungslogik) Naming.lookup("//localhost/Bewertungslogik");

            String status = bewertungslogik.getStatusByBewerbungsId(bewerbungsid).trim();
            switch (status) {
                case "eingegangen":
                    bewertungslogik.starteErstenDurchlauf(bewerbungsid);
                    System.out.println("Erster Durchlauf gestartet");
                    break;
                case "1. Termin erfolgreich":
                    if (empfehlung == true) {
                        bewertungslogik.starteZweitenDurchlauf(bewerbungsid);
                        System.out.println("Zweiter Durchlauf gestartet");                        
                    } else {
                        bewertungslogik.bewerbungAblehnen(bewerbungsid);
                        System.out.println("Bewerbung abgelehnt");
                    }
                    break;
                case "2. Termin erfolgreich":
                    if (empfehlung == true) {
                        bewertungslogik.finaleBewertung(bewerbungsid);
                        System.out.println("Bewerbung erfolgreich abgeschlossen");
                    } else {
                        bewertungslogik.bewerbungAblehnen(bewerbungsid);
                        System.out.println("Bewerbung abgelehnt");
                    }
                    break;
            
                default:
                    System.out.println("Fehler im Bewerbungsstatus");
                    System.out.println("Status: " + bewertungslogik.getStatusByBewerbungsId(bewerbungsid));
                    break;
            }

        } catch (Exception e) {
            System.out.println("Warnung: Speichern fehlgeschlagen");
            e.printStackTrace();
        }
    }
}
