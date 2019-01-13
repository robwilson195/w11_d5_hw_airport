import java.util.ArrayList;

public class Airport {

    private String airportCode;
    private ArrayList<ArrayList<Plane>> hangers;
    private ArrayList<Flight> flights;

    public Airport(String airPortCode) {
        this.airportCode = airPortCode;
        this.flights = new ArrayList<>();
        this.hangers = new ArrayList<>();
        for (int i = 0; i < 3; i++) {
            this.hangers.add(new ArrayList<>());
        }
    }

    public String getAirportCode() {
        return airportCode;
    }

    public ArrayList<ArrayList<Plane>> getHangers() {
        return hangers;
    }

    public ArrayList<Flight> getFlights() {
        return flights;
    }

    public void scheduleFlight(String code, String dest) {
        Flight newFlight = new Flight(code, dest);
        this.flights.add(newFlight);
        Plane plane = this.getSmallestPlane();
        newFlight.addPlane(plane);
    }

    public void addPlane(Plane newPlane) {
        if (newPlane.getPlaneType() == PlaneType.COMACC919) {
            this.hangers.get(0).add(newPlane);
        } else if (newPlane.getPlaneType() == PlaneType.BOEING747) {
            this.hangers.get(1).add(newPlane);
        } else if (newPlane.getPlaneType() == PlaneType.AIRBUSA380){
            this.hangers.get(2).add(newPlane);
        }
    }

    public Flight findFlight(String code) {
        Flight foundFlight = null;
        for (Flight flight : this.flights) {
            if (flight.getFlightNumber() == code) {
                foundFlight = flight;
                break;
            }
        }
        return foundFlight;
    }

    public Plane getSmallestPlane() {
        Plane smallestPlane = null;
        for (ArrayList<Plane> hanger : this.hangers) {
            if (hanger.size() > 0) {
                smallestPlane = hanger.remove(0);
                break;
            }
        }
        return smallestPlane;
    }

    public void sellTicket(String flightCode, Passenger passenger) {
        Flight flight = findFlight(flightCode);
        int currentPlaneCapacity = flight.getPlane().getPlaneType().getCapacity();
        if (flight.getPassengers().size() < currentPlaneCapacity) {
            flight.addPassenger(passenger);
        } else if (getLargerPlane(currentPlaneCapacity) != null) {
            Plane newPlane = getLargerPlane(currentPlaneCapacity);
            this.addPlane(flight.removePlane());
            flight.addPlane(newPlane);
            flight.addPassenger(passenger);
        }
    }

    public Plane getLargerPlane(int currentCapacity) {
        Plane largerPlane = null;
        for (ArrayList<Plane> hanger : this.hangers) {
            if (hanger.size() > 0 && hanger.get(0).getPlaneType().getCapacity() > currentCapacity) {
                largerPlane = hanger.get(0);
                break;
            }
        }
        return largerPlane;
    }


    public void launchFlight(String flightCode) {
        this.findFlight("FG987").depart();
    }
}
