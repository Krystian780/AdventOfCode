package com.krystian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class CaloriesCalculator {
    private List<String> listOfStrings = new ArrayList<>();

    private List<Integer> pareAllElementsToInteger(String path) throws IOException {
        listOfStrings = Files.readAllLines(Paths.get(path));
        List<Integer> parsedIntegers = new ArrayList<>();
        for(int x = 0; x < listOfStrings.size(); x++) {
                try {
                    parsedIntegers.add(Integer.parseInt(listOfStrings.get(x)));
                }
                catch (NumberFormatException e){
                    parsedIntegers.add(null);
                }
           }
        return parsedIntegers;
        }

    public Integer getMaximumCalories(String path) throws IOException {
        List<Integer> listOfIntegers = pareAllElementsToInteger(path);
        int counter = 0;
        int calories = 0;
        HashMap<Integer, Integer> caloriesOfEachElf= new HashMap<>();
        for(int w = 0; w < listOfIntegers.size(); w++){
            if(listOfIntegers.get(w)==null){
                caloriesOfEachElf.put(++counter, calories);
                calories = 0;
            }
            else{
                calories = calories+listOfIntegers.get(w);
            }
        }
        List<Integer> keys = new ArrayList<>(caloriesOfEachElf.values());
        return keys.stream().max(Integer::compare).get();
    }

}




