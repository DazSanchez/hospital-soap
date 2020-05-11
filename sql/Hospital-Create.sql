CREATE DATABASE IF NOT EXISTS hospital CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

USE hospital;

CREATE TABLE consultorios (
  id       int(10) NOT NULL AUTO_INCREMENT, 
  piso     int(1) NOT NULL, 
  numero   int(4) NOT NULL UNIQUE, 
  idMedico int(10) NOT NULL, 
  CONSTRAINT consultorio_pk 
    PRIMARY KEY (id));
CREATE TABLE direcciones (
  id        int(10) NOT NULL AUTO_INCREMENT, 
  direccion varchar(100) NOT NULL, 
  ciudad    varchar(50) NOT NULL, 
  CONSTRAINT direccion_pk 
    PRIMARY KEY (id));
CREATE TABLE especialidades (
  id          int(10) NOT NULL AUTO_INCREMENT, 
  descripcion varchar(255) NOT NULL, 
  CONSTRAINT especialidad_pk 
    PRIMARY KEY (id));
CREATE TABLE medicos (
  id             int(10) NOT NULL AUTO_INCREMENT, 
  nombre         varchar(60) NOT NULL, 
  apPaterno      varchar(60) NOT NULL, 
  apMaterno      varchar(60) NOT NULL, 
  idEspecialidad int(10) NOT NULL, 
  CONSTRAINT medico_pk 
    PRIMARY KEY (id));
CREATE TABLE pacientes (
  idExpediente  int(10) NOT NULL AUTO_INCREMENT, 
  nombre        varchar(60) NOT NULL, 
  apPaterno     varchar(60) NOT NULL, 
  apMaterno     varchar(60) NOT NULL, 
  telefono      varchar(10) NOT NULL, 
  rfc           varchar(13) NOT NULL UNIQUE, 
  curp          varchar(18) NOT NULL UNIQUE, 
  idDireccion   int(10), 
  photo         mediumtext NOT NULL, 
  idConsultorio int(10) NOT NULL, 
  CONSTRAINT paciente_pk 
    PRIMARY KEY (idExpediente));
CREATE TABLE visitas (
  id            int(10) NOT NULL AUTO_INCREMENT, 
  idPaciente    int(10) NOT NULL, 
  fecha         date NOT NULL, 
  observaciones text NOT NULL, 
  CONSTRAINT vsitas_pk 
    PRIMARY KEY (id));
ALTER TABLE consultorios ADD CONSTRAINT consultorio_medico FOREIGN KEY (idMedico) REFERENCES medicos (id);
ALTER TABLE medicos ADD CONSTRAINT medico_especialidad FOREIGN KEY (idEspecialidad) REFERENCES especialidades (id);
ALTER TABLE pacientes ADD CONSTRAINT paciente_consultorio FOREIGN KEY (idConsultorio) REFERENCES consultorios (id);
ALTER TABLE pacientes ADD CONSTRAINT paciente_direccion FOREIGN KEY (idDireccion) REFERENCES direcciones (id);
ALTER TABLE visitas ADD CONSTRAINT paciente_visita FOREIGN KEY (idPaciente) REFERENCES pacientes (idExpediente);
