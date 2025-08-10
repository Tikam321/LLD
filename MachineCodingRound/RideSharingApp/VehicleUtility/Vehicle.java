package MachineCodingRound.RideSharingApp.VehicleUtility;


public class Vehicle {
    private String name;
    private VehicleType vehicleType;
    private String numberPLate;
    private int availableSeats;
    private boolean isRunning;


    public Vehicle(String name, String numberPLate, VehicleType vehicleType,int seats) {
        this.name = name;
        this.numberPLate = numberPLate;
        this.vehicleType = vehicleType;
        this.availableSeats = seats;
        this.isRunning = false;
    }

    public VehicleType getVehicleType() {
        return vehicleType;
    }

    public void setVehicleType(VehicleType vehicleType) {
        this.vehicleType = vehicleType;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNumberPLate() {
        return numberPLate;
    }

    public void setNumberPLate(String numberPLate) {
        this.numberPLate = numberPLate;
    }

    public int getAvailableSeats() {
        return availableSeats;
    }

    public void setAvailableSeats(int availableSeats) {
        this.availableSeats = availableSeats;
    }
    public void startRide() {
        this.isRunning = true;
    }
    public void endRide() {
        this.isRunning = false;
    }
}

