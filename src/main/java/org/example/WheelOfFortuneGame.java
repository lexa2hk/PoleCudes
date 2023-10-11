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

    private boolean handleSectorAction(WheelSector sector, Player currentPlayer) {
        String sectorName = sector.getName();
        int points = sector.getPoints();
        Scanner scanner = new Scanner(System.in);
        char letter;
        switch (sectorName) {
            case "Prize" -> {
                System.out.println("\n\nТекущее слово: " + currentRound.getCurrentPattern());
                System.out.println("Поздравляем, у вас выпал сектор 'Приз'!");
                System.out.println("Вы можете либо продолжить игру, либо взять приз.");
                System.out.print("Введите 'Продолжить' или 'Взять приз': ");
                String choice = scanner.nextLine();
                if (choice.equalsIgnoreCase("Взять приз")) {
                    System.out.println("Приз взят, игра продолжается");
                }
            }
            // Если игрок выбирает продолжить, вы можете ничего не делать, так как он продолжит игру.
            case "Plus" -> {
                System.out.println("\n\nТекущее слово: " + currentRound.getCurrentPattern());
                System.out.println("Вы получили сектор 'Плюс'!");
                System.out.print("Введите букву, которую хотите открыть: ");
                letter = scanner.nextLine().charAt(0);  // Получаем первый символ введенной буквы

                return isLetterOpened(letter);

            }
            case "Key" -> {
                System.out.println("\n\nТекущее слово: " + currentRound.getCurrentPattern());
                System.out.println("Вы получили сектор 'Ключ'!");
                System.out.println("У вас есть 6 ключей, один из которых от автомобиля.");
                System.out.print("Введите номер ключа, который хотите использовать (1-6): ");
                if (handleKeySector(new Random().nextInt(6) + 1)) {
                    System.out.println("Поздравляем! Этот ключ подходит к автомобилю, и вы выигрываете его.");
                }
                else {
                    System.out.println("К сожалению, этот ключ не подходит к автомобилю.");
                }

            }
            case "Bankrupt" -> {
                System.out.println("\n\nТекущее слово: " + currentRound.getCurrentPattern());
                System.out.println("Увы, вы попали в сектор 'Банкрот' и теряете все свои очки.");
                currentPlayer.setScore(0); // Обнуляем счет игрока
            }
            case "Zero" -> {
                System.out.println("\n\nТекущее слово: " + currentRound.getCurrentPattern());
                System.out.println("Вы остаетесь с текущим счетом, но ход переходит к следующему игроку.");
            }
            case "Double" -> {
                System.out.println("\n\nТекущее слово: " + currentRound.getCurrentPattern());
                System.out.println("Вы получили сектор 'Удвоение'!");
                System.out.print("Введите букву, которую хотите открыть: ");
                letter = scanner.nextLine().charAt(0);
                points = sector.getPoints() * 2; // Удваиваем баллы
                currentPlayer.addScore(points);

                // Реализуйте логику для открытия буквы и обновления текущего шаблона слова.
                return isLetterOpened(letter);
            }
        }

        currentPlayer.addScore(points);
        return false;
    }

    public boolean handleKeySector(int correctKeyNumber) {
        Scanner scanner = new Scanner(System.in);
        int keyNumber = scanner.nextInt();
        return keyNumber == correctKeyNumber;
    }

    public boolean isLetterOpened(char letter) {
        String encodedWord;
        String currentPattern;
        String currentPatternAfterReveal;
        encodedWord = currentRound.getEncodedWord();
        currentPattern = currentRound.getCurrentPattern();

        currentPatternAfterReveal = WordPatternService.revealLetter(encodedWord, currentPattern, letter);
        if(!currentPattern.equals(currentPatternAfterReveal)) {
            currentRound.setCurrentPattern(currentPatternAfterReveal);
            return true;
        }
        else {
            return false;
        }
    }

    public Player play() throws InterruptedException {
        while (true) {
            Player currentPlayer = currentRound.getPlayers().get(currentPlayerIndex);
            WheelSector sector = spinWheel();
            System.out.println(currentPlayer.getName() + " спиннит барабан...");
            Thread.sleep(4000);
            // Вывод информации о текущем секторе
            System.out.println("Сектор: " + sector.getName());

            // Обработка действий сектора
            boolean isLetterRevealed = handleSectorAction(sector, currentPlayer);

            // Вывод информации о текущем счете игрока
            System.out.println(currentPlayer.getName() + " имеет " + currentPlayer.getScore() + " очков.");

            // Проверка условий завершения игры и определение победителя
            if (currentRound.getCurrentPattern().equals(currentRound.getEncodedWord())) {
                Player winner = determineWinner();
                System.out.println("Победитель: " + winner.getName());
                return winner;
            }

            // Переход к следующему игроку
            if (!isLetterRevealed) {
                currentPlayerIndex = (currentPlayerIndex + 1) % currentRound.getPlayers().size();
            }
            Thread.sleep(1000);
        }
    }



    public static void main(String[] args) throws InterruptedException {
        WheelOfFortuneGame game = new WheelOfFortuneGame();
        game.play();
    }
}