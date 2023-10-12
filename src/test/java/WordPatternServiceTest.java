import org.example.WordPatternService;
import org.junit.jupiter.api.Test;

import org.example.WordPatternService.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

import static org.junit.jupiter.api.Assertions.*;

public class WordPatternServiceTest {

    @Test
    public void shouldRevealLetterInPattern() {
        // Как разработчик, который реализует программный продукт,
        // я хочу, чтобы функция revealLetter корректно раскрывала букву в шаблоне,
        // для того чтобы пользователь мог угадать слово.


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
    public void shouldTryGuessWord(String word) {
        // Как разработчик, который реализует программный продукт,
        // я хочу, чтобы функция tryGuessWord проверяла угаданное слово,
        // для того чтобы пользователь мог проверить свои догадки.

        assertTrue(WordPatternService.tryGuessWord(word, word));
        assertFalse(WordPatternService.tryGuessWord(null, word));
    }
}
