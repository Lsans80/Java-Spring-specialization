-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Optica
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Optica
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Optica` DEFAULT CHARACTER SET utf8 ;
USE `Optica` ;

-- -----------------------------------------------------
-- Table `Optica`.`proveedor`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Optica`.`proveedor` (
  `idProveedor` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(80) NOT NULL,
  `telefono` VARCHAR(15) NOT NULL,
  `fax` VARCHAR(15) NULL,
  `nif` VARCHAR(15) NOT NULL,
  PRIMARY KEY (`idProveedor`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Optica`.`gafa`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Optica`.`gafa` (
  `idGafa` INT NOT NULL AUTO_INCREMENT,
  `idMarca` INT NOT NULL,
  `graduacionIzquierdo` VARCHAR(10) NOT NULL,
  `graduacionDerecho` VARCHAR(10) NOT NULL,
  `colorMontura` VARCHAR(45) NOT NULL,
  `colorCristal` VARCHAR(45) NOT NULL,
  `precio` FLOAT NOT NULL,
  `idProveedor` INT NOT NULL,
  PRIMARY KEY (`idGafa`),
  INDEX `idproveedor_idx` (`idProveedor` ASC) VISIBLE,
  CONSTRAINT `idproveedor`
    FOREIGN KEY (`idProveedor`)
    REFERENCES `Optica`.`proveedor` (`idProveedor`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Optica`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Optica`.`cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `email` VARCHAR(45) NOT NULL,
  `fechaRegistro` VARCHAR(45) NOT NULL,
  `recomendadoPor` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `recomendadoPor_idx` (`recomendadoPor` ASC) VISIBLE,
  CONSTRAINT `recomendadoPor`
    FOREIGN KEY (`recomendadoPor`)
    REFERENCES `Optica`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Optica`.`venta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Optica`.`venta` (
  `idVenta` INT NOT NULL AUTO_INCREMENT,
  `fechaVenta` DATE NOT NULL,
  `empleado` VARCHAR(30) NOT NULL,
  `idGafa` INT NOT NULL,
  `idCliente` INT NOT NULL,
  PRIMARY KEY (`idVenta`),
  INDEX `idCliente_idx` (`idCliente` ASC) VISIBLE,
  INDEX `idGafa_idx` (`idGafa` ASC) VISIBLE,
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `Optica`.`cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idGafa`
    FOREIGN KEY (`idGafa`)
    REFERENCES `Optica`.`gafa` (`idGafa`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
