/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dto;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class ResultadoBusquedaDTO<T> {

    private Integer total;
    private T payload;

    public Integer getTotal() {
        return total;
    }

    public void setTotal(Integer total) {
        this.total = total;
    }

    public T getPayload() {
        return payload;
    }

    public void setPayload(T payload) {
        this.payload = payload;
    }

}
