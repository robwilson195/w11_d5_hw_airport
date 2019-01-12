public class Plane {

    private PlaneType planeType;
    private AirlineType airline;

    public Plane(AirlineType airline, PlaneType planeType) {
        this.airline = airline;
        this.planeType = planeType;
    }

    public PlaneType getPlaneType() {
        return planeType;
    }

    public AirlineType getAirline() {
        return airline;
    }
}
