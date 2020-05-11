/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.controller;

import com.itorizaba.servicioshospital.DetallePaciente;
import com.itorizaba.servicioshospital.RespuestaError;
import com.itorizaba.servicioshospital.ServiciosHospital;
import com.itorizaba.servicioshospital.ServiciosHospitalPortType;
import com.itorizaba.servicioshospital.Visita;
import java.io.IOException;
import java.util.List;
import java.util.stream.Collectors;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceRef;
import me.hsanchez.hospital.dto.VisitaDTO;
import me.hsanchez.hospital.exceptions.QueryExecutionException;
import org.apache.commons.lang3.math.NumberUtils;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebServlet(name = "DetallePacienteServlet", urlPatterns = {"/paciente/*"})
public class DetallePacienteServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Hospital/ServiciosHospital.wsdl")
    private ServiciosHospital service;
    
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        try {
            String path = req.getPathInfo();
            String id = path.substring(1);
            
            if(id.isEmpty()) {
                resp.sendRedirect(req.getContextPath() + "/");
                return;
            }
            
            if(!NumberUtils.isCreatable(id)) {
                throw new Exception("Número de expediente deber ser numérico: " + id);
            }
            
            ServiciosHospitalPortType port = service.getServiciosHospitalPort();
            Holder<DetallePaciente> detalle = new Holder<>();
            Holder<RespuestaError> error = new Holder<  >();
            port.getDetallePaciente(Integer.parseInt(id, 10), detalle, error);
            
            if(error.value.isFallo()) {
                throw new QueryExecutionException(error.value.getMensaje());
            }
            
            List<Visita> visitas = detalle.value.getVisitas().getItem();
            List<VisitaDTO> dtos = visitas.stream().map(v -> VisitaDTO.newVisitaDTO(v)).collect(Collectors.toList());
            
            req.setAttribute("paciente", detalle.value.getPaciente());
            req.setAttribute("medico", detalle.value.getMedico());
            req.setAttribute("consultorio", detalle.value.getConsultorio());
            req.setAttribute("visitas", dtos);
        } catch (Exception ex) {
            req.setAttribute("error", ex);
        }
        
        req.getRequestDispatcher("/detalle-paciente.jsp").forward(req, resp);
    }
}
