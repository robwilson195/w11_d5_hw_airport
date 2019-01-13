import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class PassengerTest {

    private Passenger passenger;

    @Before
    public void setUp() {
        this.passenger = new Passenger("Steve Jobs", "CFG23456");
    }

    @Test
    public void hasName() {
        assertEquals("Steve Jobs", passenger.getName());
    }

    @Test
    public void hasPassportCode() {
        assertEquals("CFG23456", passenger.getPassportCode());
    }
}
