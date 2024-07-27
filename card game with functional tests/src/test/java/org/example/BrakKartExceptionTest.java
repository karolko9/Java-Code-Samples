package org.example;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class BrakKartExceptionTest {

    @Test
    public void testKonstruktor() {
        String message = "Testowy komunikat wyjątku";
        BrakKartException exception = new BrakKartException(message);
        assertEquals(message, exception.getMessage());
    }
}
