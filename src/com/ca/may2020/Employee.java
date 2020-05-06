package com.ca.may2020;

import java.util.*;

public class Employee {
    //Attributes //instance variable //default value
    private final long id=count++;
    private String name;
    private double salary;
    private String address;
    private static int count;

    //class Variable
    public static boolean lock;
    Employee(){
        name = "xyz";
        salary=0;
        address =null;

    }
    Employee(String name, String address, double salary){
        this.name = name;
        this.address = address;
        this.salary =salary;

    }
//
//    Employee(String address, double salary, String name){
//        this.name = name;
//        this.address = address;
//        this.salary =salary;
//
//    }

//    private void id(){
//        count++;
//        id=count;
//    }

    //behaviors
    public void printDetails(){
        System.out.println("ID: "+id+" name"+name+" salary"+salary+" address"+address+" Byte"+lock);
    }

    public String printDetails(String name,String address){
        this.name = name;
        this.address = address;
        String modifiedData = "name:"+name+"::address:"+address;
        return modifiedData;
    }

    public void printNameById(long id){ //method parameters => formal parameter
        System.out.println("Name: "+name);
    }

    public double annualSalary(){
        int a=10;//local variables
//        int a=0;
        return 12*salary;
    }

    public double revisedSalary(double bonus){
        return salary+bonus;
    }

    public List<Integer> test(List<Integer> ls){
        ls.add(3);
        return ls;
    }

}
