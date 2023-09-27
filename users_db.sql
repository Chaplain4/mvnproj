-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 27, 2023 at 09:40 PM
-- Server version: 5.6.41
-- PHP Version: 5.5.38

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `users_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `employees`
--

CREATE TABLE `employees` (
  `id` int(11) NOT NULL,
  `name` varchar(128) DEFAULT NULL,
  `last_name` varchar(128) NOT NULL DEFAULT 'Stranger',
  `age` int(11) NOT NULL,
  `office_id` int(11) NOT NULL,
  `passport_id` int(11) NOT NULL,
  `updated_ts` timestamp NULL DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `last_name`, `age`, `office_id`, `passport_id`, `updated_ts`, `created_ts`) VALUES
(1, 'Bill', 'Stranger', 35, 1, 1, NULL, '2023-09-25 18:28:44'),
(2, 'Mike', 'Stranger', 55, 1, 2, NULL, '2023-09-25 18:28:44'),
(3, 'John', 'Stranger', 35, 1, 3, NULL, '2023-09-27 16:55:28'),
(4, NULL, 'Ivanov', 37, 4, 4, NULL, '2023-09-27 16:58:47'),
(6, 'Liza', 'Ivanova', 45, 2, 5, NULL, '2023-09-27 18:28:38'),
(7, 'Olga', 'Stranger', 18, 3, 6, NULL, '2023-09-27 18:32:16');

-- --------------------------------------------------------

--
-- Table structure for table `offices`
--

CREATE TABLE `offices` (
  `id` int(11) NOT NULL,
  `title` varchar(64) NOT NULL,
  `address` varchar(256) NOT NULL,
  `phone 1` varchar(128) NOT NULL,
  `phone 2` varchar(128) NOT NULL,
  `postal_code` int(11) NOT NULL,
  `updated_ts` timestamp NULL DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `offices`
--

INSERT INTO `offices` (`id`, `title`, `address`, `phone 1`, `phone 2`, `postal_code`, `updated_ts`, `created_ts`) VALUES
(1, 'MAIN', 'BLR, Minsk, K.Marksa 32', '+375172416974', '+375172416975', 220111, NULL, '2023-09-27 16:32:41'),
(2, 'DEP#1', 'BLR, Minsk, K.Marksa 34', '+375172417974', '+375172417975', 220111, NULL, '2023-09-27 16:32:41'),
(3, 'DEP#2', 'BLR, Minsk, K.Marksa 35', '+375179046974', '+375172404975', 220111, NULL, '2023-09-27 16:32:41'),
(4, 'DEP#3', 'BLR, Minsk, K.Marksa 36', '+375172416974', '+375172416975', 220111, NULL, '2023-09-27 16:32:41');

-- --------------------------------------------------------

--
-- Table structure for table `passport`
--

CREATE TABLE `passport` (
  `id` int(11) NOT NULL,
  `personal_id` varchar(9) NOT NULL,
  `ind_id` varchar(20) NOT NULL,
  `exp_ts` date NOT NULL,
  `created_ts` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `passport`
--

INSERT INTO `passport` (`id`, `personal_id`, `ind_id`, `exp_ts`, `created_ts`) VALUES
(1, 'MP9831021', 'A7897846OP23', '2024-01-20', '2014-01-20'),
(2, 'MP9131021', 'A7897846OP13', '2024-09-20', '2014-09-20'),
(3, 'MP9504021', 'A7897846OP93', '2024-03-20', '2014-03-20'),
(4, 'MP9871451', 'A7897446OP23', '2024-02-20', '2014-02-20'),
(5, 'MP9007421', 'A1792346OP23', '2023-10-27', '2019-10-27'),
(6, 'MP9837499', 'A7899346OP23', '2024-10-27', '2020-10-27');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `passport_id` (`passport_id`),
  ADD KEY `fk_office_id_offices_pk_id` (`office_id`);

--
-- Indexes for table `offices`
--
ALTER TABLE `offices`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `passport`
--
ALTER TABLE `passport`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=8;

--
-- AUTO_INCREMENT for table `offices`
--
ALTER TABLE `offices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `passport`
--
ALTER TABLE `passport`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `employees`
--
ALTER TABLE `employees`
  ADD CONSTRAINT `fk_office_id_offices_pk_id` FOREIGN KEY (`office_id`) REFERENCES `offices` (`id`),
  ADD CONSTRAINT `fk_passport_id_passport_pk_id` FOREIGN KEY (`passport_id`) REFERENCES `passport` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
