package MachineCodingRound.ElevatorMachineCoding.Service;

import MachineCodingRound.ElevatorMachineCoding.Model.Elevator;
import MachineCodingRound.ElevatorMachineCoding.Model.Floor;
import MachineCodingRound.ElevatorMachineCoding.Model.Request;
import MachineCodingRound.ElevatorMachineCoding.enums.DirectionStatus;
import MachineCodingRound.ElevatorMachineCoding.strategy.ElevatorAlgorithmStrategy;

import java.util.List;

public class ElevatorService {
    private ElevatorAlgorithmStrategy elevatorAlgorithmStrategy;
    List<Elevator> elevatorList;
    List<Floor> floors;

    public ElevatorService(ElevatorAlgorithmStrategy elevatorAlgorithmStrategy, List<Elevator> elevatorList, List<Floor> floors) {
        this.elevatorAlgorithmStrategy = elevatorAlgorithmStrategy;
        this.elevatorList = elevatorList;
        this.floors = floors;
    }

    public void addRequest(Request request) {
        Elevator elevator = getNearestElevator();
        elevator.addPassengerRequest(request);
    }

    private Elevator getNearestElevator() {
        int minDistance = Integer.MAX_VALUE;
        Elevator nearestElevator = null;
        for (Elevator elevator : elevatorList) {
            int currentDistance = Math.abs(minDistance - elevator.getCurrentFloor());
            if (currentDistance < minDistance) {
                minDistance = currentDistance;
                nearestElevator = elevator;
            }
        }
        for (Elevator elevator : elevatorList) {
            if (elevator.getElevatorStatus() == DirectionStatus.IDLE)
                nearestElevator =  elevator;
        }
        return nearestElevator;
    }

    public void processRequest() {

    }
}
