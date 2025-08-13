//package MachineCodingRound.Elevator2MachineCoding.strategy;
//
//import MachineCodingRound.Elevator2MachineCoding.enums.DirectionStatus;
//import MachineCodingRound.Elevator2MachineCoding.model.Elevator;
//import MachineCodingRound.Elevator2MachineCoding.requests.ExternalRequest;
//
//import java.util.List;
//
//public class DirectionBatchingAssignmentStrategy implements ElevatorAssignmentStrategy{
//
//    @Override
//    public Elevator assignElevator(List<Elevator> elevators, ExternalRequest request) {
//        for (Elevator e: elevators) {
//            if (e.getDirectionStatus() == request.getDirectionStatus()) {
//                int curr = e.getCurrentFloor();
//                if ((request.getDirectionStatus() == DirectionStatus.UP && curr <= request.getCurrentFloor()) ||
//                        (request.getDirectionStatus() == DirectionStatus.DOWN && curr >= request.getCurrentFloor())) {
//                    return e; // batch it!
//                }
//            }
//        }
//
//        // 2. Fall back to nearest idle
//        for (Elevator e : elevators) {
//            if (e.getDirectionStatus() == DirectionStatus.IDLE) {
//                return e;
//            }
//        }
//        return null;
//
//    }
//
//}
