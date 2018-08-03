-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 03, 2018 at 11:15 AM
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
(2, 1, 'etude eyebrow pencil', 14, 2, 0),
(3, 2, 'stay matte 24', 5, 3, 34000),
(4, 2, 'intense matte', 1, 2, 45000),
(5, 2, 'intense mattee', 29, 2, 45000),
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
(17, 19, 2, 1, 0),
(18, 20, 5, 1, 0),
(19, 21, 3, 12, 0),
(20, 0, 4, 2, 0.1),
(21, 0, 3, 2, 0),
(22, 22, 3, 1, 0),
(23, 23, 3, 1, 0.1),
(24, 24, 3, 1, 0),
(25, 25, 2, 2, 0),
(26, 26, 2, 1, 0),
(27, 26, 4, 2, 0),
(28, 0, 4, 1, 0),
(29, 27, 4, 2, 0);

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
-- Table structure for table `kurir`
--

CREATE TABLE `kurir` (
  `idKurir` int(11) NOT NULL,
  `nama` varchar(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `kurir`
--

INSERT INTO `kurir` (`idKurir`, `nama`) VALUES
(1, 'jne'),
(2, 'j&t');

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
(27, 'jn'),
(28, 'sutu'),
(29, 'erh'),
(30, 'kejr'),
(31, 'djfk'),
(32, 'jkfh'),
(33, 'kfdk'),
(34, 'kdjfkle'),
(35, 'fnjfgs'),
(36, 'gjwbr'),
(37, 'jgfk'),
(38, 'jfkw');

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
  `pegawai` varchar(16) NOT NULL,
  `kurir` int(11) NOT NULL,
  `invoice` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `idMember`, `tanggalBeli`, `pegawai`, `kurir`, `invoice`) VALUES
(1, 9, '2018-07-31', 'owner', 0, 0),
(2, 10, '2018-07-31', 'kosong', 0, 0),
(3, 11, '2018-07-31', 'kosong', 0, 0),
(4, 12, '2018-07-31', 'kosong', 0, 0),
(5, 13, '2018-07-31', 'owner', 0, 0),
(6, 14, '2018-07-31', 'owner', 0, 0),
(7, 15, '2018-07-31', 'owner', 0, 0),
(8, 16, '2018-07-31', 'owner', 0, 0),
(9, 17, '2018-07-31', 'owner', 0, 0),
(10, 18, '2018-07-31', 'owner', 0, 0),
(11, 19, '2018-07-31', 'owner', 0, 0),
(12, 20, '2018-07-31', 'owner', 0, 0),
(13, 21, '2018-07-31', 'owner', 0, 0),
(14, 22, '2018-07-31', 'owner', 0, 0),
(15, 23, '2018-07-31', 'owner', 0, 0),
(16, 24, '2018-07-31', 'owner', 0, 0),
(17, 25, '2018-07-31', 'owner', 0, 0),
(18, 26, '2018-07-31', 'owner', 0, 0),
(19, 27, '2018-07-31', 'owner', 0, 0),
(20, 28, '2018-08-02', 'owner', 0, 0),
(21, 29, '2018-08-02', 'owner', 0, 0),
(22, 32, '2018-08-02', 'owner', 2, 25000),
(23, 33, '2018-08-02', 'owner', 1, 10000),
(24, 34, '2018-08-02', 'owner', 2, 15000),
(25, 35, '2018-08-02', 'owner', 2, 50000),
(26, 36, '2018-08-02', 'owner', 1, 1000),
(27, 38, '2018-08-03', 'owner', 2, 930);

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
-- Indexes for table `kurir`
--
ALTER TABLE `kurir`
  ADD PRIMARY KEY (`idKurir`);

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
  MODIFY `idDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;
--
-- AUTO_INCREMENT for table `jenis`
--
ALTER TABLE `jenis`
  MODIFY `idJenis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=4;
--
-- AUTO_INCREMENT for table `kurir`
--
ALTER TABLE `kurir`
  MODIFY `idKurir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `idMember` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=39;
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
  MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=28;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
