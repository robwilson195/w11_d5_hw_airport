public class Passenger {

    private String passportCode;
    private String name;

    public Passenger(String name, String passportCode) {
        this.name = name;
        this.passportCode = passportCode;
    }

    public String getName() {
        return name;
    }

    public String getPassportCode() {
        return passportCode;
    }
}
