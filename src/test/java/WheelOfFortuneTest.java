import org.example.Player;
import org.example.WheelOfFortuneGame;
import org.example.WheelSector;

import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mock;
import org.mockito.Mockito;



import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.mockito.Mockito.when;

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
,       assertNotNull(player);
    }
}
