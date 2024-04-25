package com.spring.thymeleaf.file.upload.service;

public class WordFrequencyImpl implements WordFrequency {


    String woord;
    int frequency;

    public WordFrequencyImpl(String word, Integer freq) {
        woord = word;
        frequency = freq;

    }
    @Override
    public String getWord() {
        return woord;
    }

    @Override
    public int getFrequency() {
        return frequency;
    }

    @Override
    public String toString() {
        return "" +
                "woord: " + woord +
                ", frequency: " + frequency;
    }

}
