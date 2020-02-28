CREATE DATABASE  IF NOT EXISTS `polish` /*!40100 DEFAULT CHARACTER SET latin1 */;
USE `polish`;
-- MySQL dump 10.13  Distrib 8.0.19, for Win64 (x86_64)
--
-- Host: cis175.ctbyl9xuofqy.us-east-2.rds.amazonaws.com    Database: polish
-- ------------------------------------------------------
-- Server version	5.7.22-log

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
-- Table structure for table `items`
--

DROP TABLE IF EXISTS `items`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items` (
  `ID` int(11) NOT NULL AUTO_INCREMENT,
  `BRAND` varchar(20) NOT NULL,
  `COLOR` varchar(35) NOT NULL,
  PRIMARY KEY (`ID`)
) ENGINE=InnoDB AUTO_INCREMENT=44 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items`
--

LOCK TABLES `items` WRITE;
/*!40000 ALTER TABLE `items` DISABLE KEYS */;
INSERT INTO `items` VALUES (1,'MAC','Red'),(7,'Maybelline','White'),(10,'MAC','Green'),(11,'Covergirl','Blue'),(28,'Covergirl','Sunny'),(35,'Covergirl','Gold'),(36,'MAC','Red'),(37,'Covergirl','Gold'),(38,'MAC','Red'),(39,'Almay','Avengers'),(40,'Almay','Hulk'),(41,'Almay','Hulk Green'),(42,'Eve','Forest'),(43,'Almay','Turtle Green');
/*!40000 ALTER TABLE `items` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `items_on_list`
--

DROP TABLE IF EXISTS `items_on_list`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `items_on_list` (
  `ITEMS_ID` int(11) NOT NULL,
  `LIST_ID` int(11) NOT NULL,
  KEY `LIST_ID` (`LIST_ID`),
  KEY `ITEMS_ID` (`ITEMS_ID`),
  CONSTRAINT `items_on_list_ibfk_1` FOREIGN KEY (`LIST_ID`) REFERENCES `list_details` (`LIST_ID`),
  CONSTRAINT `items_on_list_ibfk_2` FOREIGN KEY (`ITEMS_ID`) REFERENCES `items` (`ID`)
) ENGINE=InnoDB DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `items_on_list`
--

LOCK TABLES `items_on_list` WRITE;
/*!40000 ALTER TABLE `items_on_list` DISABLE KEYS */;
INSERT INTO `items_on_list` VALUES (36,14),(35,14),(38,15),(37,15),(40,16),(35,17),(1,18),(11,19),(7,20),(28,21);
/*!40000 ALTER TABLE `items_on_list` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `list_details`
--

DROP TABLE IF EXISTS `list_details`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `list_details` (
  `LIST_ID` int(11) NOT NULL AUTO_INCREMENT,
  `LIST_NAME` varchar(30) DEFAULT NULL,
  `TRIP_DATE` date DEFAULT NULL,
  `SHOPPER_ID` int(11) DEFAULT NULL,
  PRIMARY KEY (`LIST_ID`),
  KEY `SHOPPER_ID` (`SHOPPER_ID`),
  CONSTRAINT `list_details_ibfk_1` FOREIGN KEY (`SHOPPER_ID`) REFERENCES `shopper` (`SHOPPER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=22 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `list_details`
--

LOCK TABLES `list_details` WRITE;
/*!40000 ALTER TABLE `list_details` DISABLE KEYS */;
INSERT INTO `list_details` VALUES (14,'Tony\'s List','2020-02-27',23),(15,'Tony\'s List','2020-02-27',24),(16,'Wonder','2020-02-27',25),(17,'Wonder ','2020-02-27',26),(18,'Captain','2020-02-28',27),(19,'Tower','2020-02-27',28),(20,'Cameron','2020-02-20',29),(21,'Wonder','2020-01-23',30);
/*!40000 ALTER TABLE `list_details` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `shopper`
--

DROP TABLE IF EXISTS `shopper`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `shopper` (
  `SHOPPER_ID` int(11) NOT NULL AUTO_INCREMENT,
  `SHOPPER_NAME` varchar(30) NOT NULL,
  PRIMARY KEY (`SHOPPER_ID`)
) ENGINE=InnoDB AUTO_INCREMENT=31 DEFAULT CHARSET=latin1;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `shopper`
--

LOCK TABLES `shopper` WRITE;
/*!40000 ALTER TABLE `shopper` DISABLE KEYS */;
INSERT INTO `shopper` VALUES (1,'Bill'),(2,'Bill'),(3,'Stark'),(4,'Stark'),(5,'Stark'),(9,'Stark'),(10,'Stark'),(11,'Stark'),(12,'Stark'),(13,'Stark'),(14,'Stark'),(15,'Stark'),(16,'Stark'),(17,'Stark'),(18,'Stark'),(19,'Stark'),(20,'Stark'),(21,'Stark'),(22,'Stark'),(23,'Tony'),(24,'Tony'),(25,'Hello'),(26,'Woman'),(27,'America'),(28,'Hotel'),(29,'Stop'),(30,'Batgirl');
/*!40000 ALTER TABLE `shopper` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-02-27 21:51:40
