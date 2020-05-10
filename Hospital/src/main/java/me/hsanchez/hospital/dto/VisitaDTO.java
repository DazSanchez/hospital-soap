/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dto;

import com.itorizaba.servicioshospital.Visita;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class VisitaDTO extends Visita {
    private int idPaciente;
    private int idConsultorio;

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }
}
