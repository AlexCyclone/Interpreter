package com.gmail.babanin.aleksey;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public interface Translator {

    public static void tanslateToFile(File in, File out, Dictionary dic) throws IOException, IllegalArgumentException {
        if (in == null || out == null || dic == null) {
            throw new IllegalArgumentException("Null file pointer");
        }

        try (BufferedReader br = new BufferedReader(new FileReader(in));
                BufferedWriter bw = new BufferedWriter(new FileWriter(out))) {
            String str = "";
            while ((str = br.readLine()) != null) {
                bw.write(translateLine(str, dic));
            }

        } catch (IOException e) {
            throw e;
        }
    }

    public static String translateLine(String str, Dictionary dic) {
        if (str == null || dic == null) {
            throw new IllegalArgumentException("Null pointer String or Dictionary");
        }

        String[] words = str.split("\\W+");
        String[] separators = str.split("\\w+");

        StringBuilder sb = new StringBuilder();
        int dif = words.length - separators.length;
        for (int i = 0; i < words.length; i++) {
            if (dif <= 0) {
                sb.append(separators[i]);
            } else {
                if (i >= dif) {
                    sb.append(separators[i - dif]);
                }
            }
            sb.append(dic.translate(words[i]).toLowerCase());
        }

        if (dif < 0) {
            sb.append(separators[separators.length - 1]);
        }
        return sb.toString() + System.lineSeparator();
    }

}
