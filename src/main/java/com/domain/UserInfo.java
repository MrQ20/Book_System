package com.domain;

import java.util.List;

public class UserInfo {
    private Integer id;
    private String email;
    private String username;
    private String password;
    private Integer statu;
    private List<Roles> roles;
    private  String statuStr;
    private List<Books> books;
    public Integer getId() {
        return id;
    }



    public void setId(Integer id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getStatu() {
        return statu;
    }

    public void setStatu(Integer statu) {
        this.statu = statu;
    }

    public List<Roles> getRoles() {
        return roles;
    }

    public void setRoles(List<Roles> roles) {
        this.roles = roles;
    }

    public String getStatuStr() {
        if(statu==1){
            statuStr="激活";
        }
        else if (statu==0){
            statuStr="未激活";
        }
        return statuStr;
    }

    public void setStatuStr(String statuStr) {
        this.statuStr = statuStr;
    }

    public List<Books> getBooks() {
        return books;
    }

    public void setBooks(List<Books> books) {
        this.books = books;
    }
}
