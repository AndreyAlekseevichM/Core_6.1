import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class testsTax {

    @Test
    public void testTaxMinus6() {
        int earnings = 2000,  expected = 120;
        var result = Main.taxMinus6(earnings) ;
        Assertions.assertEquals(expected, result);
    }

    @Test
    public void testTaxMinus6_NotNull() {
        int earnings = 100;
        var result = Main.taxMinus6(earnings) ;
        Assertions.assertNotNull(String.valueOf(result));
    }

    @Test
    public void testTaxMinus6_NotEquals() {
        int earnings = 100,  expected = 100;
        var result = Main.taxMinus6(earnings) ;
        Assertions.assertNotEquals(expected, result);
    }

    @Test
    public void testEarningsMinusSpendings() {
        int earnings = 2000, spendings= 1000, expected = 150;
        var result = Main.taxEarningsMinusSpendings(earnings,spendings) ;
        Assertions.assertEquals(expected, result);
    }
}

