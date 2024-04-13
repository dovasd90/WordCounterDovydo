package com.example.wordcounterdovydo;

public class TextCounter {
    public static int getCharsCount(String phrase){
        return phrase.length();
    }

    public static int getWordsCount(String phrase){

        String[] words = phrase.split("\\s+");
        int count = words.length;

        return count;
    }
}
