import org.example.WordPatternService;
import org.junit.jupiter.api.Test;

import org.example.WordPatternService.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class WordPatternServiceTest {

    @Test
    public void letterGuessTest() {
        String encoded = "Testing";
        String pattern = "*******";
        char letter = 't';
        pattern = WordPatternService.revealLetter(encoded, pattern, letter);
        assertEquals("t**t***", pattern);

        pattern = WordPatternService.revealLetter(encoded, pattern, 'e');
        assertEquals("te*t***", pattern);

        pattern = WordPatternService.revealLetter(encoded, pattern, 'z');
        assertEquals("te*t***", pattern);

        pattern = WordPatternService.revealLetter(encoded, pattern, 's');
        assertEquals("test***", pattern);

    }

    @ParameterizedTest
    @ValueSource(strings = {"string", "dog", "testing"})
    public void wordGuessTest(String word) {
        assertTrue(WordPatternService.tryGuessWord(word,word));
        assertFalse(WordPatternService.tryGuessWord(null,word));
    }
}
