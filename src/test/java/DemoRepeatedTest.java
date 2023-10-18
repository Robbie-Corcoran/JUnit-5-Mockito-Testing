import com.rawtech.Calculator;
import org.junit.jupiter.api.*;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

public class DemoRepeatedTest {

    Calculator calculator;

    @BeforeEach
    void beforeEachTestMethod() {
        System.out.println("Executing @BeforeEach method.");
        calculator = new Calculator();
    }

    @DisplayName("Division by zero")
    @RepeatedTest(value = 3, name = "{displayName}: {currentRepetition} of {totalRepetitions}")
    void testIntegerDivision_WhenDividendIsZero_ShouldReturnArithmeticException(
            RepetitionInfo repetitionInfo,
            TestInfo testInfo
    ) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
        System.out.println("Repetition No." +repetitionInfo.getCurrentRepetition()+ " of " +repetitionInfo.getTotalRepetitions());

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
}
