/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.learn.sys.institutes.service;

import org.learn.sys.institutes.dao.InstituesDao;
import org.learn.sys.institutes.model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author Vinay
 */
@Service
public class InstituesService {
    
    @Autowired
    InstituesDao  instDao;
    
    public String saveInstitute(Institute institute) {
        
        return instDao.saveInstitute(institute);
    }
}
