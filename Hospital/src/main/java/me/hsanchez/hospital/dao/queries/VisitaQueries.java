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
public class VisitaQueries {

    public static final String OBTENER_POR_EXPEDIENTE = "SELECT * FROM visitas "
            + "WHERE idPaciente = ? "
            + "LIMIT 3 ORDER BY fecha DESC";
}
