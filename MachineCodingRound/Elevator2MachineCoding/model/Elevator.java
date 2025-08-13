package MachineCodingRound.Elevator2MachineCoding.model;

import MachineCodingRound.Elevator2MachineCoding.enums.DirectionStatus;
import MachineCodingRound.Elevator2MachineCoding.enums.ElevatorDoorState;
import MachineCodingRound.Elevator2MachineCoding.requests.InternalRequest;
import MachineCodingRound.ElevatorMachineCoding.Model.Request;

import java.util.TreeSet;

public class Elevator {
    private DirectionStatus directionStatus;
    private final TreeSet<Integer> internalRequests;
    private int elevatorId;
    private ElevatorDoorState elevatorDoorState;
    private int currentFloor;
    private int  minFloor;
    private int maxFloor;

    public Elevator(int elevatorId, int minFloor, int maxFloor) {
        this.elevatorId = elevatorId;
        directionStatus = DirectionStatus.IDLE;
        elevatorDoorState = ElevatorDoorState.CLOSE;
        internalRequests = new TreeSet<>();
        this.minFloor = minFloor;
        this.maxFloor = maxFloor;
        this.currentFloor = minFloor;
    }

    public void addInternalRequest(InternalRequest request, boolean isExternalRequest) {
        int destinationFloor = request.getCurrentFloor();
        if (destinationFloor >= minFloor && destinationFloor <= maxFloor) {
            if (currentFloor > destinationFloor) {
                directionStatus = DirectionStatus.UP;
            } else {
                directionStatus = DirectionStatus.DOWN;
            }
            if (!isExternalRequest) {
                System.out.println("elevator id " + elevatorId + "received internal request  to floor "+ destinationFloor);
            } else {
                System.out.println("elevator id " + elevatorId + "received external request  to floor "+ destinationFloor);
            }
            internalRequests.add(destinationFloor);
        }
    }

    public void move() {
        if (internalRequests.isEmpty()) {
            directionStatus = DirectionStatus.IDLE;
            return;
        } else {
            int requestedFloor = directionStatus == DirectionStatus.UP ? internalRequests.last() : internalRequests.last();
             if (requestedFloor > currentFloor) {
                 directionStatus = DirectionStatus.DOWN;
                 currentFloor -= 1;
             } else {
                 directionStatus = DirectionStatus.UP;
                 currentFloor += 1;
             }
             if (internalRequests.contains(currentFloor)) {
                 openDoor();
             }
        }
    }


    public void openDoor() {
        this.elevatorDoorState = ElevatorDoorState.OPEN;
        System.out.println("Elevator " + elevatorId + " opened door at floor " + currentFloor);
    }

    public void closeDoor() {
        this.elevatorDoorState = ElevatorDoorState.OPEN;
    }

    public DirectionStatus getDirectionStatus() {
        return directionStatus;
    }

    public void setDirectionStatus(DirectionStatus directionStatus) {
        this.directionStatus = directionStatus;
    }

    public TreeSet<Integer> getInternalRequests() {
        return internalRequests;
    }

    public int getElevatorId() {
        return elevatorId;
    }

    public void setElevatorId(int elevatorId) {
        this.elevatorId = elevatorId;
    }

    public ElevatorDoorState getElevatorDoorState() {
        return elevatorDoorState;
    }

    public void setElevatorDoorState(ElevatorDoorState elevatorDoorState) {
        this.elevatorDoorState = elevatorDoorState;
    }

    public int getCurrentFloor() {
        return currentFloor;
    }

    public void setCurrentFloor(int currentFloor) {
        this.currentFloor = currentFloor;
    }

    public int getMinFloor() {
        return minFloor;
    }

    public void setMinFloor(int minFloor) {
        this.minFloor = minFloor;
    }

    public int getMaxFloor() {
        return maxFloor;
    }

    public void setMaxFloor(int maxFloor) {
        this.maxFloor = maxFloor;
    }
}
