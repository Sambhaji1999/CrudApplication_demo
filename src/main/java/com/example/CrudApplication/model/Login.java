package com.example.CrudApplication.model;

import javax.persistence.Entity;
import javax.persistence.Id;


@Entity
public class Login {
    @Id
    int id;
    String username;
    String password;



    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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

    public void setPassword() {
        this.password = password;

    }



    @Override
    public String toString() {
        return "Login{" +
                /*"id=" + id +*/
                ", username='" + username + '\'' +
                ", password='" + password + '\'' +
                '}';
    }

}

