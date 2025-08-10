package BehaviouralPattern;


import java.rmi.Remote;


// receiver
class AirConditionar {
    private boolean isOn;
    private int temp;

    public void on() {
        System.out.println("the AC is on");
        this.isOn = true;
    }
    public void off() {
        System.out.println("Now the Ac is off");
        this.isOn = false;
    }

    public void setTemp(int temp) {
        System.out.println("now the temprature for ac is set to " + temp);
        this.temp = temp;
    }

}

interface Icommand {
    void execute();
}

class OnCommand implements Icommand {
    private AirConditionar airConditionar;

    public OnCommand(AirConditionar airConditionar) {
        this.airConditionar = airConditionar;
    }

    @Override
    public void execute() {
        airConditionar.on();
    }
}

class OffCommand implements Icommand {
    private AirConditionar airConditionar;

    public OffCommand(AirConditionar airConditionar) {
        this.airConditionar = airConditionar;
    }

    @Override
    public void execute() {
        airConditionar.off();
    }
}

class SetTemprature implements Icommand {
    private AirConditionar airConditionar;
    private int temp;

    public SetTemprature(AirConditionar airConditionar, int temp) {
        this.airConditionar = airConditionar;
        this.temp = temp;
    }

    @Override
    public void execute() {
        airConditionar.setTemp(temp);
    }
}


// invoker (sender)
class MyRemoteControl {
    private Icommand icommand;
    public void setCommand(Icommand icommand) {
        this.icommand = icommand;
    }
    public void pressButton() {
        icommand.execute();
    }
}
public class CommandDemo {
    public static void main(String[] args) {
        // air conditioner
        AirConditionar  airConditionar = new AirConditionar();

        // Remote controller
        MyRemoteControl remoteControl = new MyRemoteControl();

        Icommand onCommand = new OnCommand(airConditionar);
        Icommand offCommand = new OffCommand(airConditionar);
        Icommand setTemprature = new SetTemprature(airConditionar, 23);

        remoteControl.setCommand(onCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(offCommand);
        remoteControl.pressButton();

        remoteControl.setCommand(setTemprature);
        remoteControl.pressButton();
    }
}