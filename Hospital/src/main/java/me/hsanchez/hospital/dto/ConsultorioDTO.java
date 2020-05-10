/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dto;

import com.itorizaba.servicioshospital.Consultorio;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class ConsultorioDTO extends Consultorio {

    private int idMedico;

    public int getIdMedico() {
        return idMedico;
    }

    public void setIdMedico(int idMedico) {
        this.idMedico = idMedico;
    }

}
