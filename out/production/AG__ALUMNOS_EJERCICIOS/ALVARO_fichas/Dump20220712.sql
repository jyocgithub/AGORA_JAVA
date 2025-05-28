CREATE DATABASE `ALVARO_FICHAS` /*!40100 DEFAULT CHARACTER SET utf8mb4 COLLATE utf8mb4_0900_ai_ci */ /*!80016 DEFAULT ENCRYPTION='N' */;

USE ALVARO_FICHAS

CREATE TABLE `fichas` (
  `idficha` varchar(30) NOT NULL,
  `ici` varchar(255) DEFAULT NULL,
  `ec` varchar(255) DEFAULT NULL,
  `cas` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`idficha`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `fichas_clases` (
  `idficha` varchar(255) NOT NULL,
  `class` varchar(255) NOT NULL,
  PRIMARY KEY (`idficha`,`class`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;


CREATE TABLE `fichas_haches` (
  `idficha` varchar(255) NOT NULL,
  `idhache` varchar(255) NOT NULL,
  `concentracion` varchar(45) DEFAULT NULL,
  PRIMARY KEY (`idficha`,`idhache`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COLLATE=utf8mb4_0900_ai_ci;



