package edu.csumb.Webstore.model;

import java.util.HashMap;

import org.springframework.data.mongodb.core.mapping.Document;

import io.swagger.annotations.ApiModelProperty;

@Document(collection = "User")
public class User
{
    private String ID;
    private String password;
    private HashMap<String, Integer> cart = new HashMap<String, Integer>();
    
    public User(String ID, String password){
        this.ID = ID;
        this.password = password;
    }

    public String getID(){
        return ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getPassword(){
        return password;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public HashMap<String, Integer> getCart(){
        return cart;
    }

    public void setCart(HashMap<String, Integer> cart){
        this.cart = cart;
    }


}