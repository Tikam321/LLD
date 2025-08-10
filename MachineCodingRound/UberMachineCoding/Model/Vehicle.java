package MachineCodingRound.UberMachineCoding.Model;

import java.util.UUID;

public class Vehicle {
    private VehicleType vehicleType;
    private String id;
    private double baseFare;

    public Vehicle(VehicleType vehicleType, double baseFare) {
        this.vehicleType = vehicleType;
        this.id = UUID.randomUUID().toString();
        this.baseFare = baseFare;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public double getBaseFare() {
        return baseFare;
    }

    public void setBaseFare(double baseFare) {
        this.baseFare = baseFare;
    }
}
