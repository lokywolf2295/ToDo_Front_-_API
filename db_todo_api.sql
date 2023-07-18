-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 19-07-2023 a las 00:42:06
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.0.25

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `db_todo_api`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `task`
--

CREATE TABLE `task` (
  `id` bigint(20) NOT NULL,
  `created_date` datetime(6) NOT NULL,
  `date` date NOT NULL,
  `enable` bit(1) DEFAULT NULL,
  `finished` bit(1) NOT NULL,
  `time` time NOT NULL,
  `title` varchar(256) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `task`
--

INSERT INTO `task` (`id`, `created_date`, `date`, `enable`, `finished`, `time`, `title`) VALUES
(1, '2023-05-27 22:56:24.000000', '2023-05-28', b'1', b'0', '12:30:00', 'Realizar el Front de la Página ToDo'),
(2, '2023-05-27 22:57:00.000000', '2023-05-30', b'1', b'0', '17:40:00', 'Realizar el Back de la Página ToDo'),
(3, '2023-05-27 22:58:36.000000', '2023-06-02', b'1', b'0', '19:20:00', 'Hacer el deploy de la Página ToDo'),
(52, '2023-05-28 13:44:18.000000', '2023-05-29', b'1', b'0', '10:15:00', 'Revisar que el diseño esté correcto'),
(102, '2023-05-31 13:14:52.000000', '2023-05-31', b'1', b'0', '13:30:00', 'Prueba de Swagger');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `task_seq`
--

CREATE TABLE `task_seq` (
  `next_val` bigint(20) DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `task_seq`
--

INSERT INTO `task_seq` (`next_val`) VALUES
(201);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `task`
--
ALTER TABLE `task`
  ADD PRIMARY KEY (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
