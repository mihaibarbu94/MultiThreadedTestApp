import org.junit.Test;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

public class PrimeTest {

    @Test
    public void isPrime() {
        assertFalse(Prime.isPrime(0));
        assertFalse(Prime.isPrime(1));
        assertTrue(Prime.isPrime(2));
        assertTrue(Prime.isPrime(7));
        assertFalse(Prime.isPrime(9));
    }

    @Test
    public void isDecrescendo() {
        assertTrue(Prime.isDescrescendo(9876));
        assertFalse(Prime.isDescrescendo(9782));
        assertTrue(Prime.isDescrescendo(9));
        assertFalse(Prime.isDescrescendo(8522221));
    }

    @Test
    public void isDecrescendoPrime(){
        assertTrue(Prime.isPrime(71) && Prime.isDescrescendo(71));
        assertTrue(Prime.isPrime(98765431 ) && Prime.isDescrescendo(98765431 ));
    }


}
