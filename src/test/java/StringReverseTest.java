import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import com.java.course.StringReverser;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.NullSource;

import java.util.stream.Stream;

public class StringReverseTest {

    private static final String EMPTY_STRING = "";
    private static final String SEVERAL_SPACE = "   ";
    private static final String BACKSLASH_ARGUMENTS = "\\";

    StringReverser stringReverser = new StringReverser();


    @Test
    void testHelloWorld() throws IllegalAccessException {
        assertEquals("Hello World", stringReverser.reverseWordsinString("olleH dlroW"));
    }



    @ParameterizedTest
    @MethodSource("provideInputAndExpectedValues")
    void reverseWordsInStringShouldReturnExpectedValue(String input, String expected) throws IllegalAccessException {
        String result = stringReverser.reverseWordsinString(input);
        assertEquals(expected, result);

    }

    private static Stream<Arguments> provideInputAndExpectedValues() {
        return Stream.of(Arguments.of("Hello World!", "olleH dlroW!"), Arguments.of(SEVERAL_SPACE, ""),
            Arguments.of(BACKSLASH_ARGUMENTS, "\\"), Arguments.of(EMPTY_STRING, ""),
            Arguments.of("12345 67890", "12345 67890"), Arguments.of("abc def", "cba fed"),
            Arguments.of("H e l l o", "H e l l o"));
    }

    @ParameterizedTest
    @NullSource
    void reverseWordsInStringShouldThrowExceptionWhenInputIsNull(String input) {
        Throwable exception = assertThrows(IllegalAccessException.class, () -> stringReverser.reverseWordsinString(input));

        assertEquals("Input string cannot be null", exception.getMessage());
    }

}
