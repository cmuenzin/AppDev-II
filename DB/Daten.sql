-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 24. Jun 2024 um 17:51
-- Server-Version: 10.4.32-MariaDB
-- PHP-Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Datenbank: `appdev2`
--

--
-- Daten für Tabelle `bewerber`
--

INSERT INTO `bewerber` (`bewerberid`, `vorname`, `nachname`, `adresse`, `email`) VALUES
(1, 'Peter', 'Lustig', 'Im Witzigweg 13', 'peter@lustig.com'),
(2, 'Olaf', 'Scholzi', 'Im Bundestag 1', 'kanzler@germany.de'),
(3, 'Dieter', 'Bohlen', 'Schlumpfhausen 1', 'DSDS@bohlen.de'),
(4, 'Manfred', 'Müller', 'Im ABCWeg', 'müller@gmail.com'),
(5, 'Frederik', 'Frosch', 'zum Sumpf 15', 'sumpfgebiet@mail.de');

--
-- Daten für Tabelle `bewerbung`
--

INSERT INTO `bewerbung` (`bewerbungsid`, `bewerberid`, `datum`, `status`) VALUES
(1, 1, '2024-06-01', '1. Termin erfolgreich'),
(2, 2, '2024-06-04', 'eingegangen'),
(3, 3, '2024-06-10', 'abgelehnt'),
(4, 4, '2024-06-04', 'eingestellt');

--
-- Daten für Tabelle `mitarbeiter`
--

INSERT INTO `mitarbeiter` (`mitarbeiterid`, `vorname`, `nachname`, `email`) VALUES
(1, 'Caspar', 'Muenzinger', 'caspar.muenzinger@example.com'),
(2, 'Yannick', 'Stricker', 'yannick.stricker@example.com'),
(3, 'Jakob', 'Gattung', 'jakob.gattung@example.com');

--
-- Daten für Tabelle `termin`
--

INSERT INTO `termin` (`terminid`, `bewerberid`, `bewerbungsid`, `mitarbeiterid`, `erschienen`, `datum`, `bestätigt`, `bewertung`, `empfehlung`) VALUES
(1, 1, 1, 1, 1, '2024-07-04', 1, 'war gut', 1),
(2, 2, 2, 2, 1, '2024-07-04', 1, 'war nicht gut', 0),
(3, 1, 1, 3, 1, '2024-07-04', 1, 'Nicht gut', 0),
(4, 3, 3, 1, 1, '2024-07-05', 1, 'N/A', 0),
(5, 0, 0, 2, 0, '2024-07-05', 0, 'N/A', 0),
(6, 4, 4, 3, 1, '2024-07-05', 1, 'War gut', 1),
(7, 0, 0, 1, 0, '2024-07-06', 0, 'N/A', 0),
(8, 0, 0, 2, 0, '2024-07-06', 0, 'N/A', 0),
(9, 0, 0, 3, 0, '2024-07-06', 0, 'N/A', 0),
(10, 4, 4, 1, 1, '2024-07-07', 1, 'War gut', 1),
(11, 0, 0, 2, 0, '2024-07-07', 0, 'N/A', 0),
(12, 0, 0, 3, 0, '2024-07-07', 0, 'N/A', 0),
(13, 0, 0, 1, 0, '2024-07-08', 0, 'N/A', 0),
(14, 0, 0, 2, 0, '2024-07-08', 0, 'N/A', 0),
(15, 0, 0, 3, 0, '2024-07-08', 0, 'N/A', 0),
(16, 0, 0, 1, 0, '2024-07-09', 0, 'N/A', 0),
(17, 0, 0, 2, 0, '2024-07-09', 0, 'N/A', 0),
(18, 0, 0, 3, 0, '2024-07-09', 0, 'N/A', 0),
(19, 0, 0, 1, 0, '2024-07-10', 0, 'N/A', 0),
(20, 0, 0, 2, 0, '2024-07-10', 0, 'N/A', 0),
(21, 0, 0, 3, 0, '2024-07-10', 0, 'N/A', 0),
(22, 0, 0, 1, 0, '2024-07-11', 0, 'N/A', 0),
(23, 0, 0, 2, 0, '2024-07-11', 0, 'N/A', 0),
(24, 0, 0, 3, 0, '2024-07-11', 0, 'N/A', 0),
(25, 0, 0, 1, 0, '2024-07-12', 0, 'N/A', 0),
(26, 0, 0, 2, 0, '2024-07-12', 0, 'N/A', 0),
(27, 0, 0, 3, 0, '2024-07-12', 0, 'N/A', 0),
(28, 0, 0, 1, 0, '2024-07-13', 0, 'N/A', 0),
(29, 0, 0, 2, 0, '2024-07-13', 0, 'N/A', 0),
(30, 0, 0, 3, 0, '2024-07-13', 0, 'N/A', 0);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
