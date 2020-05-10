/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dto;

import com.itorizaba.servicioshospital.Medico;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class MedicoDTO extends Medico {

    private int idEspecialidad;

    public int getIdEspecialidad() {
        return idEspecialidad;
    }

    public void setIdEspecialidad(int idEspecialidad) {
        this.idEspecialidad = idEspecialidad;
    }

}
