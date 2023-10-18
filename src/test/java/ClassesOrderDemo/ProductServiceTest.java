package ClassesOrderDemo;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.Order;

@Order(2)
public class ProductServiceTest {
    @BeforeAll
    static void setup() {
        System.out.println("Test methods related to Products");
    }

    @Test
    void testCreateProduct_whenProductTitleIsMissing_throwsProductServiceException() {
    }

}
