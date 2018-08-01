-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 01, 2018 at 05:54 PM
-- Server version: 10.1.16-MariaDB
-- PHP Version: 5.6.24

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `silviana`
--

-- --------------------------------------------------------

--
-- Table structure for table `barang`
--

CREATE TABLE `barang` (
  `idBarang` int(11) NOT NULL,
  `idJenis` int(11) NOT NULL,
  `namaBarang` varchar(50) NOT NULL,
  `stokBarang` int(11) NOT NULL,
  `idMerk` int(11) NOT NULL,
  `harga` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `barang`
--

INSERT INTO `barang` (`idBarang`, `idJenis`, `namaBarang`, `stokBarang`, `idMerk`, `harga`) VALUES
(1, 1, 'pop rouge', 19, 1, 0),
(2, 1, 'etude eyebrow pencil', 17, 2, 0),
(3, 2, 'stay matte 24', 20, 3, 0),
(4, 2, 'intense matte', 10, 2, 45000),
(5, 2, 'intense mattee', 30, 2, 45000),
(6, 2, 'laskmds', 20, 2, 78000);

-- --------------------------------------------------------

--
-- Table structure for table `detailtransaksi`
--

CREATE TABLE `detailtransaksi` (
  `idDetail` int(11) NOT NULL,
  `idTransaksi` int(11) NOT NULL,
  `idBarang` int(11) NOT NULL,
  `qty` int(11) NOT NULL,
  `diskon` double NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `detailtransaksi`
--

INSERT INTO `detailtransaksi` (`idDetail`, `idTransaksi`, `idBarang`, `qty`, `diskon`) VALUES
(1, 15, 2, 2, 0),
(2, 16, 2, 1, 0),
(3, 17, 2, -1, 0),
(4, 18, 2, 1, 0),
(5, 19, 2, 1, 0),
(6, 20, 2, 1, 0),
(7, 21, 2, 2, 0),
(8, 22, 2, 2, 0),
(9, 22, 1, 1, 0),
(10, 23, 1, 1, 0),
(11, 16, 2, 2, 0),
(12, 17, 2, 1, 0),
(13, 18, 2, 1, 0),
(14, 18, 1, 1, 0),
(15, 18, 1, 1, 0),
(16, 19, 1, 1, 0),
(17, 19, 2, 1, 0);

-- --------------------------------------------------------

--
-- Table structure for table `jenis`
--

CREATE TABLE `jenis` (
  `idJenis` int(11) NOT NULL,
  `namaJenis` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `jenis`
--

INSERT INTO `jenis` (`idJenis`, `namaJenis`) VALUES
(1, 'pensil alis'),
(2, 'lipstick'),
(3, 'maybelline');

-- --------------------------------------------------------

--
-- Table structure for table `member`
--

CREATE TABLE `member` (
  `idMember` int(11) NOT NULL,
  `nama` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `member`
--

INSERT INTO `member` (`idMember`, `nama`) VALUES
(1, 'lili'),
(2, 'lalala'),
(3, 'lalala'),
(4, 'lala'),
(5, 'lul'),
(6, 'la'),
(7, 'lq'),
(8, 'laa'),
(9, 'lala'),
(10, 'lala'),
(11, 'baba'),
(12, 'lalaa'),
(13, 'dkjkd'),
(14, 'kwef'),
(15, 'fjdks'),
(16, 'kkaka'),
(17, 'kwqjd'),
(18, 'jsd'),
(19, 'kdjf'),
(20, 'jk'),
(21, 'njkf'),
(22, 'jf'),
(23, 'jndsfk'),
(24, 'kdjnf'),
(25, 'nsjf'),
(26, 'aslak'),
(27, 'jn');

-- --------------------------------------------------------

--
-- Table structure for table `merk`
--

CREATE TABLE `merk` (
  `idMerk` int(11) NOT NULL,
  `namaMerk` varchar(50) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `merk`
--

INSERT INTO `merk` (`idMerk`, `namaMerk`) VALUES
(1, 'emina'),
(2, 'wardah'),
(3, 'maybelline');

-- --------------------------------------------------------

--
-- Table structure for table `status`
--

CREATE TABLE `status` (
  `idStatus` int(11) NOT NULL,
  `status` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int(11) NOT NULL,
  `idMember` int(11) NOT NULL,
  `tanggalBeli` date NOT NULL,
  `pegawai` varchar(16) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `idMember`, `tanggalBeli`, `pegawai`) VALUES
(1, 9, '2018-07-31', 'owner'),
(2, 10, '2018-07-31', 'kosong'),
(3, 11, '2018-07-31', 'kosong'),
(4, 12, '2018-07-31', 'kosong'),
(5, 13, '2018-07-31', 'owner'),
(6, 14, '2018-07-31', 'owner'),
(7, 15, '2018-07-31', 'owner'),
(8, 16, '2018-07-31', 'owner'),
(9, 17, '2018-07-31', 'owner'),
(10, 18, '2018-07-31', 'owner'),
(11, 19, '2018-07-31', 'owner'),
(12, 20, '2018-07-31', 'owner'),
(13, 21, '2018-07-31', 'owner'),
(14, 22, '2018-07-31', 'owner'),
(15, 23, '2018-07-31', 'owner'),
(16, 24, '2018-07-31', 'owner'),
(17, 25, '2018-07-31', 'owner'),
(18, 26, '2018-07-31', 'owner'),
(19, 27, '2018-07-31', 'owner');

-- --------------------------------------------------------

--
-- Table structure for table `user`
--

CREATE TABLE `user` (
  `nama` varchar(50) NOT NULL,
  `username` varchar(16) NOT NULL,
  `password` varchar(16) NOT NULL,
  `level` int(1) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `user`
--

INSERT INTO `user` (`nama`, `username`, `password`, `level`) VALUES
('admin', 'admin', 'admin', 2),
('adminn', 'admin1', 'admin1', 2),
('anita', 'admin2', 'admin2', 2),
('waw', 'admin3', 'admin3', 2),
('lalaa', 'admin4', 'admin4', 2),
('siliv', 'owner', 'owner', 1);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `barang`
--
ALTER TABLE `barang`
  ADD PRIMARY KEY (`idBarang`);

--
-- Indexes for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  ADD PRIMARY KEY (`idDetail`);

--
-- Indexes for table `jenis`
--
ALTER TABLE `jenis`
  ADD PRIMARY KEY (`idJenis`);

--
-- Indexes for table `member`
--
ALTER TABLE `member`
  ADD PRIMARY KEY (`idMember`);

--
-- Indexes for table `merk`
--
ALTER TABLE `merk`
  ADD PRIMARY KEY (`idMerk`);

--
-- Indexes for table `status`
--
ALTER TABLE `status`
  ADD PRIMARY KEY (`idStatus`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`);

--
-- Indexes for table `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`username`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `barang`
--
ALTER TABLE `barang`
  MODIFY `idBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  MODIFY `idDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT for table `jenis`
--
ALTER TABLE `jenis`
  MODIFY `idJenis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `idMember` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
--
-- AUTO_INCREMENT for table `merk`
--
ALTER TABLE `merk`
  MODIFY `idMerk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `idStatus` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
