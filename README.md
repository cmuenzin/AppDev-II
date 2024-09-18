# Bewerbungsmanagement-System - AppDevII

Das Bewerbungsmanagement-System ist ein Projekt, das im Rahmen der Vorlesung AppDevII an der RH Köln entwickelt wird. Es zielt darauf ab, den Prozess der Bewerberverwaltung und Interviewplanung zu automatisieren und zu vereinfachen.

## Gruppe
Muenzinger, Gattung, Stricker

## Aufgabenstellung

## A1: Erstellen eines graphischen Prozessmodells und eines Datenmodells

- **Aufgabe**: Entwickeln Sie ein graphisches Prozessmodell und ein Datenmodell mit einem relationalen Schema, das speziell auf die Anforderungen Ihrer Gruppe zugeschnitten ist.
- **Abgabe**:
  - **Was zu tun ist**: Laden Sie das Datenmodell und das Prozessmodell auf die Lernplattform ILIAS hoch.
  - **Frist**: Bis zum **15. Mai 2024**.

## A2: Entwicklung einer Drei-Schichten-Architektur

- **Aufgabe**: Erstellen Sie eine Drei-Schichten-Architektur für die Anwendung. Ordnen Sie den einzelnen Schichten die entsprechenden Daten bzw. Methoden zu, die notwendig sind, um den beschriebenen Prozess auszuführen.
- **Abgabe**:
  - **Was zu tun ist**: Laden Sie eine graphische Darstellung der Architektur auf ILIAS hoch.
  - **Frist**: Bis zum **29. Mai 2024**.

## A3: Implementierung der Dienste und Realisierung des Prozesses

- **Aufgabe**: Implementieren Sie die Dienste und realisieren Sie den Prozess beispielhaft mit Testdaten, die alle möglichen Abläufe des Prozesses (inklusive Entscheidungen) abdecken.
- **Abgabe**:
  - **Was zu tun ist**: Laden Sie die Dokumentation über den Prozess, die Modelle, die Implementierung und Ihre definierten Testfälle auf ILIAS hoch.
  - **Frist**: Bis zum **03. Juli 2024**.

## Thema

Bewerbung und Bewerbungsgespräch

Ein Bewerber wird zu einem Vorstellungsgespräch eingeladen. Wenn der dabei vorgeschlagene Termin durch den Bewerber bestätigt wird, erfolgt das Gespräch mit einer kurzen Bewertung und Empfehlung im System, ansonsten wird ein Alternativtermin gefunden. Erscheint der Bewerber nicht, wird die Bewerbung abgelehnt. Nach einem Gespräch wird durch einen Mitarbeiter entschieden, ob der Bewerber zu einem zweiten Gespräch eingeladen wird, worauf der gleiche Ablauf erfolgt. Danach erfolgt eine abschließende Bewertung der Gespräche und es ergeht eine Absage oder Zusage an den Bewerber.

### Kernfunktionen

- **Einladung zum Vorstellungsgespräch:** Ein Bewerber wird zu einem Vorstellungsgespräch eingeladen.
- **Terminbestätigung:** Der Bewerber bestätigt oder fordert einen Alternativtermin an.
- **Durchführung des Gesprächs:** Falls der Bewerber erscheint, wird das Gespräch durchgeführt und bewertet. Falls nicht, wird die Bewerbung abgelehnt.
- **Entscheidung über weitere Gespräche:** Ein Mitarbeiter entscheidet, ob der Bewerber zu einem zweiten Gespräch eingeladen wird.
- **Abschließende Bewertung:** Nach dem zweiten Gespräch erfolgt eine endgültige Bewertung, die zu einer Zusage oder Absage führt.

  ### Schnittstellen
  - **Anwendungsschicht - Prozesslogik**
  - Aufrufe aus der Anwendungsschicht nach untem aufegführten Standard-Format:
  - GUI bildet beide Sichtweisen ab. 
    
  - **Prozesslogik - Datenbank**
  - SQL Abfragen sind im Branch der Datenbank definiert
  - Aufrufe über Prozesslogik Branch nach untem aufegführten Standard-Format:
 
  - **Format für Schnittstellenmodell**
  - Termin Einladung senden (Event) | terminEinladung_Senden
  - Termin wird abgelehnt (Path)    | terminEinladung_Ablehnen
  - Termin wird bestätigt (Path)    | terminEinladung_Bestaetigen
  - nächsten Freien Gesprächstermin (Event) | terminEinladung_Naechster
  - Vorgeschlagenen Termin buchen (Event) | terminEinladung_Buchen
  - Bewerbungsgespräch (Event) | Gespraech_Laeuft
  - Bewerber erscheint nicht (Path) | GespraechMitarbeiter_BewerberNichtErschienen
  - 
