-- phpMyAdmin SQL Dump
-- version 4.5.1
-- http://www.phpmyadmin.net
--
-- Host: 127.0.0.1
-- Generation Time: Aug 23, 2018 at 03:43 PM
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
(2, 1, 'etude eyebrow pencil', 5, 2, 10000),
(3, 2, 'stay matte 24', 39, 3, 34000),
(4, 2, 'intense matte', 4, 2, 45000),
(6, 2, 'laskmds', 20, 2, 78000),
(7, 1, 'dknfk', 10, 1, 20000),
(8, 7, 'hypergloss liner', 10, 8, 40000),
(9, 1, 'dmfkmf', 100, 4, 400000),
(10, 7, 'kekeke', 10, 1, 45000),
(11, 1, 'viva black eyebrow', 10, 1, 10000);

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
(22, 22, 3, 1, 0),
(23, 23, 3, 1, 0.1),
(24, 24, 3, 1, 0),
(25, 25, 2, 2, 0),
(26, 26, 2, 1, 0),
(27, 26, 4, 2, 0),
(29, 27, 4, 2, 0),
(30, 28, 5, 2, 0),
(31, 29, 2, 1, 0),
(32, 30, 3, 1, 0),
(34, 32, 3, 1, 0),
(35, 33, 5, 1, 0),
(36, 34, 5, 1, 0),
(37, 34, 3, 1, 0),
(38, 35, 3, 1, 0),
(39, 36, 3, 1, 0),
(40, 37, 2, 1, 0),
(41, 38, 2, 1, 0),
(42, 39, 2, 1, 0),
(43, 40, 2, 1, 0),
(44, 41, 2, 1, 0),
(45, 42, 2, 1, 0),
(46, 45, 4, 3, 0),
(47, 50, 4, 10, 0.1),
(48, 50, 2, 1, 0);

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
(3, 'maybelline'),
(4, 'bedakk'),
(6, 'highlitter'),
(7, 'eyeliner'),
(8, 'dkkdek'),
(9, 'eyeshadow'),
(10, 'moisturizer'),
(11, 'sheet mask'),
(12, 'lip scrub');

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
(2, 'j&t'),
(3, 'tiki'),
(4, 'wa'),
(5, 'lalaa'),
(6, 'dkkd');

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
(38, 'jfkw'),
(39, 'rkjj'),
(40, 'ggbj'),
(41, 'ncjjk'),
(42, 'jhf'),
(43, 'jfie'),
(44, 'djb'),
(45, 'ewfj'),
(46, 'ejkjk'),
(47, 'fnk'),
(48, ' wfd'),
(49, 'fjn348'),
(50, 'fwjf'),
(51, 'jfvn'),
(52, 'kwg'),
(53, 'fnjd'),
(54, 'dnj'),
(55, 'kdfw'),
(56, 'kd493'),
(57, 'kejrjrbdj'),
(58, 'jfgk'),
(59, 'heheh'),
(60, 'jfnkjr'),
(61, 'hihi'),
(62, 'huhuh'),
(63, 'hwhw'),
(64, 'hehehehe'),
(65, 'hqhqhq'),
(66, 'hwhwhwhwh'),
(67, 'fjjkwefhj'),
(68, 'hqhqhhq'),
(69, 'fvfffffff'),
(70, 'bfhbhf'),
(71, 'fkrjkg'),
(72, 'jffjr'),
(73, 'fjkf'),
(74, 'jkk'),
(75, 'fjjf'),
(76, 'hdjdn'),
(77, 'dndmfn'),
(78, 'ndnk');

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
(3, 'focallure'),
(4, 'abh'),
(5, 'jwrk'),
(6, 'beauty creations'),
(7, 'dkskd'),
(8, 'maybelline'),
(9, 'ndjkn'),
(10, 'nature republic'),
(11, 'viva');

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
  `invoice` varchar(25) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=latin1;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `idMember`, `tanggalBeli`, `pegawai`, `kurir`, `invoice`) VALUES
(29, 40, '2018-08-05', 'owner', 1, '7000'),
(30, 42, '2018-08-06', 'admin1', 2, '6000'),
(31, 43, '2018-08-06', 'admin4', 2, '64823'),
(36, 49, '2018-08-06', 'admin1', 1, '384'),
(38, 51, '2018-08-06', 'admin3', 1, '9334'),
(39, 52, '2018-08-06', 'owner', 1, '48932'),
(40, 53, '2018-08-06', 'admin1', 1, '9834'),
(41, 54, '2018-08-06', 'admin2', 1, '839'),
(42, 55, '2018-08-06', 'admin1', 1, '389'),
(43, 62, '2018-07-31', 'owner', 2, 'hggjhhjhjhhk'),
(44, 69, '2018-08-19', 'kosong', 1, 'ffsfsgf'),
(45, 70, '2018-08-19', 'kosong', 1, 'cdjsfjcds'),
(46, 73, '2018-08-23', 'owner', 1, 'frfk'),
(47, 74, '2018-08-23', 'owner', 1, 'hhjjh'),
(48, 75, '2018-08-23', 'owner', 1, 'jndjwn'),
(49, 76, '2018-08-23', 'owner', 1, 'jdnfd'),
(50, 77, '2018-08-23', 'owner', 1, 'dfn'),
(51, 78, '2018-08-23', 'owner', 1, 'dkwnf');

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
('soto', 'ayam', 'babat', 2),
('kekek', 'kekeke', 'ekkeke23', 2),
('alalala', 'lalalala', 'alalalala', 2),
('lalalal', 'lalalalalal', 'alallalala', 2),
('siliv', 'owner', 'owner', 1),
('Ayam', 'yam', 'ayam', 2);

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
  MODIFY `idBarang` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `detailtransaksi`
--
ALTER TABLE `detailtransaksi`
  MODIFY `idDetail` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=49;
--
-- AUTO_INCREMENT for table `jenis`
--
ALTER TABLE `jenis`
  MODIFY `idJenis` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=13;
--
-- AUTO_INCREMENT for table `kurir`
--
ALTER TABLE `kurir`
  MODIFY `idKurir` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=7;
--
-- AUTO_INCREMENT for table `member`
--
ALTER TABLE `member`
  MODIFY `idMember` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=79;
--
-- AUTO_INCREMENT for table `merk`
--
ALTER TABLE `merk`
  MODIFY `idMerk` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=12;
--
-- AUTO_INCREMENT for table `status`
--
ALTER TABLE `status`
  MODIFY `idStatus` int(11) NOT NULL AUTO_INCREMENT;
--
-- AUTO_INCREMENT for table `transaksi`
--
ALTER TABLE `transaksi`
  MODIFY `idTransaksi` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=52;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
