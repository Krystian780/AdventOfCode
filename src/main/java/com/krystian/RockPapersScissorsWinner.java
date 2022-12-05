package com.krystian;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class RockPapersScissorsWinner {
    private List<String> listOfStrings = new ArrayList<>();

    public int pareAllElementsToInteger(String path) throws IOException {
        char array[] = {'A', 'B', 'C'};
        char array2[] = {'X', 'Y', 'Z'};
        listOfStrings = Files.readAllLines(Paths.get(path));
        int count = 0;
        for (int x = 0; x < listOfStrings.size(); x++) {
            for (int y = 0; y < array.length; y++) {
                if (listOfStrings.get(x).charAt(0) == array[y]) {
                    if (y == 0) {
                        if (listOfStrings.get(x).charAt(2) == 'X')
                            count = count + 4;
                        else if (listOfStrings.get(x).charAt(2) == 'Y')
                            count = count + 8;
                        else
                            count = count + 3;
                    }
                    else if (y == 1) {
                        if (listOfStrings.get(x).charAt(2) == 'X')
                            count = count + 1;
                        else if (listOfStrings.get(x).charAt(2) == 'Y')
                            count = count + 5;
                        else
                            count = count + 9;
                    }
                    else {
                        if (listOfStrings.get(x).charAt(2) == 'X')
                            count = count + 7;
                        else if (listOfStrings.get(x).charAt(2) == 'Y')
                            count = count + 2;
                        else
                            count = count + 6;
                    }
                }
            }
        }
        return count;
    }
}
