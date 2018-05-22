package com.panoskakos.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;
import java.io.Serializable;

@XmlRootElement
@XmlAccessorType(XmlAccessType.FIELD)
public class Offer implements Serializable
{

    public Offer(){

    }

    private String description;


    private double price;


    private boolean expired;

    private String dateOffered;

    private String expiryDate;

    public String getDateOffered() {
        return dateOffered;
    }

    public void setDateOffered(String dateOffered) {
        this.dateOffered = dateOffered;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }

    public boolean isExpired() {
        return expired;
    }

    public void setExpired(boolean expired) {
        this.expired = expired;
    }






    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

//    public boolean isExpired() {
//        return expired;
//    }
//
//    public void setExpired(boolean expired) {
//        this.expired = expired;
//    }
//
//    public LocalDate getDateOffered() {
//        return dateOffered;
//    }
//
//    public void setDateOffered(LocalDate dateOffered) {
//        this.dateOffered = dateOffered;
//    }


}