package MachineCodingRound.UberMachineCoding.Service;

import MachineCodingRound.UberMachineCoding.Model.Driver;
import MachineCodingRound.UberMachineCoding.Model.Ride;
import MachineCodingRound.UberMachineCoding.Model.Rider;
import MachineCodingRound.UberMachineCoding.Notification.EventRiderSubject;
import MachineCodingRound.UberMachineCoding.Strategy.PricingStrategy;

import java.util.List;
import java.util.Optional;

import static MachineCodingRound.UberMachineCoding.Service.UberService.MAX_DISTANCE;

public class BookingRideService {
    private final UberService uberService;
    private final FarePriceService farePriceService;

    public  static BookingRideService instance;
    private EventRiderSubject eventRiderSubject;
    private EventRiderSubject eventDriverSubject;
    private PricingStrategy pricingStrategy;

    public BookingRideService(PricingStrategy pricingStrategy) {
        uberService = UberService.getInstance();
        farePriceService = FarePriceService.getInstance();
        eventRiderSubject = new EventRiderSubject();
        eventDriverSubject = new EventRiderSubject();
        this.pricingStrategy = pricingStrategy;
    }

    public void bookRide(Ride ride) {
        List<Driver> allowedDrivers = uberService.registeredDrivers.stream()
                .filter(driver -> allowedDriverForVehicleType(driver, ride)).toList();
        if (allowedDrivers.size() > 0) {
            System.out.println("there is the available drivers info ");
            farePriceService.showVehicleWithPrice(allowedDrivers, ride,pricingStrategy);
            allowedDrivers.forEach(driver -> eventRiderSubject.addObserver(driver));
            eventRiderSubject.notifyAllObservers("you got the new Ride notification");
        } else  {
            throw new IllegalArgumentException("There is no DRIVER available at the moment.");
        }
    }

    private boolean allowedDriverForVehicleType(Driver driver,Ride ride) {
        return ride.getCurrentLocation().toDistance(driver.getCurrentLocations()) <= MAX_DISTANCE
                && driver.isDriverAvailable()
                && ride.getVehicleType().equals(driver.getVehicle().getVehicleType());
    }

    public Driver acceptBooking(Ride ride, Rider rider) {
        Optional<Driver> targetDriver = uberService.registeredDrivers.stream()
                .filter(driver -> allowedDriverForVehicleType(driver, ride)).findFirst();
        if (targetDriver.isPresent()) {
            eventDriverSubject.addObserver(targetDriver.get());
            eventDriverSubject.notifyAllObservers("accepted the ride booking");
            uberService.driverIdToRideRegistry.put(targetDriver.get().getDriverId(), ride);
            System.out.println("OTP is generated as driver " + targetDriver.get().getName() + " has accepted the ride");
        } else {
            throw new RuntimeException("there is no driver found please wait we processing it.....");
        }
        return targetDriver.orElseThrow(() -> new RuntimeException("there is no driver available at the moment"));
    }

}
