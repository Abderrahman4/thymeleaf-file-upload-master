package com.spring.thymeleaf.file.upload.service;

import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class CreateMap {

    public Map<String, Integer> zetStringOmInMap (String str) {
        Map<String, Integer> map = new HashMap<>();

        String[] words = str.split(" ");

        for (String word : words) {

            word = word.toLowerCase();

            Integer integer = map.get(word);

            if (integer == null)
                map.put(word, 1);
            else {
                map.put(word, integer + 1);
            }
        }
        return map;
    }

}
