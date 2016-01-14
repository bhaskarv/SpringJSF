package org.learn.sys.institutes.service;

import org.learn.sys.institutes.dao.InstituesDao;
import org.learn.sys.institutes.model.Institute;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class InstituesService {
    
    @Autowired
    InstituesDao  instDao;
    
    public String saveInstitute(Institute institute) {
        
        return instDao.saveInstitute(institute);
    }
}
