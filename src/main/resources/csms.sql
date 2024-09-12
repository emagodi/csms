-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Host: 127.0.0.1
-- Generation Time: Jun 05, 2024 at 07:34 AM
-- Server version: 10.4.32-MariaDB
-- PHP Version: 8.2.12

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Database: `csms`
--

-- --------------------------------------------------------

--
-- Table structure for table `application`
--

CREATE TABLE `application` (
                               `id` bigint(20) NOT NULL,
                               `created_at` datetime(6) DEFAULT NULL,
                               `created_by` varchar(255) DEFAULT NULL,
                               `updated_at` datetime(6) DEFAULT NULL,
                               `updated_by` varchar(255) DEFAULT NULL,
                               `address` varchar(255) DEFAULT NULL,
                               `district` enum('EAST_DISTRICT','GWERU_DISTRICT','KWEKWE_DISTRICT','NORTH_DISTRICT','NO_DISTRICT') DEFAULT NULL,
                               `email` varchar(255) DEFAULT NULL,
                               `firstname` varchar(255) DEFAULT NULL,
                               `identification_type` enum('DRIVER_LICENCE','NATIONAL_ID','VALID_PASSPORT') DEFAULT NULL,
                               `job_type` enum('FAULT','NEW_CONNECTION','PROJECT') DEFAULT NULL,
                               `lasttname` varchar(255) DEFAULT NULL,
                               `msg` varchar(255) DEFAULT NULL,
                               `national_id` varchar(255) DEFAULT NULL,
                               `phone_number` varchar(255) DEFAULT NULL,
                               `reference_no` varchar(255) DEFAULT NULL,
                               `reference_type` enum('ACCOUNT_NUMBER','FAULT_NUMBER','OTHER','PROJECT_NUMBER') DEFAULT NULL,
                               `region` enum('EASTERN_REGION','HARARE_REGION','HEAD_OFFICE','NCC','NORTHERN_REGION','NO_REGION','SOUTHERN_REGION','WESTERN_REGION') DEFAULT NULL,
                               `status` enum('DISTRICT_APPROVED','GM_APPROVED','INSPECTION_ACCEPTED','INSPECTION_REJECTED','ITEM_ACCEPTED','ITEM_REJECTED','MD_APPROVED','NOT_APPLIED','PENDING','RECEIVED','REJECTED') DEFAULT NULL,
                               `title` enum('DR','MISS','MR','MRS','MS','PROF') DEFAULT NULL,
                               `total_price` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application`
--

INSERT INTO `application` (`id`, `created_at`, `created_by`, `updated_at`, `updated_by`, `address`, `district`, `email`, `firstname`, `identification_type`, `job_type`, `lasttname`, `msg`, `national_id`, `phone_number`, `reference_no`, `reference_type`, `region`, `status`, `title`, `total_price`) VALUES
                                                                                                                                                                                                                                                                                                              (1, '2024-04-15 10:34:58.000000', 'kudakotie@gmail.com', '2024-05-23 15:49:19.000000', 'kotilasco@gmail.com', 'Amet ratione irure ', 'EAST_DISTRICT', 'vytuqepaq@mailinator.com', 'Iola', 'NATIONAL_ID', 'NEW_CONNECTION', 'Vaughn', NULL, '360', '+1 (959) 675-7825', '425', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'NOT_APPLIED', 'MR', 90),
                                                                                                                                                                                                                                                                                                              (2, '2024-04-15 11:09:43.000000', 'kudakotie@gmail.com', '2024-04-15 11:09:43.000000', 'kudakotie@gmail.com', 'Beatae quia nostrum ', 'EAST_DISTRICT', 'lacele@mailinator.com', 'Carol', 'NATIONAL_ID', 'NEW_CONNECTION', 'Johnson', '', '910', '+1 (825) 997-2493', '3322422', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'NOT_APPLIED', 'MR', 3186),
                                                                                                                                                                                                                                                                                                              (3, '2024-04-16 08:43:42.000000', 'kudakotie@gmail.com', '2024-04-20 11:23:00.000000', 'zawala@gmail.com', 'Maxime ea ipsa a au', 'EAST_DISTRICT', 'milemosog@mailinator.com', 'Martha', 'NATIONAL_ID', 'NEW_CONNECTION', 'Norman', 'Some of the items do not meet the standards we need', '157', '+1 (522) 262-2728', '2334', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'NOT_APPLIED', 'MR', 5580),
                                                                                                                                                                                                                                                                                                              (4, '2024-04-16 10:29:11.000000', 'kudakotie@gmail.com', '2024-04-29 15:37:08.000000', 'zawala@gmail.com', 'Animi enim qui simi', 'EAST_DISTRICT', 'joxezylybu@mailinator.com', 'Hayden', 'NATIONAL_ID', 'NEW_CONNECTION', 'Melton', 'the item does not meet our standards', '485', '+1 (243) 832-6293', '1223', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'NOT_APPLIED', 'MR', 885),
                                                                                                                                                                                                                                                                                                              (5, '2024-04-16 10:34:18.000000', 'kudakotie@gmail.com', '2024-04-29 15:04:03.000000', 'zvi@gmail.com', 'Deserunt elit fugia', 'EAST_DISTRICT', 'vipemywec@mailinator.com', 'Marsden', 'NATIONAL_ID', 'NEW_CONNECTION', 'Rosales', NULL, '161', '+1 (836) 568-9006', '2373', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'NOT_APPLIED', 'MR', 1245),
                                                                                                                                                                                                                                                                                                              (6, '2024-04-16 10:43:48.000000', 'kudakotie@gmail.com', '2024-04-29 15:07:46.000000', 'zvi@gmail.com', 'Commodi sit consecte', 'EAST_DISTRICT', 'lakymawe@mailinator.com', 'Eve', 'NATIONAL_ID', 'NEW_CONNECTION', 'Davidson', 'This is too much', '838', '+1 (531) 235-9767', '42534', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'REJECTED', 'MR', 9042),
                                                                                                                                                                                                                                                                                                              (7, '2024-04-16 10:45:02.000000', 'kudakotie@gmail.com', '2024-05-24 13:06:24.000000', 'zawala@gmail.com', 'Commodo nulla repreh', 'EAST_DISTRICT', 'hyrucoz@mailinator.com', 'Shea', 'NATIONAL_ID', 'NEW_CONNECTION', 'Hale', NULL, '952', '+1 (216) 515-8789', '', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'INSPECTION_ACCEPTED', 'MR', 4071),
                                                                                                                                                                                                                                                                                                              (8, '2024-04-16 10:48:14.000000', 'kudakotie@gmail.com', '2024-04-30 12:04:58.000000', 'taps@gmail.com', 'Sunt ipsum volupta', 'EAST_DISTRICT', 'bazime@mailinator.com', 'Rana', 'NATIONAL_ID', 'NEW_CONNECTION', 'Sharp', 'Test rejection', '868', '+1 (711) 249-5194', '00998', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'REJECTED', 'MR', 1000),
                                                                                                                                                                                                                                                                                                              (9, '2024-04-25 09:47:41.000000', 'kotilasco@gmail.com', '2024-04-29 15:47:35.000000', 'zawala@gmail.com', 'Mollit placeat non ', 'EAST_DISTRICT', 'kirukyb@mailinator.com', 'Kennan', 'NATIONAL_ID', 'NEW_CONNECTION', 'Townsend', 'I have provided the reason why i rejected each item', '308', '+1 (573) 453-6814', '425', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'INSPECTION_REJECTED', 'MR', 999),
                                                                                                                                                                                                                                                                                                              (10, '2024-04-25 09:49:48.000000', 'kotilasco@gmail.com', '2024-05-24 13:23:21.000000', 'zawala@gmail.com', 'Possimus eaque ulla', 'EAST_DISTRICT', 'nurasu@mailinator.com', 'Hop', 'NATIONAL_ID', 'NEW_CONNECTION', 'Cantrell', 'ndnmmdsnds dsnmdsn', '656', '+1 (884) 721-9681', '425222', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'INSPECTION_REJECTED', 'MR', 2619),
                                                                                                                                                                                                                                                                                                              (11, '2024-04-25 09:51:34.000000', 'kotilasco@gmail.com', '2024-04-25 09:51:34.000000', 'kotilasco@gmail.com', 'Non illum sit atque', 'EAST_DISTRICT', 'kahededix@mailinator.com', 'Henry', 'NATIONAL_ID', 'NEW_CONNECTION', 'Carlson', '', '367', '+1 (279) 837-6344', '425900', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'RECEIVED', 'MR', 3097),
                                                                                                                                                                                                                                                                                                              (12, '2024-04-25 09:52:26.000000', 'kotilasco@gmail.com', '2024-04-30 12:01:15.000000', 'zvi@gmail.com', 'Nihil minim officia ', 'EAST_DISTRICT', 'wideqy@mailinator.com', 'Brianna', 'NATIONAL_ID', 'NEW_CONNECTION', 'Leonard', 'Testing rejection ', '724', '+1 (752) 771-8016', '89009', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'RECEIVED', 'MR', 11150),
                                                                                                                                                                                                                                                                                                              (13, '2024-04-25 09:53:11.000000', 'kotilasco@gmail.com', '2024-04-25 09:57:14.000000', 'porcupine@gmail.com', 'Consectetur molliti', 'EAST_DISTRICT', 'foky@mailinator.com', 'Castor', 'NATIONAL_ID', 'NEW_CONNECTION', 'Roy', 'We already have the items in the store', '143', '+1 (585) 698-7545', '0098', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'REJECTED', 'MR', 41),
                                                                                                                                                                                                                                                                                                              (14, '2024-04-25 09:53:48.000000', 'kotilasco@gmail.com', '2024-04-30 12:18:04.000000', 'zawala@gmail.com', 'Fugiat molestiae rec', 'EAST_DISTRICT', 'luce@mailinator.com', 'Ray', 'NATIONAL_ID', 'NEW_CONNECTION', 'Fox', 'The material is not good enough', '100', '+1 (299) 573-7248', '', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'INSPECTION_REJECTED', 'MR', 2323),
                                                                                                                                                                                                                                                                                                              (15, '2024-04-29 09:03:43.000000', 'kotilasco@gmail.com', '2024-04-30 12:13:11.000000', 'zawala@gmail.com', 'Esse laborum porro ', 'EAST_DISTRICT', 'xoso@mailinator.com', 'Natalie', 'NATIONAL_ID', 'NEW_CONNECTION', 'Knowles', 'The material is not good', '883', '+1 (618) 152-4432', 'jkkj', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'INSPECTION_REJECTED', 'MR', 3186),
                                                                                                                                                                                                                                                                                                              (16, '2024-04-29 09:10:44.000000', 'kotilasco@gmail.com', '2024-05-23 16:06:06.000000', 'zawala@gmail.com', 'Esse laborum porro ', 'EAST_DISTRICT', 'xoso@mailinator.com', 'Natalie', 'NATIONAL_ID', 'NEW_CONNECTION', 'Knowles', 'ijoo jkklklk kkjjjjjjlk', '883', '+1 (618) 152-4432', 'jkkj', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'INSPECTION_REJECTED', 'MR', 3186),
                                                                                                                                                                                                                                                                                                              (17, '2024-04-29 09:14:05.000000', 'kotilasco@gmail.com', '2024-04-30 11:33:53.000000', 'porcupine@gmail.com', 'Repudiandae iure qui', 'EAST_DISTRICT', 'ganije@mailinator.com', 'Nash', 'NATIONAL_ID', 'NEW_CONNECTION', 'Rivers', NULL, '761', '+1 (272) 138-8456', '899987', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'DISTRICT_APPROVED', 'MR', 885),
                                                                                                                                                                                                                                                                                                              (18, '2024-04-29 09:15:33.000000', 'kotilasco@gmail.com', '2024-04-29 09:59:28.000000', 'porcupine@gmail.com', 'Repudiandae iure qui', 'EAST_DISTRICT', 'ganije@mailinator.com', 'Nash', 'NATIONAL_ID', 'NEW_CONNECTION', 'Rivers', 'We have the items in store', '761', '+1 (272) 138-8456', '899987', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'REJECTED', 'MR', 885),
                                                                                                                                                                                                                                                                                                              (19, '2024-04-29 09:16:45.000000', 'kotilasco@gmail.com', '2024-04-29 15:29:26.000000', 'zawala@gmail.com', 'Repudiandae iure qui', 'EAST_DISTRICT', 'ganije@mailinator.com', 'Nash', 'NATIONAL_ID', 'NEW_CONNECTION', 'Rivers', NULL, '761', '+1 (272) 138-8456', '899987', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'INSPECTION_ACCEPTED', 'MR', 885),
                                                                                                                                                                                                                                                                                                              (20, '2024-04-29 09:20:13.000000', 'kotilasco@gmail.com', '2024-04-29 15:10:13.000000', 'zvi@gmail.com', 'Voluptatem distincti', 'EAST_DISTRICT', 'vihogid@mailinator.com', 'Debra', 'NATIONAL_ID', 'NEW_CONNECTION', 'Dillard', NULL, '884', '+1 (919) 815-6486', 'wesd', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'MD_APPROVED', 'MR', 6814),
                                                                                                                                                                                                                                                                                                              (21, '2024-04-29 09:21:14.000000', 'kotilasco@gmail.com', '2024-04-29 10:10:49.000000', 'taps@gmail.com', 'Voluptatem distincti', 'EAST_DISTRICT', 'vihogid@mailinator.com', 'Debra', 'NATIONAL_ID', 'NEW_CONNECTION', 'Dillard', NULL, '884', '+1 (919) 815-6486', 'wesd', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'GM_APPROVED', 'MR', 1239),
                                                                                                                                                                                                                                                                                                              (22, '2024-04-29 09:23:49.000000', 'kotilasco@gmail.com', '2024-04-29 10:12:47.000000', 'taps@gmail.com', 'Voluptatem distincti', 'EAST_DISTRICT', 'vihogid@mailinator.com', 'Debra', 'NATIONAL_ID', 'NEW_CONNECTION', 'Dillard', 'not a reasonable application', '884', '+1 (919) 815-6486', 'wesd', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'REJECTED', 'MR', 1239),
                                                                                                                                                                                                                                                                                                              (23, '2024-04-29 09:28:28.000000', 'kotilasco@gmail.com', '2024-04-29 09:53:46.000000', 'porcupine@gmail.com', 'Voluptatem distincti', 'EAST_DISTRICT', 'vihogid@mailinator.com', 'Debra', 'NATIONAL_ID', 'NEW_CONNECTION', 'Dillard', NULL, '884', '+1 (919) 815-6486', 'wesd', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'DISTRICT_APPROVED', 'MR', 17),
                                                                                                                                                                                                                                                                                                              (24, '2024-04-29 09:31:22.000000', 'kotilasco@gmail.com', '2024-04-29 09:51:06.000000', 'porcupine@gmail.com', 'Voluptatem distincti', 'EAST_DISTRICT', 'vihogid@mailinator.com', 'Debra', 'NATIONAL_ID', 'NEW_CONNECTION', 'Dillard', NULL, '884', '+1 (919) 815-6486', 'wesd', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'DISTRICT_APPROVED', 'MR', 17),
                                                                                                                                                                                                                                                                                                              (25, '2024-04-29 09:44:45.000000', 'kotilasco@gmail.com', '2024-04-30 12:12:26.000000', 'zawala@gmail.com', 'Et nobis consequatur', 'EAST_DISTRICT', 'kotymoh@mailinator.com', 'Irma', 'NATIONAL_ID', 'NEW_CONNECTION', 'Sawyer', NULL, '566', '+1 (538) 815-2366', 'sdcc', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'INSPECTION_ACCEPTED', 'MR', 1327),
                                                                                                                                                                                                                                                                                                              (26, '2024-04-30 10:02:11.000000', 'kotilasco@gmail.com', '2024-04-30 11:22:24.000000', 'porcupine@gmail.com', 'Illum elit adipisi', 'EAST_DISTRICT', 'cute@mailinator.com', 'Stephanie', 'NATIONAL_ID', 'NEW_CONNECTION', 'Floyd', NULL, '892', '+1 (351) 577-2665', '425kkk', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'DISTRICT_APPROVED', 'MR', 0),
                                                                                                                                                                                                                                                                                                              (27, '2024-05-06 09:52:47.000000', 'kotilasco@gmail.com', '2024-05-06 09:52:47.000000', 'kotilasco@gmail.com', 'Laborum Animi sint', 'EAST_DISTRICT', 'jadihuba@mailinator.com', 'Gary', 'NATIONAL_ID', 'NEW_CONNECTION', 'Horne', '', '444', '+1 (191) 978-6959', '425kklll', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'PENDING', 'MR', 885),
                                                                                                                                                                                                                                                                                                              (28, '2024-05-06 09:56:44.000000', 'kotilasco@gmail.com', '2024-05-06 09:56:44.000000', 'kotilasco@gmail.com', 'Non nobis reiciendis', 'EAST_DISTRICT', 'buvejytil@mailinator.com', 'Marcia', 'NATIONAL_ID', 'NEW_CONNECTION', 'Dalton', '', '493', '+1 (341) 141-1468', '425', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'PENDING', 'MR', 2212),
                                                                                                                                                                                                                                                                                                              (29, '2024-05-06 09:59:57.000000', 'kotilasco@gmail.com', '2024-05-06 09:59:57.000000', 'kotilasco@gmail.com', 'Officiis aspernatur ', 'EAST_DISTRICT', 'beciqe@mailinator.com', 'Carol', 'NATIONAL_ID', 'NEW_CONNECTION', 'Webster', '', '385', '+1 (646) 935-3269', '425', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'PENDING', 'MR', 38940),
                                                                                                                                                                                                                                                                                                              (30, '2024-05-06 10:04:42.000000', 'kotilasco@gmail.com', '2024-05-22 12:18:32.000000', 'kotilasco@gmail.com', 'Consectetur quam et', 'EAST_DISTRICT', 'vinezydob@mailinator.com', 'Kaseem', 'NATIONAL_ID', 'NEW_CONNECTION', 'Rodriquez', NULL, '269', '+1 (408) 357-6049', 'uuyu', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'PENDING', 'MR', 2655),
                                                                                                                                                                                                                                                                                                              (31, '2024-05-06 10:12:32.000000', 'kotilasco@gmail.com', '2024-05-23 15:58:37.000000', 'porcupine@gmail.com', 'Vel consequatur Asp', 'EAST_DISTRICT', 'komefyh@mailinator.com', 'Vladimir', 'NATIONAL_ID', 'NEW_CONNECTION', 'Oneil', 'we already have the items', '705', '+1 (953) 206-5283', 'o0090', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'REJECTED', 'MR', 885),
                                                                                                                                                                                                                                                                                                              (32, '2024-05-06 10:16:19.000000', 'kotilasco@gmail.com', '2024-05-23 15:57:22.000000', 'porcupine@gmail.com', 'Pariatur Dolore off', 'EAST_DISTRICT', 'xuleziha@mailinator.com', 'Zeus', 'NATIONAL_ID', 'NEW_CONNECTION', 'Blackwell', NULL, '87', '+1 (318) 151-1761', '344567', 'ACCOUNT_NUMBER', 'EASTERN_REGION', 'DISTRICT_APPROVED', 'MR', 0);

-- --------------------------------------------------------

--
-- Table structure for table `application_application_line_items_list`
--

CREATE TABLE `application_application_line_items_list` (
                                                           `application_id` bigint(20) NOT NULL,
                                                           `application_line_items_list_id` bigint(20) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application_application_line_items_list`
--

INSERT INTO `application_application_line_items_list` (`application_id`, `application_line_items_list_id`) VALUES
                                                                                                               (1, 1),
                                                                                                               (1, 2),
                                                                                                               (2, 3),
                                                                                                               (2, 4),
                                                                                                               (3, 5),
                                                                                                               (3, 6),
                                                                                                               (3, 7),
                                                                                                               (4, 8),
                                                                                                               (5, 9),
                                                                                                               (5, 10),
                                                                                                               (5, 11),
                                                                                                               (6, 12),
                                                                                                               (6, 13),
                                                                                                               (7, 14),
                                                                                                               (7, 15),
                                                                                                               (8, 16),
                                                                                                               (9, 17),
                                                                                                               (10, 18),
                                                                                                               (10, 19),
                                                                                                               (10, 20),
                                                                                                               (11, 21),
                                                                                                               (12, 22),
                                                                                                               (12, 23),
                                                                                                               (13, 24),
                                                                                                               (14, 25),
                                                                                                               (15, 26),
                                                                                                               (16, 27),
                                                                                                               (16, 28),
                                                                                                               (17, 29),
                                                                                                               (18, 30),
                                                                                                               (19, 31),
                                                                                                               (20, 32),
                                                                                                               (21, 33),
                                                                                                               (22, 34),
                                                                                                               (22, 35),
                                                                                                               (23, 36),
                                                                                                               (23, 37),
                                                                                                               (24, 38),
                                                                                                               (25, 39),
                                                                                                               (26, 40),
                                                                                                               (27, 41),
                                                                                                               (28, 42),
                                                                                                               (29, 43),
                                                                                                               (30, 44),
                                                                                                               (31, 45),
                                                                                                               (32, 46),
                                                                                                               (32, 47);

-- --------------------------------------------------------

--
-- Table structure for table `application_line_items`
--

CREATE TABLE `application_line_items` (
                                          `id` bigint(20) NOT NULL,
                                          `description` varchar(255) DEFAULT NULL,
                                          `item_code` varchar(255) DEFAULT NULL,
                                          `price` decimal(38,2) DEFAULT NULL,
                                          `quantity` int(11) DEFAULT NULL,
                                          `unit_of_measure` varchar(255) DEFAULT NULL,
                                          `reason` varchar(255) DEFAULT NULL,
                                          `status` enum('DISTRICT_APPROVED','GM_APPROVED','INSPECTION_ACCEPTED','INSPECTION_REJECTED','ITEM_ACCEPTED','ITEM_REJECTED','MD_APPROVED','NOT_APPLIED','PENDING','RECEIVED','REJECTED') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `application_line_items`
--

INSERT INTO `application_line_items` (`id`, `description`, `item_code`, `price`, `quantity`, `unit_of_measure`, `reason`, `status`) VALUES
                                                                                                                                        (1, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', 'Eheka', 'PENDING'),
                                                                                                                                        (2, 'CABLE 300MM2 AL 3C 33KV XLPE', '462520-0325', 1593.00, 2, NULL, NULL, NULL),
                                                                                                                                        (3, 'CABLE 95MM2 CU 1C 33KV XLPE', '462520-0020', 0.00, 2, 'MT', NULL, NULL),
                                                                                                                                        (4, 'CABLE 300MM2 AL 3C 33KV XLPE', '462520-0325', 1593.00, 2, NULL, NULL, NULL),
                                                                                                                                        (5, 'CABLE 70MM2 CU 1C 11 - 33KV XLPE', '462520-0011', 464.63, 12, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (6, 'CABLE  35MM2 CU 3C 11KV PILC', '463510-0017', 0.00, 1, 'EA', 'We are rolling on', 'ITEM_REJECTED'),
                                                                                                                                        (7, 'WIRE INSL. 1.5MM2 PVC 660V YELLOW', '465040-0022', 5.49, 1, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (8, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', '', 'ITEM_REJECTED'),
                                                                                                                                        (9, 'WIRE INSL. 1.5MM2 PVC 660V BLACK', '465040-0010', 7.79, 3, 'MT', NULL, NULL),
                                                                                                                                        (10, 'WIRE INSUL. 2.5MM2 2C PVC 660V FLEX', '465040-0025', 5.31, 5, 'LB', NULL, NULL),
                                                                                                                                        (11, 'CABLE 70MM2 CU 1C 11 - 33KV XLPE', '462520-0011', 464.63, 5, 'MT', NULL, NULL),
                                                                                                                                        (12, 'CABLE  185MM2 CU 3C 33KV XLPE', '462520-0290', 17.70, 2, 'MT', NULL, NULL),
                                                                                                                                        (13, 'CABLE, 800MM2 AL 1C 11KV PILC', '463510-0310', 1125.90, 8, 'MT', NULL, NULL),
                                                                                                                                        (14, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (15, 'CABLE 300MM2 AL 3C 33KV XLPE', '462520-0325', 1593.00, 2, NULL, '', 'ITEM_ACCEPTED'),
                                                                                                                                        (16, 'CABLE 70MM2 CU 1C 11 - 33KV XLPE', '462520-0011', 464.63, 40, 'MT', NULL, NULL),
                                                                                                                                        (17, 'CABLE 50MM2 3C 11KV XLPE', '463520-0050', 999.34, 1, 'MT', 'The item does not reach our standards', 'ITEM_REJECTED'),
                                                                                                                                        (18, 'CABLE  185MM2 CU 3C 33KV XLPE', '462520-0290', 17.70, 1, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (19, 'CABLE  35MM2 CU 3C 11KV PILC', '463510-0017', 0.00, 1, 'EA', 'ndsndsnmds nds dskdsk', 'ITEM_REJECTED'),
                                                                                                                                        (20, 'CABLE 300MM2 CU 1C 33KV XLPE', '462520-0250', 867.30, 3, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (21, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 7, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (22, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (23, 'WIRE INSL. 2.5MM2 PVC 660V GREEN', '465040-0070', 5.13, 2000, 'MT', NULL, NULL),
                                                                                                                                        (24, 'WIRE INSL. 2.5MM2 PVC 660V GREEN', '465040-0070', 5.13, 8, 'MT', NULL, NULL),
                                                                                                                                        (25, 'CABLE 70MM2 CU 1C 11 - 33KV XLPE', '462520-0011', 464.63, 5, 'MT', 'the material is not good', 'ITEM_REJECTED'),
                                                                                                                                        (26, 'CABLE 300MM2 AL 3C 33KV XLPE', '462520-0325', 1593.00, 2, NULL, 'the material is not good', 'ITEM_REJECTED'),
                                                                                                                                        (27, 'CABLE 300MM2 AL 3C 33KV XLPE', '462520-0325', 1593.00, 2, NULL, '', 'ITEM_ACCEPTED'),
                                                                                                                                        (28, 'CABLE  35MM2 CU 3C 11KV PILC', '463510-0017', 0.00, 1, 'EA', 'yyuyu yuujj jjj', 'ITEM_REJECTED'),
                                                                                                                                        (29, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', NULL, NULL),
                                                                                                                                        (30, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', NULL, NULL),
                                                                                                                                        (31, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (32, 'CABLE,  300MM2 1C AL 33KV PILC', '462510-0154', 619.50, 11, 'MT', NULL, NULL),
                                                                                                                                        (33, 'CABLE,  300MM2 1C AL 33KV PILC', '462510-0154', 619.50, 2, 'MT', NULL, NULL),
                                                                                                                                        (34, 'CABLE,  300MM2 1C AL 33KV PILC', '462510-0154', 619.50, 2, 'MT', NULL, NULL),
                                                                                                                                        (35, 'CABLE  35MM2 CU 3C 11KV PILC', '463510-0017', 0.00, 1, 'EA', NULL, NULL),
                                                                                                                                        (36, 'CABLE  35MM2 CU 3C 11KV PILC', '463510-0017', 0.00, 1, 'EA', NULL, NULL),
                                                                                                                                        (37, 'CABLE  185MM2 CU 3C 33KV XLPE', '462520-0290', 17.70, 1, 'MT', NULL, NULL),
                                                                                                                                        (38, 'CABLE  185MM2 CU 3C 33KV XLPE', '462520-0290', 17.70, 1, 'MT', NULL, NULL),
                                                                                                                                        (39, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 3, 'MT', '', 'ITEM_ACCEPTED'),
                                                                                                                                        (40, 'CABLE 70MM/0.1 CU 1C 33KV PILC', '462510-0105', 0.00, 1, 'MT', NULL, NULL),
                                                                                                                                        (41, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', NULL, NULL),
                                                                                                                                        (42, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 5, 'MT', NULL, NULL),
                                                                                                                                        (43, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 88, 'MT', NULL, NULL),
                                                                                                                                        (44, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 6, 'MT', NULL, NULL),
                                                                                                                                        (45, 'CABLE,  300MM2 1C CU 33KV HS/PILC', '462510-0153', 442.50, 2, 'MT', NULL, NULL),
                                                                                                                                        (46, 'CABLE 95MM2 CU 1C 33KV XLPE', '462520-0020', 0.00, 2, 'MT', NULL, NULL),
                                                                                                                                        (47, 'CABLE  35MM2 CU 3C 11KV PILC', '463510-0017', 0.00, 2, 'EA', NULL, NULL);

-- --------------------------------------------------------

--
-- Table structure for table `materials`
--

CREATE TABLE `materials` (
                             `id` bigint(20) NOT NULL,
                             `created_at` datetime(6) DEFAULT NULL,
                             `created_by` varchar(255) DEFAULT NULL,
                             `updated_at` datetime(6) DEFAULT NULL,
                             `updated_by` varchar(255) DEFAULT NULL,
                             `description` varchar(255) DEFAULT NULL,
                             `item_code` varchar(255) DEFAULT NULL,
                             `price` decimal(38,2) DEFAULT NULL,
                             `unit_of_measure` varchar(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

-- --------------------------------------------------------

--
-- Table structure for table `refresh_token`
--

CREATE TABLE `refresh_token` (
                                 `id` bigint(20) NOT NULL,
                                 `expiry_date` datetime(6) NOT NULL,
                                 `revoked` bit(1) NOT NULL,
                                 `token` varchar(255) NOT NULL,
                                 `user_id` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `refresh_token`
--

INSERT INTO `refresh_token` (`id`, `expiry_date`, `revoked`, `token`, `user_id`) VALUES
                                                                                     (1, '2024-04-30 08:19:43.000000', b'0', 'YjFjNjBkMTEtYWFmMi00YTk3LWIyYWUtMWU3ZTgwYTVhN2Iz', 1),
                                                                                     (3, '2024-04-30 08:21:32.000000', b'0', 'YmYyYTFkODktMjAwZi00Yzk1LTk4ZTEtYTlhZjk0ZDU1NjFh', 3),
                                                                                     (4, '2024-04-30 08:21:57.000000', b'0', 'YjQ1ZWFlZTktYzAxMi00ZjQ4LWE3NGUtN2Y2ZjUzZTU3MGJk', 4),
                                                                                     (5, '2024-04-30 08:23:32.000000', b'0', 'MTZiOGZjMDgtY2QzZC00ZDQ4LTljOTctNWFlNmUwODBjYzA3', 3),
                                                                                     (6, '2024-04-30 08:24:09.000000', b'0', 'M2EyNjQyZDEtZTBmZS00MGFlLWFhYTItODVjY2RmYzQ1OWUy', 5),
                                                                                     (7, '2024-04-30 08:25:08.000000', b'0', 'NTY2NWU1N2UtMjlkOC00ZDM5LWIyYWYtNWI0ZGNmNWRkZDhm', 6),
                                                                                     (8, '2024-04-30 08:36:54.000000', b'0', 'YThkYzMyNmYtMmJlZS00NDc0LWFjMzUtNzExOWQyNGM3Y2Yx', 7),
                                                                                     (9, '2024-04-30 08:47:50.000000', b'0', 'OWM3ZjUxODUtZTVmYS00NTc4LWIzNWUtN2MyYjBiNDdiM2Rm', 3),
                                                                                     (10, '2024-04-30 08:53:25.000000', b'0', 'MDg2YjRjMTItYTgzYS00MDU3LWIxYmQtOTFhMTQxNjIyZDA0', 3),
                                                                                     (11, '2024-04-30 08:56:30.000000', b'0', 'YTNjNWE1YWEtMzNiMS00NzdjLTk5MjEtYWM4ZmFhZjkzZDkz', 3),
                                                                                     (52, '2024-04-30 09:15:43.000000', b'0', 'MWFiZmUxODEtMTQ5MS00YWZjLTg1ZGMtMjJmNjEyZmM3ZGI0', 3),
                                                                                     (53, '2024-04-30 09:17:11.000000', b'0', 'Nzg2ZmZkYWMtNDk4MS00NjExLTgyNGItMGJhZTc3NjRkNWRi', 4),
                                                                                     (54, '2024-04-30 09:23:36.000000', b'0', 'ZGRhNmQzMWMtNmI5OC00YzFhLWI2MDktMjY4NzI2OTQ2NmUx', 7),
                                                                                     (55, '2024-04-30 09:28:37.000000', b'0', 'NTQyZjYxOTItMjJjOC00ZjAzLTgzNjAtZjRjZTExOWQzMTll', 3),
                                                                                     (102, '2024-05-01 06:38:17.000000', b'0', 'NTMwNzY1YTgtYWE0ZC00YjcxLThmMTQtZjllNzRkMmZlM2Vl', 3),
                                                                                     (103, '2024-05-01 07:00:22.000000', b'0', 'Mzg5MTQyOGYtNDUwNy00OWQwLWJkNjEtOWRhMTAwNmYyMzQx', 1),
                                                                                     (152, '2024-05-01 08:22:29.000000', b'0', 'NDYyMzFmOTQtNzU4YS00MTljLTlhNWMtNzNlZWNkM2YyMjk0', 3),
                                                                                     (153, '2024-05-01 08:50:21.000000', b'0', 'ZDU1NGZkYjAtZGViZi00Y2UzLWFjYWUtMzdlNmVmMTA0MGE5', 4),
                                                                                     (202, '2024-05-02 08:37:58.000000', b'0', 'MDFkNDY1NzYtZWJkMC00YWVhLWI1M2QtODM0NGRmYTM0MmM3', 52),
                                                                                     (203, '2024-05-02 08:41:20.000000', b'0', 'MzFhZDVhMmQtMzUyYy00ZGIwLThlM2ItOTMyOTM5MmU0NGFk', 52),
                                                                                     (252, '2024-05-02 08:51:34.000000', b'0', 'ODlmNzRlNjUtYWEyNS00YTZmLTllYWMtYjI3MzFjMTUzMGY0', 52),
                                                                                     (302, '2024-05-04 07:25:30.000000', b'0', 'OTgyZjRmMjktNGU5MC00Mjc4LTgzZTYtNDZjYTQzMzg2OTVm', 52),
                                                                                     (352, '2024-05-04 12:26:35.000000', b'0', 'MWE3MTI0Y2YtMWQwNS00NzlmLWJlMjUtZTM4OTkwYTllMjQy', 52),
                                                                                     (402, '2024-05-04 13:34:08.000000', b'0', 'YzcyZGZhOWMtYjZhYi00OTM1LWE1N2ItZmI5YmI2NzgzOWU2', 52),
                                                                                     (452, '2024-05-04 14:12:05.000000', b'0', 'MDE3NzhhMDUtNzRmZC00NjkxLWIzYmYtZTM4NTUwMTU2Mjcx', 52),
                                                                                     (502, '2024-05-04 19:45:25.000000', b'0', 'ZmFkMzUxZDgtMWUzMi00OGE1LWFmYjYtMzAyZDJkMThkM2Iw', 52),
                                                                                     (552, '2024-05-05 08:57:25.000000', b'0', 'ZjViNDdiNTEtYzQ3MC00ZWJmLTkzYzgtOTI5Y2VkOGZmMTU5', 52),
                                                                                     (602, '2024-05-05 09:16:11.000000', b'0', 'Y2MwZmNiMzEtM2E5ZS00Mzg2LTgxMzQtYjhjODI3NTFmZWRj', 52),
                                                                                     (652, '2024-05-08 09:16:41.000000', b'0', 'YTEyNmM5OTctMWY5MS00MDAxLTk1MzMtZjE0MjI0NzdiNzU0', 52),
                                                                                     (653, '2024-05-08 09:21:33.000000', b'0', 'YWExODQ3NzQtZmQyMS00NTk2LTg4ZGEtZWJkZGI5MDQ0NzVk', 52),
                                                                                     (702, '2024-05-10 07:44:45.000000', b'0', 'MDgwYjljZTMtMDkxZS00YWFlLWFlYmMtNWQ2NGY4ZjE2ZTNh', 102),
                                                                                     (703, '2024-05-10 07:44:59.000000', b'0', 'MjA2NDRkNDYtODA1YS00OTNmLTkyM2EtZTYzOTJhZTFlNDA4', 102),
                                                                                     (704, '2024-05-10 07:55:20.000000', b'0', 'MDRhNmMyOWEtOGMwNC00MGNiLTk0ZmQtMDJlYjAyYjA0OGU5', 4),
                                                                                     (752, '2024-05-10 09:16:32.000000', b'0', 'YTMxYTkwN2MtNDMyZS00NDI0LTkxZmYtNDZkYjdkZjhhM2M2', 4),
                                                                                     (802, '2024-05-14 07:01:39.000000', b'0', 'M2VmYmFlNDUtZGYxMS00MzM5LWJhZDctNjdmMTY4ZTYzNjUy', 102),
                                                                                     (803, '2024-05-14 07:48:55.000000', b'0', 'YWFiN2ZiNWYtODAzYS00MzNlLTg0N2QtOThlNmY4ZGNlYTYy', 4),
                                                                                     (804, '2024-05-14 08:07:38.000000', b'0', 'ZWUxZGRjNTctNzc2NS00YjUxLTgzN2UtNTgyZjVjMTllMWY4', 6),
                                                                                     (805, '2024-05-14 08:17:22.000000', b'0', 'ZGNlZjE0MTEtMTU4Zi00NWEzLWE0MDEtMTJhM2FhNTM2YWNi', 1),
                                                                                     (806, '2024-05-14 09:25:26.000000', b'0', 'MTQ1OGUwNzQtZjZjMS00OTVkLWJmNTQtMzg0NzQxNjY0ODli', 5),
                                                                                     (852, '2024-05-14 13:04:27.000000', b'0', 'MzUyNjA4NzMtY2M3Yy00OWIzLWE1NzEtYzE3N2JkNGU1OWUw', 5),
                                                                                     (902, '2024-05-14 13:23:12.000000', b'0', 'NGYwZjA2MWQtZTcyZi00ZDZlLTgwNTgtZTdiYjAxYmViYzAz', 52),
                                                                                     (903, '2024-05-14 13:49:05.000000', b'0', 'NmMxMWRmNzItNGZkMS00MWNiLWFlMDMtM2RkYmRlMzllMTM4', 102),
                                                                                     (904, '2024-05-14 13:51:53.000000', b'0', 'NDgwNzY1MWYtODgwNS00YjJjLWI1MGUtMGUxNmE1MjllYzAw', 4),
                                                                                     (905, '2024-05-15 07:32:50.000000', b'0', 'MzgyMTI4MjItODBjYy00ZWNjLWE5NGQtMzMyYmFhMWQyZmY1', 102),
                                                                                     (906, '2024-05-15 07:41:29.000000', b'0', 'MzFjZDM2OTEtMzZmYy00YjhiLTk3MTYtZTg3YjFlZGEwNjIz', 102),
                                                                                     (952, '2024-05-15 09:19:47.000000', b'0', 'YTIyZTA3ZWEtY2EwNy00YjJmLTg3NjYtZmMwZjQwZmQ5ZmYy', 4),
                                                                                     (953, '2024-05-15 09:53:57.000000', b'0', 'MTE3M2ZlNGUtODc4Ny00MjlmLWFlZmYtMDEwOGQ0N2FlNDhh', 1),
                                                                                     (954, '2024-05-15 09:54:17.000000', b'0', 'Njg4ZWJhMGYtMjQ4Ny00NzZiLTk5ZjMtNzAzMGQ0NTJkZTJh', 5),
                                                                                     (955, '2024-05-15 10:02:36.000000', b'0', 'YzVmNGE2MjItNGM0Zi00M2JjLTlhMWItNzE3MDY3NWE2MzM5', 5),
                                                                                     (956, '2024-05-15 10:03:09.000000', b'0', 'NmRiN2YxNGMtYzY4My00MWE3LWJmODMtZDUyMmM3YjIyYzE4', 6),
                                                                                     (957, '2024-05-15 10:08:53.000000', b'0', 'M2Q1YjIzNjUtYTFiMi00ZmY4LWExZGItMjhmOGI3MDY0OGUx', 1),
                                                                                     (958, '2024-05-15 10:11:38.000000', b'0', 'ZjQ2ZmY3ZTctMDBjZS00ZGExLWE4MDUtZjM4ZDBkM2FkMWEx', 52),
                                                                                     (1002, '2024-05-17 12:32:31.000000', b'0', 'ODRjYTE5OGUtYmIyOC00OTNlLWEwMDItZGQ3Yzk2YjUzMmI1', 102),
                                                                                     (1052, '2024-05-19 10:04:01.000000', b'0', 'OTYyNzczN2UtZjk3OS00Zjc2LWFhY2YtN2E3YzQ3NGZmOWQz', 52),
                                                                                     (1102, '2024-05-21 07:42:44.000000', b'0', 'YTQyYTRkOTEtNzAwNS00N2IxLWIxOTYtMDdmODk0MTVlODY4', 102),
                                                                                     (1152, '2024-05-30 08:00:27.000000', b'0', 'MGE0ODU3ZDItODY2MC00MzI3LTg0N2MtMzkwM2I2NGJmYjE2', 52),
                                                                                     (1153, '2024-05-30 08:01:11.000000', b'0', 'YjUwNDQ0NGYtODJlYS00MzRiLTk5MGQtYzgwZDc2NTY1OTU0', 102),
                                                                                     (1154, '2024-05-30 08:24:01.000000', b'0', 'NjdlMmUwYzEtYTI5MS00Y2Q2LTgzNmYtNjk2OGYyZjA2MmIw', 102),
                                                                                     (1155, '2024-05-30 08:36:52.000000', b'0', 'NWRlYThmMmItMTc4Zi00YjEyLWJhNDQtOGEwNzUyOGQ0M2I0', 102),
                                                                                     (1202, '2024-06-01 07:22:30.000000', b'0', 'NDU1MmFlMWUtOGZiNC00ZDY1LTgyOWEtNThlNzdiZGViMDQ0', 52),
                                                                                     (1203, '2024-06-01 07:23:53.000000', b'0', 'ZDM5Yzg1MWUtZTc3NC00ZWM4LTg3ZDUtMmFlYTViNjdkM2Y0', 102),
                                                                                     (1204, '2024-06-01 07:25:16.000000', b'0', 'YTQ3ZTZkODMtMTVmMC00NDNjLWI0MWEtZWM3ZmE2OTg5ZTFm', 4),
                                                                                     (1205, '2024-06-01 07:27:27.000000', b'0', 'NzczMzhhNjMtNDQ3NC00OWU1LWIyN2EtMjNkMjkxMDQ3NTI5', 6),
                                                                                     (1206, '2024-06-01 07:32:06.000000', b'0', 'MDAwNDg0OWQtYzViNS00Y2Y1LTkxZmEtZWE1YmU0MjIzNGY3', 5),
                                                                                     (1207, '2024-06-01 07:33:33.000000', b'0', 'NDg3YWUyOTktZmFlOS00YmMzLWE2ZGMtMGY5NzBhMzY3YTg3', 1),
                                                                                     (1208, '2024-06-01 07:35:06.000000', b'0', 'NDFhZmVkYjgtZjA0YS00NjhiLTgwNzQtMzYzYjBmNDVhZGYw', 52),
                                                                                     (1209, '2024-06-01 08:15:28.000000', b'0', 'NzkxMGQ5NTQtODNlZi00NmI4LWIwMTktOGUyNDZmMzdmYjI0', 102),
                                                                                     (1252, '2024-06-05 07:21:20.000000', b'0', 'YWFhZjhlNTUtNjI1NC00MDU3LWJkNDgtZjgyNTY0MDBhOThj', 102),
                                                                                     (1302, '2024-06-06 09:55:10.000000', b'0', 'ZDA3NDEyOTktMDljYi00ZGRlLTk0ZDYtMTc3MWM1NTM2ZTA2', 102),
                                                                                     (1352, '2024-06-06 10:09:06.000000', b'0', 'YjU1NDFjZjAtYTAzMS00OWM3LWFlZWYtOTM3ZDdlMWU1OWY1', 102),
                                                                                     (1402, '2024-06-06 10:21:56.000000', b'0', 'OTgyYjNkYzgtMjc4OC00MjJjLWE5NjktYWYyODc2MTk5YzEw', 102),
                                                                                     (1403, '2024-06-06 10:31:39.000000', b'0', 'ZGJlOWMzMDEtYzdiZS00OWI5LWFjYzEtZTI5NWI4ZWEwYTg1', 152),
                                                                                     (1404, '2024-06-06 10:39:58.000000', b'0', 'OGY3OTkzZDctYWM2NS00YTE5LTgxZTItNTBlMGM2ZTU3YTJh', 152),
                                                                                     (1405, '2024-06-07 09:09:41.000000', b'0', 'NDdlZGVjNWQtY2NmMy00NTNiLThlMDUtYmFjZDEyOTA0NTdk', 102),
                                                                                     (1406, '2024-06-07 13:29:08.000000', b'0', 'ZmY2YzlkNjctZDJiMy00OTdhLWJkMTAtNDIzMTMzY2JmNTg1', 102),
                                                                                     (1407, '2024-06-07 13:41:23.000000', b'0', 'NWM0ODg3OTEtMzNjMy00YjI1LWJjYjAtZmEzZGY2ODVkNTBm', 102),
                                                                                     (1408, '2024-06-07 13:55:46.000000', b'0', 'YzEzZTZiMzAtNWFmMC00ODEzLWJhM2UtZTMyMTczNTc1MjMw', 4),
                                                                                     (1409, '2024-06-07 13:59:55.000000', b'0', 'NTM4YWM2Y2YtZDYxMi00YmM4LWI1M2YtNmMwMTAzY2M3M2Zm', 1),
                                                                                     (1410, '2024-06-07 14:03:02.000000', b'0', 'MWM1NzhhNWMtNDU3ZS00NGU1LTliM2EtNzVhNzZlYjQ2MWE3', 52),
                                                                                     (1411, '2024-06-07 14:07:50.000000', b'0', 'MmZmNmQwYWItZGYyOC00OWQ2LThmZWYtMWJhYzAyYzEwOGJk', 102),
                                                                                     (1452, '2024-06-08 09:12:46.000000', b'0', 'OWVjZTVjNzctZjIzYS00NTNiLTllNDgtYjlmOGViNTMyMzZm', 102),
                                                                                     (1453, '2024-06-08 09:36:33.000000', b'0', 'Yzg4NGNiNTUtODE2Ny00NDQ2LThhOGUtM2YzYWNmNDU2NTE5', 5),
                                                                                     (1454, '2024-06-08 09:46:54.000000', b'0', 'MTgyNGFiMmQtZDIzNC00OGUxLWEyNmMtZTYwMjU2YzdhODU5', 52),
                                                                                     (1455, '2024-06-08 11:24:05.000000', b'0', 'OTBhYmNmOTktYmFhNC00ZWUyLWJkNDMtODk4MThlZTdhMDdm', 102),
                                                                                     (1502, '2024-06-11 08:12:43.000000', b'0', 'ODQ1ZjkxZWQtOTkyYy00ODA5LWFjOTQtNWJhODQ1ODUyMzdi', 102),
                                                                                     (1503, '2024-06-11 08:16:29.000000', b'0', 'NzZlYTk4NTUtNTA2My00YTk0LWEwMTUtYWQwMTYzZjI1MTc5', 102),
                                                                                     (1504, '2024-06-11 09:57:38.000000', b'0', 'MWU2N2U2YTgtNjcxMS00NDg2LTk3YjktZjViODJiOTQ0NDA4', 102),
                                                                                     (1552, '2024-06-11 13:10:15.000000', b'0', 'NzZlMDhmNjktMzI0ZS00MDE1LTlmOWItZWIzM2NiMzY5NDBi', 102);

-- --------------------------------------------------------

--
-- Table structure for table `refresh_token_seq`
--

CREATE TABLE `refresh_token_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `refresh_token_seq`
--

INSERT INTO `refresh_token_seq` (`next_val`) VALUES
    (1651);

-- --------------------------------------------------------

--
-- Table structure for table `_user`
--

CREATE TABLE `_user` (
                         `id` bigint(20) NOT NULL,
                         `district` enum('EAST_DISTRICT','GWERU_DISTRICT','KWEKWE_DISTRICT','NORTH_DISTRICT','NO_DISTRICT') DEFAULT NULL,
                         `email` varchar(255) DEFAULT NULL,
                         `firstname` varchar(255) DEFAULT NULL,
                         `lastname` varchar(255) DEFAULT NULL,
                         `password` varchar(255) DEFAULT NULL,
                         `region` enum('EASTERN_REGION','HARARE_REGION','HEAD_OFFICE','NCC','NORTHERN_REGION','NO_REGION','SOUTHERN_REGION','WESTERN_REGION') DEFAULT NULL,
                         `role` enum('ADMIN','DISTRICTMANAGER','GENERALMANAGER','MANAGINGDIRECTOR','PROJECTENGINEER','STORESCLERK','USER') DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `_user`
--

INSERT INTO _user (`id`, `district`, `email`, `firstname`, `lastname`, `password`, `region`, `role`) VALUES
                                                                                                           (1, 'EAST_DISTRICT', 'chikoti@gmail.com', 'Kuda', 'Chikoti', '$2a$10$6RUSAA8.VlUsw0rN2fNTV.dEjNGGDa2WZRiA/1Y5gEIMBSXD9xhAa', 'EASTERN_REGION', 'STORESCLERK'),
                                                                                                           (3, 'NO_DISTRICT', 'kudakotie@gmail.com1', 'Kudakwashe', 'Koti', '$2a$10$vuOniqLiqlj72RcoIfyNFubVdaons36fuIhzmB4HPjanDopnrXBga', 'NO_REGION', 'USER'),
                                                                                                           (4, 'EAST_DISTRICT', 'porcupine@gmail.com', 'Edwin', 'Magodi', '$2a$10$8RUdySddmurxtSwMDXie2eFsUtAzLF5wKkzUYsHx4./9J3lt3dczO', 'EASTERN_REGION', 'DISTRICTMANAGER'),
                                                                                                           (5, 'EAST_DISTRICT', 'zvi@gmail.com', 'Tawanda', 'Zviro', '$2a$10$pdXH8Xogpqqz1HE/D76nUedlisl6GH6bMHbYaurS/m1YmntdIwn4q', 'EASTERN_REGION', 'MANAGINGDIRECTOR'),
                                                                                                           (6, 'EAST_DISTRICT', 'taps@gmail.com', 'Wilson', 'Tapera', '$2a$10$VtxzgNit32y7jFGqreNTYe8rE.L.n3tW8Y5nxqYQxJRcTffJoiPbu', 'EASTERN_REGION', 'GENERALMANAGER'),
                                                                                                           (7, 'EAST_DISTRICT', 'dee@gmail.com', 'Degrees', 'Mugovera', '$2a$10$hp5U7FcL.UKrjJPiQ65JhupyV60CxQEisbgp72qWxzpwFRcmU2XYe', 'EASTERN_REGION', 'USER'),
                                                                                                           (52, 'EAST_DISTRICT', 'zawala@gmail.com', 'Kelvin', 'Zawala', '$2a$10$Q2NTR7B7bfH2mJeUw0IVQO8NqhkqyLx1ts8967Wra35t9qCYBtDlW', 'EASTERN_REGION', 'PROJECTENGINEER'),
                                                                                                           (102, 'NO_DISTRICT', 'kotilasco@gmail.com', 'Kudakwashe', 'Koti', '$2a$10$aRvISw9clurYHDaojuaxUuHIUKt83YIrEdyrDD29NTonMqRLxWJzS', 'NO_REGION', 'USER'),
                                                                                                           (152, 'NO_DISTRICT', 'emagodi@zetdc.co.zw', 'Edwin', 'Magodi', '$2a$10$5biy6aOSu/tXCCYTeaL5d.hAAnyd2mqvnMn07rH/h00q2ZGgvcM8m', 'NO_REGION', 'ADMIN');

-- --------------------------------------------------------

--
-- Table structure for table `_user_seq`
--

CREATE TABLE `_user_seq` (
    `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Dumping data for table `_user_seq`
--

INSERT INTO `_user_seq` (`next_val`) VALUES
    (251);

--
-- Indexes for dumped tables
--

--
-- Indexes for table `application`
--
ALTER TABLE `application`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `application_application_line_items_list`
--
ALTER TABLE `application_application_line_items_list`
    ADD UNIQUE KEY `UK_nogxrmo2encdi8wdwwtgx90v4` (`application_line_items_list_id`),
    ADD KEY `FKb2lt5395g5g4ushbu83p86t44` (`application_id`);

--
-- Indexes for table `application_line_items`
--
ALTER TABLE `application_line_items`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `materials`
--
ALTER TABLE `materials`
    ADD PRIMARY KEY (`id`);

--
-- Indexes for table `refresh_token`
--
ALTER TABLE `refresh_token`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_r4k4edos30bx9neoq81mdvwph` (`token`),
  ADD KEY `FKbws85up72jgwebb6ttkjiytg3` (`user_id`);

--
-- Indexes for table `_user`
--
ALTER TABLE `_user`
    ADD PRIMARY KEY (`id`),
  ADD UNIQUE KEY `UK_k11y3pdtsrjgy8w9b6q4bjwrx` (`email`);

--
-- AUTO_INCREMENT for dumped tables
--

--
-- AUTO_INCREMENT for table `application`
--
ALTER TABLE `application`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=33;

--
-- AUTO_INCREMENT for table `application_line_items`
--
ALTER TABLE `application_line_items`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=48;

--
-- AUTO_INCREMENT for table `materials`
--
ALTER TABLE `materials`
    MODIFY `id` bigint(20) NOT NULL AUTO_INCREMENT;

--
-- Constraints for dumped tables
--

--
-- Constraints for table `application_application_line_items_list`
--
ALTER TABLE `application_application_line_items_list`
    ADD CONSTRAINT `FKb2lt5395g5g4ushbu83p86t44` FOREIGN KEY (`application_id`) REFERENCES `application` (`id`),
  ADD CONSTRAINT `FKiedoaj1tsclbvaionut74vu70` FOREIGN KEY (`application_line_items_list_id`) REFERENCES `application_line_items` (`id`);

--
-- Constraints for table `refresh_token`
--
ALTER TABLE `refresh_token`
    ADD CONSTRAINT `FKbws85up72jgwebb6ttkjiytg3` FOREIGN KEY (`user_id`) REFERENCES `_user` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
