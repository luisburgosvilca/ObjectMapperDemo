/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 */

package com.demo.objectmapperdemo;

import com.demo.objectmapperdemo.model.LaptopModel;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import java.io.IOException;
import java.io.StringWriter;
import java.util.List;
import java.util.Map;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author ASUS
 */
public class ObjectMapperDemo {

    public static void main(String[] args) {
        //ejemplo1();
        //ejemplo2();
        //ejemplo3();
        //ejemplo4();
        //ejemplo5();
        ejemplo6();
    }
    
    public static void ejemplo1() {
        String json ="{\"brand\":\"Asus\", \"model\":\"Tuf Gaming\"}";
        //System.out.println("laptop: "+json);
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LaptopModel laptop = objectMapper.readValue(json,LaptopModel.class);
            System.out.println("Laptop:" +laptop);
                   
            } catch (JsonProcessingException ex) {
            Logger.getLogger(ObjectMapperDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ejemplo2(){
        String json ="{\"brand\":\"Asus\", \"model\":\"Tuf Gaming\", \"color\":\"negro\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.configure(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES, false);
        try {
            LaptopModel laptop = objectMapper.readValue(json,LaptopModel.class);
            System.out.println("Laptop:" +laptop);
                   
            } catch (JsonProcessingException ex) {
            Logger.getLogger(ObjectMapperDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ejemplo3(){
        String json ="[{\"brand\":\"Asus\", \"model\":\"Tuf Gaming\"},"
                + "{\"brand\":\"Lenovo\", \"model\":\"ThinkPad\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            LaptopModel[] laptop = objectMapper.readValue(json,LaptopModel[].class);
            
                for(LaptopModel portatil : laptop){
                    System.out.println(portatil);
                }
                   
            } catch (JsonProcessingException ex) {
            Logger.getLogger(ObjectMapperDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }
    
    public static void ejemplo4() {
        String json ="[{\"brand\":\"Asus\", \"model\":\"Tuf Gaming\"},"
                + "{\"brand\":\"Lenovo\", \"model\":\"ThinkPad\"}]";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            List<LaptopModel> laptop = objectMapper.readValue(json,new TypeReference<List<LaptopModel>>(){});
            
                for(LaptopModel portatil : laptop){
                    System.out.println(portatil);
                }
                   
            } catch (JsonProcessingException ex) {
            Logger.getLogger(ObjectMapperDemo.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void ejemplo5() {
        String json ="{\"brand\":\"Asus\", \"model\":\"Tuf Gaming\"}";
        ObjectMapper objectMapper = new ObjectMapper();
        try {
            Map<String,String> laptop = objectMapper.readValue(json,new TypeReference<Map<String,String>>(){});
            
                laptop.keySet().forEach(key ->{
                    System.out.println("Key: "+key);
                    System.out.println("Value: "+laptop.get(key));
                });
            } catch (JsonProcessingException ex) {
            Logger.getLogger(ObjectMapperDemo.class.getName()).log(Level.SEVERE, null, ex);
        } 
    }
    
    public static void ejemplo6() {
        
        LaptopModel laptopModel = new LaptopModel();
        laptopModel.setBrand("Asus");
        laptopModel.setModel("TUF Gaming");
        
        ObjectMapper objectMapper = new ObjectMapper();
        StringWriter stringWriter = new StringWriter();

        try {
            objectMapper.writeValue(stringWriter, laptopModel);
            String json = stringWriter.toString();
            System.out.println(json);
        } catch (IOException ex) {
            Logger.getLogger(ObjectMapperDemo.class.getName()).log(Level.SEVERE, null, ex);
        }
    }    
}
