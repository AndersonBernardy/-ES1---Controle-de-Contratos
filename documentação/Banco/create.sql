-- MySQL Workbench Forward Engineering

SET @OLD_UNIQUE_CHECKS=@@UNIQUE_CHECKS, UNIQUE_CHECKS=0;
SET @OLD_FOREIGN_KEY_CHECKS=@@FOREIGN_KEY_CHECKS, FOREIGN_KEY_CHECKS=0;
SET @OLD_SQL_MODE=@@SQL_MODE, SQL_MODE='ONLY_FULL_GROUP_BY,STRICT_TRANS_TABLES,NO_ZERO_IN_DATE,NO_ZERO_DATE,ERROR_FOR_DIVISION_BY_ZERO,NO_ENGINE_SUBSTITUTION';

-- -----------------------------------------------------
-- Schema contratos
-- -----------------------------------------------------

-- -----------------------------------------------------
-- Schema contratos
-- -----------------------------------------------------
CREATE SCHEMA IF NOT EXISTS `contratos` DEFAULT CHARACTER SET utf8 ;
USE `contratos` ;

-- -----------------------------------------------------
-- Table `contratos`.`rua`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`rua` (
  `id_rua` INT NOT NULL AUTO_INCREMENT,
  `nome_rua` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id_rua`),
  UNIQUE INDEX `nome_rua_UNIQUE` (`nome_rua` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`bairro`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`bairro` (
  `id_bairro` INT NOT NULL AUTO_INCREMENT,
  `nome_bairro` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id_bairro`),
  UNIQUE INDEX `nome_bairro_UNIQUE` (`nome_bairro` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`estado`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`estado` (
  `id_estado` INT NOT NULL AUTO_INCREMENT,
  `nome_estado` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id_estado`),
  UNIQUE INDEX `nome_estado_UNIQUE` (`nome_estado` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`cidade`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`cidade` (
  `id_cidade` INT NOT NULL AUTO_INCREMENT,
  `nome_cidade` VARCHAR(64) NOT NULL,
  `id_estado` INT NOT NULL,
  PRIMARY KEY (`id_cidade`),
  UNIQUE INDEX `nome_cidade_UNIQUE` (`nome_cidade` ASC) VISIBLE,
  INDEX `fk_cidade_estado1_idx` (`id_estado` ASC) VISIBLE,
  CONSTRAINT `fk_cidade_estado1`
    FOREIGN KEY (`id_estado`)
    REFERENCES `contratos`.`estado` (`id_estado`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`endereco`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`endereco` (
  `id_endereco` INT NOT NULL AUTO_INCREMENT,
  `cep` VARCHAR(32) NOT NULL,
  `id_rua` INT NOT NULL,
  `id_bairro` INT NOT NULL,
  `id_cidade` INT NOT NULL,
  PRIMARY KEY (`id_endereco`),
  INDEX `fk_endereco_rua_idx` (`id_rua` ASC) VISIBLE,
  INDEX `fk_endereco_bairro1_idx` (`id_bairro` ASC) VISIBLE,
  INDEX `fk_endereco_cidade1_idx` (`id_cidade` ASC) VISIBLE,
  CONSTRAINT `fk_endereco_rua`
    FOREIGN KEY (`id_rua`)
    REFERENCES `contratos`.`rua` (`id_rua`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_bairro1`
    FOREIGN KEY (`id_bairro`)
    REFERENCES `contratos`.`bairro` (`id_bairro`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_endereco_cidade1`
    FOREIGN KEY (`id_cidade`)
    REFERENCES `contratos`.`cidade` (`id_cidade`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`cliente`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`cliente` (
  `id_cliente` INT NOT NULL AUTO_INCREMENT,
  `nome_cliente` VARCHAR(64) NOT NULL,
  `numero_endereco` INT NOT NULL,
  `complemento_endereco` VARCHAR(64) NULL,
  `id_endereco` INT NOT NULL,
  `is_pessoa_fisica` TINYINT NOT NULL,
  `cpf` VARCHAR(16) NULL,
  `cnpj` VARCHAR(32) NULL,
  PRIMARY KEY (`id_cliente`),
  UNIQUE INDEX `cpf_UNIQUE` (`cpf` ASC) VISIBLE,
  UNIQUE INDEX `cnpj_UNIQUE` (`cnpj` ASC) VISIBLE,
  INDEX `fk_cliente_endereco1_idx` (`id_endereco` ASC) VISIBLE,
  CONSTRAINT `fk_cliente_endereco1`
    FOREIGN KEY (`id_endereco`)
    REFERENCES `contratos`.`endereco` (`id_endereco`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`email`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`email` (
  `email` VARCHAR(64) NOT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`email`),
  INDEX `fk_email_cliente1_idx` (`id_cliente` ASC) VISIBLE,
  CONSTRAINT `fk_email_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `contratos`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`ddd`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`ddd` (
  `ddd` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`ddd`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`ddi`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`ddi` (
  `ddi` VARCHAR(4) NOT NULL DEFAULT '+55',
  PRIMARY KEY (`ddi`))
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`telefone`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`telefone` (
  `numero_telefone` VARCHAR(16) NOT NULL,
  `id_cliente` INT NOT NULL,
  `ddd` VARCHAR(4) NOT NULL,
  `ddi` VARCHAR(4) NOT NULL,
  PRIMARY KEY (`numero_telefone`, `id_cliente`),
  INDEX `fk_telefone_cliente1_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_telefone_ddd1_idx` (`ddd` ASC) VISIBLE,
  INDEX `fk_telefone_ddi1_idx` (`ddi` ASC) VISIBLE,
  CONSTRAINT `fk_telefone_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `contratos`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefone_ddd1`
    FOREIGN KEY (`ddd`)
    REFERENCES `contratos`.`ddd` (`ddd`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_telefone_ddi1`
    FOREIGN KEY (`ddi`)
    REFERENCES `contratos`.`ddi` (`ddi`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`tipo_contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`tipo_contrato` (
  `id_tipo_contrato` INT NOT NULL AUTO_INCREMENT,
  `nome_tipo_contrato` VARCHAR(64) NOT NULL,
  PRIMARY KEY (`id_tipo_contrato`),
  UNIQUE INDEX `nome_tipo_contrato_UNIQUE` (`nome_tipo_contrato` ASC) VISIBLE)
ENGINE = InnoDB;


-- -----------------------------------------------------
-- Table `contratos`.`contrato`
-- -----------------------------------------------------
CREATE TABLE IF NOT EXISTS `contratos`.`contrato` (
  `id_contrato` INT NOT NULL AUTO_INCREMENT,
  `data_emissao` DATETIME NOT NULL,
  `inicio_validade` DATETIME NOT NULL,
  `fim_validade` DATETIME NOT NULL,
  `descricao` VARCHAR(256) NULL,
  `valor` DOUBLE NOT NULL,
  `id_tipo_contrato` INT NOT NULL,
  `id_cliente` INT NOT NULL,
  PRIMARY KEY (`id_contrato`),
  INDEX `fk_contrato_cliente1_idx` (`id_cliente` ASC) VISIBLE,
  INDEX `fk_contrato_tipo_contrato1_idx` (`id_tipo_contrato` ASC) VISIBLE,
  CONSTRAINT `fk_contrato_cliente1`
    FOREIGN KEY (`id_cliente`)
    REFERENCES `contratos`.`cliente` (`id_cliente`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT `fk_contrato_tipo_contrato1`
    FOREIGN KEY (`id_tipo_contrato`)
    REFERENCES `contratos`.`tipo_contrato` (`id_tipo_contrato`)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION)
ENGINE = InnoDB;


SET SQL_MODE=@OLD_SQL_MODE;
SET FOREIGN_KEY_CHECKS=@OLD_FOREIGN_KEY_CHECKS;
SET UNIQUE_CHECKS=@OLD_UNIQUE_CHECKS;
