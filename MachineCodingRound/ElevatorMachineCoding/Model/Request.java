package MachineCodingRound.ElevatorMachineCoding.Model;

import MachineCodingRound.ElevatorMachineCoding.enums.MoveStatus;

public class Request {
    private int currentFloor;
    private int destinationFloor;

    public Request(MoveStatus moveStatus, int currentFloor, int destinationFloor) {
        this.currentFloor = currentFloor;
        this.destinationFloor = destinationFloor;
    }

    public boolean isMovingUp() {
        return this.currentFloor < this.destinationFloor;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getDestinationFloor() {
        return destinationFloor;
    }

    public void setDestinationFloor(int destinationFloor) {
        this.destinationFloor = destinationFloor;
    }
}
