package com.example.news.models;

import android.widget.Button;

public class ModelRegisterFragment {
    private String lastnameEt;
    private String midlenameEt;
    private String firstnameEt;
    private String usernameEt;
    private String passwordEt;
    private String rePasswordEt;
    private String phonebumberEt;
    private String forgetPasswordTv;
    private String logInTv;
    private Button registerBtn ;


    // constructor
    public ModelRegisterFragment(String lastnameEt, String midlenameEt, String firstnameEt
            , String usernameEt, String passwordEt, String rePasswordEt, String phonebumberEt
            , String forgetPasswordTv, String logInTv, Button registerBtn) {


        this.lastnameEt = lastnameEt;
        this.midlenameEt = midlenameEt;
        this.firstnameEt = firstnameEt;
        this.usernameEt = usernameEt;
        this.passwordEt = passwordEt;
        this.rePasswordEt = rePasswordEt;
        this.phonebumberEt = phonebumberEt;
        this.forgetPasswordTv = forgetPasswordTv;
        this.logInTv = logInTv;
        this.registerBtn = registerBtn;
    }


    /* Getters / Setters*/

    public String getLastnameEt() {
        return lastnameEt;
    }

    public void setLastnameEt(String lastnameEt) {
        this.lastnameEt = lastnameEt;
    }

    public String getMidlenameEt() {
        return midlenameEt;
    }

    public void setMidlenameEt(String midlenameEt) {
        this.midlenameEt = midlenameEt;
    }

    public String getFirstnameEt() {
        return firstnameEt;
    }

    public void setFirstnameEt(String firstnameEt) {
        this.firstnameEt = firstnameEt;
    }

    public String getUsernameEt() {
        return usernameEt;
    }

    public void setUsernameEt(String usernameEt) {
        this.usernameEt = usernameEt;
    }

    public String getPasswordEt() {
        return passwordEt;
    }

    public void setPasswordEt(String passwordEt) {
        this.passwordEt = passwordEt;
    }

    public String getRePasswordEt() {
        return rePasswordEt;
    }

    public void setRePasswordEt(String rePasswordEt) {
        this.rePasswordEt = rePasswordEt;
    }

    public String getPhonebumberEt() {
        return phonebumberEt;
    }

    public void setPhonebumberEt(String phonebumberEt) {
        this.phonebumberEt = phonebumberEt;
    }

    public String getForgetPasswordTv() {
        return forgetPasswordTv;
    }

    public void setForgetPasswordTv(String forgetPasswordTv) {
        this.forgetPasswordTv = forgetPasswordTv;
    }

    public String getLogInTv() {
        return logInTv;
    }

    public void setLogInTv(String logInTv) {
        this.logInTv = logInTv;
    }

    public Button getRegisterBtn() {
        return registerBtn;
    }

    public void setRegisterBtn(Button registerBtn) {
        this.registerBtn = registerBtn;
    }
}
