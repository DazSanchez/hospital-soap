/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dao;

import com.itorizaba.servicioshospital.DetallePaciente;
import java.sql.SQLException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import me.hsanchez.hospital.dao.queries.PacienteQueries;
import me.hsanchez.hospital.datasource.HospitalDatasource;
import me.hsanchez.hospital.dto.PacienteDTO;
import me.hsanchez.hospital.exceptions.QueryExecutionException;
import me.hsanchez.hospital.handler.DetallePacienteBeanHandler;
import me.hsanchez.hospital.handler.PacienteBeanHandler;
import org.apache.commons.dbutils.QueryRunner;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class PacienteDAO {
    public List<PacienteDTO> obtenerPorCiudad(String ciudad) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(HospitalDatasource.getDataSource());
        PacienteBeanHandler handler = new PacienteBeanHandler(qr);
        
        try {
            return qr.query(PacienteQueries.BUSCAR_POR_CIUDAD, handler, ciudad);
        } catch (SQLException ex) {
            throw new QueryExecutionException("Ocurrió un error obteniendo los pacientes", ex);
        }
    }
    
    public DetallePaciente obtenerDetalle(int expediente) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(HospitalDatasource.getDataSource());
        DetallePacienteBeanHandler handler = new DetallePacienteBeanHandler(qr);
        
        try {
            return qr.query(PacienteQueries.OBTENER_DETALLE_POR_EXPEDIENTE, handler, expediente);
        } catch (SQLException ex) {
            throw new QueryExecutionException("Ocurrió un error obteniendo el detalle", ex);
        }
    }
}
