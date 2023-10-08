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

    }

    //Smolnikov
    public WheelSector spinWheel() {

        return null;
    }

    public Player determineWinner() {
        return null;
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