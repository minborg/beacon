-- MySQL dump 10.13  Distrib 5.5.43, for debian-linux-gnu (x86_64)
--
-- Host: localhost    Database: speedment_stat
-- ------------------------------------------------------
-- Server version	5.5.43-0ubuntu0.14.04.1

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
-- Table structure for table `beacon`
--

DROP TABLE IF EXISTS `beacon`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beacon` (
  `id` bigint(20) unsigned NOT NULL AUTO_INCREMENT,
  `created` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  `ipAddress` char(64) NOT NULL,
  PRIMARY KEY (`id`),
  KEY `created` (`created`)
) ENGINE=InnoDB AUTO_INCREMENT=133 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beacon`
--

LOCK TABLES `beacon` WRITE;
/*!40000 ALTER TABLE `beacon` DISABLE KEYS */;
/*!40000 ALTER TABLE `beacon` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beacon_property`
--

DROP TABLE IF EXISTS `beacon_property`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beacon_property` (
  `beacon` bigint(20) unsigned NOT NULL,
  `key` int(10) unsigned NOT NULL,
  `value` text,
  PRIMARY KEY (`beacon`,`key`),
  KEY `key` (`key`),
  KEY `beacon` (`beacon`),
  CONSTRAINT `FK_beacon` FOREIGN KEY (`beacon`) REFERENCES `beacon` (`id`),
  CONSTRAINT `FK_beacon_property_key` FOREIGN KEY (`key`) REFERENCES `beacon_property_key` (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beacon_property`
--

LOCK TABLES `beacon_property` WRITE;
/*!40000 ALTER TABLE `beacon_property` DISABLE KEYS */;
/*!40000 ALTER TABLE `beacon_property` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `beacon_property_key`
--

DROP TABLE IF EXISTS `beacon_property_key`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `beacon_property_key` (
  `id` int(10) unsigned NOT NULL AUTO_INCREMENT,
  `key` char(64) NOT NULL,
  PRIMARY KEY (`id`),
  UNIQUE KEY `key` (`key`)
) ENGINE=InnoDB AUTO_INCREMENT=107 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `beacon_property_key`
--

LOCK TABLES `beacon_property_key` WRITE;
/*!40000 ALTER TABLE `beacon_property_key` DISABLE KEYS */;
INSERT INTO `beacon_property_key` VALUES (104,'comment'),(106,'ip-address-name'),(103,'path'),(101,'referer'),(102,'site'),(100,'user-agent'),(105,'version');
/*!40000 ALTER TABLE `beacon_property_key` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usage`
--

DROP TABLE IF EXISTS `usage`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `usage` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `site` text NOT NULL,
  `artifact` text,
  `timeStamp` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP,
  `count` int(20) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=103 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usage`
--

LOCK TABLES `usage` WRITE;
/*!40000 ALTER TABLE `usage` DISABLE KEYS */;
INSERT INTO `usage` VALUES (95,'maven','ace-core','2015-01-14 23:00:00',23),(96,'maven','ace-core','2015-02-14 23:00:00',35),(97,'maven','ace-core','2015-03-14 23:00:00',41),(98,'maven','ace-core','2015-04-14 22:00:00',11),(99,'maven','ace-core','2015-05-14 22:00:00',51),(100,'maven','speedment','2015-06-14 22:00:00',32),(101,'maven','speedment-maven-plugin','2015-06-14 22:00:00',30),(102,'maven','ace-core','2015-06-14 22:00:00',7);
/*!40000 ALTER TABLE `usage` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2015-07-16 14:22:49
