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
    private Passenger passenger4;

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
        this.passenger4 = new Passenger("Aimee Keown", "CFG76543");

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
    public void startsWithNoFlights() {
        assertEquals(0, airport.getFlights().size());
    }

    @Test
    public void canMakeFlight() {
        airport.scheduleFlight("FF278", "Geneva");
        assertEquals("FF278", airport.getFlights().get(0).getFlightNumber());
    }

    @Test
    public void canReturnFlightByCode() {
        airport.scheduleFlight("FF278", "Geneva");
        airport.scheduleFlight("FG987", "Miami");
        Flight foundFlight = airport.findFlight("FG987");
        assertEquals("Miami", foundFlight.getDestination());
    }

    @Test
    public void canAddPlane() {
        airport.addPlane(plane2);
        assertEquals(plane2, airport.getHangers().get(1).get(0));
    }

    @Test
    public void  canReturnSmallestAvailablePlane() {
        airport.addPlane(plane2);
        airport.addPlane(plane3);
        airport.addPlane(plane4);
        airport.addPlane(plane1);
        airport.addPlane(plane5);
        assertEquals(plane1, airport.getSmallestPlane());
    }

    @Test
    public void smallestPlaneIsCheckedOutWhenFlightIsScheduled() {
        airport.addPlane(plane2);
        airport.addPlane(plane3);
        airport.addPlane(plane4);
        airport.addPlane(plane1);
        airport.addPlane(plane5);
        airport.scheduleFlight("FG987", "Miami");
        assertEquals(plane2, airport.getSmallestPlane());
    }

    @Test
    public void canSellTicket() {
        airport.addPlane(plane1);
        airport.scheduleFlight("FG987", "Miami");
        airport.sellTicket("FG987", passenger1);
        assertEquals(1,airport.findFlight("FG987").getPassengers().size());
    }

    @Test
    public void canUpdradePlaneIfCapacityExceeded() {
        airport.addPlane(plane1);
        airport.addPlane(plane2);
        airport.scheduleFlight("FG987", "Miami");
        assertEquals(plane1, airport.findFlight("FG987").getPlane());
        airport.sellTicket("FG987", passenger1);
        airport.sellTicket("FG987", passenger2);
        airport.sellTicket("FG987", passenger3);
        assertEquals(plane2, airport.findFlight("FG987").getPlane());
    }

    @Test
    public void wontSellTicketIfBigEnoughPlaneNotAvailable() {
        airport.addPlane(plane1);
        airport.addPlane(plane2);
        airport.scheduleFlight("FG987", "Miami");
        assertEquals(plane1, airport.findFlight("FG987").getPlane());
        airport.sellTicket("FG987", passenger1);
        airport.sellTicket("FG987", passenger2);
        airport.sellTicket("FG987", passenger3);
        assertEquals(plane2, airport.findFlight("FG987").getPlane());
        airport.sellTicket("FG987", passenger4);
        assertEquals(3, airport.findFlight("FG987").getPassengers().size());
    }

    @Test
    public void canLaunchFlight() {
        airport.scheduleFlight("FG987", "Miami");
        airport.launchFlight("FG987");
        assertEquals(true, airport.findFlight("FG987").getHistoricalStatus());
    }
}
