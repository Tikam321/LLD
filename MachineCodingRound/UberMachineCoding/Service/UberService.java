package MachineCodingRound.UberMachineCoding.Service;

import MachineCodingRound.UberMachineCoding.Model.Booking;
import MachineCodingRound.UberMachineCoding.Model.Driver;
import MachineCodingRound.UberMachineCoding.Model.Ride;
import MachineCodingRound.UberMachineCoding.Model.Rider;
import MachineCodingRound.UberMachineCoding.enums.BookingStatus;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class UberService {
     List<Driver> registeredDrivers;
     List<Rider> registeredRiderRegistry;
     Map<String, Ride> driverIdToRideRegistry;
     Map<Rider, Ride> riderToRideMap;
     public static final double MAX_DISTANCE = 5;
     public static UberService instance;


     private UberService() {
          this.registeredDrivers = new ArrayList<>();
          this.registeredRiderRegistry = new ArrayList<>();
          this.driverIdToRideRegistry = new HashMap<>();
          this.riderToRideMap = new HashMap<>();
     }

     public static synchronized UberService getInstance()  {
          if (instance != null) {
               return instance;
          }
          return instance = new UberService();
     }
     public void addDriver(Driver driver) {
          registeredDrivers.add(driver);
     }

     public void addRider(Rider rider) {
          registeredRiderRegistry.add(rider);
     }

     public void endRide(Booking booking) {
          if (booking != null) {
               booking.updateStatus(BookingStatus.ENDED);
               booking.getDriver().endRide();
               System.out.println("the ride id" + booking.getBookingId() + " has ended thank you choosing us.");

          } else {
               throw new IllegalArgumentException("there is no ride exist for Driver");
          }
     }
}
