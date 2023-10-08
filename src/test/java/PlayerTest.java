import org.example.Player;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

public class PlayerTest {

    private Player player = Mockito.mock(Player.class);



    @Test
    public void testInitialScoreIsZero() {
        when(player.getScore()).thenReturn(0);
    }

    @Test
    public void testAddScore() {
        Player player = Mockito.mock(Player.class);
        when(player.getScore()).thenReturn(0);

        player.addScore(10);

        verify(player).addScore(10);

        when(player.getScore()).thenReturn(10);

        assertEquals(10, player.getScore());
    }
}
