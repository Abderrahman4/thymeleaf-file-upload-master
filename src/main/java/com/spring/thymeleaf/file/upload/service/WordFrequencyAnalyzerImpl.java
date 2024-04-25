package com.spring.thymeleaf.file.upload.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.*;
import java.util.stream.Collectors;

@Service
public class WordFrequencyAnalyzerImpl implements WordFrequencyAnalyzer {

    @Autowired
    CreateMap createMap;

    @Override
    public int calculateHighestFrequency(String text) {

        Map<String, Integer> map = createMap.zetStringOmInMap(text);
        int maxValueInMap=(Collections.max(map.values()));  // This will return max value in the HashMap
        return maxValueInMap;
    }

    @Override
    public int calculateFrequencyForWord(String text, String word) {

        Map<String, Integer> map = createMap.zetStringOmInMap(text);
        int aantal = map.get(word);




        return aantal;
    }

    @Override
    public List<WordFrequency> calculateMostFrequentNWords(String text, int n) {

        Map<String, Integer> map = createMap.zetStringOmInMap(text);
        List<WordFrequency> wordFrequencyList = new ArrayList<>();

        for (Map.Entry<String, Integer> entry : map.entrySet()) {
            wordFrequencyList.add(new WordFrequencyImpl(entry.getKey(), entry.getValue()));
        }

        Collections.sort(wordFrequencyList, new WordFrequencyComparator());



        List<WordFrequency> topList = wordFrequencyList.stream()
                .limit(n).collect(Collectors.toList());

        return topList;

    }
}
