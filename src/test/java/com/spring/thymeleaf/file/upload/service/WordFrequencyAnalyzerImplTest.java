package com.spring.thymeleaf.file.upload.service;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class WordFrequencyAnalyzerImplTest {

    @Autowired
    WordFrequencyAnalyzerImpl wordFrequencyAnalyzer;


    @Test
    void calculateHighestFrequency() throws IOException {

        String text = new String(Files.readAllBytes(Paths.get("./src/test/resources/kan.txt")));

        int hoogste = wordFrequencyAnalyzer.calculateHighestFrequency(text);

        assertEquals(4, hoogste);


    }

    @Test
    void calculateFrequencyForWord() throws IOException {

        String text = new String(Files.readAllBytes(Paths.get("./src/test/resources/kan.txt")));
        int aantal = wordFrequencyAnalyzer.calculateFrequencyForWord(text, "kan");

        assertEquals(3, aantal);
    }

    @Test
    void calculateMostFrequentNWords() throws IOException {

        String text = new String(Files.readAllBytes(Paths.get("./src/test/resources/kan.txt")));
        List<WordFrequency> list = wordFrequencyAnalyzer.calculateMostFrequentNWords(text, 3);

        assertEquals(4, list.get(0).getFrequency());
        assertEquals(3, list.size());
        assertEquals("het", list.get(0).getWord());

    }
}