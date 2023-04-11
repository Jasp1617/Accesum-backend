-- phpMyAdmin SQL Dump
-- version 5.2.0
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 09-04-2023 a las 04:32:53
-- Versión del servidor: 10.4.27-MariaDB
-- Versión de PHP: 8.2.0

SET SQL_MODE = "NO_AUTO_VALUE_ON_ZERO";
START TRANSACTION;
SET time_zone = "+00:00";


/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8mb4 */;

--
-- Base de datos: `accesum`
--

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `parametros`
--

CREATE TABLE `parametros` (
  `id_parametros` int(11) NOT NULL,
  `id_sedes` int(11) NOT NULL,
  `id_user` int(11) NOT NULL,
  `id_rol` int(11) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `parametros`
--

INSERT INTO `parametros` (`id_parametros`, `id_sedes`, `id_user`, `id_rol`) VALUES
(1, 1, 4, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `rol`
--

CREATE TABLE `rol` (
  `id` int(11) NOT NULL,
  `rol_nombre` varchar(225) NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `rol`
--

INSERT INTO `rol` (`id`, `rol_nombre`) VALUES
(1, 'Administrador\r\n'),
(2, 'Director'),
(3, 'SubDirector'),
(4, 'Coordinador'),
(5, 'Vigilante'),
(6, 'Personal'),
(7, 'Aprendiz'),
(8, 'Mirador');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_centros`
--

CREATE TABLE `tbl_centros` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tbl_centros_codigo` int(11) NOT NULL,
  `tbl_centros_nombre` text NOT NULL,
  `tbl_centros_tbl_regionals_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_centros`
--

INSERT INTO `tbl_centros` (`id`, `tbl_centros_codigo`, `tbl_centros_nombre`, `tbl_centros_tbl_regionals_id`) VALUES
(1, 1010, 'Despacho Dirección', 1),
(2, 9517, 'Centro para la Biodiversidad y el Turismo del Amazonas', 1),
(3, 1010, 'Despacho Dirección', 2),
(4, 9101, 'Centro de los Recursos Naturales Renovables - La Salada', 2),
(5, 9201, 'Centro del Diseño y Manufactura del Cuero', 2),
(6, 9202, 'Centro de Formación en Diseño, Confección y Moda.', 2),
(7, 9203, 'Centro para el Desarrollo del Habitat y la Construcción', 2),
(8, 9204, 'Centro de Tecnología de la Manufactura Avanzada.', 2),
(9, 9205, 'Centro Tecnológico del Mobiliario', 2),
(10, 9206, 'Centro Tecnológico de Gestión Industrial', 2),
(11, 9301, 'Centro de Comercio', 2),
(12, 9401, 'Centro de Servicios de Salud', 2),
(13, 9402, 'Centro de Servicios y Gestión Empresarial', 2),
(14, 9501, 'Complejo Tecnológico para la Gestión Agroempresarial', 2),
(15, 9502, 'Complejo Tecnológico Minero Agroempresarial', 2),
(16, 9503, 'Centro de la Innovación, la Agroindustria y el Turismo', 2),
(17, 9504, 'Complejo Tecnológico Agroindustrial, Pecuario y Turistico', 2),
(18, 9549, 'Complejo Tecnológico, Turístico y Agroindustrial del Occidente Antioqueño', 2),
(19, 912710, 'Centro de Formación Minero Ambiental', 2),
(20, 1010, 'Despacho Dirección', 3),
(21, 9530, 'Centro de Gestión y Desarrollo Agroindustrial de Arauca', 3),
(22, 1010, 'Despacho Dirección', 4),
(23, 9103, 'Centro para el Desarrollo Agroecologico y Agroindustrial', 4),
(24, 9207, 'Centro Nacional Colombo Alemán', 4),
(25, 9208, 'Centro Industrial y de Aviación', 4),
(26, 9302, 'Centro de \nComercio y Servicios', 4),
(27, 1010, 'Despacho Dirección', 5),
(28, 9104, 'Centro Agroempres arial y Minero', 5),
(29, 9105, 'Centro Internacional Náutico, Fluvial y Portuario', 5),
(30, 9218, 'Centro para la Industria Petroquímica', 5),
(31, 9304, 'Centro de Comercio y\nServicios', 5),
(32, 1010, 'Despacho Dirección', 6),
(33, 9110, 'Centro de Desarrollo Agropecuario y Agroindustrial', 6),
(34, 9111, 'Centro Minero', 6),
(35, 9305, 'Centro de Gestión Administrativa y Fortalecimiento Empresarial', 6),
(36, 9514, 'Centro Industrial de Mantenimiento y Manufactura', 6),
(37, 1010, 'Despacho Dirección', 7),
(38, 9112, 'Centro para la Formación Cafetera', 7),
(39, 9219, 'Centro de Automatización Industrial', 7),
(40, 9220, 'Centro de Procesos Industriales', 7),
(41, 9306, 'Centro de\nComercio y Servicios', 7),
(42, 9515, 'Centro Pecuario y Agroempresarial', 7),
(43, 1010, 'Despacho Dirección', 8),
(44, 9516, 'Centro Tecnológico de la Amazonia', 8),
(45, 1010, 'Despacho Dirección', 9),
(46, 9519, 'Centro Agroindustrial y Fortalecimiento Empresarial de Casanare', 9),
(47, 1010, 'Despacho Dirección', 10),
(48, 9113, 'Centro Agropecuario', 10),
(49, 9221, 'Centro de Teleinformática y Producción Industrial', 10),
(50, 9307, 'Centro de Comercio y\nServicios', 10),
(51, 1010, 'Despacho Dirección', 11),
(52, 9114, 'Centro Biotecnológico del Caribe', 11),
(53, 9520, 'Centro Agroempresarial', 11),
(54, 9521, 'Centro de Operación y Mantenimiento Minero', 11),
(55, 1010, 'Despacho Dirección', 12),
(56, 9522, 'Centro de Recursos Naturales, Industria y Biodiversidad', 12),
(57, 1010, 'Despacho Dirección', 13),
(58, 9115, 'Centro Agropecuario y de Biotecnología el Porvenir', 13),
(59, 9523, 'Centro de Comercio, Industria y Turismo deCórdoba', 13),
(60, 1010, 'Despacho Dirección', 14),
(61, 9232, 'Centro Industrial y de Desarrollo Empresarial de Soacha', 14),
(62, 9509, 'Centro de Desarrollo Agroindustrial y Empresarial', 14),
(63, 9510, 'Centro Agroecológico y Empresarial', 14),
(64, 9511, 'Centro de la Tecnología de Diseño y la Productividad Empresarial', 14),
(65, 9512, 'Centro de Biotecnología Agropecuaria', 14),
(66, 9513, 'Centro de Desarrollo Agroempresarial', 14),
(67, 1010, 'Despacho Dirección', 34),
(68, 1012, 'Oficina de Control\nInterno', 34),
(69, 1013, 'Oficina de Control Interno\nDisciplinario', 34),
(70, 1023, 'Oficina de Comunicaciones', 34),
(71, 1032, 'Oficina de Sistemas', 34),
(72, 10, 'Dirección Jurídica', 34),
(73, 2020, 'Secretaría General', 34),
(74, 3030, 'Dirección de Planeación y Direccionamiento Corporativo', 34),
(75, 4040, 'Dirección Administrativa y Financiera', 34),
(76, 5050, 'Dirección de Empleo y Trabajo', 34),
(77, 6060, 'Dirección de Formación Profesional', 34),
(78, 7070, 'Dirección Sistema Nacional de Formación para el Trabajo', 34),
(79, 8080, 'Dirección de Promoción y Relaciones Corporativas', 34),
(80, 1010, 'Despacho Dirección', 15),
(81, 9209, 'Centro de Tecnologías para la Construcción y la Madera', 15),
(82, 9210, 'Centro de Electricidad, Electrónica y Telecomunicaciones', 15),
(83, 9211, 'Centro de Gestión Industrial', 15),
(84, 9212, 'Centro de Manufactura en Textil y\nCuero', 15),
(85, 9213, 'Centro de Tecnologías del Transporte', 15),
(86, 9214, 'Centro Metalmecánico', 15),
(87, 9215, 'Centro de\nMateriales y Ensayos', 15),
(88, 9216, 'Centro de Diseño y Metrología', 15),
(89, 9217, 'Centro para la Industria de la Comunicación Gráfica', 15),
(90, 9303, 'Centro de Gestión de Mercados, Logística y Tecnologías de la Información', 15),
(91, 9403, 'Centro de Formación de Talento Humano en Salud', 15),
(92, 9404, 'Centro de Gestión Administrativa', 15),
(93, 9405, 'Centro de Servicios\nFinancieros', 15),
(94, 9406, 'Centro Nacional de Hoteleria, Turismo y\nAlimentos', 15),
(95, 9508, 'Centro de For', 15),
(96, 1010, 'Despacho Dirección', 16),
(97, 9547, 'Centro Ambiental y Ecoturistico del Nororiente Amazónico', 16),
(98, 1010, 'Despacho Dirección', 17),
(99, 9222, 'Centro Industrial y de Energías Alternativas', 17),
(100, 9524, 'Centro Agroempresarial y Acuicola', 17),
(101, 1010, 'Despacho\nDirecci?n', 18),
(102, 9533, 'Centro de Desarrollo Agroindustrial, Turístico y Tecnológico del Guaviare', 18),
(103, 1010, 'Despacho\nDirecci?n', 19),
(104, 9116, 'Centro de Formación Agroindustrial', 19),
(105, 9525, 'Centro Agroempresarial y Desarrollo Pecuario del Huila', 19),
(106, 9526, 'Centro de Desarrollo Agroempresarial y Turístico del Huila', 19),
(107, 9527, 'Centro de la Industria, la Empresa y\nlos Servicios', 19),
(108, 9528, 'Centro de Gestión y Desarrollo Sostenible Surcolombiano', 19),
(109, 1010, 'Despacho Dirección', 20),
(110, 9118, 'Centro Acuicola y Agroindustrial de Gaira', 20),
(111, 9529, 'Centro de Logística y Promoción Ecoturística del Magdalena', 20),
(112, 1010, 'Despacho Dirección', 21),
(113, 9117, 'Centro Agroindustrial del Meta', 21),
(114, 9532, 'Centro de Industria y Servicios del\nMeta', 21),
(115, 1010, 'Despacho Dirección', 22),
(116, 9534, 'Centro Sur Colombiano de Logística Internacional', 22),
(117, 9535, 'Centro Agroindustrial y Pesquero de la Costa Pacifica', 22),
(118, 9536, 'Centro Internacional de Producción Limpia -Lope', 22),
(119, 1010, 'Despacho Dirección', 23),
(120, 9119, 'Centro de Formación para el Desarrollo Rural y Minero', 23),
(121, 9537, 'Centro de la Industria, la Empresa y\nlos Servicios', 23),
(122, 1010, 'Despacho Dirección', 24),
(123, 9518, 'Centro Agroforestal y Acuicola Arapaima', 24),
(124, 1010, 'Despacho Dirección', 25),
(125, 9120, 'Centro Agroindustrial', 25),
(126, 9231, 'Centro para el Desarrollo Tecnológico de la Construcción y la Industria', 25),
(127, 9538, 'Centro de Comercio y\nTurismo', 25),
(128, 1010, 'Despacho Dirección', 26),
(129, 9121, 'Centro Atención Sector Agropecuario', 26),
(130, 9223, 'Centro de Diseño e Innovación Tecnológica Industrial', 26),
(131, 9308, 'Centro de\nComercio y Servicios', 26),
(132, 1010, 'Despacho Dirección', 27),
(133, 9539, 'Centro de Formación Turística, Gente de Mar y de Servicios', 27),
(134, 1010, 'Despacho Dirección', 28),
(135, 9122, 'Centro Atención Sector Agropecuario', 28),
(136, 9224, 'Centro Industrial de Mantenimiento Integral', 28),
(137, 9225, 'Centro Industrial del Diseño y la Manufactura', 28),
(138, 9309, 'Centro de Servicios Empresariales y Turísticos', 28),
(139, 9540, 'Centro Industrial y del Desarrollo Tecnológico', 28),
(140, 9541, 'Centro Agroturístico', 28),
(141, 9545, 'Centro Agroempresarial y Turístico de los Andes', 28),
(142, 9546, 'Centro de Gestión Agroempresarial del Oriente', 28),
(143, 1010, 'Despacho Dirección', 29),
(144, 9542, 'Centro de la Innovación, la Tecnología y los Servicios', 29),
(145, 1010, 'Despacho Dirección', 30),
(146, 9123, 'Centro Agropecuario\nla Granja', 30),
(147, 9226, 'Centro de Industria y Construcción', 30),
(148, 9310, 'Centro de Comercio y\nServicios', 30),
(149, 1010, 'Despacho Dirección', 31),
(150, 9124, 'Centro Agropecuario de Buga', 31),
(151, 9125, 'Centro Latinoamericano de Especies Menores', 31),
(152, 9126, 'Centro Náutico Pesquero de Buenaventura', 31),
(153, 9227, 'Centro de Electricidad y Automatización Industrial - CEAI', 31),
(154, 9228, 'Centro de la Construcción', 31),
(155, 9229, 'Centro de Diseño Tecnológico Industrial', 31),
(156, 9230, 'Centro Nacional de Asistencia Técnica a la Industria -ASTIN', 31),
(157, 9311, 'Centro de Gestión Tecnológica de Servicios', 31),
(158, 9543, 'Centro de Tecnologías Agroindustriales', 31),
(159, 9544, 'Centro de Biotecnología Industrial', 31),
(160, 1010, 'Despacho Dirección', 32),
(161, 9548, 'Centro Agropecuario y de Servicios Ambientales\n\"Jiri-jirimo\"', 32),
(162, 1010, 'Despacho Dirección', 33),
(163, 9531, 'Centro de Producción y Transformación Agroindustrial de la Orinoquia', 33);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_coordinacions`
--

CREATE TABLE `tbl_coordinacions` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tbl_coordinacions_codigo` int(11) DEFAULT NULL,
  `tbl_coordinacions_nombre` text DEFAULT NULL,
  `tbl_coordinacions_coordinador` text DEFAULT NULL,
  `tbl_coordinacions_tbl_centros_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_coordinacions`
--

INSERT INTO `tbl_coordinacions` (`id`, `tbl_coordinacions_codigo`, `tbl_coordinacions_nombre`, `tbl_coordinacions_coordinador`, `tbl_coordinacions_tbl_centros_id`) VALUES
(1, 1, 'TIc y Energía', 'Manuel Gregorio Hormechea Lance', 24),
(2, 2, 'Metalmecánica Malambo', 'Aldo Jose Silvera Serrano', 24),
(3, 3, 'Metalmecánica', 'Reberto Ignacio Morales Heilbron', 24),
(4, 4, 'Automatización', 'Elkin David Pertuz Rada', 24),
(5, 5, 'Desplazados por la violencia', 'Cesar Augusto Velez Betancourt', 24),
(6, 6, 'Jornada 24 horas', 'Jose Javier Ramirez Gomez', 24),
(7, 7, 'Articulación con la Media', 'Cesar Augusto Velez Betancourt II', 24);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_fichas`
--

CREATE TABLE `tbl_fichas` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tbl_fichas_codigo` text NOT NULL,
  `fichas_grupo` text NOT NULL,
  `programa` varchar(225) NOT NULL,
  `tbl_fichas_tbl_coordinacions` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_fichas`
--

INSERT INTO `tbl_fichas` (`id`, `tbl_fichas_codigo`, `fichas_grupo`, `programa`, `tbl_fichas_tbl_coordinacions`) VALUES
(1, '0000', 'Personal', 'Personal', 1),
(55, '2483684', 'ADSO-1', 'Tecnologo Analisis y Desarrollo de Software', 1),
(56, '2483839', 'ADSO-2', 'Tecnologo Analisis y Desarrollo de Software', 1),
(57, '2503112', 'ADSO-3', 'Tecnologo Analisis y Desarrollo de Software', 1),
(58, '2503106', 'ADSO-4', 'Tecnologo Analisis y Desarrollo de Software', 1),
(59, '2603365', 'ADSO-5', 'Tecnologo Analisis y Desarrollo de Software', 1),
(60, '2652534', 'ADSO-6', 'Tecnologo Analisis y Desarrollo de Software', 1),
(61, '2664531', 'ADSO-7', 'Tecnologo Analisis y Desarrollo de Software', 1),
(62, '2672184', 'ADSO-8', 'Tecnologo Analisis y Desarrollo de Software', 1),
(63, '2696227', 'ADSO-9', 'Tecnologo Analisis y Desarrollo de Software', 1),
(64, '2343088', 'GRD-26', 'TECNOLOGO EN GESTION DE REDES DE DATOS', 1),
(65, '2453224', 'GRD-27', 'TECNOLOGO EN GESTION DE REDES DE DATOS', 1),
(66, '2483863', 'GRD-28', 'TECNOLOGO EN GESTION DE REDES DE DATOS', 1),
(67, '2562468', 'GRD-29', 'TECNOLOGO EN GESTION DE REDES DE DATOS', 1),
(68, '2595318', 'GRD-30', 'TECNOLOGO EN GESTION DE REDES DE DATOS', 1),
(69, '2652543', 'GRD-31', 'TECNOLOGO EN GESTION DE REDES DE DATOS', 1),
(70, '2562470', 'ICD-1', 'TECNICO INTEGRACION DE CONTENIDOS DIGITALES', 1),
(71, '2615434', 'ICD-2', 'TECNICO INTEGRACION DE CONTENIDOS DIGITALES', 1),
(72, '2672187', 'TPS-34', 'TECNICO EN PROGRAMCION DE SOFTWARE', 1),
(73, '2672190', 'TPS-35', 'TECNICO EN PROGRAMCION DE SOFTWARE', 1),
(74, '2562467', 'TCSD-4', 'TECNICO EN CONTROL DE LA SEGURIDAD DIGITAL', 1),
(75, '2562462', 'TAD-4', 'TECNICO EN CONTROL DE LA SEGURIDAD DIGITAL', 1),
(76, '2424310', 'IITIC-4', 'IMPLEMENTACION DE INFRAESTRUCTURA DE TECNOLOGIAS DE LA INFORMACION Y LAS COMUNICACIONES', 1),
(77, '2654526', 'IITIC-5', 'IMPLEMENTACION DE INFRAESTRUCTURA DE TECNOLOGIAS DE LA INFORMACION Y LAS COMUNICACIONES', 1),
(78, '2696228', 'IITIC-6', 'IMPLEMENTACION DE INFRAESTRUCTURA DE TECNOLOGIAS DE LA INFORMACION Y LAS COMUNICACIONES', 1),
(79, '2696230', 'IITIC-7', '4', 1),
(80, '2562460', 'TS-38', '9', 1),
(81, '2614390', 'TS-39', '9', 1),
(82, '2614484', 'TS-40', '9', 1),
(83, '2672191', 'TS-41', '9', 1),
(84, '2672192', 'TS-42', '9', 1),
(85, '2563081', 'IRC-36', '7', 1),
(86, '2503108', 'IRST-1', '11', 1),
(87, '2562471', 'IRST-2', '11', 1),
(88, '2614472', 'IRST-03', '11', 1),
(89, '2562455', 'IRIT-17', '12', 1);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_regionals`
--

CREATE TABLE `tbl_regionals` (
  `id` bigint(20) UNSIGNED NOT NULL,
  `tbl_regionals_codigo` int(11) NOT NULL,
  `tbl_regionals_nombre` text NOT NULL,
  `tbl_regionals_director` text NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_unicode_ci;

--
-- Volcado de datos para la tabla `tbl_regionals`
--

INSERT INTO `tbl_regionals` (`id`, `tbl_regionals_codigo`, `tbl_regionals_nombre`, `tbl_regionals_director`) VALUES
(1, 91, 'REGIONAL AMAZONAS', 'Arturo Arango Santos'),
(2, 5, 'REGIONAL ANTIOQUIA', 'Juan Felipe Rendón Ochoa'),
(3, 81, 'REGIONAL ARAUCA', 'Eddie Yovanny Millán'),
(4, 8, 'REGIONAL ATLÁNTICO', 'Jacqueline Rojas Solano'),
(5, 13, 'REGIONAL BOLÍVAR', 'Jaime Torrado Casadiegos'),
(6, 15, 'REGIONAL BOYACÁ', 'Ramón Anselmo Vargas López'),
(7, 17, 'REGIONAL CALDAS', 'Luis Alejandro Trejos Ruíz'),
(8, 18, 'REGIONAL CAQUETÁ', 'Danny López Segura'),
(9, 85, 'REGIONAL CASANARE', 'Johana Astrid Medina Peña'),
(10, 19, 'REGIONAL CAUCA', 'Hernando Ramírez Dulcey'),
(11, 20, 'REGIONAL CESAR', 'Jesús Alberto Namén Chavarro'),
(12, 27, 'REGIONAL CHOCÓ', 'Juan Carlos Blanco Córdoba'),
(13, 23, 'REGIONAL CÓRDOBA', 'Víctor Ariza Plama'),
(14, 25, 'REGIONAL CUNDINAMARCA', 'Jimmy Gonzalo Maldonado Novoa'),
(15, 11, 'REGIONAL DISTRITO CAPITAL', 'Enrique Romero Contreras'),
(16, 94, 'REGIONAL GUAINÍA', 'Jairo Orlando Rojas Buitrago'),
(17, 44, 'REGIONAL GUAJIRA', 'Linda de Jesús Tromp Villareal'),
(18, 95, 'REGIONAL GUAVIARE', 'Luz Piedad Echeverry Quinceo'),
(19, 41, 'REGIONAL HUILA', 'Cándido Herrera Gonzáles'),
(20, 47, 'REGIONAL MAGDALENA', 'Víctor Hugo Armenta Herrera'),
(21, 50, 'REGIONAL META', 'Diana María Del Mar Pino Humanez'),
(22, 52, 'REGIONAL NARIÑO', 'Sara Ángela Arturo González'),
(23, 54, 'REGIONAL NORTE DE SANTANDER', 'Wilmar Manuel Cepeda Basto'),
(24, 86, 'REGIONAL PUTUMAYO', 'William James Rodríguez Ortiz'),
(25, 63, 'REGIONAL QUINDÍO', 'Carlos Fabio Alvarez Angel'),
(26, 66, 'REGIONAL RISARALDA', 'Mario Chica Palacio'),
(27, 88, 'REGIONAL SAN ANDRÉS', 'Leonora Barragán Bedoya'),
(28, 68, 'REGIONAL SANTANDER', 'Orlando Ariza Ariza'),
(29, 70, 'REGIONAL SUCRE', 'Marco Eugenio Gómez Ordosgoitia'),
(30, 73, 'REGIONAL TOLIMA', 'Álvaro Iván Barrero Buitrago'),
(31, 76, 'REGIONAL VALLE', 'Fernando José Muriel Andrade'),
(32, 97, 'REGIONAL VAUPÉS', 'Luz Empir Velásquez Camargo'),
(33, 99, 'REGIONAL VICHADA', 'Oscar Eduardo Daza Joaquín'),
(34, 1, 'DIRECCION GNERAL', 'DIRECTOR GENERAL'),
(80, 1231, 'Atlantico', 'Breiner Castro');

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `tbl_sedes`
--

CREATE TABLE `tbl_sedes` (
  `id_sedes` int(11) NOT NULL,
  `tbl_sedes_codigo` int(100) NOT NULL,
  `sedes_nombre` varchar(100) NOT NULL,
  `sedes_ciudad` varchar(100) NOT NULL,
  `sede_direccion` varchar(100) NOT NULL,
  `sede_centros_id` bigint(20) UNSIGNED NOT NULL,
  `sede_cordinacions` bigint(20) UNSIGNED NOT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `tbl_sedes`
--

INSERT INTO `tbl_sedes` (`id_sedes`, `tbl_sedes_codigo`, `sedes_nombre`, `sedes_ciudad`, `sede_direccion`, `sede_centros_id`, `sede_cordinacions`) VALUES
(1, 1, 'Sede TIC\r\n', 'Barranquilla\r\n', 'calle 68 cra 54', 24, 1),
(2, 2, 'Sede Energias ', 'Barranquilla ', 'C. 28 #22 79', 24, 1),
(3, 3, 'Sede Malambo', 'Malambo', 'C', 24, 2),
(4, 4, 'Sede Refrigeración', 'Sede Refrigeración', 'c', 24, 4),
(5, 5, 'Calle 30', 'Barranquilla', 'Calle 30', 24, 7);

-- --------------------------------------------------------

--
-- Estructura de tabla para la tabla `user`
--

CREATE TABLE `user` (
  `user_id` int(11) NOT NULL,
  `name` varchar(100) NOT NULL,
  `document` int(11) NOT NULL,
  `email` varchar(225) CHARACTER SET utf8mb4 COLLATE utf8mb4_unicode_ci NOT NULL,
  `password` varchar(100) NOT NULL,
  `detalles` varchar(225) DEFAULT NULL,
  `fichas_id` bigint(20) UNSIGNED DEFAULT NULL
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_general_ci;

--
-- Volcado de datos para la tabla `user`
--

INSERT INTO `user` (`user_id`, `name`, `document`, `email`, `password`, `detalles`, `fichas_id`) VALUES
(4, 'Jorge', 1047039410, 'jasp@gmail.com', '$2a$10$OCiJdEJmufIYa6XsZh8V5uYRlA8CAuaR..C0qWm0lLYgUyWC0LGNC', 'wef', 55),
(6, 'Helmunt', 1047036740, 'Helmunt@gmail.com', '1047036740', 'wefxcf', 55),
(7, 'Jordan', 1047036790, 'Jordan@gmail.com', '1047036790', 'wefxcf', 55);

--
-- Índices para tablas volcadas
--

--
-- Indices de la tabla `parametros`
--
ALTER TABLE `parametros`
  ADD PRIMARY KEY (`id_parametros`),
  ADD KEY `id_sedes` (`id_sedes`),
  ADD KEY `id_user` (`id_user`),
  ADD KEY `id_rol` (`id_rol`);

--
-- Indices de la tabla `rol`
--
ALTER TABLE `rol`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_centros`
--
ALTER TABLE `tbl_centros`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tbl_centros_tbl_centros_tbl_regionals_id_foreign` (`tbl_centros_tbl_regionals_id`);

--
-- Indices de la tabla `tbl_coordinacions`
--
ALTER TABLE `tbl_coordinacions`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tbl_coordinaciones_tbl_centros` (`tbl_coordinacions_tbl_centros_id`);

--
-- Indices de la tabla `tbl_fichas`
--
ALTER TABLE `tbl_fichas`
  ADD PRIMARY KEY (`id`),
  ADD KEY `tbl_fichas_tbl_fichas_tbl_coordinacions_foreign` (`tbl_fichas_tbl_coordinacions`);

--
-- Indices de la tabla `tbl_regionals`
--
ALTER TABLE `tbl_regionals`
  ADD PRIMARY KEY (`id`);

--
-- Indices de la tabla `tbl_sedes`
--
ALTER TABLE `tbl_sedes`
  ADD PRIMARY KEY (`id_sedes`),
  ADD KEY `sede_centros_id` (`sede_centros_id`),
  ADD KEY `sede_centros_id_2` (`sede_centros_id`),
  ADD KEY `sede_cordinacions` (`sede_cordinacions`);

--
-- Indices de la tabla `user`
--
ALTER TABLE `user`
  ADD PRIMARY KEY (`user_id`),
  ADD UNIQUE KEY `email` (`email`),
  ADD KEY `id_fichas` (`fichas_id`);

--
-- AUTO_INCREMENT de las tablas volcadas
--

--
-- AUTO_INCREMENT de la tabla `parametros`
--
ALTER TABLE `parametros`
  MODIFY `id_parametros` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=2;

--
-- AUTO_INCREMENT de la tabla `rol`
--
ALTER TABLE `rol`
  MODIFY `id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `tbl_centros`
--
ALTER TABLE `tbl_centros`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=167;

--
-- AUTO_INCREMENT de la tabla `tbl_coordinacions`
--
ALTER TABLE `tbl_coordinacions`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=30;

--
-- AUTO_INCREMENT de la tabla `tbl_fichas`
--
ALTER TABLE `tbl_fichas`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=90;

--
-- AUTO_INCREMENT de la tabla `tbl_regionals`
--
ALTER TABLE `tbl_regionals`
  MODIFY `id` bigint(20) UNSIGNED NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=81;

--
-- AUTO_INCREMENT de la tabla `tbl_sedes`
--
ALTER TABLE `tbl_sedes`
  MODIFY `id_sedes` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=6;

--
-- AUTO_INCREMENT de la tabla `user`
--
ALTER TABLE `user`
  MODIFY `user_id` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=9;

--
-- Restricciones para tablas volcadas
--

--
-- Filtros para la tabla `parametros`
--
ALTER TABLE `parametros`
  ADD CONSTRAINT `parametros_ibfk_1` FOREIGN KEY (`id_user`) REFERENCES `user` (`user_id`),
  ADD CONSTRAINT `parametros_ibfk_2` FOREIGN KEY (`id_sedes`) REFERENCES `tbl_sedes` (`id_sedes`),
  ADD CONSTRAINT `parametros_ibfk_3` FOREIGN KEY (`id_rol`) REFERENCES `rol` (`id`);

--
-- Filtros para la tabla `tbl_centros`
--
ALTER TABLE `tbl_centros`
  ADD CONSTRAINT `tbl_centros_ibfk_1` FOREIGN KEY (`tbl_centros_tbl_regionals_id`) REFERENCES `tbl_regionals` (`id`);

--
-- Filtros para la tabla `tbl_coordinacions`
--
ALTER TABLE `tbl_coordinacions`
  ADD CONSTRAINT `tbl_coordinaciones_tbl_centros` FOREIGN KEY (`tbl_coordinacions_tbl_centros_id`) REFERENCES `tbl_centros` (`id`);

--
-- Filtros para la tabla `tbl_fichas`
--
ALTER TABLE `tbl_fichas`
  ADD CONSTRAINT `tbl_fichas_ibfk_1` FOREIGN KEY (`tbl_fichas_tbl_coordinacions`) REFERENCES `tbl_coordinacions` (`id`);

--
-- Filtros para la tabla `tbl_sedes`
--
ALTER TABLE `tbl_sedes`
  ADD CONSTRAINT `tbl_sedes_ibfk_1` FOREIGN KEY (`sede_centros_id`) REFERENCES `tbl_centros` (`id`),
  ADD CONSTRAINT `tbl_sedes_ibfk_2` FOREIGN KEY (`sede_cordinacions`) REFERENCES `tbl_coordinacions` (`id`);

--
-- Filtros para la tabla `user`
--
ALTER TABLE `user`
  ADD CONSTRAINT `user_ibfk_1` FOREIGN KEY (`fichas_id`) REFERENCES `tbl_fichas` (`id`);
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
