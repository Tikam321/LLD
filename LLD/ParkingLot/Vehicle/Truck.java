package LLD.ParkingLot.Vehicle;

public class Truck extends Vehicle{
    private final double RATE = 299.0;
    public Truck(String plateNumber) {
        super(plateNumber, VehicleType.TRUCK);
    }

    public double calculateBill(double hoursStayed) {
        return RATE * hoursStayed;
    }
}
