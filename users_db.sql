-- phpMyAdmin SQL Dump
-- version 4.8.3
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Sep 25, 2023 at 09:46 PM
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
  `updated_ts` timestamp NULL DEFAULT NULL,
  `created_ts` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `employees`
--

INSERT INTO `employees` (`id`, `name`, `last_name`, `age`, `updated_ts`, `created_ts`) VALUES
(1, 'John', 'Stranger', 35, NULL, '2023-09-25 18:20:46'),
(2, 'Bill', 'Stranger', 35, NULL, '2023-09-25 18:28:49'),
(3, 'Mike', 'Stranger', 55, NULL, '2023-09-25 18:28:49');

-- --------------------------------------------------------

--
-- Table structure for table `offices`
--

CREATE TABLE `offices` (
  `id` int(11) NOT NULL,
  `country_code` varchar(3) NOT NULL DEFAULT 'BY',
  `address` varchar(200) NOT NULL,
  `postal_code` mediumint(6) NOT NULL,
  `telephone_number` varchar(20) DEFAULT NULL,
  `email` varchar(50) DEFAULT NULL,
  `work_hours` varchar(12) DEFAULT '9.00-17.00'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `offices`
--

INSERT INTO `offices` (`id`, `country_code`, `address`, `postal_code`, `telephone_number`, `email`, `work_hours`) VALUES
(1, 'BY', 'Minsk, Lenina str, 5', 220111, '342-79-19', NULL, '9.00-17.00'),
(2, 'BY', 'Минск, Lenina str, 8', 220111, NULL, NULL, '9.00-17.00'),
(3, 'BY', 'Минск, Lenina str, 7', 220111, NULL, NULL, '9.00-17.00'),
(4, 'BY', 'Минск, Lenina str, 9', 220111, NULL, NULL, '9.00-17.00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `employees`
--
ALTER TABLE `employees`
  ADD PRIMARY KEY (`id`);

--
-- Indexes for table `offices`
--
ALTER TABLE `offices`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employees`
--
ALTER TABLE `employees`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `offices`
--
ALTER TABLE `offices`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
