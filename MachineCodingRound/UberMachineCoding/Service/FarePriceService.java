package MachineCodingRound.UberMachineCoding.Service;

import MachineCodingRound.UberMachineCoding.Model.Driver;
import MachineCodingRound.UberMachineCoding.Model.Ride;
import MachineCodingRound.UberMachineCoding.Strategy.VehiclePriceStrategy;

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
    public double calculateFarePrice(Driver driver, Ride ride ) {
        return new VehiclePriceStrategy()
                .getPrice(ride.getVehicleType(), driver.getCurrentLocations()
                        .toDistance(ride.getDestinationLocation()),driver.getVehicle());
    }

    public void showVehicleWithPrice(List<Driver> allowedDrivers, Ride ride) {
        allowedDrivers.forEach(driver -> System.out.println("Available Driver name " + driver.getName() + " " +
                calculateFarePrice(driver, ride)+ "R have the total pay."));

    }
}
