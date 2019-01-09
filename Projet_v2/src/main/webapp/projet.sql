-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1:3306
-- Généré le :  sam. 29 déc. 2018 à 22:57
-- Version du serveur :  5.7.19
-- Version de PHP :  5.6.31

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `projet`
--

-- --------------------------------------------------------

--
-- Structure de la table `credentials`
--

DROP TABLE IF EXISTS `credentials`;
CREATE TABLE IF NOT EXISTS `credentials` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `LOGIN` varchar(25) NOT NULL,
  `PASSWORD` varchar(25) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `credentials`
--

INSERT INTO `credentials` (`ID`, `LOGIN`, `PASSWORD`) VALUES
(1, 'admin', 'admin');

-- --------------------------------------------------------

--
-- Structure de la table `employees`
--

DROP TABLE IF EXISTS `employees`;
CREATE TABLE IF NOT EXISTS `employees` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `NAME` varchar(25) NOT NULL,
  `FIRSTNAME` varchar(25) NOT NULL,
  `TELHOME` varchar(10) NOT NULL,
  `TELMOB` varchar(10) NOT NULL,
  `TELPRO` varchar(10) NOT NULL,
  `ADRESS` varchar(150) NOT NULL,
  `POSTALCODE` varchar(5) NOT NULL,
  `CITY` varchar(25) NOT NULL,
  `EMAIL` varchar(50) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=37 DEFAULT CHARSET=utf8;

--
-- Déchargement des données de la table `employees`
--

INSERT INTO `employees` (`ID`, `NAME`, `FIRSTNAME`, `TELHOME`, `TELMOB`, `TELPRO`, `ADRESS`, `POSTALCODE`, `CITY`, `EMAIL`) VALUES
(27, 'Simpson', 'Homer', '0123456789', '0612345678', '0698765432', '2 avenue Duff', '92700', 'Colombes', 'hsimpson@gmail.com'),
(28, 'Simpson', 'Bart', '0145362787', '0645362718', '0611563477', '10 rue des Rebelles', '92270', 'Bois-colombes', 'bsimpson@gmail.com'),
(29, 'Lagaffe', 'Gaston', '0187665987', '0623334256', '0654778654', '65 rue de la Paresse', '92700', 'Colombes', 'glagaffe@yahoo.fr'),
(30, 'Mafalda', 'Querida', '0187611987', '0783334256', '0658878654', '6 rue de Buenos Aires', '75016', 'Paris', 'qmafalda@hotmail.ar'),
(31, 'Woodpecker', 'Woody', '0187384987', '0622494256', '0674178654', '5 bvd des Picoreurs', '21000', 'Dijon', 'woody@mail.co.uk'),
(32, 'Brown', 'Charlie', '0122456678', '0699854673', '0623445166', '140 avenue Foche', '90000', 'Nanterre', 'cbrown@live.com'),
(33, 'Sam', 'Smith', '0138763864', '0664263999', '0681740173', '19 rue de la Rivière', '24011', 'Quimper', 'ssam@aol.com'),
(34, 'Alex', 'Johnson', '0198765432', '0623456789', '0612345678', '91 avenue de la Grue', '29031', 'Evreux', 'ajonhson@efrei.net'),
(35, 'Clover', 'Williams', '0111563477', '0645362787', '0645362718', '72 bvd des Paquerettes', '12076', 'Marseilles', 'cwilliams@gmail.com'),
(36, 'Jerry', 'Jones', '0154778654', '0687665987', '0623334256', '142 rue du pâté', '22088', 'Rennes', 'jjones@hotmail.com');
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
