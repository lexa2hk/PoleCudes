package org.example;

import java.util.List;
import java.util.Random;

public class Round {
    private List<Player> players;
    private String theme;
    private List<WheelSector> wheel;

    String[] words = {"dom","samolet","kartofel","zebra","telefon"};
    private String encodedWord;
    private String currentPattern;

    public void setEncodedWord(String encodedWord) {
        this.encodedWord = encodedWord;
    }

    public Round(List<Player> players, String theme, List<WheelSector> wheel) {
        this.players = players;
        this.theme = theme;
        this.wheel = wheel;

        Random generator = new Random();
        int randomIndex = generator.nextInt(words.length);
        this.encodedWord = words[randomIndex];

        currentPattern = "*".repeat(encodedWord.length());
    }

    public String getEncodedWord() {
        return encodedWord;
    }

    public String getCurrentPattern() {
        return currentPattern;
    }

    public void setCurrentPattern(String pattern) {
        currentPattern = pattern;
    }

    public String getTheme() {
        return theme;
    }

    public List<WheelSector> getWheel() {
        return wheel;
    }

    public List<Player> getPlayers() {
        return players;
    }


}