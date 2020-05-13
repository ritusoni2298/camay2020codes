package com.ca.may2020;
interface OneInterface{
    int a =10;
    int b = 20;
    //abstract
    public void printDetails();
    //default
    public default void defaultTest(){
        System.out.println("first interface");
    }
    //static methods are not overridden
    public static void staticTest(){
        System.out.println("first static method");
    }

//    public void demo();
}

interface TwoInterface{
    int a= 40;
    int c = 30;
    public void printDetails();
//    public void test();
    public default void defaultTest(){
        System.out.println("second interface");
//        return 1;
    }
    public static int staticTest(){
        System.out.println("second static method");
        return 0;
    }
    public default int defaultdemo(int abs){
        return abs+abs;
    }

}

abstract class abstractClass{
    int abs;
    public int abstractMethod(int abs){
        this.abs = abs;
        return abs+abs;
    }

}


public class BaseClass extends abstractClass implements OneInterface, TwoInterface{
    int x;
    public int abstractMethod(int x){
        return super.abstractMethod(x);
    }

    @Override
    public void printDetails() {
        System.out.println("print details"+" a"+OneInterface.a);
    }
    public void defaultTest(){
        System.out.println("base class");
    }
    public int staticTest(){
        System.out.println("second static method");
        return 0;
    }

}
