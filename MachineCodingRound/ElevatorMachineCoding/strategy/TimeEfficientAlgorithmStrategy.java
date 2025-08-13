package MachineCodingRound.ElevatorMachineCoding.strategy;

import MachineCodingRound.ElevatorMachineCoding.Model.Elevator;
import MachineCodingRound.ElevatorMachineCoding.Model.Request;
import MachineCodingRound.ElevatorMachineCoding.enums.DirectionStatus;

import java.util.Collections;
import java.util.PriorityQueue;

public class TimeEfficientAlgorithmStrategy implements ElevatorAlgorithmStrategy {
    private final PriorityQueue<Request> requests;

    public TimeEfficientAlgorithmStrategy() {
        this.requests = new PriorityQueue<>(); // min heap
    }

    @Override
    public void addRequest(Request request, Elevator elevator) {
      requests.add(request);
    }

    public void processCurrentRequest(Elevator elevator) {
        int pickUpFloor, destFloor;
       if (!requests.isEmpty()) {
           pickUpFloor = requests.peek().getCurrentFloor();
           destFloor = requests.peek().getDestinationFloor();
           requests.poll();
       }



    }

}
