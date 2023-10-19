package junit5.basics;

import com.rawtech.junit5.basics.Calculator;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.stream.Stream;

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

    private static Stream<Arguments> integerSubtractionInputParameters() {
        return Stream.of(
                Arguments.of(32, 10, 22),
                Arguments.of(54, 5, 49),
                Arguments.of(1234, 1230, 4)
        );
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

    @DisplayName("Test Integer Subtraction [minuend, subtrahend, expectedResult]")
    @ParameterizedTest
//    @MethodSource("integerSubtractionInputParameters")
//    @CsvSource( {
//            "33, 1, 32",
//            "24, 5, 19",
//            "1245431, 4311, 1241120"
//    } )

    @CsvFileSource(resources = "/integerSubtraction.csv")
    void testIntegerSubtraction(int minuend, int subtrahend, int expectedResult) {
        System.out.println("Running Test Integer Subtraction: " + minuend + " - " + subtrahend + " = " + expectedResult);
//        Arrange


//        Act
        int actualResult = calculator.integerSubtraction(minuend, subtrahend);

//        Assert
        assertEquals(expectedResult, actualResult, () -> minuend + " - " + subtrahend + " did not produce " + expectedResult);
    }

    @DisplayName("Test the firstName is not null")
    @ParameterizedTest
    @ValueSource(strings = {"John", "Tom", "Kate"})
    void valueSourceDemonstration(String firstName) {
        System.out.println("Testing: " + firstName);
        assertNotNull(firstName);
    }
}
