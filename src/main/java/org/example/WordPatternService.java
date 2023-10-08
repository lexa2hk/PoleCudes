package org.example;

public class WordPatternService {

    public static String revealLetter(String encodedWord,String currentPattern, char letter){
        StringBuilder revealedPattern = new StringBuilder(currentPattern);

        for (int i = 0; i < encodedWord.length(); i++) {
            if (encodedWord.charAt(i) == letter) {
                revealedPattern.setCharAt(i, letter);
            }
        }

        return revealedPattern.toString();
    }

    public static boolean tryGuessWord(String encodedWord, String currentPattern, String guessedWord){
        return guessedWord.equals(encodedWord);
    }

}
