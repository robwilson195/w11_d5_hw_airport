public enum PlaneType {
    AIRBUSA380("Airbus A380", 4),
    BOEING747("Boeing 747", 3),
    COMACC919("Comac C919", 2);

    private final int capacity;
    private final String name;

    PlaneType(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
