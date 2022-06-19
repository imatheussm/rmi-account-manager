package com.ufpa.accountmanager;

public class Account {
    private String username, password, name;

    public Account(String username, String password, String name) {
        setUsername(username);
        setPassword(password);
        setName(name);
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

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String toString() {
        return "[Account] User: " + this.name + " (username: " + this.username + ")\n";
    }
}
