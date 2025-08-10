package LLD.ParkingLot.Vehicle;

public class Car  extends Vehicle{

    private final double RATE = 99.0;

    public Car(String plateNumber) {
        super(plateNumber, VehicleType.CAR);
    }

    @Override
    public double calculateBill(double hoursStayed) {
        return RATE * hoursStayed;
    }
}
