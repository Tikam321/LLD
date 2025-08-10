package BehaviouralPattern;

import java.util.ArrayList;
import java.util.List;



class ConfigurationMomento {
    private int length;
    private int breadth;

    public ConfigurationMomento(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
}
class ConfigurationMomentoCaretaker {
    private List<ConfigurationMomento> configurationMomentoList;

    public ConfigurationMomentoCaretaker() {
        this.configurationMomentoList = new ArrayList<>();
    }

    public void addMomento(ConfigurationMomento configurationMomento) {
        this.configurationMomentoList.add(configurationMomento);
    }

    public ConfigurationMomento undo() {
        if (configurationMomentoList.size() > 1) {
            int ind = configurationMomentoList.size() - 1;
            ConfigurationMomento lastMomento = configurationMomentoList.get(ind);
            return lastMomento;
        }
        return null;
    }
}
class ConfigurationOriginator {
    private int length;
    private int breadth;

    public ConfigurationOriginator(int length, int breadth) {
        this.length = length;
        this.breadth = breadth;
    }

    public ConfigurationMomento save() {
        return new ConfigurationMomento(length, breadth);
    }

    public void restore(ConfigurationMomento configurationMomento) {
        this.length = configurationMomento.getLength();
        this.breadth = configurationMomento.getBreadth();
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public int getBreadth() {
        return breadth;
    }

    public void setBreadth(int breadth) {
        this.breadth = breadth;
    }
}

public class MomentoPatternDemo {
    public static void main(String[] args) {
        ConfigurationMomentoCaretaker configurationMomentoCaretaker = new ConfigurationMomentoCaretaker();

        ConfigurationOriginator configurationOriginator = new ConfigurationOriginator(12,15);
        ConfigurationMomento snapshot = configurationOriginator.save();

        // add to history(configurationMomentoCareTaker)
        configurationMomentoCaretaker.addMomento(snapshot);

        //originator changing to new state
        configurationOriginator.setLength(24);
        configurationOriginator.setBreadth(30);

        ConfigurationMomento snapshot1 = configurationOriginator.save();

        configurationMomentoCaretaker.addMomento(snapshot1);

        //originator changing to new state
        configurationOriginator.setLength(48);
        configurationOriginator.setBreadth(60);

        ConfigurationMomento restoredStateMomenoto = configurationMomentoCaretaker.undo();
        configurationOriginator.restore(restoredStateMomenoto);
        System.out.println("restored length " + configurationOriginator.getLength() + " restored breadth " + configurationOriginator.getBreadth() );




    }
}
