package MachineCodingRound.ElevatorMachineCoding.strategy;

import MachineCodingRound.ElevatorMachineCoding.Model.Elevator;
import MachineCodingRound.ElevatorMachineCoding.Model.Request;
import MachineCodingRound.ElevatorMachineCoding.enums.DirectionStatus;

import java.util.PriorityQueue;

public class MinWaitTimeEfficientAlgorithmAlgorithm implements ElevatorAlgorithmStrategy {
    private final PriorityQueue<Request> minHeap;

    public MinWaitTimeEfficientAlgorithmAlgorithm(PriorityQueue<Request> minHeap) {
        this.minHeap = new PriorityQueue<>();
    }

    @Override
    public void addRequest(Request request, Elevator elevator) {
        minHeap.add(request);
    }

    @Override
    public void processCurrentRequest(Elevator elevator) {
        if (!minHeap.isEmpty()) {
            if (elevator.getElevatorStatus() == DirectionStatus.IDLE) {
                Request currentRequest = minHeap.poll();

                if (currentRequest.isMovingUp()) {
                    int passengerCurrentFloor = currentRequest.getCurrentFloor();

                    int passengerDestinationFloor = currentRequest.getDestinationFloor();
                }

            }
        }

    }

}
