package MachineCodingRound.UberMachineCoding.Model;

import MachineCodingRound.UberMachineCoding.enums.VehicleType;

public class Ride {
    private String rideId;
    private Location currentLocation;
    private Location destinationLocation;
    private VehicleType vehicleType;

    public Ride(String rideId, Location currentLocation, Location destinationLocation, VehicleType vehicleType) {
        this.currentLocation = currentLocation;
        this.destinationLocation = destinationLocation;
        this.vehicleType = vehicleType;
        this.rideId = rideId;
    }

    public String getRideId() {
        return rideId;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setRideId(String rideId) {
        this.rideId = rideId;
    }

    public Location getCurrentLocation() {
        return currentLocation;
    }

    public void setCurrentLocation(Location currentLocation) {
        this.currentLocation = currentLocation;
    }

    public Location getDestinationLocation() {
        return destinationLocation;
    }

    public void setDestinationLocation(Location destinationLocation) {
        this.destinationLocation = destinationLocation;
    }


    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }
}
