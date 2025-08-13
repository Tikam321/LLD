package MachineCodingRound.ElevatorMachineCoding.strategy;

import MachineCodingRound.ElevatorMachineCoding.Model.Elevator;
import MachineCodingRound.ElevatorMachineCoding.Model.Request;

public interface ElevatorAlgorithmStrategy {
    public void addRequest(Request request, Elevator elevator);
    public void processCurrentRequest(Elevator elevator);
}

