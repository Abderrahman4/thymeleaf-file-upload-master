package com.spring.thymeleaf.file.upload.service;
import java.util.Comparator;

class WordFrequencyComparator implements Comparator<WordFrequency>{


    @Override
    public int compare(WordFrequency o1, WordFrequency o2) {
        return o2.getFrequency() -o1.getFrequency();
    }
}
