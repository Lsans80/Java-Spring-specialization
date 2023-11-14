-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema Spotify
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema Spotify
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `Spotify` DEFAULT CHARACTER SET utf8 ;
USE `Spotify` ;

-- -----------------------------------------------------
-- Table `Spotify`.`timestamps`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`timestamps` (
  `create_time` TIMESTAMP NULL DEFAULT CURRENT_TIMESTAMP,
  `update_time` TIMESTAMP NULL);


-- -----------------------------------------------------
-- Table `Spotify`.`category`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`category` (
  `category_id` INT NOT NULL,
  `name` VARCHAR(255) NOT NULL,
  PRIMARY KEY (`category_id`));


-- -----------------------------------------------------
-- Table `Spotify`.`Tarjeta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Tarjeta` (
  `idTarjeta` INT NOT NULL AUTO_INCREMENT,
  `numeroTarjeta` VARCHAR(45) NOT NULL,
  `fechaCaducidad` VARCHAR(45) NOT NULL,
  `codigoSeguridad` INT NOT NULL,
  PRIMARY KEY (`idTarjeta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Paypal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Paypal` (
  `idPaypal` INT NOT NULL AUTO_INCREMENT,
  `nombrePaypal` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idPaypal`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Pago`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Pago` (
  `idPago` INT NOT NULL AUTO_INCREMENT,
  `idPaypal` INT NULL,
  `idTarjeta` INT NULL,
  `fecha` DATE NOT NULL,
  `total` FLOAT NOT NULL,
  PRIMARY KEY (`idPago`),
  INDEX `fk_idpagoTargeta_idx` (`idTarjeta` ASC) VISIBLE,
  INDEX `fk_idpagoPaypal_idx` (`idPaypal` ASC) VISIBLE,
  CONSTRAINT `fk_idpagoTargeta`
    FOREIGN KEY (`idTarjeta`)
    REFERENCES `Spotify`.`Tarjeta` (`idTarjeta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_idpagoPaypal`
    FOREIGN KEY (`idPaypal`)
    REFERENCES `Spotify`.`Paypal` (`idPaypal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Suscripcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Suscripcion` (
  `idSuscripcion` INT NOT NULL AUTO_INCREMENT,
  `fechaInicioSuscripcion` DATE NOT NULL,
  `fechaRenovacionServicio` DATE NOT NULL,
  `idPago` INT NOT NULL,
  PRIMARY KEY (`idSuscripcion`),
  INDEX `fk_suscripcionPago_idx` (`idPago` ASC) VISIBLE,
  CONSTRAINT `fk_suscripcionPago`
    FOREIGN KEY (`idPago`)
    REFERENCES `Spotify`.`Pago` (`idPago`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `Sexo` VARCHAR(45) NULL,
  `pais` VARCHAR(45) NOT NULL,
  `cp` VARCHAR(45) NOT NULL,
  `freePremium` ENUM('free', 'premiun') NOT NULL,
  `idSuscripcion` INT NULL,
  PRIMARY KEY (`idUsuario`),
  INDEX `fk_idUsuarioSuscripcion_idx` (`idSuscripcion` ASC) VISIBLE,
  CONSTRAINT `fk_idUsuarioSuscripcion`
    FOREIGN KEY (`idSuscripcion`)
    REFERENCES `Spotify`.`Suscripcion` (`idSuscripcion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Playlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Playlist` (
  `idPlaylist` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `numeroCanciones` INT NULL,
  `fechaCreacion` DATE NOT NULL,
  `estado` ENUM('visible', 'eliminada') NOT NULL,
  `fechaEliminacion` TIMESTAMP(6) NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idPlaylist`),
  INDEX `fk_Playlist_Usuario1_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Playlist_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `Spotify`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`SeguirArtista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`SeguirArtista` (
  `idSeguirArtista` INT NOT NULL AUTO_INCREMENT,
  `idArtista` INT NOT NULL,
  `idUsuario` INT NULL,
  PRIMARY KEY (`idSeguirArtista`),
  INDEX `fk_SeguirArtista_Artista1_idx` (`idArtista` ASC) VISIBLE,
  INDEX `fk_SeguirArtista_Usuario1_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_SeguirArtista_Artista1`
    FOREIGN KEY (`idArtista`)
    REFERENCES `Spotify`.`Artista` (`idArtista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_SeguirArtista_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `Spotify`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Artista`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Artista` (
  `idArtista` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `imagen` MEDIUMBLOB NOT NULL,
  `idSeguirArtista` INT NULL,
  PRIMARY KEY (`idArtista`),
  INDEX `fk_Artista_SeguirArtista1_idx` (`idSeguirArtista` ASC) VISIBLE,
  CONSTRAINT `fk_Artista_SeguirArtista1`
    FOREIGN KEY (`idSeguirArtista`)
    REFERENCES `Spotify`.`SeguirArtista` (`idSeguirArtista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Album`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Album` (
  `idAlbum` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `AnyoPublicacion` INT NOT NULL,
  `ImagenPortada` MEDIUMBLOB NOT NULL,
  `idArtista` INT NOT NULL,
  PRIMARY KEY (`idAlbum`),
  INDEX `fk_Album_Artista1_idx` (`idArtista` ASC) VISIBLE,
  CONSTRAINT `fk_Album_Artista1`
    FOREIGN KEY (`idArtista`)
    REFERENCES `Spotify`.`Artista` (`idArtista`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Cancion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Cancion` (
  `idCancion` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `duracion` TIME NOT NULL,
  `numeroReproducciones` INT NOT NULL,
  `idAlbum` INT NOT NULL,
  PRIMARY KEY (`idCancion`, `idAlbum`),
  INDEX `fk_Cancion_Album1_idx` (`idAlbum` ASC) VISIBLE,
  CONSTRAINT `fk_Cancion_Album1`
    FOREIGN KEY (`idAlbum`)
    REFERENCES `Spotify`.`Album` (`idAlbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`AgregarCancion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`AgregarCancion` (
  `idAgregarCancion` INT NOT NULL,
  `fecha` DATE NOT NULL,
  `IdUsuario` INT NOT NULL,
  `idCancion` INT NOT NULL,
  `idPlaylist` INT NOT NULL,
  PRIMARY KEY (`idAgregarCancion`),
  INDEX `fk_AgregarCancionUsuario_idx` (`IdUsuario` ASC) VISIBLE,
  INDEX `fk_AgregarCancionCancion_idx` (`idCancion` ASC) VISIBLE,
  INDEX `fk_AgregarCancionPlaylist_idx` (`idPlaylist` ASC) VISIBLE,
  CONSTRAINT `fk_AgregarCancionUsuario`
    FOREIGN KEY (`IdUsuario`)
    REFERENCES `Spotify`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AgregarCancionCancion`
    FOREIGN KEY (`idCancion`)
    REFERENCES `Spotify`.`Cancion` (`idCancion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_AgregarCancionPlaylist`
    FOREIGN KEY (`idPlaylist`)
    REFERENCES `Spotify`.`Playlist` (`idPlaylist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `Spotify`.`Favoritos`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `Spotify`.`Favoritos` (
  `idFavoritos` INT NOT NULL AUTO_INCREMENT,
  `idCancion` INT NULL,
  `idAlbum` INT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idFavoritos`),
  INDEX `fk_Favoritos_Cancion1_idx` (`idCancion` ASC) VISIBLE,
  INDEX `fk_Favoritos_Album1_idx` (`idAlbum` ASC) VISIBLE,
  INDEX `fk_Favoritos_Usuario1_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fk_Favoritos_Cancion1`
    FOREIGN KEY (`idCancion`)
    REFERENCES `Spotify`.`Cancion` (`idCancion`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Favoritos_Album1`
    FOREIGN KEY (`idAlbum`)
    REFERENCES `Spotify`.`Album` (`idAlbum`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_Favoritos_Usuario1`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `Spotify`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
