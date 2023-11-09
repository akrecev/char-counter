package com.kretsev.charcounter.service.impl;

import com.kretsev.charcounter.service.CharCountService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class CharCountServiceImplTest {
    @Autowired
    CharCountService countService;

    @Test
    void getCharsCount() {
        String testResult = countService.getCharsCount("aaaaabcccc");
        String expectedResult = "\"a\": 5, \"c\": 4, \"b\": 1";
        assertEquals(expectedResult, testResult);
    }
}