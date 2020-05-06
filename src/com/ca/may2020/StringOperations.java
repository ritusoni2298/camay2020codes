package com.ca.may2020;
import java.lang.reflect.Array;
import java.util.*;

abstract class AbstractDemo{
    int a =10;
    static int b = 20;
    abstract public void printValues();
    public void printValueWithVariables(){
        System.out.println("a="+a+" b= "+b);
    }
}
interface InterfaceDemo{
    int a =10;
    public void printValues(); // abstract by default
    //default and static
    public default void printValuesDefault(){
        System.out.println("a = "+a);
    }
    public static void printValuesStatic(){
        System.out.println("static");
    }
}

public class StringOperations {
    public static void main(String[] args) {
        String st = "Morning";
        String st1 = "Morning";
        String st2 = new String("Morning");
        String st3 = new String("Morning");

        if(st == st1){ //true//.equals(st)
            System.out.println("equal");//
        }
        if(st == st2){//false
            System.out.println("Equal st and st2");//
        }
        System.out.println(st.toLowerCase());
        //swap the cases of the String
        char[] ch = st.toCharArray();
        for(int i=0;i<ch.length;i++){
            if(ch[i] >='a' && ch[i] <='z'){
                ch[i]-=32;
            }else if(ch[i] >= 'A' && ch[i]<='Z'){
                ch[i]+=32;
            }
        }
        String st4 = String.valueOf(ch);
        System.out.println(st4);

        //"ing"
        System.out.println(st.contains("ing"));
        System.out.println(st.lastIndexOf("n"));

        //Split and Join
        // \d \w "[A-Za-z0-9]*."
        String st5 = "my.name.is.xyz";
        String[] split = st5.split("\\.");
        for( String i : split){
            System.out.println(i);
        }
        //join by _
        String joined = String.join("_k",split);
        System.out.println(joined);

        String s = joined.substring(2,6);
        String s1 = joined.replace("_k",".");

        //String Builder
        StringBuilder sb = new StringBuilder(st5);
        sb.append(" surname");
        sb.replace(2,4,"a");

        //Wrapper Classes
        Integer i = 12;
        Double d = 123.23;
        Character chr = new Character('a');
        System.out.println(i == 12);
        String string ="I1D2I3";// , num =10
        int num = 12;
        String[] arr = string.split("");
        for(i=0;i<arr.length;i++){
            if(arr[i].equals("I")){
                num+=Integer.parseInt(arr[i+1]);
            }else if(arr[i].equals("D")){
                num-=Integer.parseInt(arr[i+1]);
            }else{
                continue;
            }
        }
        System.out.println(num);

        //Collection
        List<Integer> ls = new ArrayList<>();
        ls.addAll(Arrays.asList(1,3,4,5,6,12,3));

        //[23,21,32,"st","a","b","c",45,5]

    }
}
