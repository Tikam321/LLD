package MachineCodingRound.UberMachineCoding;

import MachineCodingRound.UberMachineCoding.Model.*;
import MachineCodingRound.UberMachineCoding.Service.BookingRideService;
import MachineCodingRound.UberMachineCoding.Service.OtpService;
import MachineCodingRound.UberMachineCoding.Service.UberService;
import MachineCodingRound.UberMachineCoding.Strategy.PricingStrategy;
import MachineCodingRound.UberMachineCoding.Strategy.SurgePriceStrategy;
import MachineCodingRound.UberMachineCoding.enums.VehicleType;

public class uberServiceDemo {
    public static void main(String[] args) {
        UberService uberService = UberService.getInstance();
        OtpService otpService = OtpService.getInstance();
        // price strategy

        PricingStrategy surgePriceStrategy = new SurgePriceStrategy(2);

        BookingRideService bookingRideService = new BookingRideService(surgePriceStrategy);

        // Rider name
        Rider rider1 = new Rider("Rider1");
        Rider rider2 = new Rider("Rider2");

        // Vehicle name
        Vehicle go1 = new Vehicle(VehicleType.GO, 23);
        Vehicle sedan = new Vehicle(VehicleType.SEDAN, 45);

        // Driver
        Location driver1Location = new Location(1,1);
        Driver driver1 = new Driver("driver1",4.5,go1, driver1Location);

        Location driver2Location = new Location(1,2);
        Driver driver2 = new Driver("driver2",4.9,sedan, driver2Location);

        // add driver to uber service
        uberService.addDriver(driver1);
        uberService.addDriver(driver2);

        // add  rider to uber service
        uberService.addRider(rider1);
        uberService.addRider(rider2);

        // step:1 book ride by rider1
        Location currentLoc = new Location(0,0);
        Location destLoc = new Location(5,6);
        Ride ride = new Ride("123",currentLoc, destLoc,VehicleType.SEDAN);

        // book ride
        bookingRideService.bookRide(ride);
        Driver driver = null;

        // step2: driver accepted the ride
        Booking booking = null;
        try{
            booking = bookingRideService.acceptBooking(ride, rider1);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        int otp = booking.getOtp();
        System.out.println(otp);
        // step3: now rider1 provides the otp to driver2
        try{
            otpService.confirmOtp(booking);
        } catch (Exception e) {
            System.out.println(e.getMessage());
        }

        // step4: ending the ride
        uberService.endRide(booking);
    }
}
