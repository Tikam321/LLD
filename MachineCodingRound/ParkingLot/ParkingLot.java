package MachineCodingRound.ParkingLot;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

public class ParkingLot {

    private String id;
    private int floorSize;
    private int parkingSlotSize;
    private final List<ParkingFloor> parkingFloors = new ArrayList<>();

    public ParkingLot(String id, int floorSize, int parkingSlotSize) {
        this.id = id;
        this.floorSize = floorSize;
        this.parkingSlotSize = parkingSlotSize;
        for(int i=0; i< floorSize; i++) {
            parkingFloors.add(new ParkingFloor(i+1,parkingSlotSize));
        }
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public List<ParkingFloor> getParkingFloors() {
        return parkingFloors;
    }

    public int getFloorSize() {
        return floorSize;
    }

    public void setFloorSize(int floorSize) {
        this.floorSize = floorSize;
    }

    public int getParkingSlotSize() {
        return parkingSlotSize;
    }

    public void setParkingSlotSize(int parkingSlotSize) {
        this.parkingSlotSize = parkingSlotSize;
    }

//    public Ticket parkedVehicle(Vehicle vehicle) {
//        for(ParkingFloor floor: getParkingFloors()) {
//            for(ParkingSlot slot: floor.getParkingSlots()) {
//                if (!slot.isParked() && slot.getVehicleType().equals(vehicle.getType())) {
//                    String ticketId = getId() + " " + floor.getFloorId() + " " + slot.getSlotNumber();
//                    return new Ticket(ticketId, vehicle, new Date(), slot);
//                }
//            }
//        };
//        System.out.println("the parking lot for ");
//        return null;
//    }
//
//    public void unParkedVehicle(Ticket ticket) {
//        ParkingSlot slot = ticket.getParkingSlot();
//        if (slot.isParked()) {
//            slot.setVehicle(null);
//            System.out.println("Vehicle id "+ slot.getVehicle().getRegistrationNumber() + "is un parked from parking slot.");
//        } else {
//            System.out.println("vehicle is already is unParked already");
//        }
//    }
//
//    public void printFreeSlotCountForEachFloor(VehicleType vehicleType) {
//        for(ParkingFloor floor: getParkingFloors()) {
//            int count = 0;
//            for(ParkingSlot slot: floor.getParkingSlots()) {
//                if (slot.getVehicleType().equals(vehicleType) && !slot.isParked()) {
//                    count++;
//                }
//            }
//            System.out.println("for floor " + floor.getFloorId() + " have " + count + " slots available.");
//        }
//    }
//
//    public void printFreeSlotForEachFloor(VehicleType vehicleType) {
//        for(ParkingFloor floor: getParkingFloors()) {
//            for(ParkingSlot slot: floor.getParkingSlots()) {
//                if (slot.getVehicleType().equals(vehicleType) && !slot.isParked()) {
//                    System.out.println("for floor " + floor.getFloorId() + "have " + slot.getSlotNumber() + " is available.");
//                }
//            }
//        }
//    }
//
//    public void displayOccupiedSlots(VehicleType vehicleType) {
//        for(ParkingFloor floor: getParkingFloors()) {
//            for(ParkingSlot slot: floor.getParkingSlots()) {
//                if (slot.getVehicleType().equals(vehicleType) && slot.isParked()) {
//                    System.out.println("for floor " + floor.getFloorId() + "have " + slot.getSlotNumber() + " is occupied.");
//                }
//            }
//        }
//    }
}
