package LLD.LibraryManagementSystem;

public class Shelf {
    private int rackNumber;
    private int locationId;

    public Shelf(int rackNumber, int locationId) {
        this.rackNumber = rackNumber;
        this.locationId = locationId;
    }

    public int getRackNumber() {
        return rackNumber;
    }

    public void setRackNumber(int rackNumber) {
        this.rackNumber = rackNumber;
    }

    public int getLocationId() {
        return locationId;
    }

    public void setLocationId(int locationId) {
        this.locationId = locationId;
    }
}
