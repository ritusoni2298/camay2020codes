package com.ca.may2020;


public class Customer{
    //attributes
    String name;
    private String id;
    private String address;//instance variables
    //class variable
    static String lock;
    protected String orderName;
    Customer(){
        name ="vignesh";
        id="101";
        address ="ny";
    }

    //behavior
    public void printData(){
        System.out.println(name+"name "+":: id"+id+":: address"+address);
    }
}