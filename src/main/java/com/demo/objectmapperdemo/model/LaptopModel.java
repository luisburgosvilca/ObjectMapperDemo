/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.demo.objectmapperdemo.model;

//import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

/**
 *
 * @author ASUS
 */
//@JsonIgnoreProperties(ignoreUnknown = true)
public class LaptopModel {
    
    private String brand;
    private String model;

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public String toString() {
        return "LaptopModel{" + "brand=" + brand + ", model=" + model + '}';
    }
    
}
