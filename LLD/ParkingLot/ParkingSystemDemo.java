package LLD.ParkingLot;

import LLD.ParkingLot.Vehicle.Car;
import LLD.ParkingLot.Vehicle.MotorCycle;
import LLD.ParkingLot.Vehicle.Truck;

import java.util.Scanner;

public class ParkingSystemDemo {
    public static void main(String[] args) {
        ParkingLot parkingLot = ParkingLot.getInstance();
        Scanner scanner = new Scanner(System.in);
        Level level1 = new Level(1,8);
        Level level2 = new Level(2, 10);

        //adding level to parkinglot
        parkingLot.addLevel(level1);
//        parkingLot.addLevel(level2);

        Car tataHarrier = new Car("MH-1234");
        Car tiago = new Car("MH-D2F4");
        Car nexon = new Car("MH-SD23");
        MotorCycle motorCycle = new MotorCycle("RJ-4HSDF");
        Truck tataTruck = new Truck("UK-ASD34");
        Truck tataTruck1 = new Truck("UK-AS2334");
        Truck tataTruck2 = new Truck("UK-AW34WE");


//        parkingLot.displayAvailability();

        // adding the cars
        // using this ticket you can get the start time and from unparked() you get he exit time and we can calcualte the the time duraton and calculate the amount to be paid
        Ticket ticket1 = parkingLot.parkedVehicle(tataHarrier);
//        parkingLot.parkedVehicle(tiago);
//        parkingLot.parkedVehicle(nexon);

        // adding the motorcycles
//        parkingLot.parkedVehicle(motorCycle);

        // adding th truck
//        parkingLot.parkedVehicle(tataTruck);
//        parkingLot.parkedVehicle(tataTruck1);
//        parkingLot.parkedVehicle(tataTruck2);

        // unparked the vehicle
        parkingLot.displayAvailability();

        parkingLot.unParkedVehicle(tataHarrier, 15, scanner);
        parkingLot.displayAvailability();

        // you will get error as the vehicle is already vacant
        parkingLot.unParkedVehicle(tataHarrier, 15, scanner);

        scanner.close();




    }
}
