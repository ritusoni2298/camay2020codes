package com.ca.may2020;

import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

public class FileHandling {
    //Reader Writer
    //FileInputStream  FileOutputStream
    public static void main(String[] args) {
        try{
            FileWriter w = new FileWriter("/home/consultad/file1.txt");
            String st = "Welcome to the training";
            w.append(st);
            w.append(st);
            w.close();
        }catch(IOException e){
            e.printStackTrace();
        }
        try{
            FileReader rf = new FileReader("/home/consultad/file1.txt");
//            System.out.println((char)rf.read());
//            System.out.println((char)rf.read());
            int i = rf.read();
            while(i!=-1){
                System.out.print((char)i);
                i=rf.read();
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

}
