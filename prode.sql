-- MySQL dump 10.13  Distrib 8.0.32, for Win64 (x86_64)
--
-- Host: localhost    Database: prode
-- ------------------------------------------------------
-- Server version	8.0.32

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `pronostico`
--

DROP TABLE IF EXISTS `pronostico`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronostico` (
  `idPronostico` int NOT NULL AUTO_INCREMENT,
  `participante` varchar(45) NOT NULL,
  `gana_1` varchar(10) NOT NULL,
  `empata` varchar(10) NOT NULL,
  `gana_2` varchar(10) NOT NULL,
  PRIMARY KEY (`idPronostico`),
  UNIQUE KEY `idPronostico_UNIQUE` (`idPronostico`)
) ENGINE=InnoDB AUTO_INCREMENT=73 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronostico`
--

LOCK TABLES `pronostico` WRITE;
/*!40000 ALTER TABLE `pronostico` DISABLE KEYS */;
INSERT INTO `pronostico` VALUES (1,'Mariana','X','--','--'),(2,'Mariana','--','X','--'),(3,'Mariana','X','--','--'),(4,'Mariana','--','--','X'),(5,'Mariana','X','--','--'),(6,'Mariana','--','X','--'),(7,'Mariana','X','--','--'),(8,'Mariana','--','X','--'),(9,'Pedro','--','--','X'),(10,'Pedro','--','X','--'),(11,'Pedro','--','--','X'),(12,'Pedro','--','--','X'),(13,'Pedro','--','--','X'),(14,'Pedro','--','X','--'),(15,'Pedro','X','--','--'),(16,'Pedro','X','--','--'),(17,'Tomas','X','--','--'),(18,'Tomas','X','--','--'),(19,'Tomas','X','--','--'),(20,'Tomas','X','--','--'),(21,'Tomas','X','--','--'),(22,'Tomas','X','--','--'),(23,'Tomas','X','--','--'),(24,'Tomas','--','X','--'),(25,'Ana','--','--','X'),(26,'Ana','X','--','--'),(27,'Ana','X','--','--'),(28,'Ana','--','--','X'),(29,'Ana','X','--','--'),(30,'Ana','--','X','--'),(31,'Ana','--','X','--'),(32,'Ana','--','X','--'),(33,'Roberto','--','--','X'),(34,'Roberto','--','X','--'),(35,'Roberto','X','--','--'),(36,'Roberto','--','X','--'),(37,'Roberto','X','--','--'),(38,'Roberto','--','X','--'),(39,'Roberto','X','--','--'),(40,'Roberto','--','X','--'),(41,'Rosario','--','--','X'),(42,'Rosario','--','X','--'),(43,'Rosario','--','X','--'),(44,'Rosario','--','X','--'),(45,'Rosario','X','--','--'),(46,'Rosario','X','--','--'),(47,'Rosario','X','--','--'),(48,'Rosario','--','X','--'),(49,'Hector','X','--','--'),(50,'Hector','--','X','--'),(51,'Hector','X','--','--'),(52,'Hector','--','--','X'),(53,'Hector','--','X','--'),(54,'Hector','X','--','--'),(55,'Hector','--','X','--'),(56,'Hector','X','--','--'),(57,'Lucia','X','--','--'),(58,'Lucia','--','X','--'),(59,'Lucia','--','--','X'),(60,'Lucia','X','--','--'),(61,'Lucia','X','--','--'),(62,'Lucia','X','--','--'),(63,'Lucia','X','--','--'),(71,'Florencia','--','--','X'),(72,'Alfonso','--','X','--');
/*!40000 ALTER TABLE `pronostico` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pronostico_x_resultado`
--

DROP TABLE IF EXISTS `pronostico_x_resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `pronostico_x_resultado` (
  `idPxR` int NOT NULL AUTO_INCREMENT,
  `pronostico` int NOT NULL,
  `resultado` int NOT NULL,
  `fase` varchar(45) NOT NULL,
  `ronda` int NOT NULL,
  PRIMARY KEY (`idPxR`),
  UNIQUE KEY `idPxR_UNIQUE` (`idPxR`),
  KEY `pxr_resultado_idx` (`resultado`),
  KEY `pxr_pronostico_idx` (`pronostico`),
  CONSTRAINT `pxr_pronostico` FOREIGN KEY (`pronostico`) REFERENCES `pronostico` (`idPronostico`) ON UPDATE CASCADE,
  CONSTRAINT `pxr_resultado` FOREIGN KEY (`resultado`) REFERENCES `resultado` (`idResultado`) ON DELETE RESTRICT ON UPDATE CASCADE
) ENGINE=InnoDB AUTO_INCREMENT=64 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pronostico_x_resultado`
--

LOCK TABLES `pronostico_x_resultado` WRITE;
/*!40000 ALTER TABLE `pronostico_x_resultado` DISABLE KEYS */;
INSERT INTO `pronostico_x_resultado` VALUES (1,1,1,'Fase de grupos - Grupo A',1),(2,2,2,'Fase de grupos - Grupo A',1),(3,3,3,'Fase de grupos - Grupo A',1),(4,4,4,'Fase de grupos - Grupo A',1),(5,5,5,'Fase de grupos - Grupo A',1),(6,6,6,'Fase de grupos - Grupo A',1),(7,7,7,'Fase de grupos - Grupo B',2),(8,8,8,'Fase de grupos - Grupo B',2),(9,9,9,'Fase de grupos - Grupo B',2),(10,10,10,'Fase de grupos - Grupo B',2),(11,11,11,'Fase de grupos - Grupo B',2),(12,12,12,'Fase de grupos - Grupo B',2),(13,13,13,'Fase de grupos - Grupo C',3),(14,14,14,'Fase de grupos - Grupo C',3),(15,15,15,'Fase de grupos - Grupo C',3),(16,16,16,'Fase de grupos - Grupo C',3),(17,17,17,'Fase de grupos - Grupo C',3),(18,18,18,'Fase de grupos - Grupo C',3),(19,19,19,'Fase de grupos - Grupo D',4),(20,20,20,'Fase de grupos - Grupo D',4),(21,21,21,'Fase de grupos - Grupo D',4),(22,22,22,'Fase de grupos - Grupo D',4),(23,23,23,'Fase de grupos - Grupo D',4),(24,24,24,'Fase de grupos - Grupo D',4),(25,25,25,'Fase de grupos - Grupo E',5),(26,26,26,'Fase de grupos - Grupo E',5),(27,27,27,'Fase de grupos - Grupo E',5),(28,28,28,'Fase de grupos - Grupo E',5),(29,29,29,'Fase de grupos - Grupo E',5),(30,30,30,'Fase de grupos - Grupo E',5),(31,31,31,'Fase de grupos - Grupo F',6),(32,32,32,'Fase de grupos - Grupo F',6),(33,33,33,'Fase de grupos - Grupo F',6),(34,34,34,'Fase de grupos - Grupo F',6),(35,35,35,'Fase de grupos - Grupo F',6),(36,36,36,'Fase de grupos - Grupo F',6),(37,37,37,'Fase de grupos - Grupo G',7),(38,38,38,'Fase de grupos - Grupo G',7),(39,39,39,'Fase de grupos - Grupo G',7),(40,40,40,'Fase de grupos - Grupo G',7),(41,41,41,'Fase de grupos - Grupo G',7),(42,42,42,'Fase de grupos - Grupo G',7),(43,43,43,'Fase de grupos - Grupo H',8),(44,44,44,'Fase de grupos - Grupo H',8),(45,45,45,'Fase de grupos - Grupo H',8),(46,46,46,'Fase de grupos - Grupo H',8),(47,47,47,'Fase de grupos - Grupo H',8),(48,48,48,'Fase de grupos - Grupo H',8),(49,49,49,'Octavos',1),(50,50,50,'Octavos',2),(51,51,51,'Octavos',3),(52,52,52,'Octavos',4),(53,53,53,'Octavos',5),(54,54,54,'Octavos',6),(55,55,55,'Octavos',7),(56,56,56,'Octavos',8),(57,57,57,'Cuartos',1),(58,58,58,'Cuartos',2),(59,59,59,'Cuartos',3),(60,60,60,'Cuartos',4),(61,61,61,'Semifinal',1),(62,62,62,'Semifinal',2),(63,63,63,'Final',1);
/*!40000 ALTER TABLE `pronostico_x_resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado`
--

DROP TABLE IF EXISTS `resultado`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultado` (
  `idResultado` int NOT NULL AUTO_INCREMENT,
  `equipo_1` varchar(45) NOT NULL,
  `goles_equipo_1` int NOT NULL,
  `goles_equipo_2` int NOT NULL,
  `equipo_2` varchar(45) NOT NULL,
  PRIMARY KEY (`idResultado`),
  UNIQUE KEY `idResultado_UNIQUE` (`idResultado`)
) ENGINE=InnoDB AUTO_INCREMENT=65 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado`
--

LOCK TABLES `resultado` WRITE;
/*!40000 ALTER TABLE `resultado` DISABLE KEYS */;
INSERT INTO `resultado` VALUES (1,'Qatar',0,2,'Ecuador'),(2,'Senegal',0,2,'Países Bajos'),(3,'Qatar',1,3,'Senegal'),(4,'Países Bajos',1,1,'Ecuador'),(5,'Ecuador',1,2,'Senegal'),(6,'Países Bajos',2,0,'Qatar'),(7,'Inglaterra',6,2,'Irán'),(8,'Estados Unidos',1,1,'Gales'),(9,'Gales',0,2,'Irán'),(10,'Inglaterra',0,0,'Estados Unidos'),(11,'Gales',0,3,'Inglaterra'),(12,'Irán',0,1,'Estados Unidos'),(13,'Argentina',1,2,'Arabia Saudí'),(14,'México',0,0,'Polonia'),(15,'Polonia',2,0,'Arabia Saudí'),(16,'Argentina',2,0,'México'),(17,'Polonia',0,2,'Argentina'),(18,'Arabia Saudí',1,2,'México'),(19,'Dinamarca',0,0,'Túnez'),(20,'Francia',4,1,'Australia'),(21,'Túnez',0,1,'Australia'),(22,'Francia',2,1,'Dinamarca'),(23,'Australia',1,0,'Dinamarca'),(24,'Túnez',1,0,'Francia'),(25,'Alemania',1,2,'Japón'),(26,'España',7,0,'Costa Rica'),(27,'Japón',0,1,'Costa Rica'),(28,'España',1,1,'Alemania'),(29,'Japón',2,1,'España'),(30,'Costa Rica',2,4,'Alemania'),(31,'Marruecos',0,0,'Croacia'),(32,'Bélgica',1,0,'Canadá'),(33,'Bélgica',0,2,'Marruecos'),(34,'Croacia',4,1,'Canadá'),(35,'Croacia',0,0,'Bélgica'),(36,'Canadá',1,2,'Marruecos'),(37,'Suiza',1,0,'Camerún'),(38,'Brasil',2,0,'Serbia'),(39,'Camerún',3,3,'Serbia'),(40,'Brasil',1,0,'Suiza'),(41,'Camerún',1,0,'Brasil'),(42,'Serbia',2,3,'Suiza'),(43,'Uruguay',0,0,'Corea del Sur'),(44,'Ghana',2,3,'Portugal'),(45,'Corea del Sur',2,3,'Ghana'),(46,'Portugal',2,0,'Uruguay'),(47,'Corea del Sur',2,1,'Portugal'),(48,'Ghana',0,2,'Uruguay'),(49,'Países Bajos',3,1,'Estados Unidos'),(50,'Argentina',2,1,'Australia'),(51,'Francia',3,1,'Polonia'),(52,'Inglaterra',3,0,'Senegal'),(53,'Japón',1,3,'Croacia'),(54,'Brasil',4,1,'Corea del Sur'),(55,'Marruecos',3,0,'España'),(56,'Portugal',6,1,'Suiza'),(57,'Croacia',4,2,'Brasil'),(58,'Países Bajos',3,4,'Argentina'),(59,'Inglaterra',1,2,'Francia'),(60,'Marruecos',1,0,'Portugal'),(61,'Argentina',3,0,'Croacia'),(62,'Francia',2,0,'Marruecos'),(63,'Argentina',4,2,'Francia'),(64,'Polonia',0,0,'Paises');
/*!40000 ALTER TABLE `resultado` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `resultado_prode`
--

DROP TABLE IF EXISTS `resultado_prode`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `resultado_prode` (
  `idRprode` int NOT NULL AUTO_INCREMENT,
  `participante` varchar(45) NOT NULL,
  `fase` varchar(45) NOT NULL,
  `ronda` int NOT NULL,
  `puntos` int NOT NULL DEFAULT '0',
  `puntos_extras` int NOT NULL DEFAULT '0',
  `aciertos` int NOT NULL DEFAULT '0',
  PRIMARY KEY (`idRprode`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `resultado_prode`
--

LOCK TABLES `resultado_prode` WRITE;
/*!40000 ALTER TABLE `resultado_prode` DISABLE KEYS */;
INSERT INTO `resultado_prode` VALUES (12,'Mariana','Fase de grupos - Grupo A',1,0,0,0),(13,'Mariana','Fase de grupos - Grupo B',2,1,1000,1),(14,'Pedro','Fase de grupos - Grupo B',2,3,1000,3),(15,'Pedro','Fase de grupos - Grupo C',3,3,1000,3),(16,'Tomas','Fase de grupos - Grupo C',3,0,0,0),(17,'Tomas','Fase de grupos - Grupo D',4,3,0,3),(18,'Ana','Fase de grupos - Grupo E',5,2,0,2),(19,'Ana','Fase de grupos - Grupo F',6,0,0,0),(20,'Roberto','Fase de grupos - Grupo F',6,0,0,0),(21,'Roberto','Fase de grupos - Grupo G',7,0,0,0),(22,'Rosario','Fase de grupos - Grupo G',7,0,0,0),(23,'Rosario','Fase de grupos - Grupo H',8,2,0,2),(24,'Hector','Octavos',1,3,0,3),(25,'Lucia','Cuartos',1,2,0,2),(26,'Lucia','Semifinal',1,1,1000,1),(27,'Lucia','Final',1,1,1000,1);
/*!40000 ALTER TABLE `resultado_prode` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2023-04-26 18:52:55
