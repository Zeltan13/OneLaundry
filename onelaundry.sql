-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1:3307
-- Generation Time: Dec 29, 2023 at 06:31 AM
-- Server version: 10.4.27-MariaDB
-- PHP Version: 8.1.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `onelaundry`
--

-- --------------------------------------------------------

--
-- Table structure for table `admin`
--

CREATE TABLE `admin` (
  `idAdmin` int(11) NOT NULL,
  `username` varchar(50) DEFAULT NULL,
  `password` varchar(50) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `admin`
--

INSERT INTO `admin` (`idAdmin`, `username`, `password`) VALUES
(1, 'admin', 'password'),
(2, 'Messi', 'theGOAT'),
(3, 'kylian123', 'mbappe'),
(4, 'kemal', 'pwd'),
(5, 'aldianskuy', 'password'),
(6, 'steph', 'curry');

-- --------------------------------------------------------

--
-- Table structure for table `customer`
--

CREATE TABLE `customer` (
  `idCustomer` int(11) NOT NULL,
  `idPerson` int(11) DEFAULT NULL,
  `idAdmin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `customer`
--

INSERT INTO `customer` (`idCustomer`, `idPerson`, `idAdmin`) VALUES
(1, 3, 1),
(2, 4, 2),
(3, 5, 1),
(4, 25, 1),
(5, 27, 4),
(6, 28, 4),
(7, 29, 2),
(8, 32, 1);

-- --------------------------------------------------------

--
-- Table structure for table `item`
--

CREATE TABLE `item` (
  `idItem` int(11) NOT NULL,
  `item` varchar(128) DEFAULT NULL,
  `hargaPerKg` varchar(128) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `item`
--

INSERT INTO `item` (`idItem`, `item`, `hargaPerKg`) VALUES
(1, 'Selimut', '10000'),
(2, 'Baju', '5000'),
(3, 'Pakaian', '6000');

-- --------------------------------------------------------

--
-- Table structure for table `person`
--

CREATE TABLE `person` (
  `idPerson` int(11) NOT NULL,
  `nama` varchar(50) DEFAULT NULL,
  `alamat` varchar(50) DEFAULT NULL,
  `noTelp` varchar(50) DEFAULT NULL,
  `jenisKelamin` varchar(50) DEFAULT NULL,
  `idAdmin` int(11) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `person`
--

INSERT INTO `person` (`idPerson`, `nama`, `alamat`, `noTelp`, `jenisKelamin`, `idAdmin`) VALUES
(1, 'Fathan Askar', 'Jl. Sukabirus No.C55', '0812 9199 4175', 'Male', 1),
(2, 'Alexia Putellas', 'Camp Nou', '1234 5678 9101', 'Female', 2),
(3, 'Lionel Messi', 'Rosario Street', '8923 8888 7310', 'Male', NULL),
(4, 'Saeparudin Saleh', 'Jl Telekomunikasi No 8', '0812 5555 1234', 'Male', NULL),
(5, 'Jane Smith', '135 Carrer de la Maternitat', '555 5678', 'Female', NULL),
(6, 'Robert Johnson', '78 Avinguda de Joan XXIII', '555 9012', 'Male', NULL),
(7, 'Fatmawati Dermanwan', 'Jl Sukbirus No 89d', '0822 1213 3456', 'Female', NULL),
(8, 'Muhammad Irfan', 'Jl Sukapura No 34a', '0872 3218 7890', 'Male', NULL),
(9, 'Wendy Agung', 'Jl Sukabirus No 22e', '0800 8140 395', 'Female', NULL),
(10, 'David Wilson', '210 Carrer de l\'Arizala', '555-6789', 'Male', NULL),
(11, 'Olivia Taylor', '44 Carrer de Martí i Franquès', '555-0123', 'Female', NULL),
(12, 'Anisa Putri', 'Ciganitri No 85c', '0821 1032 9847', 'Male', NULL),
(13, 'Ava Anderson', '91 Carrer de Numància', '555-8901', 'Female', NULL),
(14, 'Rizky Pratama', 'Ciganitri 123b', '0888 7532 8951', 'Male', NULL),
(15, 'Mia Hall', '178 Avinguda Diagonal', '555-6789', 'Female', NULL),
(16, 'Dika Ramadhan', 'Jl Sukabirus No 83', '0832 1325 8076', 'Male', NULL),
(17, 'Isabella Ward', '55 Carrer de la Travessera de Les Corts', '555-4567', 'Female', NULL),
(18, 'James Turner', '23 Carrer de Taquígraf Serra', '555-8901', 'Male', NULL),
(19, 'Agus Susanto', 'Jl Sukapura No 74', '0812 3012 9857', 'Female', NULL),
(20, 'Benjamin Cole', 'Jl Sukapura No 11', '0812 4983 7265', 'Male', NULL),
(21, 'Emma King', 'Jl Sukapura No 54', '0891 8491 7256', 'Female', NULL),
(22, 'Nia Permata Sari', 'Jalan Sukabirus No 32', '0812 1221 2180', 'Male', NULL),
(23, 'Amelia Wright', '106 Carrer de la Granada del Penedès', '555-8901', 'Female', NULL),
(24, 'Kylian', 'Mbappe', '12345678', 'Laki-Laki', 3),
(25, 'Roronoa Zoro', 'Lost Somewhere', '5555 1234', 'Laki-Laki', NULL),
(26, 's', 's', 's', 'Laki-Laki', 4),
(27, 'Fathan', 'Bogor', '80321812375', 'Laki-Laki', NULL),
(28, 'riza', 'bandung', '30298157', 'Laki-Laki', NULL),
(29, 'Cristiano Ronaldo', '123 Main street', '4444-1234', 'Laki-Laki', NULL),
(30, 'Aldian', 'Sukabirus', '081298765432', 'Laki-Laki', 5),
(31, 'Steph Curry', 'Usa', '5555-1234', 'Laki-Laki', 6),
(32, 'Dhafindra ', 'Pasir Jaya', '0821215353', 'Laki-Laki', NULL);

-- --------------------------------------------------------

--
-- Table structure for table `transaksi`
--

CREATE TABLE `transaksi` (
  `idTransaksi` int(11) NOT NULL,
  `noTransaksi` varchar(128) DEFAULT NULL,
  `layanan` varchar(128) DEFAULT NULL,
  `status` varchar(128) DEFAULT NULL,
  `total` double DEFAULT NULL,
  `idCustomer` int(11) DEFAULT NULL,
  `idItem` int(11) DEFAULT NULL,
  `idAdmin` int(11) DEFAULT NULL,
  `berat` varchar(20) DEFAULT NULL,
  `tgl` date DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `transaksi`
--

INSERT INTO `transaksi` (`idTransaksi`, `noTransaksi`, `layanan`, `status`, `total`, `idCustomer`, `idItem`, `idAdmin`, `berat`, `tgl`) VALUES
(1, 'T1', 'Laundry', 'Selesai', 30000, 1, 1, 1, '3.0 Kg', '2023-05-30'),
(2, 'T2', 'Laundry', 'Belum Selesai', 10000, 2, 2, 2, '2.0 Kg', '2023-11-02'),
(4, 'T4', 'Laundry', 'Selesai', 500000, 7, 1, 2, '50.0 Kg', '2023-05-29'),
(6, 'T6', 'Laundry', 'Selesai', 100000, 3, 1, 1, '10.0 Kg', '2020-06-09'),
(7, 'T7', 'Laundry', 'Selesai', 20000, 1, 1, 1, '2.0 Kg', '2023-05-17'),
(13, 'T13', 'Laundry', 'Selesai', 25000, 8, 2, 1, '5.0 Kg', '2023-12-28');

--
-- Indexes for dumped tables
--

--
-- Indexes for table `admin`
--
ALTER TABLE `admin`
  ADD PRIMARY KEY (`idAdmin`);

--
-- Indexes for table `customer`
--
ALTER TABLE `customer`
  ADD PRIMARY KEY (`idCustomer`),
  ADD KEY `idPerson` (`idPerson`),
  ADD KEY `fk_idAdmin` (`idAdmin`);

--
-- Indexes for table `item`
--
ALTER TABLE `item`
  ADD PRIMARY KEY (`idItem`);

--
-- Indexes for table `person`
--
ALTER TABLE `person`
  ADD PRIMARY KEY (`idPerson`),
  ADD KEY `fk_idAdminPerson` (`idAdmin`);

--
-- Indexes for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD PRIMARY KEY (`idTransaksi`),
  ADD KEY `fk_idCustomer` (`idCustomer`),
  ADD KEY `fk_idItem` (`idItem`),
  ADD KEY `fk_idAdmin` (`idAdmin`);

--
-- Constraints for dumped tables
--

--
-- Constraints for table `customer`
--
ALTER TABLE `customer`
  ADD CONSTRAINT `fk_idAdmin` FOREIGN KEY (`idAdmin`) REFERENCES `admin` (`idAdmin`);

--
-- Constraints for table `person`
--
ALTER TABLE `person`
  ADD CONSTRAINT `fk_idAdminPerson` FOREIGN KEY (`idAdmin`) REFERENCES `admin` (`idAdmin`);

--
-- Constraints for table `transaksi`
--
ALTER TABLE `transaksi`
  ADD CONSTRAINT `fk_idItem` FOREIGN KEY (`idItem`) REFERENCES `item` (`idItem`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
