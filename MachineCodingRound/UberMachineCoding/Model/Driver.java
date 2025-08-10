package MachineCodingRound.UberMachineCoding.Model;

import java.util.UUID;

public class Driver {
    private String driverId;
    private String name;
    private double rating;
    private String message;
    private Vehicle vehicle;

    private Location currentLocations;
    private boolean isDriverAvailable;
    public Driver( String name, double rating, Vehicle vehicle, Location currentLocation) {
        this.driverId = UUID.randomUUID().toString();
        this.name = name;
        this.rating = rating;
        this.vehicle = vehicle;
        this.currentLocations = currentLocation;
        this.isDriverAvailable = true;
    }

    public boolean isDriverAvailable() {
        return isDriverAvailable;
    }

    public void setDriverIsOccupied() {
        this.isDriverAvailable = false;
    }

    public void endRide() {
        this.isDriverAvailable = true;
    }

//    @Override
//    public void getNotification(Ride ride) {
//        System.out.println("you got notifications from " +  + " for " + ride.getDestinationLocation());
//    }

    public String getDriverId() {
        return driverId;
    }

    public void setDriverId(String driverId) {
        this.driverId = driverId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    public double getRating() {
        return rating;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Location getCurrentLocations() {
        return currentLocations;
    }

    public void setCurrentLocations(Location currentLocations) {
        this.currentLocations = currentLocations;
    }
}
