import org.example.Player;
import org.example.WheelOfFortuneGame;
import org.example.WheelSector;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.Arrays;
import java.util.Scanner;

import static org.junit.jupiter.api.Assertions.*;

public class WheelOfFortuneTest {

    static WheelOfFortuneGame wheelOfFortuneGame;
    private static Player currentPlayer;
    private static final ByteArrayOutputStream outputStream = new ByteArrayOutputStream();
    private final PrintStream originalOut = System.out;

    @BeforeAll
    public static void init(){
        wheelOfFortuneGame = new WheelOfFortuneGame();
        currentPlayer = new Player("Player example");
        System.setOut(new PrintStream(outputStream));
    }

    @Test
    public void initializationTest(){
        wheelOfFortuneGame.initializeRound();
        assertNotNull(wheelOfFortuneGame.currentRound);
        assertEquals(wheelOfFortuneGame.currentRound.getPlayers().get(0).getName(),"Player 1");

    }


    @Test
    public void getRandomSector() {
        assertNotNull(wheelOfFortuneGame);
        assertNotNull(wheelOfFortuneGame.spinWheel());
    }

    @Test
    public void testDetermineWinner(){
        assertNotNull(wheelOfFortuneGame);
        Object player = wheelOfFortuneGame.determineWinner();
       assertNotNull(player);
    }


    ///////////////////////////////////////////////////////////////

    @Test
    public void testIsLetterOpenedCorrectLetter() {
        // Предполагаем, что слово "example" и текущий шаблон "*******"
        wheelOfFortuneGame.currentRound.setEncodedWord("example");
        wheelOfFortuneGame.currentRound.setCurrentPattern("*******");

        // Проверяем, что буква 'a' открывается в слове
        assertTrue(wheelOfFortuneGame.isLetterOpened('a'));

        // Проверяем, что текущий шаблон обновляется
        assertEquals("**a****", wheelOfFortuneGame.currentRound.getCurrentPattern());
    }

    @Test
    public void testIsLetterOpenedIncorrectLetter() {
        wheelOfFortuneGame.currentRound.setEncodedWord("example");
        wheelOfFortuneGame.currentRound.setCurrentPattern("*******");

        // Проверяем, что буква 'b' не открывается в слове
        assertFalse(wheelOfFortuneGame.isLetterOpened('b'));

        // Проверяем, что текущий шаблон остается без изменений
        assertEquals("*******", wheelOfFortuneGame.currentRound.getCurrentPattern());
    }
    ////////////////////////////////////////////////////////////////////////////////////////////////////////////////////

    @Test
    public void testHandlePrizeSectorTakePrize() throws InterruptedException, IOException {
        wheelOfFortuneGame.currentRound.setEncodedWord("str");
        wheelOfFortuneGame.currentRound.setCurrentPattern("***");
        WheelSector sector = new WheelSector("Prize", 100, true);
        outputStream.reset();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                wheelOfFortuneGame.handleSectorAction(sector, currentPlayer);
            }
        });
        thread.start();
        Thread.sleep(5000);
        //boolean result = wheelOfFortuneGame.handleSectorAction(sector, currentPlayer, scanner);

        String expectedOutput = "\n\nТекущее слово: ***\r\n" +
                "Поздравляем, у вас выпал сектор 'Приз'!\r\n" +
                "Вы можете либо продолжить игру, либо взять приз.\r\n" +
                "Введите 'Продолжить' или 'Взять приз': ";

        assertEquals(expectedOutput, outputStream.toString());
        assertEquals(0, currentPlayer.getScore());
    }

    @Test
    public void testHandleKeySector() throws InterruptedException, IOException {
        wheelOfFortuneGame.currentRound.setEncodedWord("str");
        wheelOfFortuneGame.currentRound.setCurrentPattern("***");
        WheelSector sector = new WheelSector("Key", 0, true);
        outputStream.reset();
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                wheelOfFortuneGame.handleSectorAction(sector, currentPlayer);
            }
        });
        thread.start();
        Thread.sleep(5000);


        String expectedOutput = "\n\nТекущее слово: ***\r\n" +
                "Вы получили сектор 'Ключ'!\r\n" +
                "У вас есть 6 ключей, один из которых от автомобиля.\r\n" +
                "Введите номер ключа, который хотите использовать (1-6): ";
        assertEquals(expectedOutput, outputStream.toString());
    }
}

