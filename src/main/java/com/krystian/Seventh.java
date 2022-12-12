package com.krystian;

import java.io.IOException;
import java.io.InputStream;
import java.util.*;
import java.util.regex.Pattern;

public class Seventh{
    private List<String> allLinesFromText = new ArrayList<>();
    private List<List<String>> eachWordInCommandSpliited = new ArrayList<>();

    public List<List<String>> getEachWordInCommandSpliited() {
        return eachWordInCommandSpliited;
    }

    public void fillOutAllLinesFromTextArrayWithLines() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classloader.getResourceAsStream("two.txt");
        Scanner scanner = new Scanner(resourceAsStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            allLinesFromText.add(line);
        }
    }

    public void retrieveLetters() throws IOException {
        fillOutAllLinesFromTextArrayWithLines();
        for (int x = 0; x < allLinesFromText.size(); x++) {
            String[] splitted = allLinesFromText.get(x).split(" ");
            List<String> splittedString = new ArrayList<>(List.of(splitted));
            ArrayList<String> lettersFromALine = new ArrayList<>();
            for (int z = 0; z < splittedString.size(); z++) {
                    lettersFromALine.add(splittedString.get(z));
            }
            eachWordInCommandSpliited.add(lettersFromALine);
        }
    }

    public void replaceNullWithX() throws IOException {
        Map<String, Integer> newMap = new HashMap<>();
        List<String> directories = new ArrayList<>();
        for(int x = 0; x < eachWordInCommandSpliited.size(); x++){
            if(eachWordInCommandSpliited.get(x).get(1).equalsIgnoreCase("cd")){
                String directoryName = null;
                int counter = 0;
                if(eachWordInCommandSpliited.get(x).get(2).equalsIgnoreCase("..")) {
                    int amountXSwitechesTo = x;
                    boolean valid = true;
                    int goBackDirectoryNames = 0;
                    while(valid) {
                        if (eachWordInCommandSpliited.get(amountXSwitechesTo).get(2).equalsIgnoreCase("..")) {
                            amountXSwitechesTo++;
                            goBackDirectoryNames++;
                        } else {
                            int directoriesSize = directories.size()-1;
                            directoryName = directories.get(directoriesSize-goBackDirectoryNames);
                            valid = false;
                        }
                    }

                }else {
                    directoryName = eachWordInCommandSpliited.get(x).get(2);
                    directories.add(directoryName);
                    counter = x + 2;
                }
                    boolean valid = true;
                    int sumInAFolder = 0;
                    while(valid){
                        if(eachWordInCommandSpliited.get(counter).get(0).equalsIgnoreCase("dir")
                                || eachWordInCommandSpliited.get(counter).get(0).chars().allMatch( Character::isDigit)){
                                    if(eachWordInCommandSpliited.get(counter).get(0).chars().allMatch( Character::isDigit)){
                                        sumInAFolder = sumInAFolder + Integer.parseInt(eachWordInCommandSpliited.get(counter).get(0));
                               }
                        }
                        else {
                            newMap.put(directoryName, sumInAFolder);
                            valid = false;
                        }
                        counter++;
                    }
                    x = counter-2;
                }
            }
        }
    }

