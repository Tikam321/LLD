package MachineCodingRound.ParkingLot;

import java.util.ArrayList;
import java.util.List;

public class ParkingFloor {
    private int floorId;
    private final List<ParkingSlot> parkingSlots = new ArrayList<>();

    private int parkingSlotSize;

    public ParkingFloor(int floorId, int parkingSlotSize) {
        this.floorId = floorId;
        this.parkingSlotSize = parkingSlotSize;
        for(int i=0;i<parkingSlotSize;i++) {
            if (i == 0) {
                parkingSlots.add(new ParkingSlot(i+1,VehicleType.TRUCK));
            } else if (i<=2) {
                parkingSlots.add(new ParkingSlot(i+1,VehicleType.BIKE));
            } else {
                parkingSlots.add(new ParkingSlot(i+1,VehicleType.CAR));
            }
        }
    }

    public int getFloorId() {
        return floorId;
    }

    public void setFloorId(int floorId) {
        this.floorId = floorId;
    }

    public List<ParkingSlot> getParkingSlots() {
        return parkingSlots;
    }

    public int getParkingSlotSize() {
        return parkingSlotSize;
    }

    public void setParkingSlotSize(int parkingSlotSize) {
        this.parkingSlotSize = parkingSlotSize;
    }
}
