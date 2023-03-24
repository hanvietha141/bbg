package com.bbg.helper;

import org.springframework.stereotype.Component;

@Component
public class StringHelper {
    public boolean haveCharacters (String[] characters, int numberMatched, String string) {
        int count = 0;
        for (String character: characters) {
            if (string.contains(character)) {
                count++;
                if (count >=3) break;
            }
        }
        if (count >= 3) {
            return true;
        }
        return false;
    }
}
