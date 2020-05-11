/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.handler;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.hsanchez.hospital.dto.VisitaDTO;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class VisitaBeanHandler extends BeanListHandler<VisitaDTO> {

    public VisitaBeanHandler() {
        super(VisitaDTO.class);
    }

    @Override
    public List<VisitaDTO> handle(ResultSet rs) throws SQLException {
        List<VisitaDTO> lista = new ArrayList<>();

        while (rs.next()) {
            VisitaDTO visita = new VisitaDTO();

            visita.setFecha(rs.getDate("fecha"));
            visita.setId(rs.getInt("id"));
            visita.setIdPaciente(rs.getInt("idPaciente"));
            visita.setObservaciones(rs.getString("observaciones"));
            lista.add(visita);
        }

        return lista;
    }
}
