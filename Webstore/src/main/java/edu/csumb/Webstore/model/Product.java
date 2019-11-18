//This is your model. This file should only contain getters and setters, along with the variables your struct uses.
//DONT FORGET THE CONSTRUCTOR! Getters and setters must be setup to match the name exactly
//or else you will have many errors.
package edu.csumb.Webstore.model;

import io.swagger.annotations.ApiModelProperty;

public class Product
{
    private String ID;
    private String description;
    private String imageURL;
    private double price;
    private int stock;

    public Product(String ID, String description, String imageURL, double price, int stock){
        this.ID = ID;
        this.description = description;
        this.imageURL = imageURL;
        this.price = 0.0;
        stock = 0;
    }

    public String getID(){
        return ID;
    }

    public void setID(String ID){
        this.ID = ID;
    }

    public String getDescription(){
        return description;
    }

    public void setDescription(String description){
        this.description = description;
    }

    public String getimageURL(){
        return imageURL;
    }

    public void setImageURL(String imageURL){
        this.imageURL = imageURL;
    }

    public double getPrice(){
        return price;
    }

    public void setPrice(double price){
        this.price = price;
    }

    public int getStock(){
        return stock;
    }

    public void setStock(int stock){
        this.stock = stock;
    }
}