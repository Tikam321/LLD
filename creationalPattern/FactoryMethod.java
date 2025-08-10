
interface Vehicle {
    void drive();

}

class Car implements Vehicle {
    @Override
    public void drive() {
        System.out.println("Driving the car");
    }
}


class Bike implements  Vehicle {

    @Override
    public void drive() {
        System.out.println("Driving the Bike.");
    }
}
class VehicleFactory {
    public static Vehicle getVehicle(String vehicleType) {
        if (vehicleType.equals("Car")) {
            return new Car();
        } else {
            return new Bike();
        }
    }
}

class FactoryMethod {
    public static void main(String[] args) {
        VehicleFactory vehicleFactory = new VehicleFactory();
        Vehicle car = VehicleFactory.getVehicle("Car");
        car.drive();
        Vehicle bike = VehicleFactory.getVehicle("Bike");
        bike.drive();
    }
}

