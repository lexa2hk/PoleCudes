package org.example;

public class WheelSector {
    private String name;
    private int points;
    private boolean canGuessWholeWord;

    public WheelSector(String name, int points, boolean canGuessWholeWord) {
        this.name = name;
        this.points = points;
        this.canGuessWholeWord = canGuessWholeWord;
    }

    public String getName() {
        return name;
    }

    public int getPoints() {
        return points;
    }

    public boolean canGuessWholeWord() {
        return canGuessWholeWord;
    }
}
