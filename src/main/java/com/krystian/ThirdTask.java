package com.krystian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ThirdTask {
    private List<String> listOfStrings = new ArrayList<>();

    public void pareAllElementsToInteger(String path) throws IOException {
        char array[] = {'A', 'B', 'C'};
        listOfStrings = Files.readAllLines(Paths.get(path));
        System.out.println(listOfStrings.size());
        int counter = 0;
        for(int x = 0; x < listOfStrings.size(); x++){
            String [] charsOfString = listOfStrings.get(x).split("");
            String [] firstPart = Arrays.copyOfRange(charsOfString, 0, (charsOfString.length + 1)/2);
            String [] secondPart = Arrays.copyOfRange(charsOfString, (charsOfString.length + 1)/2, charsOfString.length);
            counter = counter + returnCommonChar(firstPart, secondPart);
        }
        System.out.println(counter);
    }


    private int returnCommonChar(String [] first,String [] second){
        int count = 0;
        boolean stop = false;
        String common = "";
        for(int x = 0; x < first.length; x++){
            for(int y = 0; y < second.length; y++){
                count++;
                stop = true;
                break;
            }
            if(stop){
                break;
            }
        }
        return count;
    }

}
