-- MySQL dump 10.13  Distrib 5.7.21, for osx10.9 (x86_64)
--
-- Host: 127.0.0.1    Database: corona
-- ------------------------------------------------------
-- Server version	5.7.21

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
-- Table structure for table `history`
--

DROP TABLE IF EXISTS `history`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!40101 SET character_set_client = utf8 */;
CREATE TABLE `history` (
  `id` int(11) NOT NULL AUTO_INCREMENT,
  `date_text` varchar(100) NOT NULL,
  `local_new_cases` int(11) NOT NULL,
  `local_confirmed_cases` int(11) NOT NULL,
  `global_new_cases` int(11) NOT NULL,
  `global_confirmed_cases` int(11) NOT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=28 DEFAULT CHARSET=utf8;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `history`
--

LOCK TABLES `history` WRITE;
/*!40000 ALTER TABLE `history` DISABLE KEYS */;
INSERT INTO `history` VALUES (1,'2020-03-02',0,1,1937,90306),(2,'2020-03-03',0,1,2534,92840),(3,'2020-03-04',0,1,2280,95120),(4,'2020-03-05',0,1,2766,97886),(5,'2020-03-06',0,1,3915,101801),(6,'2020-03-07',0,1,4046,105847),(7,'2020-03-08',0,1,3974,109821),(8,'2020-03-09',0,1,3769,113590),(9,'2020-03-10',0,1,5030,118620),(10,'2020-03-11',1,2,7255,125875),(11,'2020-03-12',2,4,2477,128352),(12,'2020-03-13',2,6,16853,145205),(13,'2020-03-14',5,11,10896,156101),(14,'2020-03-15',8,19,11353,167454),(15,'2020-03-16',10,29,14120,181574),(16,'2020-03-17',13,42,15528,197102),(17,'2020-03-18',11,53,17719,214821),(18,'2020-03-19',13,66,27679,242500),(19,'2020-03-20',6,72,29535,272035),(20,'2020-03-21',6,78,32361,304396),(21,'2020-03-22',9,87,32557,336953),(22,'2020-03-23',10,97,41282,378235),(23,'2020-03-24',5,102,39810,418045),(24,'2020-03-25',0,102,49548,467593),(25,'2020-03-26',2,104,48460,471311),(26,'2020-03-27',0,106,60829,532237),(27,'2020-03-28',7,113,64501,620723);
/*!40000 ALTER TABLE `history` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2020-03-28 22:57:06
