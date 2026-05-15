import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import static org.junit.jupiter.api.Assertions.*;

class DiscountCalculatorTest {
    DiscountCalculator calculator = new DiscountCalculator();

    
    @ParameterizedTest
    @CsvSource({
      
        "NEW, 5, true, 7.0",      
        "REGULAR, 12, false, 13.0",
        "PREMIUM, 10, true, 15.0", 
        "NEW, 0, false, 5.0",      
        "REGULAR, 2, true, 10.0",  
        "PREMIUM, 5, false, 10.0"  
    })
    void testCalculateDiscount(String type, int orders, boolean sub, double expected) {
        assertEquals(expected, calculator.calculateDiscount(type, orders, sub));
    }

     
    @ParameterizedTest
    @CsvSource({ "NEW, 10", "NEW, 15" })
    void testInfeasibleCombination(String type, int orders) {
        assertThrows(IllegalArgumentException.class, () -> {
            calculator.calculateDiscount(type, orders, false);
        }); [cite: 26, 27]
    }
}
