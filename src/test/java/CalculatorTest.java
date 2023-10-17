import com.rawtech.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.*;

@DisplayName("Test Arithmetic in Calculator Class")
public class CalculatorTest {

//    Naming Tests: test<System Under Test>_<Condition Or State Change>_<Expected Result>
    Calculator calculator;

    @BeforeAll
    static void setup() {
        System.out.println("Executing @BeforeAll method.");
    }

    @AfterAll
    static void cleanup() {
        System.out.println("Executing @AfterAll method.");
    }

    @BeforeEach
    void beforeEachTestMethod() {
        System.out.println("Executing @BeforeEach method.");
        calculator = new Calculator();
    }

    @AfterEach
    void afterEachTestMethod() {
        System.out.println("Executing @AfterEach method.");
    }

    @DisplayName("4/2=2")
    @Test
    void testIntegerDivision_WhenFourIsDividedByTwo_ShouldReturnTwo() {
        System.out.println("Running 4/2=2");
//        Arrange   // Given
        int dividend = 4;
        int divisor = 2;
        int expectedResult = 2;

//        Act   // When
        int actualResult = calculator.integerDivision(dividend, divisor);

//        Assert    // Then
        assertEquals(expectedResult, actualResult, "integerDivision did not return 4 / 2 = 2!");
    }

    @DisplayName("Division by zero")
//    @Disabled("If disabled, a message can be added here.")
    @Test
    void testIntegerDivision_WhenDividendIsZero_ShouldReturnArithmeticException() {
        System.out.println("Running Division by zero");

//        Arrange   // Given
        int dividend = 4;
        int divisor = 0;
        String expectedException = "/ by zero";

//        Act & Assert   // When
        ArithmeticException actualException = assertThrows(ArithmeticException.class, () -> {
//          Act
            calculator.integerDivision(dividend, divisor);
        }, "Dividing by zero should throw an ArithmeticException.");

//        Assert    // Then
        assertEquals(expectedException, actualException.getMessage(), "Unexpected exception message");
    }

    @DisplayName("32-10=22")
    @Test
    void testIntegerSubtraction_WhenSubtractingTwoFromFour_ShouldReturnTwo() {
        System.out.println("Running 32-10=22");

//        Arrange   // Given
        int minuend = 32;
        int subtrahend = 10;
        int expectedResult = 22;

//        Act   // When
        int actualResult = calculator.integerSubtraction(minuend, subtrahend);

//        Assert    // Then
        assertEquals(expectedResult, actualResult, () -> minuend + " - " + subtrahend + " did not produce " + expectedResult );
    }

}
