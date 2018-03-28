CREATE DATABASE IF NOT EXISTS miBasecita;
use miBasecita;
CREATE TABLE IF NOT EXISTS `estudiantes` (
id INT NOT NULL PRIMARY KEY AUTO_INCREMENT, 
nombre VARCHAR(20), 
identificacion INT(11), 
edad INT(11), 
genero VARCHAR(20)
);