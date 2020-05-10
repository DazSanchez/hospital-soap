/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dto;

import com.itorizaba.servicioshospital.Paciente;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class PacienteDTO extends Paciente {

    private int idDireccion;
    private int idConsultorio;

    public int getIdDireccion() {
        return idDireccion;
    }

    public void setIdDireccion(int idDireccion) {
        this.idDireccion = idDireccion;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }

}
