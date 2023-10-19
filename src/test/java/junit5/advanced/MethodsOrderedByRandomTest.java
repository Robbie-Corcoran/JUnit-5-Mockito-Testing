package junit5.advanced;

import org.junit.jupiter.api.MethodOrderer;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.TestInfo;
import org.junit.jupiter.api.TestMethodOrder;

@TestMethodOrder(MethodOrderer.Random.class)
public class MethodsOrderedByRandomTest {

    @Test
    void testA(TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
    }

    @Test
    void testB(TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
    }

    @Test
    void testC(TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
    }

    @Test
    void testD(TestInfo testInfo) {
        System.out.println("Running " + testInfo.getTestMethod().get().getName());
    }
}
