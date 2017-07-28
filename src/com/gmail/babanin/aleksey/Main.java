package com.gmail.babanin.aleksey;

import java.io.File;
import java.io.IOException;

public class Main {

    public static void main(String[] args) {
        Dictionary dic = fillDictionary();

        File in = new File("English.in");
        File out = new File("Russian.out");

        try {
            Translator.tanslateToFile(in, out, dic);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }

    public static Dictionary fillDictionary() {
        Dictionary dic = new Dictionary();
        File f = new File("dictionary.txt");

        try {
            DictionaryLoader.readDictionary(f, dic);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
        
        return dic;
    }
}
