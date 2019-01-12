public enum PlaneType {
    AIRBUSA380(4),
    BOEING747(3),
    COMACC919(2);

    private final int capacity;

    PlaneType(int capacity) {
        this.capacity = capacity;
    }

    public int getCapacity() {
        return capacity;
    }
}
