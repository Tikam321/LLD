package MachineCodingRound.RideSharingApp;


import MachineCodingRound.RideSharingApp.VehicleUtility.VehicleType;

import java.util.*;

public class AutoShareRide {
    private HashMap<User, List<String>> userVehicleRegistry;
    private HashMap<User, Ride> rideDetails;
    private HashMap<User, RideStatus> rideStatusMap;


    public AutoShareRide() {
        this.userVehicleRegistry = new HashMap<>();
        this.rideDetails = new HashMap<>();
        this.rideStatusMap = new HashMap<>();
    }

    public void addUserWithVehicle(User user,  String vehicleId) {
        List<String> vehicleIds = userVehicleRegistry.computeIfAbsent(user, k -> new ArrayList<>());
        if (!vehicleIds.contains(vehicleId)) {
            vehicleIds.add(vehicleId);
        } else {
            throw new IllegalArgumentException("the vehicle is already registered with the given user");
        }
    }

    public void offer_ride(User user,Ride ride) {
        if(rideDetails.values().stream().anyMatch(x -> x.getVehicle().getNumberPLate().equals(ride.getVehicle().getNumberPLate()))) {
            throw  new IllegalArgumentException("Ride is already offered  by the user for this vehicle");
        } else {
            rideDetails.put(user,ride);
            RideStatus rideStatus = rideStatusMap.computeIfAbsent(ride.getUser(), k -> new RideStatus());
            rideStatus.updateRideOffered();
        }
    }

    public void selectRideByVehicle(String origin, String destination, int seats, VehicleType vehicleType, User user) {
        Optional<Ride> availableRide = rideDetails.values().stream().filter(ride -> ride.getVehicle().getVehicleType().equals(vehicleType)
                && ride.getOrigin().equals(origin) &&
                ride.getDestination().equals(destination) && ride.getVehicle().getAvailableSeats() >= seats).findFirst();
        if (availableRide.isPresent()) {
            Ride ride = availableRide.get();
            RideStatus rideStatus = rideStatusMap.computeIfAbsent(user, k -> new RideStatus());
            rideStatus.updateRideTaken();
            System.out.println("the vehicle id "+ ride.getRideId() + " is Booked");
            ride.setRideBooked(true);
        } else {
            System.out.println("the requested ride is not found currently please wait.");
//            throw new IllegalArgumentException("the requested ride is not found currently please wait.");
        }
    }

    public void selectRideByMostVacantSeats(String origin, String destination, int seats,User user) {
        Optional<Ride> availableRide = rideDetails.values().stream().filter(ride -> ride.getOrigin().equals(origin) &&
                        ride.getDestination().equals(destination) && ride.getVehicle().getAvailableSeats() >= seats)
                .sorted((x,y) -> Integer.compare(y.getVehicle().getAvailableSeats(), x.getVehicle().getAvailableSeats())).findFirst();
        if (availableRide.isPresent()) {
            Ride ride = availableRide.get();
            RideStatus rideStatus = rideStatusMap.computeIfAbsent(user, k -> new RideStatus());
            rideStatus.updateRideTaken();
            ride.setRideBooked(true);
            System.out.println("the ride by most vacant seats is booked with available seat "+ ride.getVehicle().getAvailableSeats());
        } else {
            System.out.println("ride is already is stopped.");
//            throw new IllegalArgumentException("ride is already is stopped.");
        }
    }

    public void stopRide() {
        rideDetails.values().stream().filter(ride -> ride.isRideBooked()).forEach(ride -> ride.endRide());
        System.out.println("all the rides has ended.");
    }

    public void print_ride_Stats() {
        for(Map.Entry<User,RideStatus> mp: rideStatusMap.entrySet()) {
            System.out.println(mp.getKey().getName() + " has taken " + mp.getValue().getRideTaken() + " and offered " + mp.getValue().getRideOffered());
        }
    }
}
