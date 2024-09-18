# Java Program Documentation

## Client Layer

### Class: Client_Bewerber

**Description**: 
Diese Klasse repräsentiert die Client-Seite des Bewerberportals. Sie bietet Methoden, um sich anzumelden, Termine zu wählen, den Status der Bewerbung abzurufen und sich abzumelden.

**Variables**:
- `int bewerbungsid`: Die ID der aktuellen Bewerbung.

#### Method: main(String[] args)

**Description**: 
Startet das Bewerberportal, erstellt eine Instanz von `Client_Bewerber` und zeigt das Hauptmenü an.

**Parameters**:
- `String[] args`: Kommandozeilenargumente (nicht verwendet).

#### Method: printMenu()

**Description**: 
Zeigt das Hauptmenü des Bewerberportals an und ermöglicht dem Benutzer, verschiedene Aktionen auszuwählen.

**Throws**: 
- Keine spezifischen Ausnahmen dokumentiert.

#### Method: anmelden()

**Description**: 
Meldet den Bewerber an und gibt die Bewerbungs-ID zurück.

**Returns**:
- `int`: Die Bewerbungs-ID des angemeldeten Bewerbers.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.
- `NotBoundException`: Wenn das Remote-Objekt nicht gefunden wird.
- `MalformedURLException`: Wenn die URL des Remote-Objekts fehlerhaft ist.

#### Method: terminWaehlen(int bewerbungsid)

**Description**: 
Ermöglicht dem Bewerber, einen Termin basierend auf der Bewerbungs-ID zu wählen.

**Parameters**:
- `int bewerbungsid`: Die ID der Bewerbung.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.
- `NotBoundException`: Wenn das Remote-Objekt nicht gefunden wird.
- `MalformedURLException`: Wenn die URL des Remote-Objekts fehlerhaft ist.

#### Method: statusAbrufen(int bewerbungsid)

**Description**: 
Ruft den Status der Bewerbung basierend auf der Bewerbungs-ID ab und gibt ihn aus.

**Parameters**:
- `int bewerbungsid`: Die ID der Bewerbung.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.
- `NotBoundException`: Wenn das Remote-Objekt nicht gefunden wird.
- `MalformedURLException`: Wenn die URL des Remote-Objekts fehlerhaft ist.

---

### Class: Client_Mitarbeiter

**Description**: 
Diese Klasse repräsentiert die Client-Seite für Mitarbeiter. Sie bietet Methoden, um sich anzumelden, Bewerber zu bewerten und Empfehlungen abzugeben.

**Variables**:
- `int mitarbeiterid`: Die ID des aktuellen Mitarbeiters.

#### Method: main(String[] args)

**Description**: 
Startet das Mitarbeiterportal, erstellt eine Instanz von `Client_Mitarbeiter` und zeigt das Hauptmenü an.

**Parameters**:
- `String[] args`: Kommandozeilenargumente (nicht verwendet).

#### Method: printMenu()

**Description**: 
Zeigt das Hauptmenü des Mitarbeiterportals an und ermöglicht dem Benutzer, verschiedene Aktionen auszuwählen.

**Throws**: 
- Keine spezifischen Ausnahmen dokumentiert.

#### Method: anmelden()

**Description**: 
Meldet den Mitarbeiter an und gibt die Mitarbeiter-ID zurück.

**Returns**:
- `int`: Die Mitarbeiter-ID des angemeldeten Mitarbeiters.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.
- `NotBoundException`: Wenn das Remote-Objekt nicht gefunden wird.
- `MalformedURLException`: Wenn die URL des Remote-Objekts fehlerhaft ist.

#### Method: bewerberBewerten()

**Description**: 
Ermöglicht dem Mitarbeiter, Bewerber zu bewerten.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.
- `NotBoundException`: Wenn das Remote-Objekt nicht gefunden wird.
- `MalformedURLException`: Wenn die URL des Remote-Objekts fehlerhaft ist.

#### Method: empfehlungAbgeben()

**Description**: 
Ermöglicht dem Mitarbeiter, Empfehlungen basierend auf den Bewertungen abzugeben.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.
- `NotBoundException`: Wenn das Remote-Objekt nicht gefunden wird.
- `MalformedURLException`: Wenn die URL des Remote-Objekts fehlerhaft ist.

---

### Class: Bewerber

**Description**: 
Diese Klasse repräsentiert einen Bewerber mit seinen grundlegenden Informationen.

**Variables**:
- `int id`: Die ID des Bewerbers.
- `String name`: Der Name des Bewerbers.
- `String adresse`: Die Adresse des Bewerbers.
- `String email`: Die E-Mail-Adresse des Bewerbers.

#### Method: getId()

**Description**: 
Gibt die ID des Bewerbers zurück.

**Returns**:
- `int`: Die ID des Bewerbers.

#### Method: getName()

**Description**: 
Gibt den Namen des Bewerbers zurück.

**Returns**:
- `String`: Der Name des Bewerbers.

#### Method: getAdresse()

**Description**: 
Gibt die Adresse des Bewerbers zurück.

**Returns**:
- `String`: Die Adresse des Bewerbers.

#### Method: getEmail()

**Description**: 
Gibt die E-Mail-Adresse des Bewerbers zurück.

**Returns**:
- `String`: Die E-Mail-Adresse des Bewerbers.

---

### Class: Bewerbung

**Description**: 
Diese Klasse repräsentiert eine Bewerbung mit ihren Details.

**Variables**:
- `int bewerbungsid`: Die ID der Bewerbung.
- `int bewerberid`: Die ID des Bewerbers.
- `String status`: Der Status der Bewerbung.

#### Method: getBewerbungsid()

**Description**: 
Gibt die ID der Bewerbung zurück.

**Returns**:
- `int`: Die ID der Bewerbung.

#### Method: getBewerberid()

**Description**: 
Gibt die ID des Bewerbers zurück.

**Returns**:
- `int`: Die ID des Bewerbers.

#### Method: getStatus()

**Description**: 
Gibt den Status der Bewerbung zurück.

**Returns**:
- `String`: Der Status der Bewerbung.

---

### Class: Mitarbeiter

**Description**: 
Diese Klasse repräsentiert einen Mitarbeiter mit seinen grundlegenden Informationen.

**Variables**:
- `int id`: Die ID des Mitarbeiters.
- `String name`: Der Name des Mitarbeiters.
- `String abteilung`: Die Abteilung des Mitarbeiters.

#### Method: getId()

**Description**: 
Gibt die ID des Mitarbeiters zurück.

**Returns**:
- `int`: Die ID des Mitarbeiters.

#### Method: getName()

**Description**: 
Gibt den Namen des Mitarbeiters zurück.

**Returns**:
- `String`: Der Name des Mitarbeiters.

#### Method: getAbteilung()

**Description**: 
Gibt die Abteilung des Mitarbeiters zurück.

**Returns**:
- `String`: Die Abteilung des Mitarbeiters.

---

### Class: Termin

**Description**: 
Diese Klasse repräsentiert einen Termin im Bewerbungssystem.

**Variables**:
- `int terminid`: Die ID des Termins.
- `int mitarbeiterid`: Die ID des zugeordneten Mitarbeiters.
- `Date datum`: Das Datum des Termins.
- `int bewerbungsid`: Die ID der zugehörigen Bewerbung.
- `String bewerbername`: Der Name des Bewerbers.
- `boolean bestätigt`: Gibt an, ob der Termin bestätigt ist.
- `String bewertung`: Die Bewertung des Termins.
- `boolean empfehlung`: Die Empfehlung des Termins.

#### Method: getTerminid()

**Description**: 
Gibt die ID des Termins zurück.

**Returns**:
- `int`: Die ID des Termins.

#### Method: getMitarbeiterid()

**Description**: 
Gibt die ID des zugeordneten Mitarbeiters zurück.

**Returns**:
- `int`: Die ID des Mitarbeiters.

#### Method: getDatum()

**Description**: 
Gibt das Datum des Termins zurück.

**Returns**:
- `Date`: Das Datum des Termins.

#### Method: getBewerbungsid()

**Description**: 
Gibt die ID der zugehörigen Bewerbung zurück.

**Returns**:
- `int`: Die ID der Bewerbung.

#### Method: getBewerbername()

**Description**: 
Gibt den Namen des Bewerbers zurück.

**Returns**:
- `String`: Der Name des Bewerbers.

#### Method: isBestätigt()

**Description**: 
Gibt an, ob der Termin bestätigt ist.

**Returns**:
- `boolean`: `true`, wenn der Termin bestätigt ist, sonst `false`.

#### Method: getBewertung()

**Description**: 
Gibt die Bewertung des Termins zurück.

**Returns**:
- `String`: Die Bewertung des Termins.

#### Method: getEmpfehlung()

**Description**: 
Gibt die Empfehlung des Termins zurück.

**Returns**:
- `boolean`: Die Empfehlung des Termins.

---

## Server Layer

### Class: Anmeldung

**Description**: 
Diese Schnittstelle definiert Methoden für die Anmeldung und Verwaltung von Bewerbern.

#### Method: getAllBewerber()

**Description**: 
Gibt eine Liste aller Bewerber zurück.

**Returns**:
- `List<Bewerber>`: Eine Liste aller Bewerber.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

#### Method: anmelden(String benutzername, String passwort)

**Description**: 
Meldet einen Bewerber mit Benutzernamen und Passwort an.

**Parameters**:
- `String benutzername`: Der Benutzername des Bewerbers.
- `String passwort`: Das Passwort des Bewerbers.

**Returns**:
- `Bewerber`: Der angemeldete Bewerber.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

---

### Class: AnmeldungImpl

**Description**: 
Diese Klasse implementiert die `Anmeldung`-Schnittstelle und bietet die tatsächliche Logik für die Methoden zur Anmeldung und Verwaltung von Bewerbern.

#### Method: getAllBewerber()

**Description**: 
Gibt eine Liste aller Bewerber zurück.

**Returns**:
- `List<Bewerber>`: Eine Liste aller Bewerber.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

#### Method: anmelden(String benutzername, String passwort)

**Description**: 
Meldet einen Bewerber mit Benutzernamen und Passwort an.

**Parameters**:
- `String benutzername`: Der Benutzername des Bewerbers.
- `String passwort`: Das Passwort des Bewerbers.

**Returns**:
- `Bewerber`: Der angemeldete Bewerber.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

---

### Class: Bewertungslogik

**Description**: 
Diese Schnittstelle definiert Methoden zur Bewertung von Bewerbungen.

#### Method: bewerberBewerten(int bewerbungsid, String bewertung)

**Description**: 
Bewertet einen Bewerber basierend auf der Bewerbungs-ID und der Bewertung.

**Parameters**:
- `int bewerbungsid`: Die ID der Bewerbung.
- `String bewertung`: Die Bewertung für die Bewerbung.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

---

### Class: BewertungslogikImpl

**Description**: 
Diese Klasse implementiert die `Bewertungslogik`-Schnittstelle und bietet die tatsächliche Logik für die Methoden zur Bewertung von Bewerbungen.

#### Method: bewerberBewerten(int bewerbungsid, String bewertung)

**Description**: 
Bewertet einen Bewerber basierend auf der Bewerbungs-ID und der Bewertung.

**Parameters**:
- `int bewerbungsid`: Die ID der Bewerbung.
- `String bewertung`: Die Bewertung für die Bewerbung.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

---

### Class: DatabaseConnection

**Description**: 
Diese Klasse stellt die Verbindung zur Datenbank her und bietet Methoden zum Abrufen dieser Verbindung.

#### Method: getConnection()

**Description**: 
Stellt eine Verbindung zur Datenbank her und gibt diese zurück.

**Returns**:
- `Connection`: Eine Verbindung zur Datenbank.

**Throws**: 
- `SQLException`: Wenn ein Datenbankzugriffsfehler auftritt.
- `ClassNotFoundException`: Wenn der JDBC-Treiber nicht gefunden wird.

---

### Class: Server

**Description**: 
Diese Klasse startet den RMI-Server und bindet die Implementierungen der Schnittstellen.

#### Method: main(String[] args)

**Description**: 
Startet den RMI-Server und bindet die Implementierungen der Schnittstellen.

**Parameters**:
- `String[] args`: Kommandozeilenargumente (nicht verwendet).

---

### Class: Terminverwaltung

**Description**: 
Diese Schnittstelle definiert Methoden zur Verwaltung von Terminen.

#### Method: terminErstellen(Termin termin)

**Description**: 
Erstellt einen neuen Termin.

**Parameters**:
- `Termin termin`: Der zu erstellende Termin.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

#### Method: terminAbrufen(int terminid)

**Description**: 
Ruft einen Termin basierend auf der Termin-ID ab.

**Parameters**:
- `int terminid`: Die ID des Termins.

**Returns**:
- `Termin`: Der abgefragte Termin.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

---

### Class: TerminverwaltungImpl

**Description**: 
Diese Klasse implementiert die `Terminverwaltung`-Schnittstelle und bietet die tatsächliche Logik für die Methoden zur Verwaltung von Terminen.

#### Method: terminErstellen(Termin termin)

**Description**: 
Erstellt einen neuen Termin.

**Parameters**:
- `Termin termin`: Der zu erstellende Termin.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.

#### Method: terminAbrufen(int terminid)

**Description**: 
Ruft einen Termin basierend auf der Termin-ID ab.

**Parameters**:
- `int terminid`: Die ID des Termins.

**Returns**:
- `Termin`: Der abgefragte Termin.

**Throws**: 
- `RemoteException`: Bei Fehlern in der Remote-Kommunikation.
