import java.util.ArrayList;

public class Flight {

    private String flightNumber;
    private String destination;
    private ArrayList<Passenger> passengers;
    private boolean historicalStatus;
    private Plane plane;

    public Flight(String flightNumber, String destination) {
        this.flightNumber = flightNumber;
        this.destination = destination;
        this.passengers = new ArrayList<>();
        this.historicalStatus = false;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public String getDestination() {
        return destination;
    }

    public ArrayList<Passenger> getPassengers() {
        return passengers;
    }

    public boolean getHistoricalStatus() {
        return historicalStatus;
    }

    public Plane getPlane() {
        return plane;
    }

    public void addPassenger(Passenger passenger) {
        this.passengers.add(passenger);
    }



    public void removePassenger(String exPassengerName) {
        for (Passenger passenger : this.passengers) {
            if (passenger.getPassportCode() == exPassengerName) {
                this.passengers.remove(passenger);
            }
        }
    }

    public void addPlane(Plane plane) {
        this.plane = plane;
    }

    public Plane removePlane() {
        Plane returnedPlane = this.plane;
        this.plane = null;
        return returnedPlane;
    }
}
