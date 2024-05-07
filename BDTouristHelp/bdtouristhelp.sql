-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 07-05-2024 a las 22:56:57
-- Versión del servidor: 10.4.28-MariaDB
-- Versión de PHP: 8.2.4

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `bdtouristhelp`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `usuarios`
--

CREATE TABLE `usuarios` (
  `idusu` int(11) NOT NULL,
  `nombre` varchar(50) NOT NULL,
  `correo` varchar(100) NOT NULL,
  `password` varchar(50) NOT NULL,
  `edad` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_unicode_ci;

--
-- Volcado de datos para la tabla `usuarios`
--

INSERT INTO `usuarios` (`idusu`, `nombre`, `correo`, `password`, `edad`) VALUES
(1, 'Erick', 'erickgianpierre@gmail.com', 'sh', 20),
(2, 'Naomi', 'naomiciriaco@gmail.com', 'hola234', 21),
(3, 'Miguel', 'miguel@gmail.com', '123', 30),
(4, 'Naomi Basurto', 'ciriacodamiano2017@gmail.com', 'Naomibasurto', 21),
(5, 'Frank', 'frankdimas@gmail.com', '123', 26);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `zonas`
--

CREATE TABLE `zonas` (
  `idzona` int(11) NOT NULL,
  `nombrez` varchar(50) NOT NULL,
  `descz` varchar(1000) NOT NULL,
  `imgurl` varchar(200) NOT NULL,
  `depaz` varchar(30) NOT NULL,
  `califica` double(10,1) NOT NULL,
  `direc` varchar(200) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8 COLLATE=utf8_general_ci;

--
-- Volcado de datos para la tabla `zonas`
--

INSERT INTO `zonas` (`idzona`, `nombrez`, `descz`, `imgurl`, `depaz`, `califica`, `direc`) VALUES
(1, 'Parque de las Leyendas', 'Es un zoologico ubicado en el distrito de San Miguel, en la ciudad de Lima, capital del Peru. Es administrado por la Municipalidad Metropolitana de Lima. Es el zoologico mas influyente, grande y visitado en todo el pais, tiene ademas zonas de recreacion y diversion, museos, jardin botanico, entre otras instalaciones.', 'https://upload.wikimedia.org/wikipedia/commons/c/c1/Entrada_principal_Parque_de_las_Leyendas.jpg', 'Lima', 4.5, 'Av. Parque de las Leyendas, San Miguel 15088'),
(2, 'Plaza Mayor de Lima', 'La plaza Mayor de Lima o plaza de Armas de Lima es el sitio fundacional de la ciudad de Lima, capital del Peru. Es el principal espacio publico de la ciudad. Esta ubicada en el centro historico de Lima, a su alrededor se levantan sobriamente el Palacio de Gobierno del Peru, la Catedral de Lima, la Iglesia del Sagrario, el Palacio Arzobispal de Lima, el Palacio Municipal de Lima y el Club de la Union.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Lima_-_Plaza_Mayor_-_Fontaine.jpg/1280px-Lima_-_Plaza_Mayor_-_Fontaine.jpg', 'Lima', 4.8, 'Jr. Junin cdra. 1, Lima 15001');

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  ADD PRIMARY KEY (`idusu`);

--
-- Indices de la tabla `zonas`
--
ALTER TABLE `zonas`
  ADD PRIMARY KEY (`idzona`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `usuarios`
--
ALTER TABLE `usuarios`
  MODIFY `idusu` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `zonas`
--
ALTER TABLE `zonas`
  MODIFY `idzona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=3;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
