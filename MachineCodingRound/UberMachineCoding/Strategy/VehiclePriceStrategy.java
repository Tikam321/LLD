package MachineCodingRound.UberMachineCoding.Strategy;

import MachineCodingRound.UberMachineCoding.Model.Vehicle;
import MachineCodingRound.UberMachineCoding.enums.VehicleType;

public class VehiclePriceStrategy implements PricingStrategy{

    public double getPrice(VehicleType vehicleType, double distance, Vehicle vehicle) {
        double baseFare = switch (vehicleType) {
            case GO -> 8.5;
            case SEDAN -> 70;
            case AUTO -> 15;
        };
        return baseFare * distance;
    }
}
