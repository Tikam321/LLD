package MachineCodingRound.ElevatorMachineCoding.Model;

import MachineCodingRound.ElevatorMachineCoding.enums.DirectionStatus;
import MachineCodingRound.ElevatorMachineCoding.strategy.ElevatorAlgorithmStrategy;

import java.util.UUID;

public class Elevator {

    private String elevatorId;
    private int currentFloor;
    private boolean isDoorOpen;
    private DirectionStatus elevatorStatus;

    private ElevatorAlgorithmStrategy elevatorAlgorithmStrategy;

    public Elevator(int currentFloor, boolean isDoorOpen, ElevatorAlgorithmStrategy elevatorAlgorithmStrategy) {
        elevatorId = UUID.randomUUID().toString();
        this.currentFloor = currentFloor;
        this.isDoorOpen = isDoorOpen;
        this.elevatorStatus = DirectionStatus.IDLE;
        this.elevatorAlgorithmStrategy = elevatorAlgorithmStrategy;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public boolean isDoorOpen() {
        return isDoorOpen;
    }

    public void setDoorOpen(boolean doorOpen) {
        isDoorOpen = doorOpen;
    }

    public DirectionStatus getElevatorStatus() {
        return elevatorStatus;
    }

    public void setElevatorStatus(DirectionStatus elevatorStatus) {
        this.elevatorStatus = elevatorStatus;
    }

    public void closeDoor() {
        this.isDoorOpen = false;
    }

    public void openDoor() {
        this.isDoorOpen = true;
    }

    public String getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(String elevatorId) {
        this.elevatorId = elevatorId;
    }

    public void addPassengerRequest(Request request) {

        elevatorAlgorithmStrategy.addRequest(request, this);
    }
//    public void  moveElevator() {
//        elevatorAlgorithmStrategy.processCurrentRequest(this);
//        if (elevatorStatus == DirectionStatus.IDLE) {
//            if (currentFloor < request.getCurrentFloor()) {
//                elevatorStatus = DirectionStatus.UP;
//                System.out.println("elevator id" + elevatorId + " reach to " + request.getCurrentFloor());
//
//            }
//        }
//        if (request.isMovingUp()) {
//            this.currentFloor = e
//        }
//        if (elevatorStatus == DirectionStatus.IDLE) {
//
//        }
//    }
}
