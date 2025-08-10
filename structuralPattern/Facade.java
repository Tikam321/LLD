package structuralPattern;




class CPU {
    void start() {
        System.out.println("CPU started.");
    }
}

class Memory {
    void load() {
        System.out.println("Memory Loaded");
    }
}
class HardDrive {
    void read() {
        System.out.println("Reading from hard drive");
    }
}

class ComputerFacade {
    private CPU cpu;
    private Memory memory;
    private HardDrive hardDrive;

    public ComputerFacade(CPU cpu, Memory memory, HardDrive hardDrive) {
        this.cpu = cpu;
        this.memory = memory;
        this.hardDrive = hardDrive;
    }

    public void startComputer() {
        this.cpu.start();
        this.memory.load();
        this.hardDrive.read();
    }

}

public class Facade {

    public static void main(String[] args) {
        CPU cpu = new CPU();
        Memory memory = new Memory();
        HardDrive hardDrive = new HardDrive();
        ComputerFacade computerFacade = new ComputerFacade(cpu, memory, hardDrive);
        computerFacade.startComputer();
    }
}