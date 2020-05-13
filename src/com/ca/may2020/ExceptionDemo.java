package com.ca.may2020;

//Throwable
//Exceptions
//RuntimeException or unchecked || Checked exception

public class ExceptionDemo {
    public static void main(String[] args) throws Exception{
        try{
            String s = "hello";
            if(s == null){
                throw new NullPointerException();
            }
            Integer i = Integer.parseInt(s);
            int i1 = 12;

        }
        catch(NumberFormatException e){
            e.printStackTrace();
        }catch(NullPointerException e){
            System.out.println("Null value found");
        }
        catch(Exception e){
            System.out.println("exception");
        }
        finally{
            System.out.println("prints anyways");
        }

        System.out.println("hello");
    }

}
