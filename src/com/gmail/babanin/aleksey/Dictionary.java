package com.gmail.babanin.aleksey;

import java.util.HashMap;
import java.util.Map;

public class Dictionary {
    private Map<String, String> words = new HashMap<>();

    public Dictionary() {
        super();
    }

    public void addWord(String word, String translate) {
        if (word.trim() != null && translate != null) {
            words.put(word.trim(), translate.trim());
        }
    }

    public String translateFull(String word) {
        if (word == null) {
            return "";
        }

        String translate = translateIgnoreCase(word);
        return translate != null ? translate : "";
    }

    public String translate(String word) {
        if (word == null) {
            return "";
        }

        String translate = translateIgnoreCase(word);
        if (translate == null) {
            return word;
        }

        String[] parse = translate.split("[\\p{Punct}]");
        if (parse[0].contains("артикль") || parse[0].contains("предлог") || parse[0].contains("глагол")) {
            return "";
        }
        return parse[0].trim();
    }

    private String translateIgnoreCase(String word) {
        if (words.get(word) != null) {
            return words.get(word);
        } else {
            return words.get(word.toLowerCase());
        }
    }

    public int getSize() {
        return words.size();
    }

    public Map<String, String> getWords() {
        return words;
    }

}
