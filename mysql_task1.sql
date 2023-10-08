-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3306
-- Generation Time: Oct 08, 2023 at 05:07 PM
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
-- Database: `mysql_task1`
--

-- --------------------------------------------------------

--
-- Table structure for table `department`
--

CREATE TABLE `department` (
  `dept_no` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `dept_name` varchar(40) COLLATE utf8mb4_unicode_ci NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `department`
--

INSERT INTO `department` (`dept_no`, `dept_name`) VALUES
('1', 'sales'),
('2', 'development');

-- --------------------------------------------------------

--
-- Table structure for table `dept_emp`
--

CREATE TABLE `dept_emp` (
  `emp_no` int(11) NOT NULL,
  `dept_no` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dept_emp`
--

INSERT INTO `dept_emp` (`emp_no`, `dept_no`, `from_date`, `to_date`) VALUES
(1, '1', '2023-10-01', '2023-10-08'),
(3, '2', '2023-10-01', '2023-10-08'),
(5, '2', '2023-10-01', '2023-10-08');

-- --------------------------------------------------------

--
-- Table structure for table `dept_manager`
--

CREATE TABLE `dept_manager` (
  `emp_no` int(11) NOT NULL,
  `dept_no` varchar(4) COLLATE utf8mb4_unicode_ci NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `dept_manager`
--

INSERT INTO `dept_manager` (`emp_no`, `dept_no`, `from_date`, `to_date`) VALUES
(4, '1', '2023-09-19', '2023-10-08'),
(2, '2', '2023-10-01', '2023-10-08');

-- --------------------------------------------------------

--
-- Table structure for table `employee`
--

CREATE TABLE `employee` (
  `emp_no` int(11) NOT NULL,
  `birth_date` date NOT NULL,
  `first_name` varchar(14) COLLATE utf8mb4_unicode_ci NOT NULL,
  `last_name` varchar(16) COLLATE utf8mb4_unicode_ci NOT NULL,
  `gender` enum('M','F') COLLATE utf8mb4_unicode_ci NOT NULL,
  `hire_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `employee`
--

INSERT INTO `employee` (`emp_no`, `birth_date`, `first_name`, `last_name`, `gender`, `hire_date`) VALUES
(1, '1992-06-11', 'Ivan', 'Ivanov', 'M', '2023-07-03'),
(2, '1991-05-15', 'Svetlana', 'Petrova', 'F', '2023-02-01'),
(3, '1993-09-21', 'Lyudmila', 'Bykova', 'F', '2022-11-07'),
(4, '1995-01-05', 'Egor', 'Klenov', 'M', '2023-07-24'),
(5, '1987-05-15', 'Vasily', 'Smirnov', 'M', '2023-02-05');

-- --------------------------------------------------------

--
-- Table structure for table `empl_skills`
--

CREATE TABLE `empl_skills` (
  `emp_no` int(11) NOT NULL,
  `skills` varchar(1024) COLLATE utf8mb4_unicode_ci NOT NULL,
  `exp` int(128) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `empl_skills`
--

INSERT INTO `empl_skills` (`emp_no`, `skills`, `exp`) VALUES
(1, 'some ivan skills', 1),
(2, 'some svetlana skills', 2),
(3, 'some other skills', 3),
(4, 'some other skills', 4),
(5, 'some other skills', 5);

-- --------------------------------------------------------

--
-- Table structure for table `salary`
--

CREATE TABLE `salary` (
  `emp_no` int(11) NOT NULL,
  `amount` int(11) NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `salary`
--

INSERT INTO `salary` (`emp_no`, `amount`, `from_date`, `to_date`) VALUES
(1, 300, '2023-09-06', '2023-10-08'),
(2, 350, '2023-09-06', '2023-10-08'),
(3, 150, '2023-09-06', '2023-10-08'),
(4, 100, '2023-10-01', '2023-10-08'),
(5, 400, '2023-10-01', '2023-10-08');

-- --------------------------------------------------------

--
-- Table structure for table `title`
--

CREATE TABLE `title` (
  `emp_no` int(11) NOT NULL,
  `title` varchar(50) COLLATE utf8mb4_unicode_ci NOT NULL,
  `from_date` date NOT NULL,
  `to_date` date NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Dumping data for table `title`
--

INSERT INTO `title` (`emp_no`, `title`, `from_date`, `to_date`) VALUES
(1, 'salesman', '2023-09-06', '2023-10-08'),
(2, 'dev manager', '2023-10-01', '2023-10-08'),
(3, 'developer', '2023-09-06', '2023-10-08'),
(4, 'sales manager', '2023-10-01', '2023-10-08'),
(5, 'developer', '2023-09-06', '2023-10-08');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `department`
--
ALTER TABLE `department`
  ADD PRIMARY KEY (`dept_no`);

--
-- Indexes for table `dept_emp`
--
ALTER TABLE `dept_emp`
  ADD UNIQUE KEY `emp_no` (`emp_no`),
  ADD KEY `dept_emp_fk_dept_no_department_pk_id` (`dept_no`);

--
-- Indexes for table `dept_manager`
--
ALTER TABLE `dept_manager`
  ADD PRIMARY KEY (`dept_no`),
  ADD UNIQUE KEY `emp_no` (`emp_no`);

--
-- Indexes for table `employee`
--
ALTER TABLE `employee`
  ADD PRIMARY KEY (`emp_no`);

--
-- Indexes for table `empl_skills`
--
ALTER TABLE `empl_skills`
  ADD UNIQUE KEY `title` (`emp_no`),
  ADD UNIQUE KEY `emp_no` (`emp_no`);

--
-- Indexes for table `salary`
--
ALTER TABLE `salary`
  ADD UNIQUE KEY `emp_no` (`emp_no`);

--
-- Indexes for table `title`
--
ALTER TABLE `title`
  ADD UNIQUE KEY `emp_no` (`emp_no`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `employee`
--
ALTER TABLE `employee`
  MODIFY `emp_no` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `dept_emp`
--
ALTER TABLE `dept_emp`
  ADD CONSTRAINT `dept_emp_fk_dept_no_department_pk_id` FOREIGN KEY (`dept_no`) REFERENCES `department` (`dept_no`),
  ADD CONSTRAINT `dept_emp_fk_emp_no_employee_pk_id` FOREIGN KEY (`emp_no`) REFERENCES `employee` (`emp_no`);

--
-- Constraints for table `dept_manager`
--
ALTER TABLE `dept_manager`
  ADD CONSTRAINT `dept_manager_fk_dept_no_department_pk_id` FOREIGN KEY (`dept_no`) REFERENCES `department` (`dept_no`),
  ADD CONSTRAINT `dept_manager_fk_emp_no_employee_pk_id` FOREIGN KEY (`emp_no`) REFERENCES `employee` (`emp_no`);

--
-- Constraints for table `empl_skills`
--
ALTER TABLE `empl_skills`
  ADD CONSTRAINT `skills_fk_emp_no_employee_pk_id` FOREIGN KEY (`emp_no`) REFERENCES `employee` (`emp_no`);

--
-- Constraints for table `salary`
--
ALTER TABLE `salary`
  ADD CONSTRAINT `salary_fk_emp_no_employee_pk_id` FOREIGN KEY (`emp_no`) REFERENCES `employee` (`emp_no`);

--
-- Constraints for table `title`
--
ALTER TABLE `title`
  ADD CONSTRAINT `title_fk_emp_no_employee_pk_id` FOREIGN KEY (`emp_no`) REFERENCES `employee` (`emp_no`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
