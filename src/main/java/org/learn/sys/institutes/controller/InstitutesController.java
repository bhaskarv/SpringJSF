/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.learn.sys.institutes.controller;

import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import org.learn.sys.institutes.model.Institute;
import org.learn.sys.institutes.service.InstituesService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

/**
 *
 * @author Vinay
 */
@Component
@Scope("request")
public class InstitutesController {
    private Institute instittue;

    @Autowired
    InstituesService service;

    public InstitutesController() {
        this.instittue = new Institute();
    }
    
    
    public String addInstitute() {
        service.saveInstitute(instittue);
        FacesContext.getCurrentInstance().addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Institute is added successfully", null));
        return null;
    }
    public Institute getInstittue() {
        return instittue;
    }

    public void setInstittue(Institute instittue) {
        this.instittue = instittue;
    }
}
