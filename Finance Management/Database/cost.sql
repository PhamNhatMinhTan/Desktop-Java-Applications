-- phpMyAdmin SQL Dump
-- version 4.9.0.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 28, 2019 at 06:56 AM
-- Server version: 10.3.15-MariaDB
-- PHP Version: 7.3.6

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `financialmanagement`
--

-- --------------------------------------------------------

--
-- Table structure for table `cost`
--

CREATE TABLE `cost` (
  `c_id` bigint(20) NOT NULL COMMENT 'cost ID',
  `c_description` varchar(250) NOT NULL COMMENT 'cost description',
  `c_value` int(11) NOT NULL COMMENT 'cost value',
  `c_date` datetime NOT NULL COMMENT 'date'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Dumping data for table `cost`
--

INSERT INTO `cost` (`c_id`, `c_description`, `c_value`, `c_date`) VALUES
(1, 'An Sang', -20000, '2019-06-24 00:00:00'),
(2, 'An Trua', -20000, '2019-06-24 00:00:00'),
(3, 'An Chieu', -20000, '2019-06-24 00:00:00'),
(4, 'An Sang', -20000, '2019-06-25 00:00:00'),
(5, 'Mua Sach', -165000, '2019-06-25 00:00:00'),
(6, 'An Trua', -20000, '2019-06-25 00:00:00'),
(7, 'Mua Game', -756000, '2019-06-25 00:00:00'),
(8, 'Mua Sach', -35000, '2019-06-21 00:00:00'),
(9, 'CGV', -90000, '2019-05-25 00:00:00'),
(10, 'mua nha', 15000, '2019-06-27 00:00:00'),
(11, 'Mua com', -15000, '2019-06-27 00:00:00'),
(12, 'An sang', -20000, '2019-06-26 00:00:00'),
(13, 'Vo cho', 50000, '2019-06-26 00:00:00'),
(14, 'Uong Coffee', -25000, '2019-06-27 00:00:00'),
(17, 'mua xe', -29000, '2019-06-27 00:00:00'),
(19, 'Ban sua', 60000, '2019-06-27 00:00:00'),
(21, 'Mua banh', -5000, '2019-06-26 00:00:00'),
(22, 'Father give', 60000, '2019-06-28 00:00:00');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `cost`
--
ALTER TABLE `cost`
  ADD PRIMARY KEY (`c_id`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `cost`
--
ALTER TABLE `cost`
  MODIFY `c_id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT 'cost ID', AUTO_INCREMENT=23;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
