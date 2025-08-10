package MachineCodingRound.ParkingLot;

import java.util.Date;

public class Ticket {
    private String ticketId;
    private Vehicle vehicle;

    private ParkingSlot parkingSlot;
    private Date checkedInTime;

    public Ticket(String ticketId, Vehicle vehicle, Date checkedInTime, ParkingSlot parkingSlot) {
        this.ticketId = ticketId;
        this.vehicle = vehicle;
        this.checkedInTime = checkedInTime;
        this.parkingSlot = parkingSlot;
    }

    public String getTicketId() {
        return ticketId;
    }

    public void setTicketId(String ticketId) {
        this.ticketId = ticketId;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }

    public Date getCheckedInTime() {
        return checkedInTime;
    }

    public void setCheckedInTime(Date checkedInTime) {
        this.checkedInTime = checkedInTime;
    }

    public ParkingSlot getParkingSlot() {
        return parkingSlot;
    }

    public void setParkingSlot(ParkingSlot parkingSlot) {
        this.parkingSlot = parkingSlot;
    }
}
