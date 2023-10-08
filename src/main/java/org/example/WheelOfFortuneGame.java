package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;
import java.util.Scanner;

public class WheelOfFortuneGame {
    public Round currentRound;
    private int currentPlayerIndex;
    private int currentWheelSectorIndex;

    public WheelOfFortuneGame() {
        initializeRound();
        this.currentPlayerIndex = 0;
        this.currentWheelSectorIndex = 0;
    }

    public void initializeRound() {
        List<Player> players = new ArrayList<>();
        players.add(new Player("Player 1"));
        players.add(new Player("Player 2"));
        players.add(new Player("Player 3"));

        List<WheelSector> wheel = new ArrayList<>();
        wheel.add(new WheelSector("Prize", 500, false));
        wheel.add(new WheelSector("Plus", 100, false));
        wheel.add(new WheelSector("Key", 200, false));
        wheel.add(new WheelSector("Bankrupt", 0, false));
        wheel.add(new WheelSector("Zero", 0, false));
        wheel.add(new WheelSector("Double", 0, false));

        String theme = "Example Theme";

        currentRound = new Round(players, theme, wheel);

    }

    //Smolnikov
    public WheelSector spinWheel() {
        Random random = new Random();
        int randomIndex = random.nextInt(currentRound.getWheel().size());
        return currentRound.getWheel().get(randomIndex);

    }

    public Player determineWinner() {
        Player winner = currentRound.getPlayers().get(0);
        for (Player player : currentRound.getPlayers()) {
            if (player.getScore() > winner.getScore()) {
                winner = player;
            }
        }
        return winner;
    }

    private void handleSectorAction(WheelSector sector, Player currentPlayer) {
        //handle sector names and piints and letters
    }

    public void play() {

    }



    public static void main(String[] args) {
        WheelOfFortuneGame game = new WheelOfFortuneGame();
        game.play();
    }
}