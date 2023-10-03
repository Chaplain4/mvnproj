-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 03, 2023 at 08:43 PM
-- Server version: 5.7.39-log
-- PHP Version: 7.2.34

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `task3_db`
--

-- --------------------------------------------------------

--
-- Table structure for table `car`
--

CREATE TABLE `car` (
  `vin` int(11) NOT NULL,
  `maker` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `model` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `year` int(11) NOT NULL,
  `engine_sn` int(11) NOT NULL,
  `owner_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `car`
--

INSERT INTO `car` (`vin`, `maker`, `model`, `year`, `engine_sn`, `owner_id`) VALUES
(156149, 'MTZ', 'Belarus-1221', 2000, 1, 1),
(156150, 'MTZ', 'Belarus-1221', 2000, 2, 1),
(156151, 'MTZ', 'Belarus-1221', 2000, 3, 2);

-- --------------------------------------------------------

--
-- Table structure for table `engine`
--

CREATE TABLE `engine` (
  `engine_sn` int(11) NOT NULL,
  `manufacturer` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `model` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `size` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `weight_in_kg` int(11) NOT NULL,
  `num_cylinders` int(11) NOT NULL,
  `VIN` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `engine`
--

INSERT INTO `engine` (`engine_sn`, `manufacturer`, `model`, `size`, `weight_in_kg`, `num_cylinders`, `VIN`) VALUES
(1, 'MMZ', 'D-260', '1300x705x1118', 710, 6, 45621984),
(2, 'MMZ', 'D-260', '1300x705x1118', 710, 6, 45621985),
(3, 'MMZ', 'D-260', '1300x705x1118', 710, 6, 45621986);

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `member_id` int(11) NOT NULL,
  `user_id` int(11) NOT NULL,
  `organization_id` int(11) NOT NULL,
  `member_email` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`member_id`, `user_id`, `organization_id`, `member_email`) VALUES
(1, 1, 1, '123'),
(2, 2, 2, '456');

-- --------------------------------------------------------

--
-- Table structure for table `organization`
--

CREATE TABLE `organization` (
  `organization_id` int(11) NOT NULL,
  `organization_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `new field` varchar(8) COLLATE utf8mb4_unicode_ci DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `organization`
--

INSERT INTO `organization` (`organization_id`, `organization_name`, `new field`) VALUES
(1, 'NewOrg1', NULL),
(2, 'NewOrg2', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `owner`
--

CREATE TABLE `owner` (
  `owner_id` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `street` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `city` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'Minsk',
  `state` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'Belarus',
  `zip` int(11) NOT NULL DEFAULT '220113',
  `homephone` varchar(64) COLLATE utf8mb4_unicode_ci DEFAULT NULL,
  `cellphone` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `owner`
--

INSERT INTO `owner` (`owner_id`, `name`, `last_name`, `street`, `city`, `state`, `zip`, `homephone`, `cellphone`) VALUES
(1, 'Mihail', 'Petrov', 'Kolasa', 'Minsk', 'Belarus', 220113, '2624874', '29-4180578'),
(2, 'Ivan', 'Pavlov', 'Kulman', 'Minsk', 'Belarus', 220013, '2357410', '29-5051322');

-- --------------------------------------------------------

--
-- Table structure for table `post`
--

CREATE TABLE `post` (
  `post_id` int(11) NOT NULL,
  `title` varchar(64) COLLATE utf8mb4_unicode_ci NOT NULL,
  `body` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `user_id` int(11) NOT NULL,
  `source_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL DEFAULT 'some source'
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `post`
--

INSERT INTO `post` (`post_id`, `title`, `body`, `user_id`, `source_name`) VALUES
(1, 'Title1', 'Body1', 1, 'some source'),
(2, 'Title2', 'Body2', 1, 'some source');

-- --------------------------------------------------------

--
-- Table structure for table `source`
--

CREATE TABLE `source` (
  `source_id` int(11) NOT NULL,
  `organization_id` int(11) NOT NULL,
  `source_name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `source`
--

INSERT INTO `source` (`source_id`, `organization_id`, `source_name`) VALUES
(1, 1, 'NewSource1'),
(2, 1, 'NewSource2'),
(3, 2, 'NewSource3'),
(4, 2, 'NewSource4');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `name` varchar(128) COLLATE utf8mb4_unicode_ci NOT NULL,
  `organization_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`user_id`, `name`, `organization_id`) VALUES
(1, 'User1', 1),
(2, 'User2', 2);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `car`
--
ALTER TABLE `car`
  ADD UNIQUE KEY `vin` (`vin`),
  ADD UNIQUE KEY `engine_sn` (`engine_sn`),
  ADD KEY `fk_owner_id_owner_pk` (`owner_id`);

--
-- Indexes for table `engine`
--
ALTER TABLE `engine`
  ADD PRIMARY KEY (`engine_sn`),
  ADD UNIQUE KEY `VIN` (`VIN`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`member_id`),
  ADD UNIQUE KEY `user_id` (`user_id`),
  ADD UNIQUE KEY `organization_id` (`organization_id`),
  ADD UNIQUE KEY `member_email` (`member_email`);

--
-- Indexes for table `organization`
--
ALTER TABLE `organization`
  ADD PRIMARY KEY (`organization_id`);

--
-- Indexes for table `owner`
--
ALTER TABLE `owner`
  ADD PRIMARY KEY (`owner_id`);

--
-- Indexes for table `post`
--
ALTER TABLE `post`
  ADD PRIMARY KEY (`post_id`),
  ADD KEY `fk_user_id_user_pk_id` (`user_id`);

--
-- Indexes for table `source`
--
ALTER TABLE `source`
  ADD PRIMARY KEY (`source_id`),
  ADD KEY `member_fk_organization_id_organization_pk_id` (`organization_id`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `engine`
--
ALTER TABLE `engine`
  MODIFY `engine_sn` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;

--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `member_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `organization`
--
ALTER TABLE `organization`
  MODIFY `organization_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `owner`
--
ALTER TABLE `owner`
  MODIFY `owner_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `post`
--
ALTER TABLE `post`
  MODIFY `post_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- AUTO_INCREMENT for table `source`
--
ALTER TABLE `source`
  MODIFY `source_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;

--
-- AUTO_INCREMENT for table `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `car`
--
ALTER TABLE `car`
  ADD CONSTRAINT `fk_engine_sn_engine_pk` FOREIGN KEY (`engine_sn`) REFERENCES `engine` (`engine_sn`),
  ADD CONSTRAINT `fk_owner_id_owner_pk` FOREIGN KEY (`owner_id`) REFERENCES `owner` (`owner_id`);

--
-- Constraints for table `member`
--
ALTER TABLE `member`
  ADD CONSTRAINT `fk_org_id_org_pk_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`),
  ADD CONSTRAINT `member_fk_user_id_user_pk_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `post`
--
ALTER TABLE `post`
  ADD CONSTRAINT `fk_user_id_user_pk_id` FOREIGN KEY (`user_id`) REFERENCES `user` (`user_id`);

--
-- Constraints for table `source`
--
ALTER TABLE `source`
  ADD CONSTRAINT `member_fk_organization_id_organization_pk_id` FOREIGN KEY (`organization_id`) REFERENCES `organization` (`organization_id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
