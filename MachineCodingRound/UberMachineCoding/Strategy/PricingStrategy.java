package MachineCodingRound.UberMachineCoding.Strategy;

import MachineCodingRound.UberMachineCoding.Model.Vehicle;
import MachineCodingRound.UberMachineCoding.enums.VehicleType;

public interface PricingStrategy {
    public double getPrice(VehicleType vehicleType, double distance, Vehicle vehicle);
}