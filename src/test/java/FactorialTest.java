import org.example.Factorial;
import org.testng.annotations.Test;
import static org.testng.Assert.assertEquals;

public class FactorialTest {

    @Test
    public void testFactorialOfZero() {
        assertEquals(Factorial.factorial(0), 1, "Факториал 0 должен быть 1");
    }

    @Test
    public void testFactorialOfPositiveNumber() {
        assertEquals(Factorial.factorial(1), 1, "Факториал 1 должен быть = 1");
        assertEquals(Factorial.factorial(10), 3628800, "Факториал 10 должен быть = 3628800");
    }

    @Test(expectedExceptions = IllegalArgumentException.class,
            expectedExceptionsMessageRegExp = "Факториал не может быть отрицательным")
    public void testFactorialOfNegativeNumber() {
        Factorial.factorial(-1);
    }
}
