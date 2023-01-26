package com.example.thymeleafformdemo;

import java.util.HashMap;

public class EphemeralPeristanceStore {
    private final HashMap<String, LoginPOJO> users;

    public boolean store(LoginPOJO obj){
        if(users.containsKey(obj.getUname())) {
            return false;
        }

        users.put(obj.getUname(), obj);
        return true;
    }

    public LoginPOJO get(String username) {
        return users.get(username);
    }

    public boolean has(String username) {
        return users.containsKey(username);
    }

    public EphemeralPeristanceStore() {
        this.users = new HashMap<>();
    }
}
