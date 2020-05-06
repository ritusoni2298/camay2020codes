package com.ca.may2020;

import java.util.Scanner;

public class FlowControlStatement {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int num= 12;
        if(num>0){
            System.out.println("positive");
        }else if(num==0) {
            System.out.println("Zero");
        }else
        {
            System.out.println("negative");
        }

        //Leap Year
        int year = 2020;
        /*
        * year is divisible by 4, and not divisible by 100 => leap year
        * divisible by 100 and 400, then it is a leap year
        *  (year % 4 == 0 && year % 100!=0) || (year % 400==0)
        * */
        int a;
        if(num>0){
            a=10;
        }
//        System.out.println(a);
        if(year %4 == 0){
            if(year %100 == 0){
                if(year%400 ==0){
                    System.out.println("leap year");
                }else{
                    System.out.println("not a leap year");
                }
            }else{
                System.out.println("leap year");
            }
        }else{
            System.out.println("not leap year");
        }

        //switch statements
        /*
        * switch(value)
        * {
        *   case <const Values>:
        *       //statements
    *           break;
    *       case <const value 2>:
    *           //statements
    *           break;
    * ..
    * ..
    *       default:
    *           //statements
    *           break;
        *
        * }
        * */
        System.out.println("enter day");
        int day = sc.nextInt();
        String daySt;
        final int a1=2;
        switch (day){
            case 1:
                daySt = "Sunday";
                break;
            case 2:
                daySt = "Monday";
                break;
            case 3:
                daySt = "Tuesday";
                break;
            case 4:
                daySt = "Wednesday";
                break;
            case 5:
                daySt = "Thursday";
                break;
            default :
                daySt = "weekend";
                break;
        }
    System.out.println(daySt);
        int sum=0;
        //looping Statements
        for(int i=0;i<50;i+=2){
//            System.out.println();
            sum+=i;
        }
        System.out.println("sum is "+sum);
        int i=0;
        sum=0;
        while(i<30){

            if(sum>9){
                System.out.println("maximum sum reached");
                break;
            }
            sum+=i;
            i+=3;
        }
        i=0;sum=40;
        do{
            if(i%3==0){
                continue;
            }
            i+=1;
            sum+=i;
        }while(sum<40);

        first:for(int i1=0;i1<20;i++){
            second:for(int j=10;j<20;j++){
                if(j%i==0){
                   break first;
                }
            }
        }

        int[] arr;
        arr= new int[3];
        int[] arr2 = new int[]{1,2,3,4};
        int[][] arr3 = new int[3][];
        arr[1]=2;
        for(i=0;i<arr.length;i++){
            arr[i]=i+1;
        }




    }
}
