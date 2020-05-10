/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.exceptions;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class QueryExecutionException extends Exception {

    public QueryExecutionException(String message) {
        super(message);
    }
    
    public QueryExecutionException(String message, Throwable t) {
        super(message, t);
    }
    
}
