package com.krystian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.*;

public class ThirdTask {
    private List<String> listOfStrings = new ArrayList<>();

    public void pareAllElementsToInteger(String path) throws IOException {
        listOfStrings = Files.readAllLines(Paths.get(path));
        System.out.println(listOfStrings.size());
        int counter = 0;
        for(int x = 0; x < listOfStrings.size(); x++){
            String [] charsOfString = listOfStrings.get(x).split("");
            String [] firstPart = Arrays.copyOfRange(charsOfString, 0, (charsOfString.length + 1)/2);
            String [] secondPart = Arrays.copyOfRange(charsOfString, (charsOfString.length + 1)/2, charsOfString.length);
            counter = counter + getPointForLetter(returnCommonChar(firstPart, secondPart));
        }
        System.out.println(counter);
    }


    private String returnCommonChar(String [] first,String [] second){
        boolean stop = false;
        String common = "";
        for(int x = 0; x < first.length; x++){
            for(int y = 0; y < second.length; y++){
                if(first[x].equals(second[y])) {
                    common = first[x];
                    stop = true;
                    break;
                }
            }
            if(stop){
                break;
            }
        }
        return common;
    }

    private int getPointForLetter(String w){
        int count = 0;
        final Map<String, Integer> alphabet = new HashMap<>();
        addIntoHashMap(alphabet);
        try {
            if (w == w.toLowerCase()) {
                count = alphabet.get(w);
            }
            if (w == w.toUpperCase()) {
                count = 26 + alphabet.get(w.toLowerCase());
            }
        }
        catch (NullPointerException n){
            System.out.println("go on");
        }
        return count;
    }

    public void addIntoHashMap(Map<String,Integer> alphabet){
        alphabet.put("a", 1);
        alphabet.put("b", 2);
        alphabet.put("c", 3);
        alphabet.put("d", 4);
        alphabet.put("e", 5);
        alphabet.put("f", 6);
        alphabet.put("g", 7);
        alphabet.put("h", 8);
        alphabet.put("i", 9);
        alphabet.put("j", 10);
        alphabet.put("k", 11);
        alphabet.put("l", 12);
        alphabet.put("m", 13);
        alphabet.put("n", 14);
        alphabet.put("o", 15);
        alphabet.put("p", 16);
        alphabet.put("q", 17);
        alphabet.put("r", 18);
        alphabet.put("s", 19);
        alphabet.put("t", 20);
        alphabet.put("u", 21);
        alphabet.put("v", 22);
        alphabet.put("w", 23);
        alphabet.put("x", 24);
        alphabet.put("y", 25);
        alphabet.put("z", 26);
    }

}

