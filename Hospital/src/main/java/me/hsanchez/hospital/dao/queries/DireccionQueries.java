/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.dao.queries;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class DireccionQueries {

    public static final String CONTAR_POR_CIUDAD = "SELECT COUNT(*) FROM direcciones WHERE ciudad LIKE ?";
    public static final String OBTENER_POR_CIUDAD = "SELECT * FROM direcciones WHERE ciudad LIKE ? LIMIT ?,?";
}
