package com.krystian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class FourthTask {
    private List<String> listOfStrings = new ArrayList<>();

    public void pareAllElementsToInteger(String path) throws IOException {
        listOfStrings = Files.readAllLines(Paths.get(path));
        int count = 0;
        int count2 = 0;
        int count3= 0;
        for(int x = 0; x < listOfStrings.size(); x++){
            boolean contains = false;
            List<Integer> integerOfNumbers = findIntegers(listOfStrings.get(x));
            List<Integer> allElementsFirst = new ArrayList<>();
            List<Integer> allElementsSecond = new ArrayList<>();
            ArrayList<Integer> findDuplicates = new ArrayList<>();

            if(integerOfNumbers.get(0)<=integerOfNumbers.get(2)&&integerOfNumbers.get(1)>=integerOfNumbers.get(3)){
                contains = true;
            }

            if(integerOfNumbers.get(2)<=integerOfNumbers.get(0)&&integerOfNumbers.get(3)>=integerOfNumbers.get(1)){
                contains = true;
            }

            if(contains){
                count++;
            }
            System.out.println(count);
        }
    }

    private static List<Integer> findIntegers(String stringToSearch) {
        Pattern integerPattern = Pattern.compile("-?\\d+");
        Matcher matcher = integerPattern.matcher(stringToSearch);

        List<Integer> integerList = new ArrayList<>();
        while (matcher.find()) {
            integerList.add(Math.abs(Integer.parseInt(matcher.group())));
        }
        return integerList;
    }

}
