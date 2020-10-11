-- MySQL dump 10.13  Distrib 8.0.21, for Linux (x86_64)
--
-- Host: localhost    Database: academia
-- ------------------------------------------------------
-- Server version	8.0.21-0ubuntu0.20.04.4

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!50503 SET NAMES utf8mb4 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Current Database: `academia`
--

CREATE DATABASE /*!32312 IF NOT EXISTS*/ `academia` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE `academia`;

--
-- Table structure for table `alumnos_curso`
--

DROP TABLE IF EXISTS `alumnos_curso`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `alumnos_curso` (
  `id` int NOT NULL AUTO_INCREMENT,
  `id_alumno` int NOT NULL,
  `id_curso` int NOT NULL,
  PRIMARY KEY (`id`),
  KEY `necesitamos_alumno_FK` (`id_alumno`),
  KEY `necesitamos_curso_FK` (`id_curso`)
) ENGINE=InnoDB AUTO_INCREMENT=11 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `alumnos_curso`
--

LOCK TABLES `alumnos_curso` WRITE;
/*!40000 ALTER TABLE `alumnos_curso` DISABLE KEYS */;
INSERT INTO `alumnos_curso` VALUES (1,1,1),(2,1,2),(3,2,1),(4,2,3),(5,3,2),(6,3,3),(7,4,1),(8,4,3),(9,6,2),(10,6,3);
/*!40000 ALTER TABLE `alumnos_curso` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cursos`
--

DROP TABLE IF EXISTS `cursos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cursos` (
  `id` int NOT NULL AUTO_INCREMENT,
  `identificador` varchar(10) NOT NULL,
  `horas` int DEFAULT NULL,
  `id_profesor` int NOT NULL,
  `id_alumno` int NOT NULL,
  `nombre` varchar(100) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `cursos_identificador_UN` (`identificador`),
  KEY `cursos_necesita_profesor_FK` (`id_profesor`)
) ENGINE=InnoDB AUTO_INCREMENT=17 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cursos`
--

LOCK TABLES `cursos` WRITE;
/*!40000 ALTER TABLE `cursos` DISABLE KEYS */;
INSERT INTO `cursos` VALUES (1,'I001',50,4,1,'Microsoft Office 2016'),(2,'I002',630,2,1,'Experto en Desarrollo de Aplicaciones WEB y Bases de Datos'),(3,'I003',510,3,2,'Desarrollo Avanzado con JAVA/JEE'),(4,'I004',60,4,2,'Microsoft Office 2016'),(10,'I005',50,4,2,'Microsoft Office 2016'),(11,'I007',50,4,4,'Microsoft Office 2016'),(12,'I006',630,2,3,'Experto en Desarrollo de Aplicaciones WEB y Bases de Datos'),(13,'I009',630,2,6,'Experto en Desarrollo de Aplicaciones WEB y Bases de Datos'),(14,'I010',510,3,4,'Desarrollo Avanzado con JAVA/JEE'),(15,'I011',510,3,3,'Desarrollo Avanzado con JAVA/JEE'),(16,'I012',510,3,6,'Desarrollo Avanzado con JAVA/JEE');
/*!40000 ALTER TABLE `cursos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuarios`
--

DROP TABLE IF EXISTS `usuarios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuarios` (
  `id_usuarios` int NOT NULL AUTO_INCREMENT,
  `nombre` varchar(100) NOT NULL,
  `apellidos` varchar(100) NOT NULL,
  `pasword` varchar(100) NOT NULL,
  `rol` int NOT NULL,
  PRIMARY KEY (`id_usuarios`),
  KEY `usuarios_FK` (`rol`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuarios`
--

LOCK TABLES `usuarios` WRITE;
/*!40000 ALTER TABLE `usuarios` DISABLE KEYS */;
INSERT INTO `usuarios` VALUES (1,'danel','roberto','698d51a19d8a121ce581499d7b701668',2),(2,'asier','txelo','550a141f12de6341fba65b0ad0433500',2),(3,'xabier','raul','bcbe3365e6ac95ea2c0343a2395834dd',2),(4,'pablo','alex','310dcbbf4cce62f762a2aaa148d556bd',2),(6,'pedro','roma','3cdf5666859f6906c283a1058cd5b9a7',1),(7,'dani','gol','28c8edde3d61a0411511d3b1866f0636',1),(8,'as','picas','c9f0f895fb98ab9159f51fd0297e236d',1);
/*!40000 ALTER TABLE `usuarios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping routines for database 'academia'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-09-18 10:05:00
