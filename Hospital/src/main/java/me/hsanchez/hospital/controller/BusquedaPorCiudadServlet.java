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
import org.apache.commons.lang3.math.NumberUtils;

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
            
            String page = req.getParameter("page");
            String perPage = req.getParameter("perPage");
            int pageInt = 1;
            int perPageInt = 5;
            
            if(page != null && NumberUtils.isCreatable(page)) {
                pageInt = Integer.parseInt(page, 10);
            }
            
            if(perPage != null && NumberUtils.isCreatable(perPage)) {
                perPageInt = Integer.parseInt(perPage, 10);
            }
            
            req.setAttribute("page", pageInt);
            req.setAttribute("perPage", perPageInt);
            req.setAttribute("buscado", true);
            
            req.setAttribute("hasPrev", pageInt != 1);
            
            try {
                ServiciosHospitalPortType port = service.getServiciosHospitalPort();
                Holder<ListaPacientes> pacientes = new Holder<>();
                Holder<RespuestaError> error = new Holder<>();
                Holder<Integer> total = new Holder<>();
                port.getPacientesPorCiudad(q, pageInt, perPageInt, pacientes, error, total);
                
                if(error.value.isFallo()) {
                    throw new QueryExecutionException(error.value.getMensaje());
                }
                
                req.setAttribute("resultados", pacientes.value.getItem());
                req.setAttribute("hasNext", (pageInt * perPageInt) < total.value);
            } catch (Exception ex) {
                req.setAttribute("error", ex);
            }

        } else {
            req.setAttribute("page", 1);
        }
        
        req.getRequestDispatcher("/resultado-busqueda.jsp").forward(req, resp);
    }
}
