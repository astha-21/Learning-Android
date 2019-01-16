package com.example.asthasharma.learningandroid;

public class Adapter {
    String name;
    String email;
    String password;
    int id;
    public int getId() {
        return this.id;
    }
    public String getEmail() {
        return this.email;
    }
    public String getPassword() {
        return this.password;
    }
    public String getName(){
        return this.name;
    }
    public void setId(int id) {
        this.id = id;
    }
    public void setEmail(String email) {
        this.email = email;
    }
    public void setPassword(String password) {
        this.password = password;
    }

    public void setName(String name) {
        this.name = name;
    }
}

