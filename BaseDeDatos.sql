CREATE DATABASE  IF NOT EXISTS `pou` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `pou`;
-- MySQL dump 10.13  Distrib 5.6.24, for osx10.8 (x86_64)
--
-- Host: 127.0.0.1    Database: pou
-- ------------------------------------------------------
-- Server version	5.5.42

/*!40101 SET @OLD_CHARACTER_SET_CLIENT=@@CHARACTER_SET_CLIENT */;
/*!40101 SET @OLD_CHARACTER_SET_RESULTS=@@CHARACTER_SET_RESULTS */;
/*!40101 SET @OLD_COLLATION_CONNECTION=@@COLLATION_CONNECTION */;
/*!40101 SET NAMES utf8 */;
/*!40103 SET @OLD_TIME_ZONE=@@TIME_ZONE */;
/*!40103 SET TIME_ZONE='+00:00' */;
/*!40014 SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0 */;
/*!40014 SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0 */;
/*!40101 SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='NO_AUTO_VALUE_ON_ZERO' */;
/*!40111 SET @OLD_SQL_NOTES=@@SQL_NOTES, SQL_NOTES=0 */;

--
-- Table structure for table `botiquin`
--

DROP TABLE IF EXISTS `botiquin`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `botiquin` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idPocima` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_pocimas_idx` (`idPocima`),
  CONSTRAINT `fk_pocimas` FOREIGN KEY (`idPocima`) REFERENCES `pocima` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `botiquin`
--

LOCK TABLES `botiquin` WRITE;
/*!40000 ALTER TABLE `botiquin` DISABLE KEYS */;
INSERT INTO `botiquin` VALUES (1,1),(2,1),(3,2),(4,3);
/*!40000 ALTER TABLE `botiquin` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `closet`
--

DROP TABLE IF EXISTS `closet`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `closet` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idCosa` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_cosas_idx` (`idCosa`),
  CONSTRAINT `fk_cosas` FOREIGN KEY (`idCosa`) REFERENCES `cosa` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `closet`
--

LOCK TABLES `closet` WRITE;
/*!40000 ALTER TABLE `closet` DISABLE KEYS */;
INSERT INTO `closet` VALUES (1,4);
/*!40000 ALTER TABLE `closet` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `comida`
--

DROP TABLE IF EXISTS `comida`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `comida` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `nivelSalud` int(11) DEFAULT NULL,
  `nivelEnergia` int(11) DEFAULT NULL,
  `nivelSatisfaccion` int(11) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  `tipoComida` enum('SNACK','FRUTA','VERDURA','CARNE') DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tipocomida_idx` (`tipoComida`)
) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `comida`
--

LOCK TABLES `comida` WRITE;
/*!40000 ALTER TABLE `comida` DISABLE KEYS */;
INSERT INTO `comida` VALUES (1,'Pollo',-1,0,10,50,'CARNE'),(2,'Manzana',3,2,4,5,'FRUTA'),(3,'Sabritas',0,0,2,12,'SNACK'),(4,'Brocoli',5,1,5,3,'VERDURA'),(5,'Higado ',10,0,15,75,'CARNE'),(6,'Guacamole',0,0,12,20,'SNACK'),(7,'Carne Asada',0,0,25,80,'CARNE'),(8,'Naranja',3,2,5,5,NULL);
/*!40000 ALTER TABLE `comida` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `cosa`
--

DROP TABLE IF EXISTS `cosa`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `cosa` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nivelEnergia` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=5 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cosa`
--

LOCK TABLES `cosa` WRITE;
/*!40000 ALTER TABLE `cosa` DISABLE KEYS */;
INSERT INTO `cosa` VALUES (1,10,'Sombrero',100),(2,15,'Zapatos',200),(3,20,'Camiseta',250),(4,5,'Boxer',50);
/*!40000 ALTER TABLE `cosa` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pocima`
--

DROP TABLE IF EXISTS `pocima`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pocima` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `tipoPocima` enum('SALUD','ENERGIA','APETITO','LLENAR_TODO') DEFAULT NULL,
  `nivelSalud` int(11) DEFAULT NULL,
  `nivelEnergia` int(11) DEFAULT NULL,
  `nivelSatisfaccion` int(11) DEFAULT NULL,
  `nombre` varchar(45) DEFAULT NULL,
  `precio` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_tipopocima_idx` (`tipoPocima`)
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pocima`
--

LOCK TABLES `pocima` WRITE;
/*!40000 ALTER TABLE `pocima` DISABLE KEYS */;
INSERT INTO `pocima` VALUES (1,'SALUD',20,0,0,'Curacion 1',20),(2,'ENERGIA',0,20,0,'Energia 1',20),(3,'APETITO',0,0,20,'Apetito 1',NULL);
/*!40000 ALTER TABLE `pocima` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `pou`
--

DROP TABLE IF EXISTS `pou`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `pou` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `nombre` varchar(45) DEFAULT NULL,
  `nivelSalud` int(11) DEFAULT NULL,
  `nivelEnergia` int(11) DEFAULT NULL,
  `nivelSatisfaccion` int(11) DEFAULT NULL,
  `dinero` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `pou`
--

LOCK TABLES `pou` WRITE;
/*!40000 ALTER TABLE `pou` DISABLE KEYS */;
/*!40000 ALTER TABLE `pou` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `refrigerador`
--

DROP TABLE IF EXISTS `refrigerador`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `refrigerador` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `idComida` int(11) DEFAULT NULL,
  PRIMARY KEY (`id`),
  KEY `fk_comidas_idx` (`idComida`),
  CONSTRAINT `fk_comidas` FOREIGN KEY (`idComida`) REFERENCES `comida` (`id`) ON DELETE NO ACTION ON UPDATE NO ACTION
) ENGINE=InnoDB AUTO_INCREMENT=4 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `refrigerador`
--

LOCK TABLES `refrigerador` WRITE;
/*!40000 ALTER TABLE `refrigerador` DISABLE KEYS */;
INSERT INTO `refrigerador` VALUES (1,1),(3,2),(2,3);
/*!40000 ALTER TABLE `refrigerador` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Dumping events for database 'pou'
--

--
-- Dumping routines for database 'pou'
--
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-11-27 20:41:17
