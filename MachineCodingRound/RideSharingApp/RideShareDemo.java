package MachineCodingRound.RideSharingApp;


import MachineCodingRound.RideSharingApp.VehicleUtility.Vehicle;
import MachineCodingRound.RideSharingApp.VehicleUtility.VehicleType;


public class RideShareDemo {
    public static void main(String[] args) {
        AutoShareRide autoShareRide = new AutoShareRide();

        User rohan = new User("rohan", "user-1");
        User shashank = new User( "shashank", "user-2");
        User nandini = new User("nandini", "user-3");
        User shipra = new User( "shipra","user-4");
        User gaurav = new User("gaurav","user-5");
        User rahul = new User("rahul","user-6");

        //vehicle details
        Vehicle swift = new Vehicle("swift","KA-01-12345", VehicleType.SWIFT,4);
        Vehicle polo = new Vehicle("polo","RJ-346",VehicleType.POLO,4);
        Vehicle xuv = new Vehicle("XUV700","KA-05-1234",VehicleType.XUV,6);
        Vehicle activa = new Vehicle("activa","KA-12-12332",VehicleType.ACTIVA,1);
        Vehicle baleno = new Vehicle("baleno","TS-05-62395",VehicleType.BALENO,3);

        // registreng the vehicle with users
        autoShareRide.addUserWithVehicle(rohan, swift.getNumberPLate());
        autoShareRide.addUserWithVehicle(shashank, baleno.getNumberPLate());
        autoShareRide.addUserWithVehicle(shipra,polo.getNumberPLate());
        autoShareRide.addUserWithVehicle(shipra,activa.getNumberPLate());
        autoShareRide.addUserWithVehicle(rahul,xuv.getNumberPLate());

        Ride ride1 = new Ride( rohan, "hyderabad","bangalore",swift,"ride-1",1);
        Ride ride2 = new Ride( shipra, "bangalore","mysore",activa,"ride-2",1);
        Ride ride3 = new Ride( shipra, "bangalore","mysore",polo,"ride3",2);
        Ride ride4 = new Ride( shashank, "hyderabad","bangalore",baleno,"ride-4",2);
        Ride ride5 = new Ride( rahul, "hyderabad","bangalore",xuv,"ride-5",5);
        Ride ride6 = new Ride( rohan, "bangalore","pune",swift,"ride-6",1);


        autoShareRide.offer_ride(rohan,ride1);
        autoShareRide.offer_ride(shipra,ride2);
        autoShareRide.offer_ride(shipra,ride3);
        autoShareRide.offer_ride(shashank,ride4);
        autoShareRide.offer_ride(rahul,ride5);
//            autoShareRide.offer_ride(rohan,ride6);

        autoShareRide.selectRideByMostVacantSeats("bangalore","mysore",1,nandini);
        autoShareRide.selectRideByVehicle("bangalore","mysore",1,VehicleType.ACTIVA,gaurav);
        autoShareRide.selectRideByMostVacantSeats("mumbai","bangalore",1,shashank);
        autoShareRide.selectRideByVehicle("hyderabad","bangalore",1,VehicleType.BALENO,rohan);
        autoShareRide.selectRideByVehicle("hyderabad","bangalore",1,VehicleType.POLO,shashank);

        autoShareRide.stopRide();

        autoShareRide.print_ride_Stats();


    }
}
