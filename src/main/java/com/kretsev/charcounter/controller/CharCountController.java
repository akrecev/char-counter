package com.kretsev.charcounter.controller;

import com.kretsev.charcounter.service.CharCountService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class CharCountController {
    private final CharCountService countService;

    @GetMapping("/{string}")
    public String countChars(@PathVariable String string) {
        return countService.getCharsCount(string);
    }

}
