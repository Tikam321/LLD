package MachineCodingRound.UberMachineCoding.Service;

import MachineCodingRound.UberMachineCoding.Model.Driver;
import MachineCodingRound.UberMachineCoding.Model.Ride;
import MachineCodingRound.UberMachineCoding.Strategy.PricingStrategy;

import java.util.List;

public class FarePriceService {

    private FarePriceService() {
    }

    public static FarePriceService instance;

    public static synchronized FarePriceService getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = new FarePriceService();
    }
    public double calculateFarePrice(Driver driver, Ride ride, PricingStrategy pricingStrategy) {
        return pricingStrategy
                .getPrice(ride.getVehicleType(), driver.getCurrentLocations()
                        .toDistance(ride.getDestinationLocation()),driver.getVehicle());
    }

    public void showVehicleWithPrice(List<Driver> allowedDrivers, Ride ride, PricingStrategy pricingStrategy) {
        allowedDrivers.forEach(driver -> System.out.println("Available Driver name " + driver.getName() + " " +
                calculateFarePrice(driver, ride, pricingStrategy)+ "R have the total pay."));
    }
}
