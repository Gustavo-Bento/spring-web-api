package com.bento.springwebapi.model;

public class Usuario {

    private Integer id;
    private String log;
    private String password;

    public Usuario() {}
    public Usuario(String log, String password) {
        this.log = log;
        this.password = password;
    }

    @Override
    public String toString() {
        return "Usuario{" +
                ", log='" + log + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getLog() {
        return log;
    }

    public void setLog(String log) {
        this.log = log;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
