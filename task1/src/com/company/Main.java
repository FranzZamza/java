package com.company;


import java.io.*;
import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

import static java.lang.System.in;

public class Main {

    public static void main(String[] args) {

        try {
            File file = new File("src/com/company/inputData");
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String line = bufferedReader.readLine();

            while (line != null) {

                ArrayList<String> list = new ArrayList<>();
                list.addAll(Arrays.asList(line.split(" ")));

                line = bufferedReader.readLine();

                if (list.size() == 2 && isNumber(list)) {
                    System.out.println(itoBase(Integer.parseInt(list.get(0)), list.get(1)));
                }
                if (list.size() == 3 && isNumber(list)) {
                    System.out.println(itoBase(list.get(0), list.get(1), list.get(2)));
                }
                if(!isNumber(list)){
                    System.out.println("usage");
                }
            }

        } catch (IOException e) {
            e.printStackTrace();
        }
    }


    public static String itoBase(int nb, String base) {
        BigInteger a = new BigInteger(String.valueOf(nb));
        String finalRes = a.toString(Integer.parseInt(base));
        return finalRes;
    }

    public static String itoBase(String nb, String baseSrc, String baseDst) {
        BigInteger a = new BigInteger(nb, Integer.parseInt(baseSrc));
        String finalRes = a.toString(Integer.parseInt(baseDst));
        return finalRes;
    }

    public static Boolean isNumber( ArrayList<String> list){
        Boolean num = true;
        if(list.size()==2){
            for (int i = 0; i < list.size(); i++) {
                if(!list.get(i).matches("\\d+")){
                    num=false;
                }
            }
        }
        String select="(.*)[а-яА-Яa-zA-Z](.*)";

        if (list.size()==3){
            if(list.get(1).matches(select) ||
                    list.get(2).matches(select)){
                num=false;
            }
        }

        return num;
    }
}
// [а-яА-Яa-zA-Z]