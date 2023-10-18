import org.junit.jupiter.api.*;

@TestInstance(TestInstance.Lifecycle.PER_CLASS )
@TestMethodOrder(MethodOrderer.OrderAnnotation.class)
public class MethodsOrderedByOrderIndexTest {

    StringBuilder completed = new StringBuilder("");

    @AfterEach
    void appendToStringBuilder() {
        System.out.println("The current state of 'completed' is: " +completed);
    }

    @Order(1)
    @Test
    void testA(TestInfo testInfo) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
        completed.append("1");
    }

    @Order(2)
    @Test
    void testD(TestInfo testInfo) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
        completed.append("2");
    }

    @Order(3)
    @Test
    void testC(TestInfo testInfo) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
        completed.append("3");
    }

    @Order(4)
    @Test
    void testB(TestInfo testInfo) {
        System.out.println("Running " +testInfo.getTestMethod().get().getName());
        completed.append("4");
    }

}
