/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.service;

import com.itorizaba.servicioshospital.DetallePaciente;
import com.itorizaba.servicioshospital.ListaPacientes;
import java.util.List;
import me.hsanchez.hospital.dao.PacienteDAO;
import me.hsanchez.hospital.dto.PacienteDTO;
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
    
    public ListaPacientes obtenerPorCiudad(String ciudad) throws QueryExecutionException {
        List<PacienteDTO> pacientes = this.pacienteDAO.obtenerPorCiudad(ciudad);
        
        ListaPacientes lista = new ListaPacientes();
        lista.getItem().addAll(pacientes);
        
        return lista;
    }
    
    public DetallePaciente obtenerDetalle(int expediente) throws QueryExecutionException {
        return this.pacienteDAO.obtenerDetalle(expediente);
    }
}
