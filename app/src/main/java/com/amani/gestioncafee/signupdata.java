package com.amani.gestioncafee;

public class signupdata {
    //private variables
    int id;
    String Username;
    String name;
    String email;
    String password;

    public String getPassword() {
        return password;
    }
    public void setPassword(String password) {
        this.password = password;
    }


    // Empty constructor
    public signupdata(){

    }





    // constructor
    public signupdata(int id, String Username, String  name,String email){
        this.id = id;
      this.email=email;
      this.name=name;
      this.Username=Username;
    }


    // getting ID
    public int getID(){
        return this.id;
    }

    // setting id
    public void setID(int id){
        this.id = id;
    }

    public String getUsername() {
        // TODO Auto-generated method stub
        return Username;
    }

    // setting  first name
    public void setUsername(String Username){
        this.Username =Username;
    }
    public String getName() {
        // TODO Auto-generated method stub
        return name;
    }

    public void setName(String name){
        this.name =name;
    }
    public String getEmail() {
        // TODO Auto-generated method stub
        return email;
    }
    public void setEmail(String email){
        this.email=email;
    }


}

