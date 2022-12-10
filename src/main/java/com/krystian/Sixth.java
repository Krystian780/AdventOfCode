package com.krystian;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

class Sixth {
    private String textFromFile;

    public void getBoxes(String pathname) throws FileNotFoundException {
        File file = new File(pathname);
        StringBuilder fileContents = new StringBuilder((int)file.length());

        try (Scanner scanner = new Scanner(file)) {
            while(scanner.hasNextLine()) {
                fileContents.append(scanner.nextLine() + System.lineSeparator());
            }
            textFromFile =  fileContents.toString();
        }
    }

    public void getNumber(){
        for(int x = 1908; x <textFromFile.length(); x++){
            char[] fourElements = new char[4];
            int element = x;
            for(int y = 0; y < 4; y++){
                fourElements[y] = textFromFile.charAt(element);
                element++;
            }
            if(checkIfArrayOfCharHasUniqueElements(fourElements)){
                System.out.println(x);
            }
        }
    }

    public boolean checkIfArrayOfCharHasUniqueElements(char[] fourElements){
        for(int x = 0; x < fourElements.length; x++){
            for(int y = x+1; y < fourElements.length; y++){
                if(fourElements[x]==fourElements[y]){
                    return false;
                }
            }
        }
        return true;
    }

    public String getTextFromFile() {
        return textFromFile;
    }

}