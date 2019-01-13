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
}
