package LLD.ParkingLot.Vehicle;

public class MotorCycle extends Vehicle{

    private final double RATE = 199.0;

    public MotorCycle(String plateNumber) {
        super(plateNumber, VehicleType.MOTORCYCLE);
    }

    @Override
    public double calculateBill(double hoursStayed) {
        return RATE * hoursStayed;
    }
}
