/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dao.queries;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class PacienteQueries {
    public static final String BUSCAR_POR_CIUDAD = "SELECT * FROM direcciones d "
            + "INNER JOIN pacientes p ON d.id = p.idDireccion "
            + "WHERE d.ciudad LIKE ?";
    public static final String OBTENER_DETALLE_POR_EXPEDIENTE = "SELECT * FROM pacientes WHERE idExpediente = ?";
}
