-- phpMyAdmin SQL Dump
-- version 4.7.4
-- https://www.phpmyadmin.net/
--
-- Hôte : 127.0.0.1
-- Généré le :  mar. 18 déc. 2018 à 09:45
-- Version du serveur :  10.1.29-MariaDB
-- Version de PHP :  7.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
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
-- Déchargement des données de la table `course`
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
-- Déchargement des données de la table `location`
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
-- Déchargement des données de la table `session`
--

INSERT INTO `session` (`session_id`, `course_id`, `location_id`, `start_date`, `end_date`, `max_students`) VALUES
(2, 'XO00', 5, '2018-11-07', '2018-11-29', 30),
(3, 'LC00', 11, '2018-11-13', '2018-11-22', 4),
(4, 'LE02', 5, '2018-11-28', '2018-11-30', 12),
(5, 'PH02', 9, '2018-11-04', '2018-11-06', 22),
(6, 'LO54', 10, '2018-11-11', '2018-11-23', 15),
(7, 'HG43', 6, '2018-11-11', '2018-11-14', 22),
(8, 'HG43', 8, '2018-11-04', '2018-11-14', 42),
(9, 'HG43', 9, '2018-11-04', '2018-11-16', 31);

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
-- Déchargement des données de la table `user`
--

INSERT INTO `user` (`user_id`, `firstname`, `lastname`, `address`, `phone`, `email`, `username`, `password`, `grainsel`, `token`) VALUES
(1, 'Nicolas', 'Vincent', '66 rue des tulipes', '0899320323', 'nicolas.vincent@gouv.fr', 'Nicolas V.', 'nicolas.vincent', '', ''),
(20, 'alexis', 'ouksel', '2 rue', '0606', 'lele@le.fr', 'admin', '468eeeded22b09efd19a5746a8d6107c', '1bc29b36f623ba82aaf6724fd3b16718', '');

-- --------------------------------------------------------

--
-- Structure de la table `user_session`
--

CREATE TABLE `user_session` (
  `session_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Index pour les tables déchargées
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
-- AUTO_INCREMENT pour les tables déchargées
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
  MODIFY `session_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=10;

--
-- AUTO_INCREMENT pour la table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=21;

--
-- Contraintes pour les tables déchargées
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
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
