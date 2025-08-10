package LLD.ParkingLot;

import LLD.ParkingLot.Vehicle.Vehicle;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class ParkingLot {
    private List<Level> levels;

    private static ParkingLot instance;

    private ParkingLot() {
        this.levels = new ArrayList<>();
    }

    public static synchronized ParkingLot getInstance() {
        if (instance ==  null) {
            return new ParkingLot();
        }
        return instance;
    }

    public void addLevel(Level level) {
        levels.add(level);
    }

    public Ticket parkedVehicle(Vehicle vehicle) {
        for(Level level: levels) {
            Ticket ticket = level.parkedVehicle(vehicle);
            if ( ticket!= null) {
                System.out.println("Vehicle parked successfully");
                return  ticket;
            }
        }
        System.out.println("vehicle cannot parked at this instance");
        return null;
    }
    public boolean unParkedVehicle(Vehicle vehicle, int hourStayed, Scanner scanner) {
        for( Level level: levels) {
            if (level.unParkedVehicle(vehicle, hourStayed, scanner)) {
                System.out.println("The vehicle having plateNumber "+ vehicle.getPlateNumber() + " is successfully exit the parking lot.");
                return true;
            }
        }
        System.out.println("the parking lot is already vacant");
        return false;
    }

    public void displayAvailability() {
        for( Level level: levels) {
           level.showAvailability();
        }
    }


}
