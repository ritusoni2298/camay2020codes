package com.ca.may2020;

import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

//functional interface
interface Operation{
    public int operate(int a,int b);
}

class Impl implements Operation{

    @Override
    public int operate(int a, int b) {
        return a+b;
    }
}

class Emp{
    private int id;
    private String name;
    private double salary;
    Emp(){

    }

    public Emp(int id, String name, double salary) {
        this.id = id;
        this.name = name;
        this.salary = salary;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getSalary() {
        return salary;
    }

    public void setSalary(double salary) {
        this.salary = salary;
    }
}

public class StreamApi {
    public static void main(String[] args) {
        Operation op = new Impl();
        op.operate(2,3);

        // (parameters) -> return a+b
        // (parameters) -> {//implementation}
        Operation op2 = (a,b)->{
            System.out.println("addition is ");
            return a+b;};

        System.out.println(op2.operate(3,4));
        //employee object -> method1 ->method2 -> method3

        Emp[] arr = {new Emp(1,"A",1223344),
                    new Emp(2,"B",124),
                    new Emp(3,"c",345),
                new Emp(1,"Arav",1223344),
                new Emp(1,"Ayush",1223344),
        };
        Stream<Emp> st = Stream.of(arr);

        List<String> names = st.map(e->e.getName()).collect(Collectors.toList());
        for (String name : names) {
            System.out.println(name);
        }
        List<String> name2 = Stream.of(arr).map(e->e.getName()).collect(Collectors.toList());
        for (String name : name2) {
            System.out.println(name);
        }
        Stream<Integer> sin = Stream.iterate(40,n->n+2).limit(20);
        //terminal operation
//        [1,2,3,4,5]
//        []
        Integer[] i = {1,2,3,4,5,6,7,8,9,10};
        List<Integer> increment1 = Stream.of(i).map(i1->i1+1).filter(i1->i1>7).collect(Collectors.toList());

        increment1.forEach(System.out::println);

        //filter
        List<String> startWithA= Stream.of(arr).map(e->e.getName()).filter(sd->sd.charAt(0)=='A').collect(Collectors.toList());
        startWithA.forEach((i1)->{System.out.println(i1);});

        //reduce
        //[1,2,3,4,5] -> 1,2 -> 1+2 -> 3+3-> 6+4 -> 10+5->15
        // a,b -> a+b
        int x =Stream.of(i).reduce((a1,b) -> a1+b).get();
        System.out.println(x);

        //IntStream LOngStream DoubleStream



    }
}
