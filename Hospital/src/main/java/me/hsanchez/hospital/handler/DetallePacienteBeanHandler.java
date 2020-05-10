/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.handler;

import com.itorizaba.servicioshospital.Consultorio;
import com.itorizaba.servicioshospital.DetallePaciente;
import com.itorizaba.servicioshospital.Direccion;
import com.itorizaba.servicioshospital.Especialidad;
import com.itorizaba.servicioshospital.ListaVisitas;
import com.itorizaba.servicioshospital.Medico;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;
import me.hsanchez.hospital.dao.queries.ConsultorioQueries;
import me.hsanchez.hospital.dao.queries.DireccionQueries;
import me.hsanchez.hospital.dao.queries.EspecialidadQueries;
import me.hsanchez.hospital.dao.queries.VisitaQueries;
import me.hsanchez.hospital.dto.ConsultorioDTO;
import me.hsanchez.hospital.dto.MedicoDTO;
import me.hsanchez.hospital.dto.MedicoQueries;
import me.hsanchez.hospital.dto.PacienteDTO;
import me.hsanchez.hospital.dto.VisitaDTO;
import org.apache.commons.dbutils.QueryRunner;
import org.apache.commons.dbutils.handlers.BeanHandler;
import org.apache.commons.dbutils.handlers.BeanListHandler;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class DetallePacienteBeanHandler extends BeanHandler<DetallePaciente> {

    private final QueryRunner qr;

    public DetallePacienteBeanHandler(QueryRunner qr) {
        super(DetallePaciente.class);
        this.qr = qr;
    }

    @Override
    public DetallePaciente handle(ResultSet rs) throws SQLException {
        BeanHandler<PacienteDTO> handler = new BeanHandler<>(PacienteDTO.class);
        PacienteDTO paciente = handler.handle(rs);

        Direccion direccion = qr.query(
                DireccionQueries.OBTENER_POR_ID,
                new BeanHandler<>(Direccion.class),
                paciente.getIdDireccion()
        );
        paciente.setDireccion(direccion);

        List<VisitaDTO> visitas = qr.query(
                VisitaQueries.OBTENER_POR_EXPEDIENTE,
                new BeanListHandler<>(VisitaDTO.class),
                paciente.getIdExpediente()
        );

        ConsultorioDTO consultorio = qr.query(
                ConsultorioQueries.OBTENER_POR_ID,
                new BeanHandler<>(ConsultorioDTO.class),
                paciente.getIdConsultorio()
        );

        MedicoDTO medico = qr.query(
                MedicoQueries.OBTENER_POR_ID,
                new BeanHandler<>(MedicoDTO.class),
                consultorio.getIdMedico()
        );
        
        Especialidad especialidad = qr.query(
                EspecialidadQueries.OBTENER_POR_ID, 
                new BeanHandler<>(Especialidad.class), 
                medico.getIdEspecialidad()
        );
        
        medico.setEspecialidad(especialidad);

        ListaVisitas lista = new ListaVisitas();
        lista.getItem().addAll(visitas);

        DetallePaciente detalle = new DetallePaciente();
        detalle.setPaciente(paciente);
        detalle.setVisitas(lista);
        detalle.setConsultorio(consultorio);
        detalle.setMedico(medico);

        return detalle;
    }
}
