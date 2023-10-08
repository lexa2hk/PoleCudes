import org.example.Player;
import org.example.Round;
import org.example.WheelSector;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class RoundTest {

    private List<Player> players;
    private String theme;
    private List<WheelSector> wheel;

    @BeforeEach
    public void setUp() {
        // Create mock Player objects
        Player player1 = mock(Player.class);
        Player player2 = mock(Player.class);

        // Create a list of mock Player objects
        players = new ArrayList<>(Arrays.asList(player1, player2));

        // Set up the theme and wheel for testing
        theme = "Test Theme";
        wheel = Arrays.asList(
                new WheelSector("Sector1", 100, true),
                new WheelSector("Sector2", 200, false)
        );
    }

    @Test
    public void testGetTheme() {
        Round round = new Round(players, theme, wheel);
        assertEquals(theme, round.getTheme());
    }

    @Test
    public void testGetWheel() {
        Round round = new Round(players, theme, wheel);
        assertEquals(wheel, round.getWheel());
    }

    @Test
    public void testGetPlayers() {
        Round round = new Round(players, theme, wheel);
        assertEquals(players, round.getPlayers());
    }
}