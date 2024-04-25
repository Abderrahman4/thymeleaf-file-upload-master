package com.spring.thymeleaf.file.upload.controller;



import com.spring.thymeleaf.file.upload.service.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;

import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.web.bind.annotation.PathVariable;

import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;


import java.util.List;



@RequestMapping("/api")

@Slf4j
@RestController
public class WordCounterController {

    @Autowired
    WordFrequencyAnalyzerImpl wordFrequencyAnalyzer;

    @GetMapping("/most-n-word-frequencies/{text}/{n}")
    public ResponseEntity<String> getMostNWordFrequencies(@PathVariable("text") String text, @PathVariable("n") int n) {



        try {

            List<WordFrequency> mostNWordFrequencies = wordFrequencyAnalyzer.calculateMostFrequentNWords(text, n);

            return ResponseEntity.ok().body(mostNWordFrequencies.toString());

        }
       catch(Exception e)
            {
                return ResponseEntity.badRequest().body("Voer een stuk tekst en een cijfer in.");
            }


}


    @GetMapping("/highest-frequency/{text}")

    public ResponseEntity<String> getHighestFrequency(@PathVariable("text") String text) {



        try{
            int highestFrequency = wordFrequencyAnalyzer.calculateHighestFrequency(text);

            return ResponseEntity.ok().body(String.valueOf(highestFrequency));

        }

        catch(Exception e)

        {
        return ResponseEntity.badRequest().body("Voer een stuk tekst in.");

        }


    }

    @GetMapping("/word-frequency/{text}/{word}")

    public ResponseEntity<String> getWordFrequencyForWord(@PathVariable("text") String text, @PathVariable("word") String word) {


        try {
            int wordFrequency = wordFrequencyAnalyzer.calculateFrequencyForWord(text, word);

            return ResponseEntity.ok().body(String.valueOf(wordFrequency));

        }
                   catch(Exception e)
        {

            return ResponseEntity.badRequest().body("Voer een stuk tekst en daarna een woord in.");
        }

    }

}