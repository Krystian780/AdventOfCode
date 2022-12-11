package com.krystian;

import java.io.IOException;
import java.util.List;

public class Main {

    public static void main(String[] args) throws IOException {
        Fifth fifth = new Fifth();
        List<List<String>> x = fifth.getListOfStrings();
        for(int y = 0; y < x.size(); y++){
            System.out.println(x.get(y));
        }
    }

}
