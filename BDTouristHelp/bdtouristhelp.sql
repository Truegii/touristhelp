-- phpMyAdmin SQL Dump
-- version 5.2.1
-- https://www.phpmyadmin.net/
--
-- Servidor: 127.0.0.1
-- Tiempo de generación: 28-05-2024 a las 18:17:12
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
(1, 'Parque de las Leyendas', 'Es un zoológico ubicado en el distrito de San Miguel, en la ciudad de Lima, capital del Perú. Es administrado por la Municipalidad Metropolitana de Lima. Es el zoológico mas influyente, grande y visitado en todo el país, tiene además zonas de recreación y diversión, museos, jardín botánico, entre otras instalaciones.', 'https://upload.wikimedia.org/wikipedia/commons/c/c1/Entrada_principal_Parque_de_las_Leyendas.jpg', 'Lima', 4.4, 'Av. Parque de las Leyendas, San Miguel 15088'),
(2, 'Plaza Mayor de Lima', 'La plaza Mayor de Lima o plaza de Armas de Lima es el sitio fundacional de la ciudad de Lima, capital del Peru. Es el principal espacio publico de la ciudad. Esta ubicada en el centro historico de Lima, a su alrededor se levantan sobriamente el Palacio de Gobierno del Peru, la Catedral de Lima, la Iglesia del Sagrario, el Palacio Arzobispal de Lima, el Palacio Municipal de Lima y el Club de la Union.', 'https://upload.wikimedia.org/wikipedia/commons/thumb/0/04/Lima_-_Plaza_Mayor_-_Fontaine.jpg/1280px-Lima_-_Plaza_Mayor_-_Fontaine.jpg', 'Lima', 4.8, 'Jr. Junin cdra. 1, Lima 15001'),
(3, 'Huacachina', 'La laguna de Huacachina es un gran oasis de aguas sulfurosas ubicado a cinco kilometros al oeste del departamento peruano Ica, en medio del desierto costero del oceano Pacifico. De aguas color verde, surgio debido al afloramiento de corrientes subterraneas y alrededor de ella hay una abundante vegetacion compuesta de palmeras, eucaliptos (especies introducidas) y la especie de algarrobo conocida como huarango, la que sirve para el descanso de las aves voladoras que pasan por esta region.', 'https://www.peru.travel/Contenido/Atractivo/Imagen/es/522/1.1/Principal/huacachina-laguna.jpg', 'Ica', 4.6, 'W66Q+V58, Huacachina 11000'),
(4, 'Lineas de Nazca', 'Las lineas de Nazca y geoglifos de pampas de Jumana o simplemente lineas de Nazca o Nasca son antiguos geoglifos​ que se encuentran en las pampas de Jumana, en el desierto de Nazca, entre las poblaciones de Nazca y Palpa, en el departamento de Ica (Peru). Fueron trazadas por la cultura nazca y estan compuestas por varios cientos de figuras que abarcan desde disenos tan simples como lineas, hasta complejas figuras zoomorfas, fitomorfas y geometricas que aparecen trazadas sobre la superficie terrestre. Desde 1994, el Comite de la Unesco ha inscrito Las lineas y geoglifos de Nazca y de Pampas de Jumana como Patrimonio de la Humanidad.', 'https://culturanazca.com/wp-content/uploads/2020/05/linea-2.jpg', 'Ica', 4.5, '8V4P+FC5, 11350'),
(5, 'Saqsaywaman', 'Sacsayhuaman o Sacsahuaman (del quechua Saqsaywaman (pukara), (fortaleza) del aguila real) es un templo ceremonial usado por los incas, ubicada a dos kilometros al norte de la ciudad de Cuzco (Peru). Se comenzo a construir durante el gobierno del sapa inca Pachacutec, en el siglo xv; sin embargo, fue Huayna Capac quien la culmino en el siglo xvi.', 'https://image-tc.galaxy.tf/wijpeg-3lu4nh2rfrshc3fhyf06l99yx/6_standard.jpg?crop=105%2C0%2C1691%2C1268&width=1140', 'Cusco', 4.7, 'Cusco 08002'),
(6, 'Lago Titicaca', 'El Titicaca (en aimara y en quechua sureño, ortografía contemporánea: Titiqaqa) es el lago navegable más alto del mundo, ubicado en los Andes centrales, dentro de la meseta del Collao, a una altitud media de 3812 m s. n. m. entre los territorios de Bolivia y Perú. Posee un área de 8300 km² de los cuales el 56 % (4996 km²) corresponden a Perú y el 44 % (3304 km²) a Bolivia,​ su profundidad máxima se estima en 281 m y se calcula su profundidad media en 107 m. Su nivel es irregular y aumenta durante el verano austral.', 'https://www.camepe.com/wp-content/uploads/2022/01/titicaca.jpg', 'Puno', 4.0, '15°49′30″S 69°19′30″O'),
(7, 'Complejo Turístico de Quistococha', 'El Complejo Turístico de Quistococha, también conocido como Parque Turístico de Quistococha, es un complejo de entretenimiento en la Ciudad de Iquitos, Perú. Ubicado en la región sureña de Iquitos Metropolitano, es el único parque turístico del Departamento de Loreto y está considerada oficialmente como un «Parque Turístico Nacional» dentro el Sistema de Reservas Turísticas Nacionales del Perú.1​ El complejo está contiguo a la Ruta Departamental LO-103 y es un notable atractivo turístico para el dinamismo de Iquitos.', 'https://blog.redbus.pe/wp-content/uploads/2018/05/Laguna-Quistococha.jpg', 'Loreto', 4.2, 'Ruta Departamental LO-103, km 6.3'),
(8, 'Parque de la Identidad Wanka', 'El Parque de la Identidad Huanca se encuentra en Huancayo, Perú.​ Inició su construcción en 1992 y concluyó en 1996. Tiene un tamaño de 5800 m². El parque alberga canales, estatuas y portales con características de la región.', 'https://www.iperu.org/wp-content/uploads/2016/01/parque-de-la-identidad-huanca.jpg', 'Junin', 4.5, 'San Jorge 600, Huancayo 12001'),
(9, 'Mirador de la Virgen Inmaculada Concepción', 'El mirador de la estatua de la Virgen Inmaculada Concepción, está ubicado en el Cerro Piedra Parada, cuenta con iluminación de noche, mostrándonos un panorama especial y digno de portada tanto de día y de noche.\r\nLa estatua de la Virgen tiene una altura total de 29.90 m. (estatua 20.40m, más el pedestal 5, y más la corona 4.50 m), posee un peso aproximado de 240 TM, la corona tiene un diámetro de 1.84 m. Su construcción tardó 08 meses utilizando el material de concreto armado, y fue inaugurado el 07 de diciembre de 2006. A los pies de la virgen se encuentra el altar para la realización de misas, rodeado de jardines y alegorías representativas de las actividades económicas de la ciudad. En su interior se encuentra el museo de exposición de fotografías de la construcción de la estatua, asimismo, la historia que realza a la Provincia de Concepción.', 'https://www.bitacorarevista.com/web/wp-content/uploads/web-Complejo-Tur%C3%ADstico-Piedra-Parada-3-1200x675.jpg', 'Junin', 4.5, 'Av. Mariscal Caceres, Concepción 12125'),
(10, 'Parque nacional del Manu', 'El parque nacional del Manu​ es un espacio natural protegido localizado en el sureste del Perú, ubicado parcialmente en los departamentos de Madre de Dios y Cuzco, entre las provincias del Manu y Paucartambo. Con un área de 1 909 806 ha, se divide en 3 grandes zonas: el parque nacional con 1 716 295 ha, el área reservada y la zona de amortiguamiento.', 'https://elperuano.pe/fotografia/thumbnail/2023/05/28/000250044M.jpg', 'Madre de Dios', 4.5, '12°08′S 71°40′O'),
(11, 'Parque la Lupuna', 'En el parque la Lupuna destaca una gigantesca lupuna de unos 200 años de antigüedad, el único tipo de árbol maderable en la zona urbana marginal de Pucallpa, que actualmente se encuentra casi extinto debido a su explotación indiscriminada.\r\nEn una de sus ramas se puede ver una cruz de metal de 60 cm, pues cuentan los lugareños que en esa zona aparecían seres extraños y en las noches era difícil transitar por allí, ya que asomaban duendecillos y animales gigantes, entre otros.', 'https://www.iperu.org/wp-content/uploads/2016/01/parque-la-lupuna.jpg', 'Ucayali', 4.0, 'Carretera Antigua, Jr. Antunez de Mayolo, Pucallpa'),
(12, 'Plaza Mayor de Huamanga', 'La plaza de Armas, llamada informalmente plaza de Sucre por la estatua erigida en ella, es la principal plaza pública y lugar fundacional de la ciudad peruana de Ayacucho.', 'https://huancaraylla.com.pe/wp-content/uploads/2022/05/Full-day-City-Tour-en-Ayacucho-Peru1-800x600-2.jpg', 'Ayacucho', 4.5, 'Andahuaylas 05003'),
(13, 'Parque Natural de Pucallpa', 'El Parque Natural de Pucallpa es un zoológico situado en la margen sur de la ciudad de Pucallpa, Perú. Su nombre coincide a ser un centro turístico natural de singular belleza paisajista y calidad ambiental siendo un área eco-urbana. Además de ello es un atractivo cultural donde se incorpora una museo regional y una zona de esparcimiento familiar. Actualmente gestionado por la Gerencia Regional de Recursos Naturales y Gestión del Medio Ambiente del Gobierno regional de Ucayali.', 'https://cdn.www.gob.pe/uploads/document/file/2798125/PARQUE%202.jpg.jpg', 'Ucayali', 3.8, 'Jose Balta, Pucallpa 25002'),
(14, 'Bosque de Piedras de Huayllay', 'El Bosque de piedras de Huayllay está ubicado en el distrito de Huayllay, provincia y departamento de Pasco, Perú tiene una extensión de 6000 ha.​ Está protegido desde 1974 por el establecimiento del Santuario nacional de Huayllay. Constituye una maravilla natural andina, a 4,310 metros sobre el nivel del mar.', 'https://blog.redbus.pe/wp-content/uploads/2019/10/000216072W-696x522.jpg', 'Pasco', 4.6, 'Carr. Vencedores de Sángrar, 19500'),
(15, 'Plaza Principal de Pozuzo', 'Fue construida posterior a la época de la Pacificación Nacional durante el año 2018. Entre los sucesos importantes que se vivieron, fue la concurrencia, residencia y punto de encuentro temporal de colonos austro alemanes, migrantes y aventureros que enrumbaron hacia la colonización de las montañas del Pozuzo; En la actualidad el recurso y sus alrededores son escenarios de múltiples actividades artísticas cívicas, patrióticas y turísticas. Es una plaza temática cuya composición de su arquitectura presenta una moderna fuente de agua y estructuras con tejado y techo de estilo europeo; así mismo es ornamentada con flores, áreas verdes y palmeras, también resaltan diferentes esculturas tanto modernas como las que representan a la pluriculturalidad de la zona, ilustrando así la cultura Andina, Austro Alemán y Cacataibo.', 'https://blog.redbus.pe/wp-content/uploads/2018/08/Plaza-de-Armas-de-Pozuzo.jpg', 'Pasco', 4.7, 'Pozuzo 19250'),
(16, 'Circuito Mágico del Agua', 'El Parque de la Reserva es un espacio público ajardinado ubicado en la urbanización Santa Beatriz, en el distrito de Lima, en ciudad homónima, capital del Perú. De configuración irregular, se ubica entre dos de las principales calles de la ciudad, la vía rápida Paseo de la República y la avenida Arequipa.', 'https://elcomercio.pe/resizer/lmXjQywhUvQ8nfXxrmusuwnFkv8=/580x330/smart/filters:format(jpeg):quality(75)/cloudfront-us-east-1.images.arcpublishing.com/elcomercio/LKDVGGWFYRF6VCFOUX3SK5IALA.jpg', 'Lima', 4.5, 'Jirón Madre de Dios S/N, Lima 15046'),
(17, 'Museo Larco', 'El Museo Arqueológico Rafael Larco Herrera, conocido como Museo Larco, es un museo de arte precolombino, ubicado en el distrito de Pueblo Libre, en la ciudad de Lima, capital del Perú. Fue fundado en 1926, por Rafael Larco Hoyle.', 'https://www.inkanmilkyway.com/wp-content/uploads/2019/11/museo-larco-lima-peru.jpg', 'Lima', 4.7, 'Av. Simón Bolivar 1515 Ingreso por, Navarra 169, Pueblo Libre'),
(18, 'Plaza José de San Martín', 'La plaza San Martín es un espacio público ubicado en la cuadra 9 de la avenida Nicolás de Piérola dentro del centro histórico de Lima en Perú. En 1988 fue declarada Patrimonio de la Humanidad por la UNESCO y es considerado uno de los espacios públicos más representativos de la ciudad de Lima.', 'https://www.limatourperu.com/wp-content/uploads/city-tour-lima-plaza-san-martin-lima.jpg', 'Lima', 4.3, 'Av. Nicolás de Piérola cdra. 9, Lima'),
(19, 'Puente de los Suspiros', 'El Puente de los Suspiros es un paso elevado peatonal de madera ubicado en el distrito limeño de Barranco. Es uno de los lugares más turísticos del histórico distrito, ​​ y un punto de encuentro de parejas de enamorados.', 'https://imgmedia.elpopular.pe/640x358/elpopular/original/2023/03/04/640355f6d37f9523fa1b1cae.webp', 'Lima', 4.5, 'Jr. Batallón 271, Barranco 15063'),
(20, 'Catedral de Ayacucho', 'La Catedral de Ayacucho es la principal catedral barroca en la ciudad homónima. Está bajo propiedad de la Iglesia católica, y fue declarada como Patrimonio Histórico Cultural de la Nación del Perú en 1972. Ubicada en la Plaza de Armas. Su construcción se inició en 1632 y concluyó en 1672', 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/09/a8/8f/93/basilica-catedral-de.jpg?w=1200&h=-1&s=1', 'Ayacucho', 4.7, '2 De Mayo, Ayacucho 05003'),
(21, 'Museo Histórico Regional Hipólito Unanue', 'El Museo Histórico Regional Hipólito Unanue es un museo arqueología y antropología de la ciudad de Ayacucho.Se encuentra en la cuadra 5 de Jr. Independencia. Fue creado en el año 1974, en homenaje al sesquicentenario de la Batalla de Ayacucho.', 'https://museos.cultura.pe/sites/default/files/styles/carrusel_museo_full/public/museos/galeria/rnm_1388030799.JPG?itok=7JYtyhVt', 'Ayacucho', 4.2, 'Independencia 502, Ayacucho 05001'),
(22, 'Plaza de Armas de Tumbes', 'La Plaza de armas de Tumbes es una plaza ubicada en la ciudad de Tumbes. Allí se encuentra la Catedral de Tumbes. Tiene una concha acústica decorada con mosaicos coloridos.', 'https://www.iperu.org/wp-content/uploads/2016/01/plaza-de-armas-de-tumbes.jpg', 'Tumbes', 4.2, 'San Martin 241, Tumbes 24001'),
(23, 'Catedral San Nicolás de Tolentino', 'La catedral de Tumbes o iglesia matriz San Nicolás de Tolentino es el nombre que recibe un templo afiliado y propiedad de la Iglesia católica ubicado en la localidad de Tumbes en el departamento del mismo nombre al norte del país sudamericano de Perú. Está ubicado específicamente en la plaza mayor de Tumbes', 'https://peru.viajandox.com/uploads/attractive_428.jpg', 'Tumbes', 4.5, 'Miguel Grau 401, Tumbes 24001'),
(24, 'Museo de Sitio Cabeza de Vaca “Gran Chilimasa”', 'Cabeza de Vaca es un complejo arqueológico situado en el distrito de Corrales, provincia de Tumbes, departamento de Tumbes y cuenta con una extensión de 69.39 hectáreas.', 'https://content.emarket.pe/common/collections/content/7a/af/7aafa138-dc19-474c-825d-4584af6c4654.png', 'Tumbes', 4.3, '9GX5+3W8, Province, Corrales 24500'),
(25, 'Santuario Nacional, Los Manglares de Tumbes', 'El Santuario Nacional Los Manglares de Tumbes es un área protegida del Perú que abarca una porción de la ecorregión del Golfo de Guayaquil, conocidos localmente como Manglares de Tumbes. Se sitúa en la sección más septentrional de la costa pacífica del país.', 'https://www.iperu.org/wp-content/uploads/2016/01/santuario-nacional-manglares-de-tumbes.jpg', 'Tumbes', 4.6, '3°30′00″S 80°29′00″O / -3.5, -80.4833'),
(26, 'Museo Contisuyo', 'El Museo Contisuyo es un museo peruano, que está situado en el departamento de Moquegua. Está ubicada en lo que era parte de la Iglesia Matriz de Moquegua. El museo está dedicado a la historia de Moquegua. Alberga piezas de la cultura Wari, Tiahuanaco, Chiribaya, Tumilaca y Estuquiña', 'https://www.museocontisuyo.com/images/article/170227/123e.jpg?nocache=1715656941', 'Moquegua', 4.4, 'R348+M4V, C. Moquegua, Moquegua 18001'),
(27, 'Museo Chiribaya', 'El Museo Chiribaya es un museo peruano que está situado en el distrito de El Algarrobal, provincia de Ilo, de departamento de Moquegua. El museo está dedicado principalmente a la cultura Chiribaya', 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/09/df/7c/3c/museo-chiribaya.jpg?w=700&h=-1&s=1', 'Moquegua', 4.2, 'El Algarrobal 18620'),
(28, 'Baños Termales de Cuchumbaya', 'Las aguas termales de Cuchumbaya provienen del Volcán Tixani que se encuentra cercano al distrito de Cuchumbaya. Estas aguas brotan de entre peñas rocosas a una temperatura de 65 °C que luego se combina con agua fría, para después ser conducido por tubos hasta los baños termales.', 'https://www.chullostravelperu.com/wp-content/uploads/2023/04/Aguas-termales-de-cuchumbaya-2.jpg', 'Moquegua', 3.5, 'Plaza Cuchumbaya, MO-102 18410, 18410'),
(29, 'La Glorieta José Gálvez', 'Es un mirador levantado sobre un peñasco del litoral, al que se accede a través de un puente de madera (Puente Venus). Es un símbolo que caracteriza a Ilo. Desde la glorieta José Gálvez se observa una hermosa vista del mar, embarcaciones, aves que vuelan sobre las rocas cercanas y, ocasionalmente, lobos marinos.', 'https://dynamic-media-cdn.tripadvisor.com/media/photo-o/14/2c/f3/4b/glorieta-jose-galvez.jpg?w=1200&h=-1&s=1', 'Moquegua', 4.3, '9M43+FQW Muelle artesanal, Ilo 18601'),
(30, 'Chan Chan', 'Chan Chan es una ciudad precolombina de adobe, construida en la costa norte del Perú por los chimúes. Es la ciudad construida en adobe más grande de América y del mundo. Se ubica al noroeste del área metropolitana de Trujillo entre los distritos de Trujillo y Huanchaco.', 'https://www.peruhop.com/wp-content/uploads/Mascotte-of-Chan-Chan-Small.jpg', 'La Libertad', 4.6, 'VWVG+Q5C, Huanchaco');

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
  MODIFY `idzona` int(11) NOT NULL AUTO_INCREMENT, AUTO_INCREMENT=31;
COMMIT;

/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
