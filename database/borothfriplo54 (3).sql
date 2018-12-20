-- phpMyAdmin SQL Dump
-- version 4.5.4.1
-- http://www.phpmyadmin.net
--
-- Client :  localhost
-- Généré le :  Jeu 20 Décembre 2018 à 17:33
-- Version du serveur :  5.7.11
-- Version de PHP :  7.0.3

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de données :  `borothfriplo54`
--

-- --------------------------------------------------------

--
-- Structure de la table `course`
--

CREATE TABLE `course` (
  `code` varchar(4) NOT NULL,
  `title` text NOT NULL,
  `description` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `course`
--

INSERT INTO `course` (`code`, `title`, `description`) VALUES
('HG43', 'Probabilités et statistiques', 'Etude des probabilités et des statistiques appliquées au domaine informatique.'),
('LC00', 'Chinois débutant', 'Cours de chinois pour débutants'),
('LE02', 'Anglais intermédiaire', 'Cours d\'anglais A2-B1.'),
('LE03', 'Anglais avancé', 'Cours d\'anglais B1-B2.'),
('LO54', 'Java Enterprise Edition', 'Etude de la technologie J2E.'),
('PH02', 'Science, Technique et Politique', 'Étude des relations entre la science, la technique et la politique dans les œuvres littéraires du XXIe siècle.'),
('XO00', 'Annales', 'Études des annales de l\'UTBM');

-- --------------------------------------------------------

--
-- Structure de la table `location`
--

CREATE TABLE `location` (
  `location_id` int(11) NOT NULL,
  `city` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `location`
--

INSERT INTO `location` (`location_id`, `city`) VALUES
(5, 'Paris'),
(6, 'Strasbourg'),
(7, 'Marseille'),
(8, 'Lyon'),
(9, 'Belfort'),
(10, 'Montbéliard'),
(11, 'Londre');

-- --------------------------------------------------------

--
-- Structure de la table `session`
--

CREATE TABLE `session` (
  `session_id` int(11) NOT NULL,
  `course_id` varchar(4) NOT NULL,
  `location_id` int(11) NOT NULL,
  `start_date` date NOT NULL,
  `end_date` date NOT NULL,
  `max_students` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `session`
--

INSERT INTO `session` (`session_id`, `course_id`, `location_id`, `start_date`, `end_date`, `max_students`) VALUES
(2, 'XO00', 5, '2018-11-07', '2018-11-29', 30),
(3, 'LC00', 11, '2018-11-13', '2018-11-22', 4),
(4, 'LE02', 5, '2018-11-28', '2018-11-30', 12),
(5, 'PH02', 9, '2018-11-04', '2018-11-06', 22),
(6, 'LO54', 10, '2018-11-11', '2018-11-23', 15),
(7, 'HG43', 6, '2018-11-11', '2018-11-14', 22),
(8, 'HG43', 8, '2018-11-04', '2018-11-14', 42),
(9, 'HG43', 9, '2018-11-04', '2018-11-16', 31),
(10, 'LO54', 10, '2018-11-11', '2018-11-23', 15),
(11, 'PH02', 9, '2018-11-04', '2018-11-06', 22),
(12, 'LC00', 11, '2018-11-13', '2018-11-22', 4),
(13, 'LC00', 11, '2018-11-13', '2018-11-22', 4),
(14, 'LC00', 11, '2018-11-13', '2018-11-22', 4);

-- --------------------------------------------------------

--
-- Structure de la table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `firstname` text NOT NULL,
  `lastname` text NOT NULL,
  `address` text NOT NULL,
  `phone` text NOT NULL,
  `email` text NOT NULL,
  `username` text NOT NULL,
  `password` text NOT NULL,
  `grainsel` text NOT NULL,
  `token` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user`
--

INSERT INTO `user` (`user_id`, `firstname`, `lastname`, `address`, `phone`, `email`, `username`, `password`, `grainsel`, `token`) VALUES
(1, 'Nicolas', 'Vincent', '66 rue des tulipes', '0899320323', 'nicolas.vincent@gouv.fr', 'Nicolas V.', 'nicolas.vincent', '', ''),
(20, 'alexis', 'ouksel', '2 rue', '0606', 'lele@le.fr', 'admin', '468eeeded22b09efd19a5746a8d6107c', '1bc29b36f623ba82aaf6724fd3b16718', '3bcfb13401b7aa2c28349c078c9a7912'),
(21, 'okk\n', 'ok', 'ok', 'jj\n', 'ok', 'admi', '14f8bf46f4b95cc94f73d6d6ff80c934', 'cdb43eb9cd3eac64251b0a03066c5808', 'tokenIsWaitingToBeGenerated'),
(22, 'alexis', 'ouksel', '2 rue', '0606', 'lele@le.fr', 'admin', '468eeeded22b09efd19a5746a8d6107c', '1bc29b36f623ba82aaf6724fd3b16718', '29a43dc11356a512e16c543639bfd7d6'),
(23, 'alexis', 'ouksel', '2 rue', '0606', 'lele@le.fr', 'admin', '468eeeded22b09efd19a5746a8d6107c', '1bc29b36f623ba82aaf6724fd3b16718', 'e4ce48454c3388566a1966afb9162c0c'),
(24, 'alexis', 'ouksel', '2 rue', '0606', 'lele@le.fr', 'admin', '468eeeded22b09efd19a5746a8d6107c', '1bc29b36f623ba82aaf6724fd3b16718', 'e4ce48454c3388566a1966afb9162c0c'),
(25, 'alexis', 'ouksel', '2 rue', '0606', 'lele@le.fr', 'admin', '468eeeded22b09efd19a5746a8d6107c', '1bc29b36f623ba82aaf6724fd3b16718', 'e4ce48454c3388566a1966afb9162c0c'),
(26, 'alexis', 'ouksel', '2 rue', '0606', 'lele@le.fr', 'admin', '468eeeded22b09efd19a5746a8d6107c', '1bc29b36f623ba82aaf6724fd3b16718', 'e4ce48454c3388566a1966afb9162c0c'),
(27, 'alexis', 'ouksel', '2 rue', '0606', 'lele@le.fr', 'admin', '468eeeded22b09efd19a5746a8d6107c', '1bc29b36f623ba82aaf6724fd3b16718', 'e4ce48454c3388566a1966afb9162c0c');

-- --------------------------------------------------------

--
-- Structure de la table `user_session`
--

CREATE TABLE `user_session` (
  `session_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Contenu de la table `user_session`
--

INSERT INTO `user_session` (`session_id`, `user_id`) VALUES
(2, 1),
(3, 20),
(6, 20),
(7, 20),
(9, 20),
(10, 20),
(12, 20),
(13, 20),
(14, 20),
(2, 23),
(3, 23),
(4, 23),
(5, 23),
(6, 23),
(7, 23),
(8, 23),
(9, 23),
(3, 24),
(4, 24),
(5, 24),
(2, 25),
(3, 25),
(4, 25),
(5, 25),
(6, 25),
(7, 25),
(8, 25),
(9, 25),
(10, 25),
(11, 25),
(12, 26),
(13, 27);

--
-- Index pour les tables exportées
--

--
-- Index pour la table `course`
--
ALTER TABLE `course`
  ADD PRIMARY KEY (`code`);

--
-- Index pour la table `location`
--
ALTER TABLE `location`
  ADD PRIMARY KEY (`location_id`);

--
-- Index pour la table `session`
--
ALTER TABLE `session`
  ADD PRIMARY KEY (`session_id`),
  ADD KEY `location_id` (`location_id`),
  ADD KEY `session_ibfk_1` (`course_id`);

--
-- Index pour la table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- Index pour la table `user_session`
--
ALTER TABLE `user_session`
  ADD PRIMARY KEY (`session_id`,`user_id`),
  ADD KEY `user_id` (`user_id`);

--
-- AUTO_INCREMENT pour les tables exportées
--

--
-- AUTO_INCREMENT pour la table `location`
--
ALTER TABLE `location`
  MODIFY `location_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT pour la table `session`
--
ALTER TABLE `session`
  MODIFY `session_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15;
--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- Contraintes pour les tables exportées
--

--
-- Contraintes pour la table `session`
--
ALTER TABLE `session`
  ADD CONSTRAINT `session_ibfk_1` FOREIGN KEY (`course_id`) REFERENCES `course` (`code`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `session_ibfk_2` FOREIGN KEY (`location_id`) REFERENCES `location` (`location_id`) ON DELETE CASCADE ON UPDATE CASCADE;

--
-- Contraintes pour la table `user_session`
--
ALTER TABLE `user_session`
  ADD CONSTRAINT `user_session_ibfk_1` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`) ON DELETE CASCADE ON UPDATE CASCADE,
  ADD CONSTRAINT `user_session_ibfk_2` FOREIGN KEY (`session_id`) REFERENCES `session` (`session_id`) ON DELETE CASCADE ON UPDATE CASCADE;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
