package MachineCodingRound.Elevator2MachineCoding.requests;

import MachineCodingRound.Elevator2MachineCoding.enums.DirectionStatus;

public class ExternalRequest extends ElevatorRequest{
    private DirectionStatus directionStatus;
    public ExternalRequest(int currentFloor, DirectionStatus directionStatus) {
        super(currentFloor);
        this.directionStatus = directionStatus;
    }

    public DirectionStatus getDirectionStatus() {
        return directionStatus;
    }

    public void setDirectionStatus(DirectionStatus directionStatus) {
        this.directionStatus = directionStatus;
    }


}
