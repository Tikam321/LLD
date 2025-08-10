package BehaviouralPattern;

class VendingMachine {
    private VendingState machineState = new IdleState();

    void setState(VendingState newState) {
        machineState = newState;
    }

    VendingState getState() {
        return machineState;
    }
}

interface VendingState {
    void insertCoin(VendingMachine vendingMachine);
    void payment(VendingMachine vendingMachine);
}

class IdleState implements  VendingState {

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("coin inserted");
        vendingMachine.setState(new WorkingState());
        System.out.println("state is change to Working state");
    }

    @Override
    public void payment(VendingMachine vendingMachine) {
        System.out.println("Insert coin first");
    }
}

class WorkingState implements VendingState {

    @Override
    public void insertCoin(VendingMachine vendingMachine) {
        System.out.println("Already processing");
    }

    @Override
    public void payment(VendingMachine vendingMachine) {
        System.out.println("payment is success");
        vendingMachine.setState(new IdleState());
        System.out.println("vending state is change to Idle");
    }
}

public class StatePatternDemo {
    public static void main(String[] args) {
        VendingMachine vendingMachine = new VendingMachine();
        System.out.println("before coin insert " + vendingMachine.getState());
        VendingState vendingState = new IdleState();
        vendingState.insertCoin(vendingMachine);
        System.out.println( vendingMachine.getState());
        vendingMachine.getState().payment(vendingMachine);
        System.out.println("after payment the state is " + vendingMachine.getState());
    }
}