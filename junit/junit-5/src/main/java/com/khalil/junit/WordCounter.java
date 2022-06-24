package com.khalil.junit;

public class WordCounter {
    public int countWords(String sentence) {
        return sentence.split(" ").length;
    }
}