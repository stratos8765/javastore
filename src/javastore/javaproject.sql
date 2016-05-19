-- phpMyAdmin SQL Dump
-- version 4.5.0.2
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: May 19, 2016 at 08:44 PM
-- Server version: 10.0.17-MariaDB
-- PHP Version: 5.5.30

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `javaproject`
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
-- Table structure for table `cameraproducts`
--

CREATE TABLE `cameraproducts` (
  `name` varchar(100) NOT NULL,
  `details` varchar(500) NOT NULL,
  `code` int(11) NOT NULL,
  `price` float NOT NULL,
  `str` varchar(100) NOT NULL,
  `megapixels` int(11) NOT NULL,
  `iso` int(11) NOT NULL,
  `exposure` int(11) NOT NULL,
  `fps` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `cameraproducts`
--

INSERT INTO `cameraproducts` (`name`, `details`, `code`, `price`, `str`, `megapixels`, `iso`, `exposure`, `fps`) VALUES
('testcamera', 'testdetails', 1234555, 12.3, 'test', 12, 10, 2, 40),
('a', 'b', 1234, 12.3, 'test', 1, 1, 1, 1),
('b', 'b', 1234, 12.3, 'test', 1, 1, 1, 1),
('a', 'b', 1234, 12.3, 'test', 1, 1, 1, 1);

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
-- Table structure for table `computerproducts`
--

CREATE TABLE `computerproducts` (
  `name` varchar(100) NOT NULL,
  `details` varchar(500) NOT NULL,
  `code` int(11) NOT NULL,
  `price` float NOT NULL,
  `str` varchar(100) NOT NULL,
  `processor` varchar(100) NOT NULL,
  `ram` varchar(100) NOT NULL,
  `graphicscard` varchar(100) NOT NULL,
  `monitor` varchar(100) NOT NULL,
  `os` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `computerproducts`
--

INSERT INTO `computerproducts` (`name`, `details`, `code`, `price`, `str`, `processor`, `ram`, `graphicscard`, `monitor`, `os`) VALUES
('a', 'a', 1222, 25.2, '', 'rar', '2', '2', '2', '2'),
('b', 'a', 1223, 25.2, '', 'rar', '2', '2', '2', '2'),
('c', 'a', 1222, 25.2, '', 'rar', '2', '2', '2', '2');

-- --------------------------------------------------------

--
-- Table structure for table `laptopproducts`
--

CREATE TABLE `laptopproducts` (
  `name` varchar(100) NOT NULL,
  `details` varchar(500) NOT NULL,
  `code` int(11) NOT NULL,
  `price` float NOT NULL,
  `str` varchar(100) NOT NULL,
  `processor` varchar(100) NOT NULL,
  `ram` varchar(100) NOT NULL,
  `graphicscard` varchar(100) NOT NULL,
  `cdrom` varchar(100) NOT NULL,
  `ssd` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `laptopproducts`
--

INSERT INTO `laptopproducts` (`name`, `details`, `code`, `price`, `str`, `processor`, `ram`, `graphicscard`, `cdrom`, `ssd`) VALUES
('a', 'b', 123333, 23.2, 'sss', 'test', 'test', 'test', 'cdrom', 'ssd'),
('b', 'b', 124433, 23.2, 'sss', 'test', 'test', 'test', 'cdrom', 'ssd');

-- --------------------------------------------------------

--
-- Table structure for table `mobileproducts`
--

CREATE TABLE `mobileproducts` (
  `name` varchar(100) NOT NULL,
  `details` varchar(500) NOT NULL,
  `code` int(11) NOT NULL,
  `price` float NOT NULL,
  `str` varchar(100) NOT NULL,
  `os` varchar(100) NOT NULL,
  `monitor` varchar(100) NOT NULL,
  `processor` varchar(100) NOT NULL,
  `camera` varchar(100) NOT NULL,
  `wifi` varchar(100) NOT NULL,
  `colour` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `mobileproducts`
--

INSERT INTO `mobileproducts` (`name`, `details`, `code`, `price`, `str`, `os`, `monitor`, `processor`, `camera`, `wifi`, `colour`) VALUES
('a', 'b', 22222, 32.1, '2', 'os', 'monitor', 'pros', 'camera', 'wifi', 'colour'),
('c', 'b', 22222, 32.1, '2', 'os', 'monitor', 'pros', 'camera', 'wifi', 'colour'),
('b', 'b', 22222, 32.1, '2', 'os', 'monitor', 'pros', 'camera', 'wifi', 'colour'),
('ztest', 'b', 22222, 32.1, '2', 'os', 'monitor', 'pros', 'camera', 'wifi', 'colour');

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

-- --------------------------------------------------------

--
-- Table structure for table `printerproducts`
--

CREATE TABLE `printerproducts` (
  `name` varchar(100) NOT NULL,
  `details` varchar(500) NOT NULL,
  `code` int(11) NOT NULL,
  `price` float NOT NULL,
  `str` varchar(100) NOT NULL,
  `type` varchar(100) NOT NULL,
  `papertype` varchar(100) NOT NULL,
  `use` varchar(100) NOT NULL,
  `connection` varchar(100) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `printerproducts`
--

INSERT INTO `printerproducts` (`name`, `details`, `code`, `price`, `str`, `type`, `papertype`, `use`, `connection`) VALUES
('a', 'b', 1233333, 233.2, '2', '1', 'A3', 'Everyday', 'USB'),
('v', 'b', 1233333, 2222, '2', '1', 'A3', 'Everyday', 'USB'),
('v', 'v', 112222, 21.22, 'tt', 'Laser', '2q', 'Everyday', 'connection'),
('d', 'v', 112222, 21.22, 'tt', 'Laser', '2q', 'Everyday', 'connection');

-- --------------------------------------------------------

--
-- Table structure for table `tvproducts`
--

CREATE TABLE `tvproducts` (
  `name` varchar(100) NOT NULL,
  `details` varchar(500) NOT NULL,
  `code` int(11) NOT NULL,
  `price` float NOT NULL,
  `str` int(11) NOT NULL,
  `hd` int(11) NOT NULL,
  `inches` float NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `tvproducts`
--

INSERT INTO `tvproducts` (`name`, `details`, `code`, `price`, `str`, `hd`, `inches`) VALUES
('a', 'd', 2222, 21.2, 0, 0, 2),
('done', 'd', 2222, 21.2, 0, 0, 2),
('b', 'd', 2222, 21.2, 0, 0, 2),
('c', 'd', 2222, 21.2, 0, 0, 2),
('e', 'd', 2222, 21.2, 0, 0, 2);

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
