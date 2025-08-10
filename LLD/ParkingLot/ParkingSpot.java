package LLD.ParkingLot;

import LLD.ParkingLot.Vehicle.Vehicle;
import LLD.ParkingLot.Vehicle.VehicleType;

public class ParkingSpot {
    private Vehicle parkedVehicle;
    private int spotNumber;

    private VehicleType parkedVehicleType;


    public ParkingSpot(int spotNumber, VehicleType parkedVehicleType) {
        this.spotNumber = spotNumber;
        this.parkedVehicleType = parkedVehicleType;
    }

    public boolean isAvailable() {
        return this.parkedVehicle == null;
    }

    public void parkVehicle(Vehicle vehicle) {
        if (isAvailable() && parkedVehicleType.equals(vehicle.getVehicleType())) {
            this.parkedVehicle = vehicle;
        } else {
            throw new IllegalArgumentException("The vehicle is not allowed to park or there is no availability for this vehicle");
        }
    }

    public void unParkedVehicle() {
        this.parkedVehicle = null;
    }

    public Vehicle getParkedVehicle() {
        return parkedVehicle;
    }

    public void setParkedVehicle(Vehicle parkedVehicle) {
        this.parkedVehicle = parkedVehicle;
    }

    public int getSpotNumber() {
        return spotNumber;
    }

    public void setSpotNumber(int spotNumber) {
        this.spotNumber = spotNumber;
    }

    public VehicleType getParkedVehicleType() {
        return parkedVehicleType;
    }

    public void setParkedVehicleType(VehicleType parkedVehicleType) {
        this.parkedVehicleType = parkedVehicleType;
    }
}
