package rmi_tester.client;

import rmi_tester.daten.Bewerber;
import rmi_tester.daten.Termin;
import rmi_tester.server.Anmeldung;
import rmi_tester.server.Bewertungslogik;
import rmi_tester.server.Terminverwaltung;

import java.rmi.Naming;
import java.util.List;
import java.util.Scanner;

/**
 * Die Client_Bewerber-Klasse repräsentiert den Client für Bewerber,
 * der es ihnen ermöglicht, sich anzumelden, Termine zu wählen und den
 * Status ihrer Bewerbung abzurufen.
 * <p>
 * Diese Klasse interagiert mit den Remote-Objekten Anmeldung, Terminverwaltung
 * und Bewertungslogik, um die erforderlichen Daten zu erhalten.
 * </p>
 */
public class Client_Bewerber {
    int bewerbungsid;

    /**
     * Die main-Methode ist der Einstiegspunkt der Anwendung.
     * Sie startet das Bewerberportal und zeigt das Menü für den Benutzer an.
     * 
     * @param args Kommandozeilenargumente (werden nicht verwendet)
     */
    public static void main(String[] args) {
        System.out.println("System: Bewerberportal gestartet");

        Client_Bewerber bewerber = new Client_Bewerber();
        bewerber.printMenu();

        System.out.println("System: Bewerberportal beendet");
    }

    /**
     * Zeigt das Hauptmenü des Bewerberportals an und ermöglicht dem Benutzer,
     * verschiedene Aktionen auszuwählen.
     */
    public void printMenu() {
        System.out.println("------- Willkommen im Bewerberportal -------");

        bewerbungsid = anmelden();

        Scanner scanner = new Scanner(System.in);
        int choice = 0;
        while (choice != 3) {
            System.out.println("Bitte wählen Sie eine Option:");
            System.out.println("(1) Termin wählen");
            System.out.println("(2) Status der Bewerbung abrufen");
            System.out.println("(3) Abmelden");
            System.out.print("-> ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    terminWaehlen(bewerbungsid);
                    break;
                case 2:
                    statusAbrufen(bewerbungsid);
                    break;
                case 3:
                    System.out.println("Sie wurden abgemeldet. Auf Wiedersehen!");
                    printMenu();
                    break;
                default:
                    System.out.println("Ungültige Auswahl. Bitte versuchen Sie es erneut");
                    break;
            }
        }
        scanner.close();
    }

    /**
     * Meldet den Bewerber an und gibt die Bewerbungs-ID zurück.
     * 
     * @return Die Bewerbungs-ID des angemeldeten Bewerbers
     */
    public int anmelden() {
        try {
            Anmeldung anmeldung = (Anmeldung) Naming.lookup("//localhost/Anmeldung");
            List<Bewerber> bewerberList = anmeldung.getAllBewerber();

            if (bewerberList.isEmpty()) {
                System.out.println("Keine Bewerber gefunden.");
            }

            System.out.println("Wählen Sie Ihre Bewerber-ID:");
            for (Bewerber bewerber : bewerberList) {
                System.out.println(bewerber);
            }

            Scanner scanner = new Scanner(System.in);
            bewerbungsid = scanner.nextInt();
            // scanner.close();
            return bewerbungsid;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return bewerbungsid;

    }

    /**
     * Holt die Termine für den Bewerber und gibt sie zurück.
     * 
     * @return Eine Liste von Terminen für den Bewerber
     */
    public List<Termin> termineHolen() {
        try {
            Terminverwaltung einladung = (Terminverwaltung) Naming.lookup("//localhost/Terminverwaltung");
            List<Termin> termine = einladung.getTermineByBewerberId(bewerbungsid);
            if (!termine.isEmpty()) {
                System.out.println("> Ihre Termine");
                for (Termin termin : termine) {
                    System.out.println("Termin ID: " + termin.getTerminid() + ", Datum: " + termin.getDatum()
                            + ", Bestätigt: " + termin.isBestätigt());
                    System.out.println("Bewerbungs ID: " + termin.getBewerbungsid() + ", Bewerbername: "
                            + termin.getBewerbername());
                }
            } else {
                System.out.println("Sie haben keine Termine gebucht.");
            }
            return termine;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * Ermöglicht dem Bewerber, einen Termin zu wählen.
     * 
     * @param bewerbungsid Die Bewerbungs-ID des angemeldeten Bewerbers
     */
    public void terminWaehlen(int bewerbungsid) {
        Scanner scanner = new Scanner(System.in);
        try {
            Terminverwaltung terminverwaltung = (Terminverwaltung) Naming.lookup("//localhost/Terminverwaltung");
            List<Termin> termine = terminverwaltung.getTermineByBewerberId(bewerbungsid);

            if (!termine.isEmpty()) {
                for (Termin termin : termine) {
                    if (termin.isBestätigt() == false) {
                        System.out.println("Termin ID: " + termin.getTerminid() + ", Datum: " + termin.getDatum());
                        System.out.println("Termin buchen? (ja/nein)");
                        String antwort = scanner.nextLine();
                        if (antwort.equals("ja")) {
                            terminverwaltung.bestätigeTermin(termin.getTerminid());
                            System.out.println("Termin gebucht.");
                            break; // Beendet die Schleife, nachdem der erste Termin bestätigt wurde
                        } else if (antwort.equals("nein")) {
                            terminverwaltung.lehneTerminAb(termin.getTerminid());
                            terminverwaltung.neueEinladung(bewerbungsid);
                            System.out.println("Termin nicht gebucht.");
                        } else {
                            System.out.println("Ungültige Eingabe. Bitte versuchen Sie es erneut.");
                        }
                    } else {
                        System.out.println("Termin bereits bestätigt.");
                    }

                }
            } else {
                System.out.println("Keine Termine gefunden.");
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Ruft den Status der Bewerbung des Bewerbers ab.
     * 
     * @param bewerbungsid Die Bewerbungs-ID des angemeldeten Bewerbers
     */
    public void statusAbrufen(int bewerbungsid) {
        try {
            Bewertungslogik bewertungslogik = (Bewertungslogik) Naming.lookup("//localhost/Bewertungslogik");
            String status = bewertungslogik.getStatusByBewerbungsId(bewerbungsid);
            System.out.println("Status der Bewerbung: " + status);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
