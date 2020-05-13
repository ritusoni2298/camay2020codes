package com.ca.may2020;

import java.sql.Array;
import java.util.*;

public class CollectionsDemo {
    public static void main(String[] args) {
        ArrayList<Integer> arr = new ArrayList();
        arr.add(1);
        arr.addAll(Arrays.asList(1,2,3,5,3,4));
        int sum=0;
        for(int i=0;i<arr.size();i++){
            sum*=(int)arr.get(i);
        }
        System.out.println(sum);
//        int[] ar = new int[];
        Object[] obj = new Object[1];
        obj[0]=4;
//        System.out.println(arr.remove(obj[0]));
//        System.out.println(arr.remove(7));

        LinkedList<Integer> ls = new LinkedList<>();
        ls.addAll(Arrays.asList(1,2,3,4,5));
        System.out.println(ls.remove(3)); //queue
        System.out.println(ls.pop());
        System.out.println(ls.pollLast());

        HashSet<Integer> hs = new HashSet<>();
        hs.addAll(Arrays.asList(1,2,3,4,4,5,2,1,3));
        //foreach
        hs.forEach((e)->{System.out.println(e+"--");}); //lambda expression

        LinkedHashSet<Integer> lhs = new LinkedHashSet<>();
        lhs.addAll(Arrays.asList(1,2,3,4,4,5,2,1,3));
        lhs.forEach(System.out::println); //    1 null

        TreeSet<Integer> ts = new TreeSet<>();
        ts.addAll(Arrays.asList(4,5,2,1,3,1,2,3,422,2,3,3));
        ts.forEach(System.out::println); // not going to have null value

        //map
        //{1:1,2:1,3:1} //allowed unique keys
        //{3:1,3:2,3:5,null:34} => {3:5}
        HashMap<Integer,Integer> map = new HashMap<>();
        for(Integer i:arr){
            if(map.containsKey(i)){
                map.put(i,map.get(i)+1);
            }else{
                map.put(i,1);
            }
        }
        for(Map.Entry m : map.entrySet()){
            System.out.println(m.getKey()+":"+m.getValue());
        }
        map.keySet().forEach((i)->{System.out.println(i+":"+map.get(i));});

//        LinkedHashMap
//        TreeMap //sorting on the basis of keys
        PriorityQueue<Integer> pq = new PriorityQueue<>((a,b)->b-a);
        pq.addAll(Arrays.asList(15,46,16,23,65,24));
        while(!pq.isEmpty())
            System.out.println(pq.poll());
//        pq.forEach(()->{System.outprintln);








    }
}
