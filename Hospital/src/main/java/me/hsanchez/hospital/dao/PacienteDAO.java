/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dao;

import com.itorizaba.servicioshospital.DetallePaciente;
import com.itorizaba.servicioshospital.Paciente;
import java.sql.SQLException;
import java.util.List;
import me.hsanchez.hospital.dao.queries.DireccionQueries;
import me.hsanchez.hospital.dao.queries.PacienteQueries;
import me.hsanchez.hospital.datasource.HospitalDatasource;
import me.hsanchez.hospital.dto.ResultadoBusquedaDTO;
import me.hsanchez.hospital.exceptions.QueryExecutionException;
import me.hsanchez.hospital.handler.DetallePacienteBeanHandler;
import me.hsanchez.hospital.handler.PacienteBeanHandler;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.ScalarHandler;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class PacienteDAO {
    public ResultadoBusquedaDTO<List<Paciente>> obtenerPorCiudad(String ciudad, int page, int perPage) throws QueryExecutionException {
        QueryRunner qr = new QueryRunner(HospitalDatasource.getDataSource());
        PacienteBeanHandler handler = new PacienteBeanHandler(qr);
        
        try {
            Long total = qr.query(DireccionQueries.CONTAR_POR_CIUDAD, new ScalarHandler<Long>(), ciudad);
            List<Paciente> lista = qr.query(DireccionQueries.OBTENER_POR_CIUDAD, handler, "%" + ciudad + "%", ((page - 1) * perPage), perPage);
            
            ResultadoBusquedaDTO<List<Paciente>> resultado = new ResultadoBusquedaDTO<>();
            
            resultado.setPayload(lista);
            resultado.setTotal(total.intValue());
            
            return resultado;
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
