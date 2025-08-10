package MachineCodingRound.UberMachineCoding.Strategy;

import MachineCodingRound.UberMachineCoding.Model.Vehicle;
import MachineCodingRound.UberMachineCoding.Model.VehicleType;

public class VehiclePriceStrategy implements PricingStrategy{

    public double getPrice(VehicleType vehicleType, double distance, Vehicle vehicle) {
        double baseFare = switch (vehicleType) {
            case GO -> 8.5;
            case SEDAN -> 70;
            case AUTO -> 15;
            default -> throw new IllegalArgumentException("the vehicleType is wrong");
        };
        return baseFare * distance;
    }
}
