package org.learn.sys.institutes.controller;

import java.util.List;
import org.learn.sys.institutes.model.Institute;
import org.learn.sys.institutes.service.InstituesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

@Controller
public class InstsController {
    
    @Autowired
    InstituesService service;
    
    @RequestMapping(value="/insts", method = RequestMethod.GET)
    public @ResponseBody List<Institute> getInsts() {
        return service.getAllInstitutes();
    }
    
    @RequestMapping(value = "insts/{typeId}", method = RequestMethod.GET)
    public @ResponseBody List<Institute> getInstitutesByType(@PathVariable("typeId") String instTye) {
        return service.getInstitutesByType(instTye);
    }
    
    @RequestMapping(value="/insts/add", method=RequestMethod.POST)
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void addInstitute(@RequestBody Institute institute) {
         service.saveInstitute(institute);
         return;
    }
}
