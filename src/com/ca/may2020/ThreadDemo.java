package com.ca.may2020;

class Demo{
    synchronized public void print(int n){
        for(int i =0;i<5;i++){
            try{
                Thread.sleep(500);
            }catch(Exception e){
                System.out.println(e);
            }
            System.out.println(i+n);
        }
    }
}

class ThreadDemo1 extends Thread{
    Demo object;
    ThreadDemo1(Demo object){
        this.object = object;
    }

    public void run() {
        object.print(20);
    }
}

public class ThreadDemo extends Thread{
    //new -start()-> runnable -run()-> running --> terminate
    //        non-runnable (sleep(),wait())
    //Thread ,Runnable
    //4 constructor
    //Thread()
    //Thread(String name)
    //Thread(Runnable r)
    //Thread(Runnable r, string s)
    Demo obj;
    ThreadDemo(Demo obj)
    {
        this.obj=obj;
    }
    public void run(){
        obj.print(30);
    }

    public static void main(String[] args) {
        Demo obj = new Demo();
        ThreadDemo td1 = new ThreadDemo(obj);
        ThreadDemo1 td2 = new ThreadDemo1(obj);

        td1.start();
        td2.start();
    }


}
