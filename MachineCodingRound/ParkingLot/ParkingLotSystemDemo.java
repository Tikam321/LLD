package MachineCodingRound.ParkingLot;

public class ParkingLotSystemDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = new ParkingLot("123R",3, 6);
        ParkingLotSystem parkingLotSystem = new ParkingLotSystem(parkingLot);

        Vehicle mahindraX700 = new Vehicle(VehicleType.CAR, "MH-123R","Red");
        Vehicle kiaSeltos = new Vehicle(VehicleType.CAR, "RJ-RE54", "White");
        Vehicle tataTruck = new Vehicle(VehicleType.TRUCK, "MP-234R", "Blue");


//        parkingLotSystem.displayOccupiedSlots(VehicleType.CAR);
        Ticket ticket1 = parkingLotSystem.parkedVehicle(mahindraX700);

        Ticket ticket2 = parkingLotSystem.parkedVehicle(tataTruck);
        Ticket ticket3 = parkingLotSystem.parkedVehicle(kiaSeltos);
        parkingLotSystem.displayOccupiedSlots(VehicleType.CAR);

//        System.out.println("after unparking the mahindara car then count for free slot available");
//        parkingLotSystem.parkedVehicle(tataTruck);
//
//        parkingLotSystem.printFreeSlotCountForEachFloor(VehicleType.CAR);

    }
}
