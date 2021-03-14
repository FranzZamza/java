package com.company;

public class Main {

    public static void main(String[] args) {
        isEq(args[0],args[1]);

    }
    static void isEq(String s1, String s2) {
        String regex = s2.replace("*", ".*");
        boolean b = s1.matches(regex);
        if(b){
            System.out.println("OK");
        }else {
            System.out.println("KO");
        }

    }
}
