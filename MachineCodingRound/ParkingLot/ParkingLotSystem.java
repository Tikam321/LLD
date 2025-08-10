package MachineCodingRound.ParkingLot;

import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class ParkingLotSystem {
    private final ParkingLot parkingLot;
    private Map<String, Ticket> ticketRegistry;

    public ParkingLotSystem(ParkingLot parkingLot) {
        this.parkingLot = parkingLot;
        ticketRegistry = new HashMap<>();
    }

    public Ticket parkedVehicle(Vehicle vehicle) {
        Ticket ticket = null;
            for(ParkingFloor floor: parkingLot.getParkingFloors()) {
            for(ParkingSlot slot: floor.getParkingSlots()) {
                if (!slot.isParked() && slot.getVehicleType().equals(vehicle.getType())) {
                    String ticketId = parkingLot.getId() + "_" + floor.getFloorId() + "_" + slot.getSlotNumber();
                    slot.setVehicle(vehicle);
                    ticket = new Ticket(ticketId, vehicle, new Date(), slot);
                    ticketRegistry.put(ticketId, ticket);
                    return ticket;
                }
            }
        };
        System.out.println("the parking lot for vehicle is not Found.");
            return null;
    }

    public void unParkedVehicle(String ticketId) {
        Ticket ticket = ticketRegistry.get(ticketId);
        if (ticket == null) {
            System.out.println("invalid ticket");
            return;
        }

        ParkingSlot slot = ticket.getParkingSlot();
        Vehicle vehicle = ticket.getVehicle();
       if (slot == null || !slot.isParked()) {
           System.out.println("Invalid Ticket");
           return;
       }
       slot.setVehicle(null);
       ticketRegistry.remove(ticketId);
       System.out.println("Vehicle id "+ vehicle.getRegistrationNumber() + "is un parked from parking slot.");
    }

    public void printFreeSlotCountForEachFloor(VehicleType vehicleType) {
        for(ParkingFloor floor: parkingLot.getParkingFloors()) {
            long count = floor.getParkingSlots().stream().filter(slot -> !slot.isParked() &&
                    slot.getVehicleType().equals(vehicleType)).count();
            System.out.println("for floor " + floor.getFloorId() + " have " + count + " slots available.");
        }
    }

    public void printFreeSlotForEachFloor(VehicleType vehicleType) {
        for(ParkingFloor floor: parkingLot.getParkingFloors()) {
            String collect = floor.getParkingSlots().stream().filter(slot -> !slot.isParked() &&
                    slot.getVehicleType().equals(vehicleType)).map(slot -> String.valueOf(slot.getSlotNumber())).collect(Collectors.joining(" "));
            System.out.println("for floor " + floor.getFloorId() + "have " + collect + " is available.");
        }
    }

    public void displayOccupiedSlots(VehicleType vehicleType) {
        for(ParkingFloor floor: parkingLot.getParkingFloors()) {
            List<Integer> occupiedSlots = floor.getParkingSlots().stream().filter(slot -> slot.isParked() &&
                    vehicleType.equals(slot.getVehicleType())).map(ParkingSlot::getSlotNumber).toList();
            System.out.println("for floor " + floor.getFloorId() + "have " + occupiedSlots + " is occupied.");
            }
    }


}
