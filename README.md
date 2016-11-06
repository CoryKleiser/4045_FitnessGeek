# 4045_FitnessGeek
Added Project to GitHub



@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@
@ Run the following script to create the DB @
@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@@

-- phpMyAdmin SQL Dump
-- version 4.6.4
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Nov 06, 2016 at 09:07 PM
-- Server version: 5.7.14
-- PHP Version: 5.6.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `fitness_geek`
--

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `user_name` varchar(40) NOT NULL,
  `password` varchar(40) NOT NULL,
  `first_name` varchar(40) NOT NULL,
  `last_name` varchar(40) DEFAULT NULL,
  `email` varchar(100) DEFAULT NULL,
  `user_weight` int(11) DEFAULT NULL,
  `user_height` int(11) DEFAULT NULL
) ENGINE=MyISAM DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `user_name`, `password`, `first_name`, `last_name`, `email`, `user_weight`, `user_height`) VALUES
(15963, 'williswm', 'Password', 'Will', 'Willis', 'test@email.com', 150, 55),
(15964, 'b91f068d-c71c-40d5-a0d4-89bdc91ea9b9', 'UNIT TEST', 'UNIT TEST', 'UNIT TEST', 'unitTest@mail.uc.edu', 150, 55),
(15965, '94986808-8c85-479a-873f-4a5963f3cfb1', 'UNIT TEST', 'UNIT TEST', 'UNIT TEST', 'userNameUid@mail.uc.edu', 150, 55),
(15966, 'd219a2a7-75fc-4475-8cc3-d479da5242ed', 'UNIT TEST', 'UNIT TEST', 'UNIT TEST', 'd219a2a7-75fc-4475-8cc3-d479da5242ed@mail.uc.edu', 150, 55),
(15967, '2168c842-eb4e-4d9e-8e00-88d6ff8687a4', 'UNIT TEST', 'UNIT TEST', 'UNIT TEST', '2168c842-eb4e-4d9e-8e00-88d6ff8687a4@mail.uc.edu', 150, 55),
(15968, '4b67b53f-7eb2-45a9-8256-2ca8f4877f3e', 'UNIT TEST', 'UNIT TEST', 'UNIT TEST', '4b67b53f-7eb2-45a9-8256-2ca8f4877f3e@mail.uc.edu', 150, 55);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `user_name` (`user_name`),
  ADD UNIQUE KEY `email` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=15969;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
