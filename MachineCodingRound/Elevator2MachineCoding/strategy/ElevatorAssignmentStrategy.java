package MachineCodingRound.Elevator2MachineCoding.strategy;

import MachineCodingRound.Elevator2MachineCoding.model.Elevator;
import MachineCodingRound.Elevator2MachineCoding.requests.ExternalRequest;

import java.util.List;

public interface ElevatorAssignmentStrategy {
    public void assignElevator(List<Elevator> elevators, ExternalRequest externalRequest);
}
