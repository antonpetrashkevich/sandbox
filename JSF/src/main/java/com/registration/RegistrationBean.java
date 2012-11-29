package com.registration;

import com.lookup.LookupBean;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * User: Anton
 * Date: 29.11.12
 * Time: 16:42
 */

@ManagedBean(name = "registrationBean")
public class RegistrationBean {

    @ManagedProperty(value = "#{lookupBean}")
    private LookupBean lookupBean;

    private String firstName;
    private String lastName;
    private String fullName;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String registerUser() {
        fullName = firstName + " " + lastName;

        ExternalContext context =
                FacesContext.getCurrentInstance().getExternalContext();
        HttpServletRequest request =
                (HttpServletRequest) context.getRequest();
        HttpServletResponse response =
                (HttpServletResponse) context.getResponse();

        return lookupBean.validate(fullName);
    }

    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setLookupBean(LookupBean lookupBean) {
        this.lookupBean = lookupBean;
    }
}
