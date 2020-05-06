package com.ca.may2020;

import java.util.Scanner;

public class ScannerDemo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i = sc.nextInt();
        double d = sc.nextDouble();
        String s = sc.nextLine();
        if(sc.hasNextInt()){
            System.out.println(sc.nextInt());
        }
        System.out.println(s+"\n"+d+"\n"+i);

    }
}
