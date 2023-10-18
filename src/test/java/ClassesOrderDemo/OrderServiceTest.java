package ClassesOrderDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;

@Order(3)
public class OrderServiceTest {

    @BeforeAll
    static void setup() {
        System.out.println("Test methods related to Order");
    }

    @Test
    void testCreateOrder_whenProductIdIsMissing_throwsOrderServiceException() {
    }
}
