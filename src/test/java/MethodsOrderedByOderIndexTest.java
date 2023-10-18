import org.junit.jupiter.api.*;

@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOderIndexTest {

    @Order(1)
    @Test
    void testA(TestInfo testInfo) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
    }

    @Order(2)
    @Test
    void testD(TestInfo testInfo) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
    }

    @Order(3)
    @Test
    void testC(TestInfo testInfo) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
    }

    @Order(4)
    @Test
    void testB(TestInfo testInfo) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
    }

}
