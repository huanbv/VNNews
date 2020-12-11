package com.example.news.models;

public class ModelLogInActivity {
    private String passwordEt;
    private  String usernameEt;

    // Constructor
    public ModelLogInActivity(String passwordEt, String usernameEt) {
        this.passwordEt = passwordEt;
        this.usernameEt = usernameEt;
    }


    // Getters / Setters

    public String getPasswordEt() {
        return passwordEt;
    }

    public void setPasswordEt(String passwordEt) {
        this.passwordEt = passwordEt;
    }

    public String getUsernameEt() {
        return usernameEt;
    }

    public void setUsernameEt(String usernameEt) {
        this.usernameEt = usernameEt;
    }
}
