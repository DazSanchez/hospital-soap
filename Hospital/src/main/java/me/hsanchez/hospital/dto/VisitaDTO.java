/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dto;

import com.itorizaba.servicioshospital.Visita;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import javax.xml.datatype.DatatypeConfigurationException;
import javax.xml.datatype.DatatypeFactory;
import javax.xml.datatype.XMLGregorianCalendar;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class VisitaDTO extends Visita {
    private int idPaciente;
    private int idConsultorio;

    public void setFecha(Date date) {
        LocalDate localDate = date.toLocalDate();
        
        try {
            XMLGregorianCalendar xmlGregorianCalendar = DatatypeFactory.newInstance().newXMLGregorianCalendar(localDate.toString());
            super.fecha = xmlGregorianCalendar;
        } catch (DatatypeConfigurationException ex) {
            super.fecha = null;
        }
    }
    
    public String getFechaFormateada() {
        XMLGregorianCalendar xmlsGregorianCalendar = super.fecha;
        java.util.Date date = xmlsGregorianCalendar.toGregorianCalendar().getTime();
        
        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
        return formatter.format(date);
    }

    public int getIdPaciente() {
        return idPaciente;
    }

    public void setIdPaciente(int idPaciente) {
        this.idPaciente = idPaciente;
    }

    public int getIdConsultorio() {
        return idConsultorio;
    }

    public void setIdConsultorio(int idConsultorio) {
        this.idConsultorio = idConsultorio;
    }
    
    public static VisitaDTO newVisitaDTO(Visita visita) {
        VisitaDTO dto = new VisitaDTO();
        
        dto.setId(visita.getId());
        dto.setObservaciones(visita.getObservaciones());
        dto.setFecha(visita.getFecha());
        
        return dto;
    }
}
