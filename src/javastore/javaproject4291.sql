-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Apr 26, 2016 at 04:31 AM
-- Server version: 10.1.9-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaproject4291`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`id`, `username`, `password`) VALUES
(1, 'admin', 'admin'),
(2, '3oxic', 'test'),
(3, 'testttt', 'test');

-- --------------------------------------------------------

--
-- Table structure for table `ccustomers`
--

CREATE TABLE `ccustomers` (
  `id` int(11) NOT NULL,
  `afm` int(11) NOT NULL,
  `fax` int(11) NOT NULL,
  `telnumber` int(11) NOT NULL,
  `discount` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `fpa` float NOT NULL,
  `address` varchar(80) NOT NULL,
  `epwnymia` varchar(30) NOT NULL,
  `ypefep` varchar(80) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ccustomers`
--

INSERT INTO `ccustomers` (`id`, `afm`, `fax`, `telnumber`, `discount`, `username`, `password`, `fpa`, `address`, `epwnymia`, `ypefep`) VALUES
(1, 123456, 0, 0, 0, '', '', 0, '', '', ''),
(1, 123456, 1, 1, 1, '1', '1', 1, '1', '1', '1'),
(1, 1233333, 1, 1, 1, '1', '11', 1, '1', '1', '1');

-- --------------------------------------------------------

--
-- Table structure for table `ncustomers`
--

CREATE TABLE `ncustomers` (
  `id` int(11) NOT NULL,
  `username` varchar(30) NOT NULL,
  `password` varchar(30) NOT NULL,
  `address` varchar(30) NOT NULL,
  `telnumber` int(11) NOT NULL,
  `afm` int(11) NOT NULL,
  `fullname` varchar(80) NOT NULL,
  `idnumber` int(11) NOT NULL,
  `fpa` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `ncustomers`
--

INSERT INTO `ncustomers` (`id`, `username`, `password`, `address`, `telnumber`, `afm`, `fullname`, `idnumber`, `fpa`) VALUES
(1, 'admin', 'admin', '1111', 1, 1, '1', 1, 1);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
