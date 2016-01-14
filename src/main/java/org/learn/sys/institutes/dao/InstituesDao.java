/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.learn.sys.institutes.dao;

import java.util.HashMap;
import java.util.Map;
import javax.sql.DataSource;
import org.learn.sys.institutes.model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

/**
 *
 * @author Vinay
 */
@Repository
public class InstituesDao {
    
    @Autowired
    DataSource dataSource;
    
    public String saveInstitute(Institute inst) {
        NamedParameterJdbcTemplate jdbcTemplate = new NamedParameterJdbcTemplate(dataSource);
        
        String sql = "insert into institutes values (:name, :type)";
        
        Map<String, String> namedParms = new HashMap<>();
        namedParms.put("name", inst.getName());
        namedParms.put("type", inst.getType());
        
        jdbcTemplate.update(sql, namedParms);
        
        return "SUCCESS";
    }
}
