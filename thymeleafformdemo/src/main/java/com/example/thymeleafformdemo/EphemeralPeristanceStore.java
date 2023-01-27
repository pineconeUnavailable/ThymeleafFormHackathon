package com.example.thymeleafformdemo;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.Iterator;
import java.util.TreeSet;

public class EphemeralPeristanceStore {
    private final HashMap<String, LoginPOJO> users;
    private final HashMap<String, String> sessionId;
    private final TreeSet<Project> projectTree;
        
    public boolean store(LoginPOJO obj){
        if(users.containsKey(obj.getUname())) {
            return false;
        }

        users.put(obj.getUname(), obj);
        return true;
    }
    
    public void storeProject(Project obj) {
    	projectTree.add(obj);
    }
    
    public Iterator<Project> getProjects(){
		return projectTree.iterator();
    }

    public LoginPOJO get(String username) {
        return users.get(username);
    }

    public boolean has(String username) {
        return users.containsKey(username);
    }

    public EphemeralPeristanceStore() {
        this.sessionId = new HashMap<>();
        this.users = new HashMap<>();
        this.projectTree = new TreeSet<>();
    }

    public String getSession(String username){
        return sessionId.get(username);
    }

    public void setSession(String username, String sessionToken){
        sessionId.put(username, sessionToken);
    }
    
    public void storeTestProjects(){
    	Project testProj1 = new Project(1l,"Blah Test","Blah Type","#FF0000","Blah Description",1,1.00,true,LocalDateTime.now());
    	Project testProj2 = new Project(1l,"Blah Test2","Blah Type2","#FFFF00","Blah Description2",1,1.00,true,LocalDateTime.now());
    	Project testProj3 = new Project(1l,"Blah Test3","Blah Type3","#FFFFF0","Blah Description3",1,1.00,true,LocalDateTime.now());
    	storeProject(testProj1);
    	storeProject(testProj2);
    	storeProject(testProj3);
    }
}
