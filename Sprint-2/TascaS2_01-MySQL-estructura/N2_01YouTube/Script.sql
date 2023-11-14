-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema YouTube
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema YouTube
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `YouTube` DEFAULT CHARACTER SET utf8 ;
USE `YouTube` ;

-- -----------------------------------------------------
-- Table `YouTube`.`Usuario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`Usuario` (
  `idUsuario` INT NOT NULL AUTO_INCREMENT,
  `email` VARCHAR(45) NOT NULL,
  `password` VARCHAR(45) NOT NULL,
  `nombreUsuario` VARCHAR(45) NOT NULL,
  `fechaNacimiento` DATE NOT NULL,
  `Sexo` VARCHAR(45) NULL,
  `pais` VARCHAR(45) NOT NULL,
  `cp` VARCHAR(45) NOT NULL,
  PRIMARY KEY (`idUsuario`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`Canal`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`Canal` (
  `idCanal` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `fechaCreacion` TIMESTAMP(6) NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idCanal`),
  INDEX `usuario_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fkUsuario`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `YouTube`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`Video`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`Video` (
  `idVideo` INT NOT NULL AUTO_INCREMENT,
  `titulo` VARCHAR(45) NOT NULL,
  `descripcion` VARCHAR(45) NULL,
  `dimension` VARCHAR(45) NOT NULL,
  `nombreArchivo` VARCHAR(45) NOT NULL,
  `duracionVideo` TIME NOT NULL,
  `thumbnail` MEDIUMBLOB NULL,
  `reproducciones` INT NOT NULL,
  `likes` INT NOT NULL DEFAULT 0,
  `dislikes` INT NOT NULL DEFAULT 0,
  `estado` ENUM('Pubico', 'Oculto', 'Privado') NOT NULL,
  `fechaPublicacion` TIMESTAMP(6) NOT NULL,
  `idCanal` INT NOT NULL,
  PRIMARY KEY (`idVideo`),
  INDEX `video_idx` (`idCanal` ASC) VISIBLE,
  CONSTRAINT `fkCanal`
    FOREIGN KEY (`idCanal`)
    REFERENCES `YouTube`.`Canal` (`idCanal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`Etiqueta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`Etiqueta` (
  `idEtiqueta` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaHora` TIMESTAMP(6) NOT NULL,
  PRIMARY KEY (`idEtiqueta`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`Comentario`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`Comentario` (
  `idComentario` INT NOT NULL AUTO_INCREMENT,
  `texto` VARCHAR(200) NOT NULL,
  `fechaHora` TIMESTAMP(6) NOT NULL,
  `idLikeDislike` INT NOT NULL,
  PRIMARY KEY (`idComentario`),
  INDEX `likeDislike_idx` (`idLikeDislike` ASC) VISIBLE,
  CONSTRAINT `fkLikeDislike`
    FOREIGN KEY (`idLikeDislike`)
    REFERENCES `YouTube`.`LikeDislike` (`idLikeDislike`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`LikeDislike`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`LikeDislike` (
  `idLikeDislike` INT NOT NULL AUTO_INCREMENT,
  `likeDislike` ENUM('like', 'dislike') NOT NULL,
  `fechaHora` TIMESTAMP(6) NOT NULL,
  `idUsuario` INT NOT NULL,
  `idVideo` INT NULL,
  `idComentario` INT NULL,
  PRIMARY KEY (`idLikeDislike`),
  INDEX `usuario_idx` (`idUsuario` ASC) VISIBLE,
  INDEX `video_idx` (`idVideo` ASC) VISIBLE,
  INDEX `comentario_idx` (`idComentario` ASC) VISIBLE,
  CONSTRAINT `fkUsuarioLikeDislike`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `YouTube`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkVideoLikeDislike`
    FOREIGN KEY (`idVideo`)
    REFERENCES `YouTube`.`Video` (`idVideo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkComentario`
    FOREIGN KEY (`idComentario`)
    REFERENCES `YouTube`.`Comentario` (`idComentario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`Suscripcion`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`Suscripcion` (
  `idSuscripcion` INT NOT NULL AUTO_INCREMENT,
  `idCanal` INT NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idSuscripcion`),
  INDEX `canal_idx` (`idCanal` ASC) VISIBLE,
  INDEX `usuario_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fkCanal`
    FOREIGN KEY (`idCanal`)
    REFERENCES `YouTube`.`Canal` (`idCanal`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkUsuarioSuscripcion`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `YouTube`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`Playlist`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`Playlist` (
  `idPlaylist` INT NOT NULL AUTO_INCREMENT,
  `nombre` VARCHAR(45) NOT NULL,
  `fechaPublicacion` TIMESTAMP(6) NOT NULL,
  `estado` ENUM('publico', 'privado') NOT NULL,
  `idUsuario` INT NOT NULL,
  PRIMARY KEY (`idPlaylist`),
  INDEX `usuario_idx` (`idUsuario` ASC) VISIBLE,
  CONSTRAINT `fkUsuarioPlaylist`
    FOREIGN KEY (`idUsuario`)
    REFERENCES `YouTube`.`Usuario` (`idUsuario`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`VideoEtiqueta`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`VideoEtiqueta` (
  `idVideoEtiqueta` INT NOT NULL AUTO_INCREMENT,
  `idVideo` INT NOT NULL,
  `idEtiqueta` INT NOT NULL,
  PRIMARY KEY (`idVideoEtiqueta`),
  INDEX `video_idx` (`idVideo` ASC) VISIBLE,
  INDEX `etiqueta_idx` (`idEtiqueta` ASC) VISIBLE,
  CONSTRAINT `fkVideoVideoEtiqueta`
    FOREIGN KEY (`idVideo`)
    REFERENCES `YouTube`.`Video` (`idVideo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkEtiqueta`
    FOREIGN KEY (`idEtiqueta`)
    REFERENCES `YouTube`.`Etiqueta` (`idEtiqueta`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `YouTube`.`PlaylistVideo`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `YouTube`.`PlaylistVideo` (
  `idPlaylistVideo` INT NOT NULL AUTO_INCREMENT,
  `idPlaylist` INT NOT NULL,
  `idVideo` INT NOT NULL,
  PRIMARY KEY (`idPlaylistVideo`),
  INDEX `playlist_idx` (`idPlaylist` ASC) VISIBLE,
  INDEX `video_idx` (`idVideo` ASC) VISIBLE,
  CONSTRAINT `fkPlaylist`
    FOREIGN KEY (`idPlaylist`)
    REFERENCES `YouTube`.`Playlist` (`idPlaylist`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fkVideoPlaylistVideo`
    FOREIGN KEY (`idVideo`)
    REFERENCES `YouTube`.`Video` (`idVideo`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
