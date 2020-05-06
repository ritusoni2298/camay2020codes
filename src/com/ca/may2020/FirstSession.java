package com.ca.may2020;

import com.consultadd.may2020.Demo1;
import com.consultadd.may2020.ImportDemo;

public class FirstSession {
    public static void main(String[] args) {
         //object reference
        Customer customer1;//null
        Customer customer = new Customer(); //customer(address) stack => name4 + id4 + address4 => heap
        customer.printData();
//        customer1.printData();
        //primitive data types
        byte b = 10;
        short s = 20;
        int i=10; //default integer value
        long l = 10L;
        i=(int)10.3;
        double d = 1.12;//floating point number
        float f = 1.12f;
        d=10;
        boolean b1 = true;
        char c = 'a';
        //Arithematic Operations
        //+,-,*,/,%
        int a=2;
        int div = i/a;
        String st ="Hello";
        System.out.println((char)('a'+'b')); //ascii sum of the characters
        System.out.println("a"+"b"); //concatination

//        a=a+2;, a-=2,a*=2,a/=2,a%=2
        a+=2;
        //Relational Operators
        //<,>,<=,>=,!=,== //resultant data type is going to be ""boolean""
        System.out.println('a'>12);
        //equals operator ==, assignment =

        //Logical Operators // short hand operators
        //OR  || => true || false => true
        //AND && => false && true => false
        //XOR ^ => false ^ true => false
        //NOT ! => !true => false


        //Bitwise Operator
        //OR |=> 5 | 5 => 101 | 101 => 101
        //AND & => 101 & 101 => 101
        //Not ~ => ~101 => 010 //2
        //Xor ^ => 101 ^ 110 => 100
        //Left Shift  00111100 << 2 => 00001111
        //Right Shift 00111100 >> 2 => 11110000

        //turnary]
        int age =12;
        String vote = age>18 ? "can vote" : "can't vote";
        //increment and decrement
        int a1=2;
        a1 = a1++ + ++a1 + a1-- + ++a1;
             // 2+4 + 4 +4
        // a1=3 , a1+2
        System.out.println(a1);
        String sd="abc";
        System.out.println(sd instanceof Object);


    }
}



