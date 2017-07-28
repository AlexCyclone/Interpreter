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
        
        dic.addWord("Kiev", "ส่ๅโ");
        saveDictionary(dic);
        
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
    
    public static void saveDictionary(Dictionary dic) {
        File f = new File("dictionary2.txt");

        try {
            DictionaryLoader.writeDictionary(f, dic);
        } catch (IllegalArgumentException | IOException e) {
            e.printStackTrace();
        }
    }
}
