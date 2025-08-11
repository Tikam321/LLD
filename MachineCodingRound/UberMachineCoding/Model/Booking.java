package MachineCodingRound.UberMachineCoding.Model;

import MachineCodingRound.UberMachineCoding.enums.BookingStatus;

import java.util.Date;
import java.util.Random;
import java.util.UUID;

public class Booking {
    private String bookingId;
    private Rider  rider;
    private Date startTimeStamp;
    private int otp;
    private Driver driver;
    private BookingStatus status;

    public Booking(Rider rider, Date startTimeStamp, Driver driver) {
        this.bookingId = UUID.randomUUID().toString();
        this.rider = rider;
        this.startTimeStamp = startTimeStamp;
        this.otp = generateRideOtp();
        this.driver = driver;
        this.status = BookingStatus.CREATED;
        this.bookingId = UUID.randomUUID().toString();
    }

    private Integer generateRideOtp() {
        Random random = new Random();
        return 1000 + random.nextInt(9000);
    }

    public void updateStatus(BookingStatus bookingStatus) {
        this.status = bookingStatus;
    }

    public String getBookingId() {
        return bookingId;
    }

    public void setBookingId(String bookingId) {
        this.bookingId = bookingId;
    }

    public Rider getRider() {
        return rider;
    }

    public void setRider(Rider rider) {
        this.rider = rider;
    }

    public Date getStartTimeStamp() {
        return startTimeStamp;
    }

    public void setStartTimeStamp(Date startTimeStamp) {
        this.startTimeStamp = startTimeStamp;
    }

    public int getOtp() {
        return otp;
    }

    public void setOtp(int otp) {
        this.otp = otp;
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public BookingStatus getStatus() {
        return status;
    }

    public void setStatus(BookingStatus status) {
        this.status = status;
    }

}
