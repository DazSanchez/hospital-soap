/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.wsdl;

import javax.jws.WebService;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
@WebService(serviceName = "ServiciosHospital", portName = "ServiciosHospitalPort", endpointInterface = "com.itorizaba.servicioshospital.ServiciosHospitalPortType", targetNamespace = "http://www.itorizaba.com/ServiciosHospital.wsdl", wsdlLocation = "WEB-INF/wsdl/ServiciosHospital.wsdl")
public class ServiciosHospital {

    public com.itorizaba.servicioshospital.ListaPacientes getPacientesPorCiudad(java.lang.String ciudad) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }

    public com.itorizaba.servicioshospital.DetallePaciente getDetallePaciente(int expediente) {
        //TODO implement this method
        throw new UnsupportedOperationException("Not implemented yet.");
    }
    
}
