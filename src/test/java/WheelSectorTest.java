import org.example.WheelSector;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


public class WheelSectorTest {

    @Test
    public void testGetName() {
        WheelSector wheelSector = new WheelSector("Test Sector", 100, true);
        assertEquals("Test Sector", wheelSector.getName());
    }

    @Test
    public void testGetPoints() {
        WheelSector wheelSector = new WheelSector("Test Sector", 200, true);
        assertEquals(200, wheelSector.getPoints());
    }

    @Test
    public void testCanGuessWholeWord() {
        WheelSector wheelSector = new WheelSector("Test Sector", 300, false);
        assertEquals(false, wheelSector.canGuessWholeWord());
    }
}