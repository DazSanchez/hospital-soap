/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package me.hsanchez.hospital.datasource;

import com.mysql.cj.jdbc.MysqlDataSource;

/**
 *
 * @author hsanchez <hsanchez.dev@gmail.com>
 */
public class HospitalDatasource {
    private static final MysqlDataSource DATASOURCE;
    
    static {
        DATASOURCE = new MysqlDataSource();
        DATASOURCE.setUrl("jdbc:mysql://localhost:3306/hospital?useSSL=false&allowPublicKeyRetrieval=true");
        DATASOURCE.setUser("hospital_user");
        DATASOURCE.setPassword("hospital_user_password");
    }

    public static MysqlDataSource getDataSource() {
        return DATASOURCE;
    }
}
