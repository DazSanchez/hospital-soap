/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.service;

import com.itorizaba.servicioshospital.DetallePaciente;
import com.itorizaba.servicioshospital.ListaPacientes;
import com.itorizaba.servicioshospital.Paciente;
import java.util.List;
import me.hsanchez.hospital.dao.PacienteDAO;
import me.hsanchez.hospital.dto.ResultadoBusquedaDTO;
import me.hsanchez.hospital.exceptions.QueryExecutionException;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class PacienteService {
    private final PacienteDAO pacienteDAO;

    public PacienteService() {
        this.pacienteDAO = new PacienteDAO();
    }
    
    public ResultadoBusquedaDTO<ListaPacientes> obtenerPorCiudad(String ciudad, int page, int perPage) throws QueryExecutionException {
        ResultadoBusquedaDTO<List<Paciente>> rb = this.pacienteDAO.obtenerPorCiudad(ciudad, page, perPage);
        
        ListaPacientes lista = new ListaPacientes();
        lista.getItem().addAll(rb.getPayload());
        
        ResultadoBusquedaDTO<ListaPacientes> resultado = new ResultadoBusquedaDTO<>();
        resultado.setPayload(lista);
        resultado.setTotal(rb.getTotal());
        
        return resultado;
    }
    
    public DetallePaciente obtenerDetalle(int expediente) throws QueryExecutionException {
        return this.pacienteDAO.obtenerDetalle(expediente);
    }
}
