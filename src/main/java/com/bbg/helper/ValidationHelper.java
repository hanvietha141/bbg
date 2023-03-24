package com.bbg.helper;

import org.springframework.stereotype.Component;

@Component
public class ValidationHelper {
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

    public boolean minMaxValue (int number) {
        if (20<= number && 22 >= number) {
            return true;
        }
        return false;
    }
}
