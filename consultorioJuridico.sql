-- MySQL dump 10.13  Distrib 8.0.17, for Win64 (x86_64)
--
-- Host: 127.0.0.1    Database: consultorio_juridico_unicah
-- ------------------------------------------------------
-- Server version	8.0.17

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
-- Table structure for table `cliente`
--

DROP TABLE IF EXISTS `cliente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `cliente` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdMunicipios` int(11) NOT NULL,
  `NumeroIdentidad` varchar(13) NOT NULL,
  `IdDepartamento` int(11) NOT NULL,
  `NombreCompleto` varchar(100) NOT NULL,
  `Edad` int(3) NOT NULL,
  `Direccion` varchar(100) NOT NULL,
  `TelefonoFijo` varchar(10) NOT NULL,
  `TelefonoMovil` varchar(10) NOT NULL,
  `EstadoCivil` enum('Soltero','Casado','Viudo','UnionDeHecho') NOT NULL,
  `FechaNacimiento` varchar(15) NOT NULL,
  `LugarDeNacimiento` varchar(100) NOT NULL,
  `NombreDelReferente` varchar(45) NOT NULL,
  `TelefonoDelReferente` varchar(10) NOT NULL,
  `Salario` varchar(25) DEFAULT NULL,
  `OtrosIngresos` varchar(35) DEFAULT NULL,
  `CantidadPersonasDependientes` varchar(2) DEFAULT NULL,
  `Parentesco` varchar(25) DEFAULT NULL,
  `TipoVivienda` varchar(20) NOT NULL,
  `EstadoVivienda` varchar(10) NOT NULL,
  `PersonasHabitando` varchar(2) DEFAULT NULL,
  `Transporte` varchar(20) NOT NULL,
  `Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `fk_IdMunicipio_idx` (`IdMunicipios`),
  KEY `fk_IdDepartamento_idx` (`IdDepartamento`),
  CONSTRAINT `fk_IdDepartamento` FOREIGN KEY (`IdDepartamento`) REFERENCES `departamento` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `cliente`
--

LOCK TABLES `cliente` WRITE;
/*!40000 ALTER TABLE `cliente` DISABLE KEYS */;
/*!40000 ALTER TABLE `cliente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `datoseconomicos`
--

DROP TABLE IF EXISTS `datoseconomicos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `datoseconomicos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdParentesco` int(11) NOT NULL,
  `CantidadAportada` varchar(30) DEFAULT NULL,
  `IdCliente` int(11) NOT NULL,
  `Parentesco` enum('Padres','Abuelos','Tios','Hijos','Otros') NOT NULL,
  `Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `fk_Id_Parentesco_idx` (`IdParentesco`),
  KEY `fk_ID_Usuario_idx2` (`IdCliente`),
  CONSTRAINT `fk_ID_Usuario2` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`Id`),
  CONSTRAINT `fk_Id_Parentesco` FOREIGN KEY (`IdParentesco`) REFERENCES `parentesco` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `datoseconomicos`
--

LOCK TABLES `datoseconomicos` WRITE;
/*!40000 ALTER TABLE `datoseconomicos` DISABLE KEYS */;
/*!40000 ALTER TABLE `datoseconomicos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `departamento`
--

DROP TABLE IF EXISTS `departamento`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `departamento` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NombreDepartamento` varchar(45) NOT NULL,
  `Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `departamento`
--

LOCK TABLES `departamento` WRITE;
/*!40000 ALTER TABLE `departamento` DISABLE KEYS */;
INSERT INTO `departamento` VALUES (1,'Colon','2019-12-04 17:13:50');
/*!40000 ALTER TABLE `departamento` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `egresos`
--

DROP TABLE IF EXISTS `egresos`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `egresos` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `TipoEgresos` varchar(20) NOT NULL,
  `IdCliente` int(11) NOT NULL COMMENT '\\n\\n',
  `Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `FK_ID_Usuarios_idx` (`IdCliente`),
  CONSTRAINT `FK_ID_Usuarios` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `egresos`
--

LOCK TABLES `egresos` WRITE;
/*!40000 ALTER TABLE `egresos` DISABLE KEYS */;
/*!40000 ALTER TABLE `egresos` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `expediente`
--

DROP TABLE IF EXISTS `expediente`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `expediente` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `IdServicio` int(11) NOT NULL,
  `IdCliente` int(11) NOT NULL,
  `Creacion` datetime DEFAULT CURRENT_TIMESTAMP,
  `NombredelDemandado` varchar(70) DEFAULT NULL,
  `DirecciondelDemandado` varchar(100) DEFAULT NULL,
  `InformaciondelTramite` varchar(250) DEFAULT NULL,
  `DiagnosticodelCaso` varchar(30) DEFAULT NULL,
  `EstadodelCaso` enum('Aprobado','RechazadoProvisionalmente','RechazadoTotalmente') DEFAULT NULL,
  `Rechazadopor` enum('CapacidadEconomica','CasoFueradelReglamento','FaltadeDocumentos','ZonadeAltoRiesgo','Otros') DEFAULT NULL,
  `IdUsuario` int(11) NOT NULL,
  `FechadeAsignacion` timestamp NULL DEFAULT NULL,
  `ObservacionesComentarios` varchar(150) DEFAULT NULL,
  PRIMARY KEY (`Id`),
  KEY `ExpedienteCliente_idx` (`IdCliente`),
  KEY `ExpedienteServicio_idx` (`IdServicio`),
  KEY `ExpedienteUsuario_idx` (`IdUsuario`),
  CONSTRAINT `ExpedienteCliente` FOREIGN KEY (`IdCliente`) REFERENCES `cliente` (`Id`),
  CONSTRAINT `ExpedienteServicio` FOREIGN KEY (`IdServicio`) REFERENCES `servicio` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT,
  CONSTRAINT `ExpedienteUsuario` FOREIGN KEY (`IdUsuario`) REFERENCES `usuario` (`Id`) ON DELETE RESTRICT ON UPDATE RESTRICT
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `expediente`
--

LOCK TABLES `expediente` WRITE;
/*!40000 ALTER TABLE `expediente` DISABLE KEYS */;
/*!40000 ALTER TABLE `expediente` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `municipios`
--

DROP TABLE IF EXISTS `municipios`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `municipios` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NombreMunicipios` varchar(50) NOT NULL,
  `idDepartamento` int(11) NOT NULL,
  `Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`),
  KEY `fk_id_departamento_idx` (`idDepartamento`),
  CONSTRAINT `fk_id_departamento` FOREIGN KEY (`idDepartamento`) REFERENCES `departamento` (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `municipios`
--

LOCK TABLES `municipios` WRITE;
/*!40000 ALTER TABLE `municipios` DISABLE KEYS */;
INSERT INTO `municipios` VALUES (1,'tocoa',1,'2019-12-04 17:16:05');
/*!40000 ALTER TABLE `municipios` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `parentesco`
--

DROP TABLE IF EXISTS `parentesco`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `parentesco` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Parentesco` varchar(20) DEFAULT NULL,
  `Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `parentesco`
--

LOCK TABLES `parentesco` WRITE;
/*!40000 ALTER TABLE `parentesco` DISABLE KEYS */;
/*!40000 ALTER TABLE `parentesco` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `servicio`
--

DROP TABLE IF EXISTS `servicio`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `servicio` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `Tramite` varchar(60) NOT NULL,
  `Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `servicio`
--

LOCK TABLES `servicio` WRITE;
/*!40000 ALTER TABLE `servicio` DISABLE KEYS */;
/*!40000 ALTER TABLE `servicio` ENABLE KEYS */;
UNLOCK TABLES;

--
-- Table structure for table `usuario`
--

DROP TABLE IF EXISTS `usuario`;
/*!40101 SET @saved_cs_client     = @@character_set_client */;
/*!50503 SET character_set_client = utf8mb4 */;
CREATE TABLE `usuario` (
  `Id` int(11) NOT NULL AUTO_INCREMENT,
  `NombreCompleto` varchar(100) NOT NULL,
  `TipoUsuario` varchar(45) NOT NULL,
  `Contrasena` varchar(30) NOT NULL,
  `Creacion` timestamp NOT NULL DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (`Id`)
) ENGINE=InnoDB AUTO_INCREMENT=2 DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;
/*!40101 SET character_set_client = @saved_cs_client */;

--
-- Dumping data for table `usuario`
--

LOCK TABLES `usuario` WRITE;
/*!40000 ALTER TABLE `usuario` DISABLE KEYS */;
INSERT INTO `usuario` VALUES (1,'enrique garcia','admin','1234','2019-12-05 18:26:45');
/*!40000 ALTER TABLE `usuario` ENABLE KEYS */;
UNLOCK TABLES;
/*!40103 SET TIME_ZONE=@OLD_TIME_ZONE */;

/*!40101 SET SQL_MODE=@OLD_SQL_MODE */;
/*!40014 SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS */;
/*!40014 SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS */;
/*!40101 SET CHARACTER_SET_CLIENT=@OLD_CHARACTER_SET_CLIENT */;
/*!40101 SET CHARACTER_SET_RESULTS=@OLD_CHARACTER_SET_RESULTS */;
/*!40101 SET COLLATION_CONNECTION=@OLD_COLLATION_CONNECTION */;
/*!40111 SET SQL_NOTES=@OLD_SQL_NOTES */;

-- Dump completed on 2019-12-12 15:40:02
