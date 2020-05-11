/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.controller;

import com.itorizaba.servicioshospital.ListaPacientes;
import com.itorizaba.servicioshospital.RespuestaError;
import com.itorizaba.servicioshospital.ServiciosHospital;
import com.itorizaba.servicioshospital.ServiciosHospitalPortType;
import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.xml.ws.Holder;
import javax.xml.ws.WebServiceRef;
import me.hsanchez.hospital.exceptions.QueryExecutionException;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebServlet(name = "BusquedaPorCiudadServlet", urlPatterns = {"/busqueda"})
public class BusquedaPorCiudadServlet extends HttpServlet {

    @WebServiceRef(wsdlLocation = "WEB-INF/wsdl/localhost_8080/Hospital/ServiciosHospital.wsdl")
    private ServiciosHospital service;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String q = req.getParameter("q");
        req.setAttribute("q", q);
        
        if(q != null) {
            
            req.setAttribute("buscado", true);
            
            try {
                ServiciosHospitalPortType port = service.getServiciosHospitalPort();
                int pagina = 0;
                int cantidad = 0;
                Holder<ListaPacientes> pacientes = new Holder<>();
                Holder<RespuestaError> error = new Holder<>();
                port.getPacientesPorCiudad(q, pagina, cantidad, pacientes, error);
                
                if(error.value.isFallo()) {
                    throw new QueryExecutionException(error.value.getMensaje());
                }
                
                req.setAttribute("resultados", pacientes.value.getItem());
            } catch (Exception ex) {
                req.setAttribute("error", ex);
            }

        }
        
        req.getRequestDispatcher("/resultado-busqueda.jsp").forward(req, resp);
    }
}
