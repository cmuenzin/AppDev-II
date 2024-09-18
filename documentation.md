# Bewerbungsmanagementsystem Dokumentation

## 1. Übersicht
Diese Dokumentation beschreibt die Implementierung eines Bewerbungsmanagementsystems. Es besteht aus zwei Hauptkomponenten: dem Client, der von Bewerbern und Mitarbeitern verwendet wird, und dem Server, der die Anmelde-, Einladungs- und Datenbankdienste verwaltet.

---

## 2. Client-Seite

### 2.1 Class: `Client_Bewerber`

**Description**:
Diese Klasse repräsentiert den Client für Bewerber und dient zur Interaktion mit dem Bewerbersystem.

**Variables**:
- *Es gibt keine Klassenvariablen in der bereitgestellten Klasse.*

**Methods**:

#### Method: `main(String[] args)`

**Description**:
Startet den Client und initialisiert die Verbindung zum Server für Bewerber.

**Parameters**:
- `String[] args`: Kommandozeilenargumente, die beim Start des Programms übergeben werden.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 2.2 Class: `Client_Mitarbeiter`

**Description**:
Diese Klasse repräsentiert den Client für Mitarbeiter und dient zur Interaktion mit dem Mitarbeitersystem.

**Variables**:
- *Es gibt keine Klassenvariablen in der bereitgestellten Klasse.*

**Methods**:

#### Method: `main(String[] args)`

**Description**:
Startet den Client und initialisiert die Verbindung zum Server für Mitarbeiter.

**Parameters**:
- `String[] args`: Kommandozeilenargumente, die beim Start des Programms übergeben werden.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

## 3. Gemeinsame Klassen

### 3.1 Class: `Bewerber`

**Description**:
Diese Klasse repräsentiert einen Bewerber und enthält relevante Informationen und Methoden zur Verwaltung der Bewerberdaten.

**Variables**:
- `private int id`: Eindeutige ID des Bewerbers.
- `private String name`: Name des Bewerbers.
- `private String email`: E-Mail-Adresse des Bewerbers.
- `private String telefon`: Telefonnummer des Bewerbers.

**Methods**:

#### Method: `Bewerber(int id, String name, String email, String telefon)`

**Description**:
Konstruktor zur Initialisierung eines Bewerber-Objekts mit den angegebenen Attributen.

**Parameters**:
- `int id`: Die eindeutige ID des Bewerbers.
- `String name`: Der Name des Bewerbers.
- `String email`: Die E-Mail-Adresse des Bewerbers.
- `String telefon`: Die Telefonnummer des Bewerbers.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getId()`

**Description**:
Gibt die eindeutige ID des Bewerbers zurück.

**Parameters**:
- *Keine*

**Returns**:
- `int`: Die ID des Bewerbers.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getName()`

**Description**:
Gibt den Namen des Bewerbers zurück.

**Parameters**:
- *Keine*

**Returns**:
- `String`: Der Name des Bewerbers.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getEmail()`

**Description**:
Gibt die E-Mail-Adresse des Bewerbers zurück.

**Parameters**:
- *Keine*

**Returns**:
- `String`: Die E-Mail-Adresse des Bewerbers.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getTelefon()`

**Description**:
Gibt die Telefonnummer des Bewerbers zurück.

**Parameters**:
- *Keine*

**Returns**:
- `String`: Die Telefonnummer des Bewerbers.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 3.2 Class: `Bewerbung`

**Description**:
Diese Klasse repräsentiert eine Bewerbung und enthält relevante Informationen und Methoden zur Verwaltung der Bewerbungsdaten.

**Variables**:
- `private int id`: Eindeutige ID der Bewerbung.
- `private int bewerberId`: ID des zugehörigen Bewerbers.
- `private String status`: Status der Bewerbung.
- `private Date datum`: Datum der Bewerbung.

**Methods**:

#### Method: `Bewerbung(int id, int bewerberId, String status, Date datum)`

**Description**:
Konstruktor zur Initialisierung eines Bewerbung-Objekts mit den angegebenen Attributen.

**Parameters**:
- `int id`: Die eindeutige ID der Bewerbung.
- `int bewerberId`: Die ID des zugehörigen Bewerbers.
- `String status`: Der Status der Bewerbung.
- `Date datum`: Das Datum der Bewerbung.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getId()`

**Description**:
Gibt die eindeutige ID der Bewerbung zurück.

**Parameters**:
- *Keine*

**Returns**:
- `int`: Die ID der Bewerbung.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getBewerberId()`

**Description**:
Gibt die ID des zugehörigen Bewerbers zurück.

**Parameters**:
- *Keine*

**Returns**:
- `int`: Die ID des zugehörigen Bewerbers.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getStatus()`

**Description**:
Gibt den Status der Bewerbung zurück.

**Parameters**:
- *Keine*

**Returns**:
- `String`: Der Status der Bewerbung.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getDatum()`

**Description**:
Gibt das Datum der Bewerbung zurück.

**Parameters**:
- *Keine*

**Returns**:
- `Date`: Das Datum der Bewerbung.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 3.3 Class: `Mitarbeiter`

**Description**:
Diese Klasse repräsentiert einen Mitarbeiter und enthält relevante Informationen und Methoden zur Verwaltung der Mitarbeiterdaten.

**Variables**:
- `private int id`: Eindeutige ID des Mitarbeiters.
- `private String name`: Name des Mitarbeiters.
- `private String abteilung`: Abteilung des Mitarbeiters.

**Methods**:

#### Method: `Mitarbeiter(int id, String name, String abteilung)`

**Description**:
Konstruktor zur Initialisierung eines Mitarbeiter-Objekts mit den angegebenen Attributen.

**Parameters**:
- `int id`: Die eindeutige ID des Mitarbeiters.
- `String name`: Der Name des Mitarbeiters.
- `String abteilung`: Die Abteilung des Mitarbeiters.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getId()`

**Description**:
Gibt die eindeutige ID des Mitarbeiters zurück.

**Parameters**:
- *Keine*

**Returns**:
- `int`: Die ID des Mitarbeiters.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getName()`

**Description**:
Gibt den Namen des Mitarbeiters zurück.

**Parameters**:
- *Keine*

**Returns**:
- `String`: Der Name des Mitarbeiters.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getAbteilung()`

**Description**:
Gibt die Abteilung des Mitarbeiters zurück.

**Parameters**:
- *Keine*

**Returns**:
- `String`: Die Abteilung des Mitarbeiters.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 3.4 Class: `Termin`

**Description**:
Diese Klasse repräsentiert einen Termin und enthält relevante Informationen und Methoden zur Verwaltung der Termindaten.

**Variables**:
- `private int id`: Eindeutige ID des Termins.
- `private int bewerberId`: ID des zugehörigen Bewerbers.
- `private Date datum`: Datum des Termins.
- `private String ort`: Ort des Termins.

**Methods**:

#### Method: `Termin(int id, int bewerberId, Date datum, String ort)`

**Description**:
Konstruktor zur Initialisierung eines Termin-Objekts mit den angegebenen Attributen.

**Parameters**:
- `int id`: Die eindeutige ID des Termins.
- `int bewerberId`: Die ID des zugehörigen Bewerbers.
- `Date datum`: Das Datum des Termins.
- `String ort`: Der Ort des Termins.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getId()`

**Description**:
Gibt die eindeutige ID des Termins zurück.

**Parameters**:
- *Keine*

**Returns**:
- `int`: Die ID des Termins.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getBewerberId()`

**Description**:
Gibt die ID des zugehörigen Bewerbers zurück.

**Parameters**:
- *Keine*

**Returns**:
- `int`: Die ID des zugehörigen Bewerbers.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getDatum()`

**Description**:
Gibt das Datum des Termins zurück.

**Parameters**:
- *Keine*

**Returns**:
- `Date`: Das Datum des Termins.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `getOrt()`

**Description**:
Gibt den Ort des Termins zurück.

**Parameters**:
- *Keine*

**Returns**:
- `String`: Der Ort des Termins.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

## 4. Server-Seite

### 4.1 Class: `Anmeldung`

**Description**:
Diese Schnittstelle definiert Methoden zur Verwaltung von Benutzeranmeldungen.

**Methods**:

#### Method: `boolean anmelden(String benutzername, String passwort)`

**Description**:
Meldet einen Benutzer mit den angegebenen Anmeldeinformationen an.

**Parameters**:
- `String benutzername`: Der Benutzername des Benutzers.
- `String passwort`: Das Passwort des Benutzers.

**Returns**:
- `boolean`: `true`, wenn die Anmeldung erfolgreich ist, sonst `false`.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 4.2 Class: `AnmeldungImpl`

**Description**:
Diese Klasse implementiert die `Anmeldung` Schnittstelle zur Verwaltung von Benutzeranmeldungen.

**Variables**:
- `private DatabaseConnection dbConnection`: Datenbankverbindung zur Überprüfung der Anmeldeinformationen.

**Methods**:

#### Method: `AnmeldungImpl(DatabaseConnection dbConnection)`

**Description**:
Konstruktor zur Initialisierung der `AnmeldungImpl`-Klasse mit einer Datenbankverbindung.

**Parameters**:
- `DatabaseConnection dbConnection`: Die Datenbankverbindung.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `boolean anmelden(String benutzername, String passwort)`

**Description**:
Meldet einen Benutzer mit den angegebenen Anmeldeinformationen an.

**Parameters**:
- `String benutzername`: Der Benutzername des Benutzers.
- `String passwort`: Das Passwort des Benutzers.

**Returns**:
- `boolean`: `true`, wenn die Anmeldung erfolgreich ist, sonst `false`.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 4.3 Class: `DatabaseConnection`

**Description**:
Diese Klasse verwaltet die Verbindung zur Datenbank und führt Abfragen aus.

**Variables**:
- `private Connection connection`: Die Datenbankverbindung.

**Methods**:

#### Method: `DatabaseConnection(String dbUrl, String user, String password)`

**Description**:
Konstruktor zur Initialisierung der Datenbankverbindung mit den angegebenen Verbindungsparametern.

**Parameters**:
- `String dbUrl`: Die URL der Datenbank.
- `String user`: Der Datenbankbenutzername.
- `String password`: Das Datenbankpasswort.

**Throws**:
- `SQLException`: Wenn ein Fehler bei der Herstellung der Verbindung auftritt.

#### Method: `Connection getConnection()`

**Description**:
Gibt die Datenbankverbindung zurück.

**Parameters**:
- *Keine*

**Returns**:
- `Connection`: Die Datenbankverbindung.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 4.4 Class: `Einladung`

**Description**:
Diese Schnittstelle definiert Methoden zur Verwaltung von Einladungen.

**Methods**:

#### Method: `void sendeEinladung(int bewerberId, String nachricht)`

**Description**:
Sendet eine Einladung an einen Bewerber.

**Parameters**:
- `int bewerberId`: Die ID des Bewerbers.
- `String nachricht`: Die Einladungstext.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 4.5 Class: `EinladungImpl`

**Description**:
Diese Klasse implementiert die `Einladung` Schnittstelle zur Verwaltung von Einladungen.

**Variables**:
- `private DatabaseConnection dbConnection`: Datenbankverbindung zur Verwaltung der Einladungen.

**Methods**:

#### Method: `EinladungImpl(DatabaseConnection dbConnection)`

**Description**:
Konstruktor zur Initialisierung der `EinladungImpl`-Klasse mit einer Datenbankverbindung.

**Parameters**:
- `DatabaseConnection dbConnection`: Die Datenbankverbindung.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

#### Method: `void sendeEinladung(int bewerberId, String nachricht)`

**Description**:
Sendet eine Einladung an einen Bewerber.

**Parameters**:
- `int bewerberId`: Die ID des Bewerbers.
- `String nachricht`: Die Einladungstext.

**Throws**:
- *Es werden keine spezifischen Ausnahmen geworfen.*

---

### 4.6 Class: `Server`

**Description**:
Diese Klasse stellt den Hauptserver dar, der die verschiedenen Dienste verwaltet und bereitstellt.

**Variables**:
- `private int port`: Der Port, auf dem der Server läuft.
- `private ServerSocket serverSocket`: Der Server-Socket zur Verwaltung eingehender Verbindungen.

**Methods**:

#### Method: `Server(int port)`

**Description**:
Konstruktor zur Initialisierung des Servers mit dem angegebenen Port.

**Parameters**:
- `int port`: Der Port, auf dem der Server laufen soll.

**Throws**:
- `IOException`: Wenn ein Fehler beim Starten des Servers auftritt.

#### Method: `void start()`

**Description**:
Startet den Server und wartet auf eingehende Verbindungen.

**Parameters**:
- *Keine*

**Throws**:
- `IOException`: Wenn ein Fehler während des Serverbetriebs auftritt.

---
