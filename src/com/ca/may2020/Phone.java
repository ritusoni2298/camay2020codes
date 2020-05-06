package com.ca.may2020;
//functional interface
import java.util.*;


interface ApplicationSetting{
    public static void installingAppSoftware(){
        System.out.println("Installing Software of application.....");
        System.out.println("Installed");
    }
    public default int countApplications(List<String> apps){
        return 1;
    }
    public void installApp(String app);
}
class GameSoftware{
    protected List<String> gamename;
    int a=10;
    public void installGames(List<String> games){
        System.out.println("Install default games");
        for(int i=0;i<games.size();i++)
            gamename.add(games.get(i));
    }
    public void printGameNames(){
        for(String game:gamename){
            System.out.println("name::: "+game);
        }
    }
}
//is-a  -> inheritance
//has-a -> attributes

public class Phone extends GameSoftware implements ApplicationSetting{
    private double weight;
    private String os;
    private String model;
    int a=20;
    public void installGames(List<String> games){
        super.installGames(games);
        System.out.println("Adding new Game");
        for(int i=0;i<games.size();i++)
            gamename.add(games.get(i));
    }

    Phone(){

    }
    Phone(double weight,String os,String model){
        this.weight=weight;
        this.os=os;
        this.model=model;
    }

    //behaviours
    public void makeCall(String phone_no)
    {
        System.out.println("dial in and call at "+phone_no);
    }

    public String sendText(String phone_no, String text){
        System.out.println("sending text: "+text+" to "+phone_no);
        return text+"along with additional data";
    }

    public double getWeight() {
        return weight;
    }

    public String getOs() {
        return os;
    }

    public String getModel() {
        return model;
    }

    public void setOs(String os) {
        this.os = os;
    }

    public void setWeight(double weight) {
        this.weight = weight;
    }

    public void setModel(String model) {
        this.model = model;
    }

    @Override
    public void installApp(String app) {
        System.out.println("installed "+app);
    }

    public int countApplications(List<String> apps){
        return apps.size();
    }
}
