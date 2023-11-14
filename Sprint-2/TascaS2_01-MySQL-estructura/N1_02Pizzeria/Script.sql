-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Pizzeria
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Pizzeria
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Pizzeria` DEFAULT CHARACTER SET utf8 ;
USE `Pizzeria` ;

-- -----------------------------------------------------
-- Table `Pizzeria`.`Provincia`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`Provincia` (
  `idProvincia` INT NOT NULL AUTO_INCREMENT,
  `nombreProvincia` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idProvincia`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`Localidad`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`Localidad` (
  `idLocalidad` INT NOT NULL AUTO_INCREMENT,
  `nombreLocalidad` VARCHAR(45) NOT NULL,
  `idProvincia` INT NOT NULL,
  PRIMARY KEY (`idLocalidad`),
  INDEX `idProvincia_idx` (`idProvincia` ASC) VISIBLE,
  CONSTRAINT `idProvincia`
    FOREIGN KEY (`idProvincia`)
    REFERENCES `Pizzeria`.`Provincia` (`idProvincia`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`Cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`Cliente` (
  `idCliente` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `direccion` VARCHAR(45) NOT NULL,
  `codigoPostal` VARCHAR(10) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `idLocalidad` INT NOT NULL,
  PRIMARY KEY (`idCliente`),
  INDEX `idLocalidad_idx` (`idLocalidad` ASC) VISIBLE,
  CONSTRAINT `idLocalidad`
    FOREIGN KEY (`idLocalidad`)
    REFERENCES `Pizzeria`.`Localidad` (`idLocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`Tienda`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`Tienda` (
  `idTienda` INT NOT NULL AUTO_INCREMENT,
  `direccion` VARCHAR(45) NOT NULL,
  `codigoPostal` INT NOT NULL,
  `idLocalidad` INT NOT NULL,
  PRIMARY KEY (`idTienda`),
  INDEX `localidad_idx` (`idLocalidad` ASC) VISIBLE,
  CONSTRAINT `localidad`
    FOREIGN KEY (`idLocalidad`)
    REFERENCES `Pizzeria`.`Localidad` (`idLocalidad`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`Empleado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`Empleado` (
  `idEmpleado` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `apellidos` VARCHAR(45) NOT NULL,
  `nif` VARCHAR(45) NOT NULL,
  `telefono` VARCHAR(45) NOT NULL,
  `puesto` VARCHAR(45) NOT NULL,
  `idTienda` INT NOT NULL,
  PRIMARY KEY (`idEmpleado`),
  INDEX `tienda_idx` (`idTienda` ASC) VISIBLE,
  CONSTRAINT `tienda`
    FOREIGN KEY (`idTienda`)
    REFERENCES `Pizzeria`.`Tienda` (`idTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`Pedido`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`Pedido` (
  `idPedido` INT NOT NULL AUTO_INCREMENT,
  `fechaHora` DATETIME NOT NULL,
  `domicilioOrecogida` VARCHAR(45) NOT NULL,
  `fechaHoraEntrega` DATETIME NOT NULL,
  `precioTotal` FLOAT NOT NULL,
  `idCliente` INT NOT NULL,
  `idTienda` INT NOT NULL,
  `idEmpleado` INT NOT NULL,
  PRIMARY KEY (`idPedido`),
  INDEX `empleado_idx` (`idEmpleado` ASC) VISIBLE,
  INDEX `cliente_idx` (`idCliente` ASC) VISIBLE,
  INDEX `tienda_idx` (`idTienda` ASC) VISIBLE,
  CONSTRAINT `idEmpleado`
    FOREIGN KEY (`idEmpleado`)
    REFERENCES `Pizzeria`.`Empleado` (`idEmpleado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idCliente`
    FOREIGN KEY (`idCliente`)
    REFERENCES `Pizzeria`.`Cliente` (`idCliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `idTienda`
    FOREIGN KEY (`idTienda`)
    REFERENCES `Pizzeria`.`Tienda` (`idTienda`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`Categoria`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`Categoria` (
  `idCategoria` INT NOT NULL AUTO_INCREMENT,
  `categoria` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idCategoria`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`Producto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`Producto` (
  `idProducto` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `idCategoria` INT NULL,
  `descripcion` VARCHAR(45) NOT NULL,
  `imagen` LONGBLOB NULL,
  `precio` FLOAT NOT NULL,
  PRIMARY KEY (`idProducto`),
  INDEX `categoria_idx` (`idCategoria` ASC) VISIBLE,
  CONSTRAINT `categoria`
    FOREIGN KEY (`idCategoria`)
    REFERENCES `Pizzeria`.`Categoria` (`idCategoria`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Pizzeria`.`CantidadProducto`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Pizzeria`.`CantidadProducto` (
  `idCantidadProducto` INT NOT NULL AUTO_INCREMENT,
  `idPedido` INT NOT NULL,
  `idProducto` INT NOT NULL,
  `cantidad` INT NOT NULL,
  PRIMARY KEY (`idCantidadProducto`),
  INDEX `producto_idx` (`idProducto` ASC) VISIBLE,
  INDEX `pedido_idx` (`idPedido` ASC) VISIBLE,
  CONSTRAINT `idPedido`
    FOREIGN KEY (`idPedido`)
    REFERENCES `Pizzeria`.`Pedido` (`idPedido`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `producto`
    FOREIGN KEY (`idProducto`)
    REFERENCES `Pizzeria`.`Producto` (`idProducto`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
