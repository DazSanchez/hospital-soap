/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.handler;

import com.itorizaba.servicioshospital.Direccion;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import me.hsanchez.hospital.dao.queries.DireccionQueries;
import me.hsanchez.hospital.dto.PacienteDTO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class PacienteBeanHandler extends BeanListHandler<PacienteDTO> {

    private final QueryRunner qr;

    public PacienteBeanHandler(QueryRunner qr) {
        super(PacienteDTO.class);
        this.qr = qr;
    }

    @Override
    public List<PacienteDTO> handle(ResultSet rs) throws SQLException {
        List<PacienteDTO> pacientes = super.handle(rs);

        BeanHandler<Direccion> handler = new BeanHandler<>(Direccion.class);

        for (PacienteDTO paciente : pacientes) {
            Direccion direccion = qr.query(DireccionQueries.OBTENER_POR_ID, handler, paciente.getIdDireccion());
            paciente.setDireccion(direccion);
        }

        return pacientes;
    }
}
