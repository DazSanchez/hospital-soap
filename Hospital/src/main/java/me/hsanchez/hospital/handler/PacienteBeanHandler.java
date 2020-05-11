/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.handler;

import com.itorizaba.servicioshospital.Direccion;
import com.itorizaba.servicioshospital.Paciente;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import me.hsanchez.hospital.dao.queries.PacienteQueries;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class PacienteBeanHandler extends BeanListHandler<Paciente> {

    private final QueryRunner qr;

    public PacienteBeanHandler(QueryRunner qr) {
        super(Paciente.class);
        this.qr = qr;
    }

    @Override
    public List<Paciente> handle(ResultSet rs) throws SQLException {
        BeanListHandler<Direccion> handler = new BeanListHandler<>(Direccion.class);

        List<Direccion> direcciones = handler.handle(rs);
        List<Paciente> pacientes = new ArrayList<>(direcciones.size());

        for (Direccion direccion : direcciones) {
            Paciente paciente = qr.query(
                    PacienteQueries.BUSCAR_POR_DIRECCION,
                    new BeanHandler<>(Paciente.class),
                    direccion.getId()
            );
            paciente.setDireccion(direccion);
            pacientes.add(paciente);
        }
        return pacientes;
    }
}
