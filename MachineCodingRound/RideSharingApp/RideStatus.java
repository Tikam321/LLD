package MachineCodingRound.RideSharingApp;

public class RideStatus {
    private int  rideTaken;
    private int rideOffered;

    public RideStatus() {
        rideTaken = 0;
        rideOffered = 0;
    }

    public int getRideTaken() {
        return rideTaken;
    }

    public void updateRideTaken() {
        rideTaken  += 1;
    }

    public int getRideOffered() {
        return rideOffered;
    }

    public void updateRideOffered() {
        this.rideOffered += 1;
    }
}

