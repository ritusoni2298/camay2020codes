package com.ca.may2020;

import java.util.*;

public class Solution {
    public static void main(String[] args) {
        Employee emp = new Employee();
        long bonus = 4500;
        emp.revisedSalary(bonus);
        List<Integer> ls = new ArrayList<>();
        emp.test(ls);
        System.out.println(ls);
        Employee emp1 = new Employee("vignesh","ny",10000);
        Employee emp2 = new Employee("sayali","ny",10000);
        Employee emp3 = new Employee("akshar","ny",10000);
        emp1.printDetails();
        emp2.printDetails();
        emp3.printDetails();

    }
}
