ALTER TABLE consultorios DROP FOREIGN KEY consultorio_medico;
ALTER TABLE visitas DROP FOREIGN KEY consultorio_visita;
ALTER TABLE medicos DROP FOREIGN KEY medico_especialidad;
ALTER TABLE pacientes DROP FOREIGN KEY paciente_direccion;
ALTER TABLE visitas DROP FOREIGN KEY paciente_visita;
DROP TABLE IF EXISTS consultorios;
DROP TABLE IF EXISTS direcciones;
DROP TABLE IF EXISTS especialidades;
DROP TABLE IF EXISTS medicos;
DROP TABLE IF EXISTS pacientes;
DROP TABLE IF EXISTS visitas;
