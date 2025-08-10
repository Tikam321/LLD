package MachineCodingRound.UberMachineCoding.Service;

import MachineCodingRound.UberMachineCoding.Model.Driver;
import MachineCodingRound.UberMachineCoding.Model.Ride;
import MachineCodingRound.UberMachineCoding.Model.Rider;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;
import java.util.Scanner;

public class OtpService {
    Map<Rider, Integer> riderToOtpMap;
    private final Scanner scanner = new Scanner(System.in);
    public static OtpService instance;

    private OtpService() {
        this.riderToOtpMap = new HashMap<>();

    }

    public static synchronized OtpService getInstance() {
        if (instance != null) {
            return instance;
        }
        return instance = new OtpService();
    }


    private Integer generateRideOtp() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

    public Integer generateOtpService(Rider rider) {
        Integer generateOtp = generateRideOtp();
        riderToOtpMap.put(rider, generateOtp);
        return generateOtp;
    }


    public void confirmOtp(Driver driver, Rider rider ){
        int count = 1;
        while(count <= 3) {
            System.out.println("Enter the otp : count " + count);
            int requestedOtp = scanner.nextInt();
            scanner.nextLine();
            if (requestedOtp == generateOtpService(rider)) {
                System.out.println("otp is confirmed and Ride is confirmed and thank you for choosing us.");
                driver.setDriverIsOccupied();
                return ;
            }
            count++;
        }
        throw new RuntimeException("you have exceeds all the chances please the ride is cancelled fpor safety purpose.");
    }
}
