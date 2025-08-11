package MachineCodingRound.UberMachineCoding.Strategy;

import MachineCodingRound.UberMachineCoding.Model.Vehicle;
import MachineCodingRound.UberMachineCoding.enums.VehicleType;

public class SurgePriceStrategy implements PricingStrategy{
    private int surgeCount;

    public SurgePriceStrategy(int surgePriceMultiplier) {
        this.surgeCount = surgePriceMultiplier;
    }

    public int getSurgeCount() {
        return surgeCount;
    }

    public void setSurgeCount(int surgeCount) {
        this.surgeCount = surgeCount;
    }

    @Override
    public double getPrice(VehicleType vehicleType, double distance, Vehicle vehicle) {
        double baseFare = switch (vehicleType) {
            case GO -> 8.5;
            case SEDAN -> 70;
            case AUTO -> 15;
        };
        double surgeMultiplier = 1 + ((double) surgeCount / 10); // for every 10+ rides 2x fare
        return baseFare * distance * surgeMultiplier;
    }
}
