import java.util.ArrayList;

public class Airport {

    private String airportCode;
    private ArrayList<ArrayList<Plane>> hangers;
    private ArrayList<Flight> flights;

    public Airport(String airPortCode) {
        this.airportCode = airPortCode;
        this.hangers = new ArrayList<>();
        this.flights = new ArrayList<>();
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
}
