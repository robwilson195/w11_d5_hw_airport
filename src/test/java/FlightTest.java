import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FlightTest {
    private Flight flight;
    private Passenger passenger;
    private Passenger passenger2;
    private Plane plane;
    private Plane plane2;

    @Before
    public void setUp() throws Exception {
        this.flight = new Flight("FF278", "Geneva");
        this.passenger = new Passenger("Rob Wilson", "CFG23456");
        this.passenger2 = new Passenger("Stuart Brown", "RTV56789");
        this.plane = new Plane(AirlineType.BRITISHAIRWAYS, PlaneType.COMACC919);
        this.plane2 = new Plane(AirlineType.EASYJET, PlaneType.BOEING747);
    }

    @Test
    public void hasFlightNumber() {
        assertEquals("FF278", flight.getFlightNumber());
    }

    @Test
    public void hasDestination() {
        assertEquals("Geneva", flight.getDestination());
    }

    @Test
    public void hasPassengers() {
        assertEquals(0, flight.getPassengers().size());
    }

    @Test
    public void hasHistoricalStatus() {
        assertEquals(false, flight.getHistoricalStatus());
    }

    @Test
    public void canAddPassenger() {
        flight.addPassenger(passenger);
        assertEquals(1, flight.getPassengers().size());
    }

    @Test
    public void canRemovePassengerByPassportCode() {
        flight.addPassenger(passenger);
        flight.addPassenger(passenger2);
        flight.removePassenger("CFG23456");
        assertEquals(1, flight.getPassengers().size());
        assertEquals("RTV56789", flight.getPassengers().get(0).getPassportCode());
        System.out.println(flight.getPassengers());
    }

    @Test
    public void addPlane() {
        flight.addPlane(plane);
        assertEquals(plane, flight.getPlane());
    }

    @Test
    public void removePlane() {
        flight.addPlane(plane);
        assertEquals(plane, flight.getPlane());
        flight.removePlane();
        assertEquals(null, flight.getPlane());
    }

    @Test
    public void canAddANewPlaneAfterRemovingAnother() {
        flight.addPlane(plane);
        assertEquals(plane, flight.getPlane());
        flight.removePlane();
        assertEquals(null, flight.getPlane());
        flight.addPlane(plane2);
        assertEquals(plane2, flight.getPlane());
    }
}
