/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.wsdl;

import com.itorizaba.servicioshospital.DetallePaciente;
import com.itorizaba.servicioshospital.ListaPacientes;
import com.itorizaba.servicioshospital.RespuestaError;
import javax.jws.WebService;
import javax.xml.ws.Holder;
import me.hsanchez.hospital.dto.ResultadoBusquedaDTO;
import me.hsanchez.hospital.exceptions.QueryExecutionException;
import me.hsanchez.hospital.service.PacienteService;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebService(serviceName = "ServiciosHospital", portName = "ServiciosHospitalPort", endpointInterface = "com.itorizaba.servicioshospital.ServiciosHospitalPortType", targetNamespace = "http://www.itorizaba.com/ServiciosHospital.wsdl", wsdlLocation = "WEB-INF/wsdl/ServiciosHospital.wsdl")
public class ServiciosHospital {
    
    private final PacienteService pacienteService;

    public ServiciosHospital() {
        this.pacienteService = new PacienteService();
    }
    
    /**
     * Obtiene los pacientes de una determinada ciudad
     * @param ciudad Ciudad a considerar para la búsqueda
     * @param pagina Página de listado
     * @param cantidad Cantidad de resultados por página
     * @param pacientes Lista de pacientes en la ciudad
     * @param error Error de petición
     * @param total Total de registros de la búsqueda sin paginación
     */
    public void getPacientesPorCiudad(String ciudad, int pagina, int cantidad, Holder<ListaPacientes> pacientes, Holder<RespuestaError> error, Holder<Integer> total) {
        RespuestaError re = new RespuestaError();
        error.value = re;
        re.setFallo(false);
        
        try {
            ResultadoBusquedaDTO<ListaPacientes> resultado = this.pacienteService.obtenerPorCiudad(ciudad, pagina, cantidad);
            pacientes.value = resultado.getPayload();
            total.value = resultado.getTotal();
        } catch (QueryExecutionException ex) {
            re.setFallo(true);
            re.setMensaje(ex.getMessage() + ": " + ex.getCause().getMessage());
            pacientes.value = new ListaPacientes();
            total.value = 0;
        }
    }

    /**
     * Obtiene el detalle de un expediente por su número de expediente
     * @param expediente Número de expediente del paciente
     * @param detalle Detalle del expediente
     * @param error Error de petición
     */
    public void getDetallePaciente(int expediente, Holder<DetallePaciente> detalle, Holder<RespuestaError> error) {
        RespuestaError re = new RespuestaError();
        error.value = re;
        re.setFallo(false);
        
        try {
            DetallePaciente respuesta = this.pacienteService.obtenerDetalle(expediente);
            detalle.value = respuesta;
        } catch (QueryExecutionException ex) {
            re.setFallo(true);
            re.setMensaje(ex.getMessage() + ": " + ex.getCause().getMessage());
            detalle.value = new DetallePaciente();
        }
    }
    
}
