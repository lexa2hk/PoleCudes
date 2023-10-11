import org.example.WheelOfFortuneGame;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class WheelOfFortuneTest {

    static WheelOfFortuneGame wheelOfFortuneGame;

    @BeforeAll
    public static void init(){
        wheelOfFortuneGame = new WheelOfFortuneGame();
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


    ////////////////////////////////////////////////////////////////
    @Test
    public void testHandleKeySectorCorrectKey() {
        // Предполагаем, что верный ключ - 3
        assertTrue(wheelOfFortuneGame.handleKeySector(3));
    }

    @Test
    public void testHandleKeySectorIncorrectKey() {
        // Предполагаем, что верный ключ - 3
        assertFalse(wheelOfFortuneGame.handleKeySector(5));
    }

    @Test
    public void testIsLetterOpenedCorrectLetter() {
        // Предполагаем, что слово "example" и текущий шаблон "*******"
        wheelOfFortuneGame.currentRound.setEncodedWord("example");
        wheelOfFortuneGame.currentRound.setCurrentPattern("*******");

        // Проверяем, что буква 'a' открывается в слове
        assertTrue(wheelOfFortuneGame.isLetterOpened('a'));

        // Проверяем, что текущий шаблон обновляется
        assertEquals("****a**", wheelOfFortuneGame.currentRound.getCurrentPattern());
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
}

