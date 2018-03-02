-- phpMyAdmin SQL Dump
-- version 4.7.0
-- https://www.phpmyadmin.net/
--
-- Máy chủ: 127.0.0.1
-- Thời gian đã tạo: Th3 01, 2018 lúc 05:33 PM
-- Phiên bản máy phục vụ: 10.1.25-MariaDB
-- Phiên bản PHP: 7.1.7

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
SET AUTOCOMMIT = 0;
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Cơ sở dữ liệu: `bookstore`
--

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `book`
--

CREATE TABLE `book` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `description` text,
  `price` decimal(10,0) NOT NULL,
  `special` tinyint(1) DEFAULT '0',
  `sale_off` int(3) DEFAULT '0',
  `picture` text,
  `created` date DEFAULT '0000-00-00',
  `created_by` varchar(255) DEFAULT NULL,
  `modified` date DEFAULT '0000-00-00',
  `modified_by` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `ordering` int(11) DEFAULT '10',
  `category_id` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `book`
--

INSERT INTO `book` (`id`, `name`, `description`, `price`, `special`, `sale_off`, `picture`, `created`, `created_by`, `modified`, `modified_by`, `status`, `ordering`, `category_id`) VALUES
(12, 'UnrealScript Game Programming Cookbook', 'Designed for high-level game programming, UnrealScript is used in tandem with the Unreal Engine to provide a scripting language that is ideal for creating your very own unique gameplay experience. By learning how to replicate some of the advanced techniques used in today\'s modern games, you too can take your game to the next level and stand out from the crowd.\r\n\r\nBy providing a series of engaging and practical recipes, this \"UnrealScript Game Programming Cookbook\" will show you how to leverage the advanced functionality within UDK. You\'ll be shown how to implement a wide variety of practical features using the high-level scripting language ranging from designing your own HUD, creating your very own custom tailored weapons, to generating pathfinding solutions, and even meticulously crafting your own AI.', '25000', 0, 20, '8290qven.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 3, 4),
(14, 'iOS 7 Programming Fundamentals', 'If you\'re getting started with iOS development, or want a firmer grasp of the basics, this practical guide provides a clear view of its fundamental building blocks—Objective-C, Xcode, and Cocoa Touch. You\'ll learn object-oriented concepts, understand how to use Apple\'s development tools, and discover how Cocoa provides the underlying functionality iOS apps need to have. Dozens of example projects are available at GitHub.\r\n\r\nOnce you master the fundamentals, you\'ll be ready to tackle the details of iOS app development with author Matt Neuburg\'s companion guide.', '45000', 0, 1, 'd1ywaomx.png', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 2, 2),
(15, 'iOS 7 Programming Cookbook', 'Overcome the vexing issues you\'re likely to face when creating apps for the iPhone, iPad, or iPod touch. With new and thoroughly revised recipes in this updated cookbook, you\'ll quickly learn the steps necessary to work with the iOS 7 SDK, including solutions for bringing real-world physics and movement to your apps with UIKit Dynamics APIs.\r\n\r\nYou\'ll learn hundreds of techniques for storing and protecting data, sending and receiving notifications, enhancing and animating graphics, managing files and folders, and many other options. Each recipe includes sample code you can use right away.', '44000', 1, 1, 'f1ie8sjy.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 3, 3),
(16, 'Advanced Programming in the UNIX', 'For more than twenty years, serious C programmers have relied on one book for practical, in-depth knowledge of the programming interfaces that drive the UNIX and Linux kernels: W. Richard Stevens\' Advanced Programming in the UNIX Environment. Now, once again, Rich\'s colleague Steve Rago has thoroughly updated this classic work. The new third edition supports today\'s leading platforms, reflects new technical advances and best practices, and aligns with Version 4 of the Single UNIX Specification.\r\n\r\nSteve carefully retains the spirit and approach that have made this book so valuable. Building on Rich\'s pioneering work, he begins with files, directories, and processes, carefully laying the groundwork for more advanced techniques, such as signal handling and terminal I/O. He also thoroughly covers threads and multithreaded programming, and socket-based IPC.', '36000', 1, 2, 'wztiukdm.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 3, 3),
(17, 'jMonkeyEngine 3.0 Beginner', 'jMonkeyEngine 3.0 is a powerful set of free Java libraries that allows you to unlock your imagination, create 3D games and stunning graphics. Using jMonkeyEngine\'s library of time-tested methods, this book will allow you to unlock its potential and make the creation of beautiful interactive 3D environments a breeze.\r\n\r\njMonkeyEngine 3.0 Beginner\'s Guide teaches aspiring game developers how to build modern 3D games with Java. This primer on 3D programming is packed with best practices, tips and tricks and loads of example code. Progressing from elementary concepts to advanced effects, budding game developers will have their first game up and running by the end of this book.', '36000', 1, 12, 'kih36otz.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 3, 2),
(18, 'Scala Cookbook', 'Save time and trouble when using Scala to build object-oriented, functional, and concurrent applications. With more than 250 ready-to-use recipes and 700 code examples, this comprehensive cookbook covers the most common problems you\'ll encounter when using the Scala language, libraries, and tools. It\'s ideal not only for experienced Scala developers, but also for programmers learning to use this JVM language.\r\n\r\nAuthor Alvin Alexander (creator of DevDaily.com) provides solutions based on his experience using Scala for highly scalable, component-based applications that support concurrency and distribution.', '46000', 0, 1, '2356qrky.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 10, 4),
(19, 'PostgreSQL Server Programming', 'Learn how to work with PostgreSQL as if you spent the last decade working on it. PostgreSQL is capable of providing you with all of the options that you have in your favourite development language and then extending that right on to the database server. With this knowledge in hand, you will be able to respond to the current demand for advanced PostgreSQL skills in a lucrative and booming market.\r\n\r\nPostgreSQL Server Programming will show you that PostgreSQL is so much more than a database server. In fact, it could even be seen as an application development framework, with the added bonuses of transaction support, massive data storage, journaling, recovery and a host of other features that the PostgreSQL engine provides.', '54000', 0, 5, 'j091ndrk.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 3, 2),
(20, 'Programming Drupal 7 Entities', 'Writing code for manipulating Drupal data has never been easier! Learn to dice and serve your data as you slowly peel back the layers of the Drupal entity onion. Next, expose your legacy local and remote data to take full advantage of Drupal\'s vast solution space.\r\n\r\nProgramming Drupal 7 Entities is a practical, hands-on guide that provides you with a thorough knowledge of Drupal\'s entity paradigm and a number of clear step-by-step exercises, which will help you take advantage of the real power that is available when developing using entities.', '58000', 0, 4, 'h9xcvy50.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 3, 2),
(21, 'Moving from C to C++', 'The author says it best, I hope to move you, a little at a time,from understanding C to the point where C++ becomes your mindset. This remarkable book is designed to streamline the process of learning C++ in a way that discusses programming problems, why they exist, and the approach C++ has taken to solve such problems.\r\n\r\nYou can\'t just look at C++ as a collection of features; some of the features make no sense in isolation. You can only use the sum of the parts if you are thinking about design, not simply coding. To understand C++, you must understand the problems with C and with programming in general. This book discusses programming problems, why they are problems, and the approach C++ has taken to solve such problems. Thus, the set of features that I explain in each chapter will be based on the way that I see a particular type of problem being solved in C++.', '36000', 1, 3, 'e2vhcqf3.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 3, 2),
(22, 'C Programming for Arduino', 'Physical computing allows us to build interactive physical systems by using software & hardware in order to sense and respond to the real world. C Programming for Arduino will show you how to harness powerful capabilities like sensing, feedbacks, programming and even wiring and developing your own autonomous systems.\r\n\r\nC Programming for Arduino contains everything you need to directly start wiring and coding your own electronic project. You\'ll learn C and how to code several types of firmware for your Arduino, and then move on to design small typical systems to understand how handling buttons, leds, LCD, network modules and much more.', '38000', 1, 1, '5rpotszu.png', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 2, 3),
(23, 'Advanced Network Programming - Principles and Techniques', 'The field of network programming is so large, and developing so rapidly, that it can appear almost overwhelming to those new to the discipline.\r\n\r\nAnswering the need for an accessible overview of the field, this text/reference presents a manageable introduction to both the theoretical and practical aspects of computer networks and network programming. Clearly structured and easy to follow, the book describes cutting-edge developments in network architectures, communication protocols, and programming techniques and models, supported by code examples for hands-on practice with creating network-based applications.', '43000', 0, 20, 'qtrxbi2s.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 3, 3),
(24, 'Programming Logics', 'This Festschrift volume, published in memory of Harald Ganzinger, contains 17 papers from colleagues all over the world and covers all the fields to which Harald Ganzinger dedicated his work during his academic career.\r\n\r\nThe volume begins with a complete account of Harald Ganzinger\'s work and then turns its focus to the research of his former colleagues, students, and friends who pay tribute to him through their writing. Their individual papers span a broad range of topics, including programming language semantics, analysis and verification, first-order and higher-order theorem proving, unification theory, non-classical logics, reasoning modulo theories, and applications of automated reasoning in biology.', '32000', 0, 1, 'x41row9y.jpg', '2013-12-12', 'admin', '2018-01-30', 'admin', 1, 2, 4);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `cart`
--

CREATE TABLE `cart` (
  `id` varchar(45) NOT NULL,
  `username` varchar(255) NOT NULL,
  `books` text NOT NULL,
  `prices` text NOT NULL,
  `quantities` text NOT NULL,
  `names` text NOT NULL,
  `pictures` text NOT NULL,
  `status` tinyint(1) DEFAULT NULL,
  `date` datetime DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `cart`
--

INSERT INTO `cart` (`id`, `username`, `books`, `prices`, `quantities`, `names`, `pictures`, `status`, `date`) VALUES
('8GUw2Xn', 'admin', '[\"15\"]', '[\"43560\"]', '[\"1\"]', '[\"iOS 7 Programming Cookbook\"]', '[\"f1ie8sjy.jpg\"]', 0, '2018-02-27 16:02:56'),
('avkrmwB', 'admin', '[\"12\",\"15\"]', '[\"20000\",\"43560\"]', '[\"1\",\"1\"]', '[\"UnrealScript Game Programming Cookbook\",\"iOS 7 Programming Cookbook\"]', '[\"8290qven.jpg\",\"f1ie8sjy.jpg\"]', 0, '2018-02-27 17:19:02'),
('g1cJX7R', '', '[\"12\",\"15\"]', '[\"20000\",\"43560\"]', '[\"1\",\"1\"]', '[\"UnrealScript Game Programming Cookbook\",\"iOS 7 Programming Cookbook\"]', '[\"8290qven.jpg\",\"f1ie8sjy.jpg\"]', 0, '2018-02-27 16:01:07');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `category`
--

CREATE TABLE `category` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `picture` text,
  `created` date DEFAULT '0000-00-00',
  `created_by` varchar(255) DEFAULT NULL,
  `modified` date DEFAULT '0000-00-00',
  `modified_by` varchar(255) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `ordering` int(11) DEFAULT '10'
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `category`
--

INSERT INTO `category` (`id`, `name`, `picture`, `created`, `created_by`, `modified`, `modified_by`, `status`, `ordering`) VALUES
(1, 'Văn Học - Tiểu Thuyết', 'mo1rwglh.jpg', '2013-12-09', 'admin', '2018-01-30', 'admin', 1, 10),
(2, 'Kinh Tế', 'sfvmdgyk.PNG', '2013-12-09', 'admin', '2018-01-29', 'admin', 1, 4),
(3, 'Tin học', 'egyf3onp.jpg', '2013-12-09', 'admin', '2018-01-30', 'admin', 1, 10),
(4, ' Kỹ Năng Sống', 'zqv56isk.jpg', '2013-12-09', 'admin', '2018-01-28', 'admin', 1, 1),
(5, 'Thiếu Nhi', 'cudx7mz4.jpg', '2013-12-09', 'admin', '2018-01-30', 'admin', 1, 10),
(6, ' Thường Thức - Đời Sống', 'f79x6zeg.jpg', '2013-12-09', 'admin', '2018-01-30', 'admin', 1, 2),
(7, 'Ngoại Ngữ - Từ Điển', '2h0borc6.jpg', '2013-12-09', 'admin', '2018-01-28', 'admin', 0, 5),
(8, 'Truyện Tranh', 'a72s3b5r.jpg', '2013-12-09', 'admin', '2018-01-30', 'admin', 1, 10),
(9, ' Văn Hoá - Nghệ Thuật - Du Lịch', 'f2qry98x.png', '2013-12-06', 'admin', '2018-01-30', 'admin', 1, 3);

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `group`
--

CREATE TABLE `group` (
  `id` int(11) NOT NULL,
  `name` varchar(255) NOT NULL,
  `group_acp` tinyint(1) DEFAULT '0',
  `created` date DEFAULT '0000-00-00',
  `created_by` varchar(45) DEFAULT NULL,
  `modified` date DEFAULT '0000-00-00',
  `modified_by` varchar(45) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `ordering` int(11) DEFAULT '10',
  `privilege_id` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `group`
--

INSERT INTO `group` (`id`, `name`, `group_acp`, `created`, `created_by`, `modified`, `modified_by`, `status`, `ordering`, `privilege_id`) VALUES
(1, 'admin', 1, '2018-01-02', NULL, '2018-01-27', 'admin', 0, 10, '1,2,3,4,5,6,7,8,9,10'),
(3, 'manager ', 1, '2018-01-02', NULL, '2018-01-27', 'admin', 0, 20, '1,2,3,4,6,7,8,9,10'),
(4, 'member', 0, '2018-01-10', '1', '2018-01-29', 'admin', 1, 30, '');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `privilege`
--

CREATE TABLE `privilege` (
  `id` int(11) NOT NULL,
  `name` text NOT NULL,
  `module` varchar(45) NOT NULL,
  `controller` varchar(45) NOT NULL,
  `action` varchar(45) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `privilege`
--

INSERT INTO `privilege` (`id`, `name`, `module`, `controller`, `action`) VALUES
(1, 'Hiển thị danh sách người dùng', 'admin', 'user', 'index'),
(2, 'Thay đổi status của người dùng', 'admin', 'user', 'status'),
(3, 'Cập nhật thông tin của người dùng', 'admin', 'user', 'form'),
(4, 'Thay đổi status của người dùng sử dụng Ajax', 'admin', 'user', 'ajaxStatus'),
(5, 'Xóa một hoặc nhiều người dùng', 'admin', 'user', 'trash'),
(6, 'Thay đổi vị trí hiển thị của các người dùng', 'admin', 'user', 'ordering'),
(7, 'Truy cập menu Admin Control Panel', 'admin', 'index', 'index'),
(8, 'Đăng nhập Admin Control Panel', 'admin', 'index', 'login'),
(9, 'Đăng xuất Admin Control Panel', 'admin', 'index', 'logout'),
(10, 'Cập nhật thông tin tài khoản quản trị', 'admin', 'index', 'profile');

-- --------------------------------------------------------

--
-- Cấu trúc bảng cho bảng `user`
--

CREATE TABLE `user` (
  `id` int(11) NOT NULL,
  `username` varchar(255) NOT NULL,
  `email` varchar(255) NOT NULL,
  `fullname` varchar(255) DEFAULT NULL,
  `password` varchar(255) NOT NULL,
  `created` date DEFAULT '0000-00-00',
  `created_by` varchar(45) DEFAULT NULL,
  `modified` date DEFAULT '0000-00-00',
  `modified_by` varchar(45) DEFAULT NULL,
  `status` tinyint(1) DEFAULT '0',
  `ordering` int(11) DEFAULT '10',
  `group_id` int(11) NOT NULL,
  `register-date` datetime DEFAULT NULL,
  `register-ip` int(255) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

--
-- Đang đổ dữ liệu cho bảng `user`
--

INSERT INTO `user` (`id`, `username`, `email`, `fullname`, `password`, `created`, `created_by`, `modified`, `modified_by`, `status`, `ordering`, `group_id`, `register-date`, `register-ip`) VALUES
(1, 'nvan', 'nvan@gmail.com', 'Nguyễn Văn An', 'e10adc3949ba59abbe56e057f20f883e', '0000-00-00', '1', '0000-00-00', NULL, 0, 4, 1, NULL, NULL),
(2, 'nvb', 'nvb@gmail.com', 'Nguyễn Văn B', 'e10adc3949ba59abbe56e057f20f883e', '0000-00-00', '1', '0000-00-00', NULL, 0, 3, 2, NULL, NULL),
(3, 'nvc', 'nvc@gmail.com', 'Nguyễn Văn C', 'e10adc3949ba59abbe56e057f20f883e', '0000-00-00', '1', '0000-00-00', NULL, 1, 2, 3, NULL, NULL),
(4, 'admin', 'admin@gmail.com', 'Admin', '98c6fee6cfcb822dcaa749ac42553f69', '0000-00-00', '1', '2018-01-13', '1', 1, 1, 1, NULL, NULL),
(12, 'Langocson8125', 'langocson8125@gmail.com', 'Lã ngọc sơn', '98c6fee6cfcb822dcaa749ac42553f69', '2018-01-13', '1', '2018-01-13', '1', 1, 14, 1, NULL, NULL),
(13, 'admin2', 'admin2@gmail.com', 'Lã ngọc sơn', '98c6fee6cfcb822dcaa749ac42553f69', '0000-00-00', NULL, '2018-01-18', 'admin1', 0, 10, 2, '2018-01-17 00:00:00', 0),
(15, 'admin4', 'admin4@gmail.com', 'admin3', '98c6fee6cfcb822dcaa749ac42553f69', '0000-00-00', NULL, '2018-01-29', 'Langocson8125', 1, 10, 0, '2018-01-17 00:00:00', 0),
(16, 'admin5', 'admin5@gmail.com', 'admin5', '98c6fee6cfcb822dcaa749ac42553f69', '0000-00-00', NULL, '0000-00-00', NULL, 0, 10, 0, '2018-01-17 00:00:00', 0),
(17, 'admin6', 'admin6@gmail.com', 'admn6', '98c6fee6cfcb822dcaa749ac42553f69', '0000-00-00', NULL, '0000-00-00', NULL, 0, 10, 0, '2018-01-17 00:00:00', 0),
(18, 'admin10', 'admin10@gmal.com', 'Admin12', '98c6fee6cfcb822dcaa749ac42553f69', '2018-01-18', 'admin1', '2018-01-29', 'admin', 0, 14, 1, NULL, NULL),
(19, 'bookstore', 'bookstore@gmail.com', 'bookstore', '98c6fee6cfcb822dcaa749ac42553f69', '0000-00-00', NULL, '0000-00-00', NULL, 0, 10, 3, '2018-01-18 00:00:00', 0);

--
-- Chỉ mục cho các bảng đã đổ
--

--
-- Chỉ mục cho bảng `book`
--
ALTER TABLE `book`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `cart`
--
ALTER TABLE `cart`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `category`
--
ALTER TABLE `category`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `group`
--
ALTER TABLE `group`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `privilege`
--
ALTER TABLE `privilege`
  ADD PRIMARY KEY (`id`);

--
-- Chỉ mục cho bảng `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`id`);

--
-- AUTO_INCREMENT cho các bảng đã đổ
--

--
-- AUTO_INCREMENT cho bảng `book`
--
ALTER TABLE `book`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=25;
--
-- AUTO_INCREMENT cho bảng `category`
--
ALTER TABLE `category`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=18;
--
-- AUTO_INCREMENT cho bảng `group`
--
ALTER TABLE `group`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=5;
--
-- AUTO_INCREMENT cho bảng `privilege`
--
ALTER TABLE `privilege`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=11;
--
-- AUTO_INCREMENT cho bảng `user`
--
ALTER TABLE `user`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=20;COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
