package com.ca.may2020;

import java.util.ArrayList;
import java.util.*;

public class DemoPhone {
    public static void main(String[] args) {
        //phone type refrenece variables
        Phone p1 = new Phone(5,"android","fg23");
        Phone p2 = new Phone(8,"android","rt12");
        p1.sendText("123456","hello");
        //interface
        ApplicationSetting ap = new Phone(5,"android","ew1234");
        ap.installApp("foodpanda");
        List<String> games = new ArrayList<String>();
        games.addAll(Arrays.asList("abc","xyz"));
        p2.installGames(games);
        games.add("wer");
        GameSoftware g1 = new Phone(5,"android","ew1234");
        g1.installGames(games);//run time
        int a= p2.a; //20
        int s= g1.a; //10 //

    }
}
