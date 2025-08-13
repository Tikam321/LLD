package MachineCodingRound.Elevator2MachineCoding.requests;

public abstract class ElevatorRequest {
    protected int currentFloor;

    public ElevatorRequest(int currentFloor) {
        this.currentFloor = currentFloor;
        }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }
}
