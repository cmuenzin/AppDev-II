-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Erstellungszeit: 11. Jun 2024 um 11:24
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

-- --------------------------------------------------------

--
-- Daten für Tabelle `mitarbeiter`
--

INSERT INTO `mitarbeiter` (`mitarbeiterid`, `vorname`, `nachname`, `email`) VALUES
(1, 'Caspar', 'Muenzinger', 'caspar.muenzinger@example.com'),
(2, 'Yannick', 'Stricker', 'yannick.stricker@example.com'),
(3, 'Jakob', 'Gattung', 'jakob.gattung@example.com');

-- --------------------------------------------------------

--
-- Tabellenstruktur für Tabelle `termin`
--

--
-- Daten für Tabelle `termin`
--

INSERT INTO `termin` (`terminid`, `bewerberid`, `bewerbungsid`, `mitarbeiterid`, `erschienen`, `datum`, `bestätigt`, `bewertung`, `empfehlung`) VALUES
(1, 0, 0, 1, 0, '2024-07-04', 0, 'N/A', 0),
(2, 0, 0, 2, 0, '2024-07-04', 0, 'N/A', 0),
(3, 0, 0, 3, 0, '2024-07-04', 0, 'N/A', 0),
(4, 0, 0, 1, 0, '2024-07-05', 0, 'N/A', 0),
(5, 0, 0, 2, 0, '2024-07-05', 0, 'N/A', 0),
(6, 0, 0, 3, 0, '2024-07-05', 0, 'N/A', 0),
(7, 0, 0, 1, 0, '2024-07-06', 0, 'N/A', 0),
(8, 0, 0, 2, 0, '2024-07-06', 0, 'N/A', 0),
(9, 0, 0, 3, 0, '2024-07-06', 0, 'N/A', 0),
(10, 0, 0, 1, 0, '2024-07-07', 0, 'N/A', 0),
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
