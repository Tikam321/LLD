package LLD.ParkingLot;

import LLD.ParkingLot.Payment.PaymentService;
import LLD.ParkingLot.Vehicle.Vehicle;
import LLD.ParkingLot.Vehicle.VehicleType;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Level {
    private final int floors;
    private List<ParkingSpot> parkingSpots;

    public Level(int floors, int size) {
        this.floors = floors;
        this.parkingSpots = new ArrayList<>();
        // as we are assigning the 40% spot for the bike 40% for the car and 20 % for truck\
        int carSpot = (int) (.4 * size);
        int bikeSpot = (int) (.4 * size);

        for (int i = 1; i< carSpot;i++) {
            this.parkingSpots.add(new ParkingSpot(i, VehicleType.CAR));
        }
        for (int i = 1; i< bikeSpot;i++) {
            this.parkingSpots.add(new ParkingSpot(i, VehicleType.MOTORCYCLE));
        }
        for (int i = 1; i< size - (bikeSpot + carSpot);i++) {
            this.parkingSpots.add(new ParkingSpot(i, VehicleType.TRUCK));
        }
    }

    public Ticket parkedVehicle(Vehicle vehicle) {
        for(ParkingSpot spot: this.parkingSpots) {
            if (spot.isAvailable() && spot.getParkedVehicleType().equals(vehicle.getVehicleType())) {
                spot.parkVehicle(vehicle);
                return new Ticket(spot, vehicle);
            }
        }
        return null;
    }

    public boolean unParkedVehicle(Vehicle vehicle, int hoursStayed, Scanner scanner) {
        for(ParkingSpot spot: this.parkingSpots) {
            if (!spot.isAvailable() && spot.getParkedVehicle().equals(vehicle)) {

                // amount calculation
                double amountToBePaid = vehicle.calculateBill(hoursStayed);

                // processing the payment
                PaymentService paymentService = new PaymentService(scanner);
                paymentService.processPayment(amountToBePaid);

                // vacant the vehicle from parking spot
                 spot.unParkedVehicle();
                System.out.println(spot.getParkedVehicle());
                return true;
            }
        }
        return false;
    }

    public void showAvailability() {
        System.out.println("Level " + floors + " Availability shown below");
        for(ParkingSpot spot: this.parkingSpots) {
            if (!spot.isAvailable()) {
                System.out.println(spot.getParkedVehicle().getPlateNumber());
            }
            System.out.println("Spot number is " +spot.getSpotNumber() +  (spot.isAvailable() ? " Available" : " Unavailable") + " for VehicleType" + spot.getParkedVehicleType());
        }
    }
}
