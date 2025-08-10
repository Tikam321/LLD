package MachineCodingRound.RideSharingApp;


import MachineCodingRound.RideSharingApp.VehicleUtility.Vehicle;

public class Ride {
    private User user;
    private String destination;
    private String origin;
    private boolean hasRideEnded;
    private Vehicle vehicle;
    private String rideId;
    private boolean isRideBooked;
    private int availableSeats;

    public Ride(User user,String origin, String destination,
                Vehicle vehicle, String rideId,int availableSeats) {
        this.user = user;
        this.origin = origin;
        this.destination = destination;
        this.hasRideEnded = true;
        this.vehicle = vehicle;
        this.rideId = rideId;
        this.isRideBooked = false;
        this.availableSeats = availableSeats;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public void endRide() {
        this.hasRideEnded = false;
    }

    public boolean getRideStatus() {
        return this.hasRideEnded;
    }

    public String getOrigin() {
        return origin;
    }

    public void setOrigin(String origin) {
        this.origin = origin;
    }

    public String getDestination() {
        return destination;
    }

    public void setDestination(String destination) {
        this.destination = destination;
    }

    public String getRideId() {
        return rideId;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public boolean isHasRideEnded() {
        return hasRideEnded;
    }

    public void setHasRideEnded(boolean hasRideEnded) {
        this.hasRideEnded = hasRideEnded;
    }

    public boolean isRideBooked() {
        return isRideBooked;
    }

    public void setRideBooked(boolean rideBooked) {
        isRideBooked = rideBooked;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
}

