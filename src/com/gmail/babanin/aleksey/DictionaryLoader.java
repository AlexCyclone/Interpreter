package com.gmail.babanin.aleksey;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Arrays;

public interface DictionaryLoader {

    public static void readDictionary(File in, Dictionary dictionary) throws IOException, IllegalArgumentException {
        if (in == null || dictionary == null) {
            throw new IllegalArgumentException("Null file pointer or dictionary");
        }
        try (BufferedReader br = new BufferedReader(new FileReader(in))) {
            String str = "";
            while ((str = br.readLine()) != null) {
                String[] parse = str.split(" -- ");
                dictionary.addWord(parse[0], parse[1]);
            }
        } catch (IOException e) {
            throw e;
        }
    }

    public static void writeDictionary(File out, Dictionary dictionary) throws IOException, IllegalArgumentException {
        if (out == null || dictionary == null) {
            throw new IllegalArgumentException("Null file pointer or dictionary");
        }

        try (BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            String[] keySet = dictionary.getWords().keySet().toArray(new String[dictionary.getSize()]);
            Arrays.sort(keySet);

            for (String key : keySet) {
                bw.write(key + " -- " + dictionary.translateFull(key) + System.lineSeparator());
            }
        } catch (IOException e) {
            throw e;
        }
    }

}
