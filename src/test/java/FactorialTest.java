import org.example.Factorial;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class FactorialTest {
    @Test
    public void testFactorialOfZero() {
        assertEquals(1, Factorial.factorial(0), "Факториал 0 должен быть = 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(1, Factorial.factorial(1), "Факториал 1 должен быть = 1");
        assertEquals(3628800, Factorial.factorial(10), "Факториал 10 должен быть = 3628800");
    }

    @Test
    public void testFactorialOfNegativeNumber() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> {
            Factorial.factorial(-1);
        });
        assertEquals("Факториал не может быть отрицательным", exception.getMessage());
    }

}
