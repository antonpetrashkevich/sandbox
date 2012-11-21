package com;

import javax.faces.bean.ManagedBean;

/**
 * User: Anton
 * Date: 21.11.12
 * Time: 14:31
 */
@ManagedBean(name = "languagesBean")
public class LanguagesBean {
    private String favoriteLanguage;

    public String getFavoriteLanguage() {
        return favoriteLanguage;
    }

    public void setFavoriteLanguage(String favoriteLanguage) {
        this.favoriteLanguage = favoriteLanguage;
    }

    public String selectLanguage() {
        return "language-selected";
    }
}
