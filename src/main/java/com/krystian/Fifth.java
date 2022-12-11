package com.krystian;

import java.io.IOException;
import java.io.InputStream;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class Fifth {
    private List<String> allLinesFromText = new ArrayList<>();
    private List<List<String>> boxes = new ArrayList<>();

    public List<List<String>> getBoxes() {
        return boxes;
    }

    public void fillOutAllLinesFromTextArrayWithLines() throws IOException {
        ClassLoader classloader = Thread.currentThread().getContextClassLoader();
        InputStream resourceAsStream = classloader.getResourceAsStream("input.txt");
        Scanner scanner = new Scanner(resourceAsStream);
        while (scanner.hasNextLine()) {
            String line = scanner.nextLine();
            allLinesFromText.add(line);
        }
    }

    public void retrieveLetters() throws IOException {
        fillOutAllLinesFromTextArrayWithLines();
        for (int x = 0; x < 8; x++) {
            String[] splitted = allLinesFromText.get(x).split("");
            List<String> splittedString = new ArrayList<>(List.of(splitted));
            ArrayList<String> lettersFromALine = new ArrayList<>();
            for (int z = 0; z < splittedString.size(); z++) {
                if (Pattern.matches("[a-zA-Z]+", splittedString.get(z))) {
                    lettersFromALine.add(splittedString.get(z));
                }
            }
            boxes.add(lettersFromALine);
        }
    }

    public void replaceNullWithX() throws IOException {
        boxes.get(0).add(1, "");
        boxes.get(1).add(1, "");
        boxes.get(0).add(3, "");
        boxes.get(0).add(3, "");
        boxes.get(0).add(6, "");
        boxes.get(0).add(6, "");
        boxes.get(0).add(6, "");
        boxes.get(1).add(4, "");
        boxes.get(1).add(7, "");
        boxes.get(1).add(8, "");
        boxes.get(2).add(4, "");
        boxes.get(2).add(7, "");
        boxes.get(2).add(8, "");
        boxes.get(3).add(4, "");
        boxes.get(3).add(7, "");
        boxes.get(4).add(7, "");
        for (int x = 0; x < boxes.size(); x++) {
            for (int z = 0; z < boxes.get(x).size(); z++) {
                if (boxes.get(x).get(z).equalsIgnoreCase("")) {
                    boxes.get(x).set(z, "X");
                }
            }
        }
    }
    public List<List<String>> getMoves() {
        List<List<String>> allMoves = new ArrayList<>();
        for (int x = 10; x < 511; x++) {
            String[] splittedLine = allLinesFromText.get(x).split(" ");
            ArrayList<String> splittedLineInArray = new ArrayList<>(List.of(splittedLine));
            ArrayList<String> moves = new ArrayList<>();
            moves.add(splittedLineInArray.get(1));
            moves.add(splittedLineInArray.get(3));
            moves.add(splittedLineInArray.get(5));
            allMoves.add(moves);
        }
        return allMoves;
    }

    public int checkIfIncreaseNeeded(int additionalBoxes, int column) throws IOException {
        List<List<String>> boxes = this.boxes;
        int heightOfAllBoxes = boxes.size();
        int boxesHeight = 0;
        for (int x = 0; x < boxes.size(); x++) {
            if (!boxes.get(x).get(column - 1).equalsIgnoreCase("X")) {
                boxesHeight++;
            }
        }
        boxesHeight = boxesHeight + additionalBoxes;
        return boxesHeight - heightOfAllBoxes;
    }

    public void addAdditionalArrayAtTheTop(int elements, List<List<String>> boxes) {
        for (int x = 0; x < elements; x++) {
            List<String> newArray = new ArrayList<>();
            for (int y = 0; y < 9; y++) {
                newArray.add("X");
            }
            boxes.add(0, newArray);
        }
    }

    public List<String> gatherElementsThatAreSupposedToBeMoved(int amount, int column) {
        List<String> eleementsToMove = new ArrayList<>();
        int counter = 0;
        for (int x = 0; x < boxes.size(); x++) {
            if (counter == amount) {
                break;
            } else {
                if (!boxes.get(x).get(column - 1).equalsIgnoreCase("X")) {
                    eleementsToMove.add(boxes.get(x).get(column - 1));
                    counter++;
                }
            }
        }
        Collections.reverse(eleementsToMove);
        return eleementsToMove;
    }

    public void replaceElementsToX(int amount, int column) throws IOException {
        int count = 0;
        for (int x = 0; x < boxes.size(); x++) {
            if (!boxes.get(x).get(column - 1).equalsIgnoreCase("X")) {
                if (count == amount) {
                    break;
                } else {
                    boxes.get(x).set(column - 1, "X");
                    count++;
                }
            }
        }
    }

    public void replaceElementsToBox(List<String> y, int column) throws IOException {
        int count = 0;
        int takeIndex = 0;
        for (int x = boxes.size() - 1; x >= 0; x--) {
            if (boxes.get(x).get(column - 1).equalsIgnoreCase("X")) {
                if (count == y.size()) {
                    break;
                } else {
                    boxes.get(x).set(column - 1, y.get(takeIndex));
                    count++;
                    takeIndex++;
                }
            }
        }
    }

    public void deleteIfNoBox() {
        for (int x = 0; x < boxes.size(); x++) {
            boolean otherThanX = false;
            for (int y = 0; y < boxes.get(x).size(); y++) {
                if (!boxes.get(x).get(y).equalsIgnoreCase("X")) {
                    otherThanX = true;
                }
            }
            if (!otherThanX) {
                boxes.remove(x);
            }
        }
    }

    public void print(){
        for(int x = 0; x < boxes.size(); x++){
            System.out.println(boxes.get(x));
        }
    }

    public void runProgramme() throws IOException {
        fillOutAllLinesFromTextArrayWithLines();
        retrieveLetters();
        replaceNullWithX();
        List<List<String>> moves = getMoves();
        print();
        for (int x = 0; x < moves.size(); x++) {
            System.out.println(moves.get(x));
            print();
            if (checkIfIncreaseNeeded(Integer.parseInt(moves.get(x).get(0)), Integer.parseInt(moves.get(x).get(2))) > 0) {
                addAdditionalArrayAtTheTop(checkIfIncreaseNeeded(Integer.parseInt(moves.get(x).get(0)), Integer.parseInt(moves.get(x).get(2))), boxes);
            }
            List<String> elementsToBeMoved = gatherElementsThatAreSupposedToBeMoved(Integer.parseInt(moves.get(x).get(0)), Integer.parseInt(moves.get(x).get(1)));
            replaceElementsToX(Integer.parseInt(moves.get(x).get(0)), Integer.parseInt(moves.get(x).get(1)));
            replaceElementsToBox(elementsToBeMoved, Integer.parseInt(moves.get(x).get(2)));
            print();
        }
    }

}