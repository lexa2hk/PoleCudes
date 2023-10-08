package org.example;

import java.util.List;

public class Round {
    private List<Player> players;
    private String theme;
    private List<WheelSector> wheel;

    public Round(List<Player> players, String theme, List<WheelSector> wheel) {
        this.players = players;
        this.theme = theme;
        this.wheel = wheel;
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