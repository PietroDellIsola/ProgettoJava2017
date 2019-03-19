-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Creato il: Ott 21, 2017 alle 15:46
-- Versione del server: 10.1.19-MariaDB
-- Versione PHP: 5.6.28

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `progettojava`
--

-- --------------------------------------------------------

--
-- Struttura della tabella `accountagenzia`
--

CREATE TABLE `accountagenzia` (
  `ID` varchar(30) NOT NULL,
  `password` varchar(10) NOT NULL,
  `P_IVA` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `accountagenzia`
--

INSERT INTO `accountagenzia` (`ID`, `password`, `P_IVA`) VALUES
('Trivago', 'TTT', '00111'),
('NoscheseTravel', 'NNN', '00133'),
('Vviaggi', 'VVV', '00155'),
('Ttourist', 'TTT', '00399');

-- --------------------------------------------------------

--
-- Struttura della tabella `agenzia`
--

CREATE TABLE `agenzia` (
  `P_IVA` varchar(20) NOT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `telefono` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `via` varchar(30) DEFAULT NULL,
  `citta` varchar(30) DEFAULT NULL,
  `CAP` varchar(6) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `agenzia`
--

INSERT INTO `agenzia` (`P_IVA`, `nome`, `telefono`, `email`, `via`, `citta`, `CAP`) VALUES
('00111', 'Trivago', '323412968', 'trivago@gmail.com', 'via Mazzini', 'Milano', '20121'),
('00133', 'Noschese Travel', '089036632', 'N@gmail.com', 'via Foscolo', 'Napoli', '82021'),
('00155', 'Vviaggi', '085667890', 'v@live.it', 'via Roma', 'Milano', '82094'),
('00399', 'Ttourist', '089067235', 'T@hotmail.it', 'via Dante', 'Torino', '54055');

-- --------------------------------------------------------

--
-- Struttura della tabella `attivita`
--

CREATE TABLE `attivita` (
  `CodAttivita` varchar(20) NOT NULL,
  `nome` varchar(20) DEFAULT NULL,
  `costo` float DEFAULT NULL,
  `orario` varchar(20) DEFAULT NULL,
  `disponibilita` tinyint(1) DEFAULT NULL,
  `IdParco` int(11) NOT NULL,
  `CodStruttura` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `attivita`
--

INSERT INTO `attivita` (`CodAttivita`, `nome`, `costo`, `orario`, `disponibilita`, `IdParco`, `CodStruttura`) VALUES
('A1', 'Doremifarm', 10, '15:00-18:00', 1, 1, 'AAA'),
('AT1', 'TiroAllaFune', 10, '11:00-13:00', 1, 2, 'EEE'),
('B1', 'Prezzemolo Land', 5, '10:00-15:30', 1, 1, 'BBB'),
('C1', 'Mammut', 7, '10:00-18:00', 1, 1, 'CCC'),
('D1', 'Magic Mountain', 11, '15:00-18:00', 1, 1, 'DDD'),
('E2', 'SingleRapidz', 7, '10:00-18:00', 1, 2, 'EEE'),
('F2', 'Oblivion', 7, '10:00-14:00', 1, 2, 'FFF'),
('G2', 'Volaplano', 5, '14:00-18:00', 1, 2, 'GGG'),
('H3', 'Far West', 9, '9:00-18:00', 1, 3, 'HHH'),
('I3', 'Re leone', 4, '10:00-16:00', 1, 3, 'III'),
('L3', 'Ruota Panoramica', 9, '12:00-18:00', 1, 3, 'LLL'),
('M4', 'Canyoing', 7, '9:00-18:00', 1, 4, 'MMM'),
('N4', 'Parapendio', 4, '11:00-17:00', 1, 4, 'NNN'),
('O4', 'Bob Run', 10, '9:00-13:00', 1, 4, 'OOO'),
('P5', 'Big River', 6, '9:00-18:00', 1, 5, 'PPP'),
('Q5', 'Skyfall', 8, '14:00-17:00', 1, 5, 'QQQ'),
('R5', 'Idrotubo Blu', 8, '9:00-13:00', 1, 5, 'RRR'),
('S5', 'Toboga Rosso', 5, '9:00-16:00', 1, 5, 'SSS');

-- --------------------------------------------------------

--
-- Struttura della tabella `biglietto`
--

CREATE TABLE `biglietto` (
  `CodBiglietto` varchar(10) NOT NULL,
  `tipo` varchar(30) DEFAULT NULL,
  `CF` varchar(20) DEFAULT NULL,
  `CodPromozione` varchar(10) DEFAULT NULL,
  `IdParco` int(11) NOT NULL,
  `dataAcquisto` date NOT NULL,
  `prezzoTotale` float DEFAULT NULL,
  `CodPacchetto` varchar(10) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `biglietto`
--

INSERT INTO `biglietto` (`CodBiglietto`, `tipo`, `CF`, `CodPromozione`, `IdParco`, `dataAcquisto`, `prezzoTotale`, `CodPacchetto`) VALUES
('B001', 'Normale', 'BRB', NULL, 1, '2017-01-01', 33, 'PAC1'),
('B002', 'Normale', 'HPV', NULL, 2, '2017-01-01', 15, 'PAC2'),
('B003', 'Promozione', 'BRW', 'PR1', 1, '2017-01-05', 17, NULL),
('B004', 'Normale', 'NTR', NULL, 5, '2017-01-12', 13, NULL),
('B005', 'Normale', 'DNP', NULL, 5, '2017-02-01', 8, NULL),
('B006', 'Normale', 'TNS', NULL, 5, '2017-02-01', 8, NULL),
('B007', 'promozione', 'CLK', 'PR7', 2, '2017-01-02', 12, NULL),
('B008', 'Normale', 'MJW', NULL, 4, '2017-01-22', 17, NULL),
('B009', 'Promozione', 'PTP', 'PR2', 1, '2017-01-22', 10, NULL),
('B010', 'Promozione', 'JMH', 'PR8', 2, '2017-01-22', 4, NULL),
('B011', 'Promozione', 'STR', 'PR4', 3, '2017-01-23', 4.5, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `bigliettocomprende`
--

CREATE TABLE `bigliettocomprende` (
  `CodBiglietto` varchar(10) NOT NULL,
  `CodAttivita` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `bigliettocomprende`
--

INSERT INTO `bigliettocomprende` (`CodBiglietto`, `CodAttivita`) VALUES
('B001', 'A1'),
('B001', 'B1'),
('B001', 'C1'),
('B001', 'D1'),
('B002', 'A1'),
('B002', 'B1'),
('B004', 'Q5'),
('B004', 'S5'),
('B005', 'Q5'),
('B006', 'Q5'),
('B008', 'M4'),
('B008', 'O4');

-- --------------------------------------------------------

--
-- Struttura della tabella `cliente`
--

CREATE TABLE `cliente` (
  `CF` varchar(20) NOT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `cognome` varchar(30) DEFAULT NULL,
  `eta` int(11) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `cliente`
--

INSERT INTO `cliente` (`CF`, `nome`, `cognome`, `eta`, `telefono`, `email`) VALUES
('BRB', 'Bruce', 'Banner', 35, '3377501237', 'Banner@gmail.com'),
('BRW', 'Bruce', 'Wayne', 31, '3341508377', 'wayne@gmail.com'),
('CLK', 'Clark', 'Kent', 28, '3394467834', 'ckent@gmail.com'),
('DNP', 'Diana', 'Prince', 26, '3312356708', 'Dprince@gmail.com'),
('HPV', 'Hope', 'Van Dyne', 23, '3378655785', 'hope@gmail.com'),
('JMH', 'James Logan', 'Howlett', 51, '3341613379', ''),
('MJW', 'Mary Jane', 'Watson', 20, '3456798033', 'MJ@spiderman.it'),
('NTR', 'Natasha', 'Romanoff', 21, '3322508677', 'romanoff@gmail.com'),
('PTP', 'Peter', 'Parker', 20, '3569814230', 'spiderman@gmail.com'),
('STR', 'Steve', 'Rogers', 55, '3876533456', 'steverogers@gmail.com'),
('TNS', 'Tony', 'Stark', 38, '3335150838', 'Tstark@stark.com');

-- --------------------------------------------------------

--
-- Struttura della tabella `convenzionato`
--

CREATE TABLE `convenzionato` (
  `IdParco` int(11) NOT NULL,
  `P_IVA` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `convenzionato`
--

INSERT INTO `convenzionato` (`IdParco`, `P_IVA`) VALUES
(1, '00133'),
(1, '00155'),
(2, '00155'),
(2, '00399'),
(3, '00399'),
(4, '00155'),
(5, '00111');

-- --------------------------------------------------------

--
-- Struttura della tabella `dipendenti`
--

CREATE TABLE `dipendenti` (
  `CF` varchar(20) NOT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `cognome` varchar(30) DEFAULT NULL,
  `eta` int(11) DEFAULT NULL,
  `IdParco` int(11) NOT NULL,
  `tipoContratto` varchar(20) DEFAULT NULL,
  `dataI` date DEFAULT NULL,
  `dataF` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `dipendenti`
--

INSERT INTO `dipendenti` (`CF`, `nome`, `cognome`, `eta`, `IdParco`, `tipoContratto`, `dataI`, `dataF`) VALUES
('GNR', 'Gennaro', 'Rossi', 30, 4, 'indeterminato', NULL, NULL),
('GSR', 'Giuseppe', 'Rossi', 38, 1, 'indeterminato', NULL, NULL),
('GSV', 'Giuseppe', 'Verdi', 33, 1, 'indeterminato', NULL, NULL),
('LCB', 'Luca', 'Bianchi', 28, 2, 'indeterminato', NULL, NULL),
('LCM', 'Luca', 'Marrone', 38, 3, 'indeterminato', NULL, NULL),
('NTR', 'Antonio', 'Rossi', 25, 1, 'determinato', '2017-01-01', '2018-01-01'),
('NTV', 'Antonio', 'Verdi', 28, 5, 'indeterminato', NULL, NULL),
('STG', 'Stefano', 'Gialli', 21, 4, 'determinato', '2017-01-01', '2018-01-01');

-- --------------------------------------------------------

--
-- Struttura della tabella `pacchetto`
--

CREATE TABLE `pacchetto` (
  `CodPacchetto` varchar(10) NOT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `descrizione` varchar(30) DEFAULT NULL,
  `dataI` date DEFAULT NULL,
  `dataF` date DEFAULT NULL,
  `prezzo` float DEFAULT NULL,
  `IdRA` int(11) NOT NULL,
  `P_IVA` varchar(20) DEFAULT NULL,
  `CF` varchar(20) DEFAULT NULL,
  `dataPrenotazione` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `pacchetto`
--

INSERT INTO `pacchetto` (`CodPacchetto`, `nome`, `descrizione`, `dataI`, `dataF`, `prezzo`, `IdRA`, `P_IVA`, `CF`, `dataPrenotazione`) VALUES
('PAC1', 'Pacchetto1', 'pranzo cena', '2017-02-03', '2017-02-13', 50, 1, '00155', 'BRB', '2017-01-01'),
('PAC2', 'Pacchetto2', 'pernottamento ', '2017-01-02', '2017-01-10', 50, 2, '00399', 'HPV', '2016-12-31'),
('PAC3', 'Pacchetto3', 'ristoro in hotel', '2017-01-01', '2017-05-05', 70, 2, '00155', NULL, NULL),
('PAC4', 'Pacchetto4', 'cena', '2017-01-01', '2017-02-28', 40, 3, '00399', NULL, NULL),
('PAC5', 'Pacchetto5', 'pranzo', '2017-01-20', '2017-04-01', 40, 1, '00133', NULL, NULL),
('PAC6', 'Pacchetto6', 'pranzo cena', '2017-01-20', '2017-04-20', 40, 4, '00399', NULL, NULL),
('PAC7', 'Pacchetto7', 'pernottamento', '2017-01-20', '2017-03-20', 50, 5, '00155', NULL, NULL),
('PAC8', 'Pacchetto8', 'pernottamento', '2017-01-20', '2017-03-20', 50, 6, '00111', NULL, NULL),
('PAC9', 'Pacchetto9', 'cena e pernottamento', '2017-01-20', '2017-03-15', 60, 6, '00111', NULL, NULL);

-- --------------------------------------------------------

--
-- Struttura della tabella `parco`
--

CREATE TABLE `parco` (
  `IdParco` int(11) NOT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `sede` varchar(30) DEFAULT NULL,
  `email` varchar(30) DEFAULT NULL,
  `telefono` varchar(20) DEFAULT NULL,
  `tipo` varchar(20) DEFAULT NULL,
  `numPiscine` int(11) DEFAULT NULL,
  `tema` varchar(30) DEFAULT NULL,
  `percorso` varchar(30) DEFAULT NULL,
  `numBigliettiVendita` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `parco`
--

INSERT INTO `parco` (`IdParco`, `nome`, `sede`, `email`, `telefono`, `tipo`, `numPiscine`, `tema`, `percorso`, `numBigliettiVendita`) VALUES
(1, 'Gardaland ', 'Verona', 'gardaland@parchi.com', '089123123', 'tematico', NULL, 'natura', NULL, 49),
(2, 'Mirabilandia', 'Ravenna', 'mirabilandia@parchi.it', '08911112', 'avventura', NULL, NULL, 'PercorsoArrampicata', 23),
(3, 'Safari Park', 'Rocca San Giovanni (Chieti)', 'safaripark@parchi.com', '089123124', 'tematico', NULL, 'faunistico', NULL, 47),
(4, 'Majagreen', 'Caramanico Terme (Pescara)', 'Majagreen@parchi.it', '020123235', 'avventura', NULL, NULL, 'percorso ad ostacoli', 29),
(5, 'Acquazzurra', 'Metaponto (Matera)', 'acquazzurra@parchi.it', '087851342', 'acquatico', 20, NULL, NULL, 16);

-- --------------------------------------------------------

--
-- Struttura della tabella `promozione`
--

CREATE TABLE `promozione` (
  `CodPromozione` varchar(10) NOT NULL,
  `dataI` date DEFAULT NULL,
  `dataF` date DEFAULT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `descrizione` varchar(60) DEFAULT NULL,
  `prezzo` float DEFAULT NULL,
  `IdParco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `promozione`
--

INSERT INTO `promozione` (`CodPromozione`, `dataI`, `dataF`, `nome`, `descrizione`, `prezzo`, `IdParco`) VALUES
('PR1', '2017-01-03', '2017-02-13', 'Metà Prezzo', 'Tutte le attività disponibili a Gardaland a metà prezzo', 17, 1),
('PR2', '2017-01-06', '2017-02-20', 'GardalandPromo', 'Occasione per Doremifarm e PrezzemoLand', 10, 1),
('PR3', '2017-07-10', '2017-09-10', 'Occasione', 'Tutte le attività disponibili a  SafariPark saranno in scont', 18, 3),
('PR4', '2017-01-02', '2017-02-28', 'Metà prezzo', 'Metà prezzo ruota panoramica', 4.5, 3),
('PR5', '2017-08-04', '2017-08-15', 'SummerPrice', 'Tutte le attività disponibili ad Acquazzura a metà prezzo', 13.5, 5),
('PR6', '2017-01-12', '2017-02-02', 'CinqueEuro', 'le attivita FarWest,ReLeone,RuotaPanoramica: 5$', 15, 3),
('PR7', '2017-01-15', '2017-03-15', 'ScontiPazzi', 'Oblivion,Voaplano,TiroAllaFune sono a metà prezzo', 12, 2),
('PR8', '2017-01-02', '2017-04-04', 'ScontiPazzi2.0', 'SingleRapidz,Voaplano al prezzo di 4$', 4, 2);

-- --------------------------------------------------------

--
-- Struttura della tabella `promozionecomprende`
--

CREATE TABLE `promozionecomprende` (
  `CodPromozione` varchar(10) NOT NULL,
  `CodAttivita` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `promozionecomprende`
--

INSERT INTO `promozionecomprende` (`CodPromozione`, `CodAttivita`) VALUES
('PR1', 'A1'),
('PR1', 'B1'),
('PR1', 'C1'),
('PR1', 'D1'),
('PR2', 'A1'),
('PR2', 'B1'),
('PR3', 'I3'),
('PR4', 'H3'),
('PR4', 'L3'),
('PR5', 'P5'),
('PR5', 'Q5'),
('PR5', 'R5'),
('PR5', 'S5'),
('PR6', 'H3'),
('PR6', 'I3'),
('PR6', 'L3'),
('PR7', 'AT1'),
('PR7', 'F2'),
('PR7', 'G2'),
('PR8', 'E2'),
('PR8', 'G2');

-- --------------------------------------------------------

--
-- Struttura della tabella `ristoroalloggio`
--

CREATE TABLE `ristoroalloggio` (
  `IdRA` int(11) NOT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `tipo` varchar(30) DEFAULT NULL,
  `via` varchar(30) DEFAULT NULL,
  `citta` varchar(30) DEFAULT NULL,
  `CAP` varchar(6) DEFAULT NULL,
  `telefono` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `ristoroalloggio`
--

INSERT INTO `ristoroalloggio` (`IdRA`, `nome`, `tipo`, `via`, `citta`, `CAP`, `telefono`) VALUES
(1, 'Da leo', 'ristorante', 'via Carnevale', 'Verona', '84126', '089897463'),
(2, 'Grand Hotel', 'hotel', 'Via Amendola', 'Ravenna', '84126', '084567864'),
(3, 'Concord', 'ristorante', 'Via Roma', 'Ravenna', '82115', '089121828'),
(4, 'Masaniello', 'ristorante', 'Via Diaz', 'Chieti', '80100', '020875345'),
(5, 'B&B', 'hotel', 'Via Papillon', 'Pescara', '82006', '010234567'),
(6, 'Hotel Flora', 'hotel', 'via Cavour', 'Matera', '12023', '3224569841');

-- --------------------------------------------------------

--
-- Struttura della tabella `struttura`
--

CREATE TABLE `struttura` (
  `CodStruttura` varchar(10) NOT NULL,
  `nome` varchar(30) DEFAULT NULL,
  `IdParco` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dump dei dati per la tabella `struttura`
--

INSERT INTO `struttura` (`CodStruttura`, `nome`, `IdParco`) VALUES
('AAA', 'StrutturaA', 1),
('BBB', 'StrutturaB', 1),
('CCC', 'StrutturaC', 1),
('DDD', 'StrutturaD', 1),
('EEE', 'StrutturaE', 2),
('FFF', 'StrutturaF', 2),
('GGG', 'StrutturaG', 2),
('HHH', 'StrutturaH', 3),
('III', 'StrutturaI', 3),
('LLL', 'StrutturaL', 3),
('MMM', 'StrutturaM', 4),
('NNN', 'StrutturaN', 4),
('OOO', 'Struttura0', 4),
('PPP', 'StrutturaP', 5),
('QQQ', 'StrutturaQ', 5),
('RRR', 'StrutturaR', 5),
('SSS', 'StrutturaS', 5);

--
-- Indici per le tabelle scaricate
--

--
-- Indici per le tabelle `accountagenzia`
--
ALTER TABLE `accountagenzia`
  ADD PRIMARY KEY (`P_IVA`),
  ADD KEY `P_IVA` (`P_IVA`);

--
-- Indici per le tabelle `agenzia`
--
ALTER TABLE `agenzia`
  ADD PRIMARY KEY (`P_IVA`);

--
-- Indici per le tabelle `attivita`
--
ALTER TABLE `attivita`
  ADD PRIMARY KEY (`CodAttivita`),
  ADD KEY `attivitaparco` (`IdParco`),
  ADD KEY `attivitastruttura` (`CodStruttura`);

--
-- Indici per le tabelle `biglietto`
--
ALTER TABLE `biglietto`
  ADD PRIMARY KEY (`CodBiglietto`),
  ADD KEY `bicl` (`CF`),
  ADD KEY `bipr` (`CodPromozione`),
  ADD KEY `bipa` (`IdParco`),
  ADD KEY `CodPacchetto` (`CodPacchetto`);

--
-- Indici per le tabelle `bigliettocomprende`
--
ALTER TABLE `bigliettocomprende`
  ADD PRIMARY KEY (`CodBiglietto`,`CodAttivita`),
  ADD KEY `bca` (`CodAttivita`);

--
-- Indici per le tabelle `cliente`
--
ALTER TABLE `cliente`
  ADD PRIMARY KEY (`CF`);

--
-- Indici per le tabelle `convenzionato`
--
ALTER TABLE `convenzionato`
  ADD PRIMARY KEY (`IdParco`,`P_IVA`),
  ADD KEY `foreignkey2` (`P_IVA`);

--
-- Indici per le tabelle `dipendenti`
--
ALTER TABLE `dipendenti`
  ADD PRIMARY KEY (`CF`),
  ADD KEY `dipendentiparco` (`IdParco`);

--
-- Indici per le tabelle `pacchetto`
--
ALTER TABLE `pacchetto`
  ADD PRIMARY KEY (`CodPacchetto`),
  ADD KEY `ce1` (`IdRA`),
  ADD KEY `ce2` (`P_IVA`),
  ADD KEY `ce3` (`CF`);

--
-- Indici per le tabelle `parco`
--
ALTER TABLE `parco`
  ADD PRIMARY KEY (`IdParco`);

--
-- Indici per le tabelle `promozione`
--
ALTER TABLE `promozione`
  ADD PRIMARY KEY (`CodPromozione`),
  ADD KEY `promozioneparco` (`IdParco`);

--
-- Indici per le tabelle `promozionecomprende`
--
ALTER TABLE `promozionecomprende`
  ADD PRIMARY KEY (`CodPromozione`,`CodAttivita`),
  ADD KEY `chiaves2` (`CodAttivita`);

--
-- Indici per le tabelle `ristoroalloggio`
--
ALTER TABLE `ristoroalloggio`
  ADD PRIMARY KEY (`IdRA`);

--
-- Indici per le tabelle `struttura`
--
ALTER TABLE `struttura`
  ADD PRIMARY KEY (`CodStruttura`),
  ADD KEY `c1` (`IdParco`);

--
-- AUTO_INCREMENT per le tabelle scaricate
--

--
-- AUTO_INCREMENT per la tabella `attivita`
--
ALTER TABLE `attivita`
  MODIFY `IdParco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `biglietto`
--
ALTER TABLE `biglietto`
  MODIFY `IdParco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `convenzionato`
--
ALTER TABLE `convenzionato`
  MODIFY `IdParco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `dipendenti`
--
ALTER TABLE `dipendenti`
  MODIFY `IdParco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `pacchetto`
--
ALTER TABLE `pacchetto`
  MODIFY `IdRA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `parco`
--
ALTER TABLE `parco`
  MODIFY `IdParco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `promozione`
--
ALTER TABLE `promozione`
  MODIFY `IdParco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- AUTO_INCREMENT per la tabella `ristoroalloggio`
--
ALTER TABLE `ristoroalloggio`
  MODIFY `IdRA` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT per la tabella `struttura`
--
ALTER TABLE `struttura`
  MODIFY `IdParco` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;
--
-- Limiti per le tabelle scaricate
--

--
-- Limiti per la tabella `accountagenzia`
--
ALTER TABLE `accountagenzia`
  ADD CONSTRAINT `cc` FOREIGN KEY (`P_IVA`) REFERENCES `agenzia` (`P_IVA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chi1` FOREIGN KEY (`P_IVA`) REFERENCES `agenzia` (`P_IVA`);

--
-- Limiti per la tabella `attivita`
--
ALTER TABLE `attivita`
  ADD CONSTRAINT `attivitaparco` FOREIGN KEY (`IdParco`) REFERENCES `parco` (`IdParco`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `attivitastruttura` FOREIGN KEY (`CodStruttura`) REFERENCES `struttura` (`CodStruttura`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `biglietto`
--
ALTER TABLE `biglietto`
  ADD CONSTRAINT `bicl` FOREIGN KEY (`CF`) REFERENCES `cliente` (`CF`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bipa` FOREIGN KEY (`IdParco`) REFERENCES `parco` (`IdParco`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bipr` FOREIGN KEY (`CodPromozione`) REFERENCES `promozione` (`CodPromozione`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chiaveest12` FOREIGN KEY (`CodPacchetto`) REFERENCES `pacchetto` (`CodPacchetto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `bigliettocomprende`
--
ALTER TABLE `bigliettocomprende`
  ADD CONSTRAINT `bca` FOREIGN KEY (`CodAttivita`) REFERENCES `attivita` (`CodAttivita`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `bcb` FOREIGN KEY (`CodBiglietto`) REFERENCES `biglietto` (`CodBiglietto`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `convenzionato`
--
ALTER TABLE `convenzionato`
  ADD CONSTRAINT `convenzionato_ibfk_1` FOREIGN KEY (`IdParco`) REFERENCES `parco` (`IdParco`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `convenzionato_ibfk_2` FOREIGN KEY (`P_IVA`) REFERENCES `agenzia` (`P_IVA`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `dipendenti`
--
ALTER TABLE `dipendenti`
  ADD CONSTRAINT `dipendentiparco` FOREIGN KEY (`IdParco`) REFERENCES `parco` (`IdParco`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `pacchetto`
--
ALTER TABLE `pacchetto`
  ADD CONSTRAINT `ce1` FOREIGN KEY (`IdRA`) REFERENCES `ristoroalloggio` (`IdRA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ce2` FOREIGN KEY (`P_IVA`) REFERENCES `agenzia` (`P_IVA`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `ce3` FOREIGN KEY (`CF`) REFERENCES `cliente` (`CF`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `promozione`
--
ALTER TABLE `promozione`
  ADD CONSTRAINT `promozioneparco` FOREIGN KEY (`IdParco`) REFERENCES `parco` (`IdParco`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `promozionecomprende`
--
ALTER TABLE `promozionecomprende`
  ADD CONSTRAINT `chiaves` FOREIGN KEY (`CodPromozione`) REFERENCES `promozione` (`CodPromozione`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `chiaves2` FOREIGN KEY (`CodAttivita`) REFERENCES `attivita` (`CodAttivita`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Limiti per la tabella `struttura`
--
ALTER TABLE `struttura`
  ADD CONSTRAINT `c1` FOREIGN KEY (`IdParco`) REFERENCES `parco` (`IdParco`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
