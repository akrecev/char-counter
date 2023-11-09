package com.kretsev.charcounter.service.impl;

import com.kretsev.charcounter.service.CharCountService;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

@Service
public class CharCountServiceImpl implements CharCountService {
    @Override
    public String getCharsCount(String string) {
        List<Character> chars = string.chars().mapToObj(e -> (char) e).collect(Collectors.toList());
        Map<Character, Integer> charMap = new HashMap<>();
        for (Character character : chars) {
            if (charMap.containsKey(character)) {
                charMap.put(character, charMap.get(character) + 1);
            } else {
                charMap.put(character, 1);
            }
        }
        List<Map.Entry<Character, Integer>> result = charMap.entrySet()
                .stream()
                .sorted(Map.Entry.comparingByValue((c1, c2) -> Integer.compare(c2, c1)))
                .collect(Collectors.toList());
        StringBuilder resultString = new StringBuilder();
        String prefix = "";
        for (Map.Entry<Character, Integer> characterIntegerEntry : result) {
            resultString.append(prefix);
            prefix = ", ";
            resultString.append("\"")
                    .append(characterIntegerEntry.getKey())
                    .append("\": ")
                    .append(characterIntegerEntry.getValue());
        }

        return resultString.toString();
    }
}
