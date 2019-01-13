import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertArrayEquals;
import static org.junit.Assert.assertEquals;

public class AirportTest {

    private Airport airport;
    private Plane plane1;
    private Plane plane2;
    private Plane plane3;
    private Plane plane4;
    private Plane plane5;
    private Passenger passenger1;
    private Passenger passenger2;
    private Passenger passenger3;

    @Before
    public void setUp(){
        this.airport = new Airport("JFK");
        this.plane1 = new Plane(AirlineType.EASYJET, PlaneType.COMACC919);
        this.plane2 = new Plane(AirlineType.EASYJET, PlaneType.BOEING747);
        this.plane3 = new Plane(AirlineType.BRITISHAIRWAYS, PlaneType.BOEING747);
        this.plane4 = new Plane(AirlineType.JET2, PlaneType.AIRBUSA380);
        this.plane5 = new Plane(AirlineType.EASYJET, PlaneType.AIRBUSA380);
        this.passenger1 = new Passenger("Catherine Megregian", "CFG12345");
        this.passenger2 = new Passenger("Rob Wilson", "CFG34567");
        this.passenger3 = new Passenger("Stuart Brown", "CFG56789");

    }

    @Test
    public void airportStatsWithEmptyHanger() {
        assertEquals(0, airport.getHangers().get(0).size());
        assertEquals(0, airport.getHangers().get(1).size());
        assertEquals(0, airport.getHangers().get(2).size());
    }

    @Test
    public void canGetAirportCode() {
        assertEquals("JFK", airport.getAirportCode());
    }

    @Test
    public void canGetFlight() {
        assertEquals(0, airport.getFlights().size());
    }
}
