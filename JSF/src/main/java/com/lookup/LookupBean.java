package com.lookup;

import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

/**
 * User: Anton
 * Date: 29.11.12
 * Time: 18:09
 */
@ManagedBean(eager = true)
@ApplicationScoped
public class LookupBean {
    public static final String SUCCESS = "success";
    public static final String ERROR = "error";

    public String validate(String fullName) {
        return fullName.length() > 3 ? SUCCESS : ERROR;
    }

}
