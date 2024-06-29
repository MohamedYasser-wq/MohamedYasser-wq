package com.example.cashout.Data;

public class RequestLogin {

    private String nationalId;
    private String password;

    public RequestLogin(String nationalId, String password) {
        this.nationalId = nationalId;
        this.password = password;
    }

    public String getNationalId() {
        return nationalId;
    }

    public void setNationalId(String nationalId) {
        this.nationalId = nationalId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
