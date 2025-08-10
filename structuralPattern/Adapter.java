package structuralPattern;

interface IndianPluginInterface {
    void IndianPlugin();
}

interface ForeignPluginInterface {
    void ForeignPlugin();
}

class IndianInputPower implements IndianPluginInterface {

    @Override
    public void IndianPlugin() {
        System.out.println("Typical indian 3 pin input plugin");
    }
}

class ForeignInputPower implements ForeignPluginInterface{
    @Override
    public void ForeignPlugin() {
        System.out.println("foreign input plugin");
    }
}

class TravelAdapter implements IndianPluginInterface {
    ForeignPluginInterface foreignPluginInterface;

    public TravelAdapter(ForeignPluginInterface foreignPluginInterface) {
        this.foreignPluginInterface = foreignPluginInterface;
    }
    @Override
    public void IndianPlugin() {
        foreignPluginInterface.ForeignPlugin();
    }
}

public class Adapter {
    public static void main(String[] args) {
        // using the indian input power plugin
        IndianInputPower indianInputPower = new IndianInputPower();
        indianInputPower.IndianPlugin();

        // using adapter during the foreign input plugin
        ForeignInputPower foreignInputPower = new ForeignInputPower();
        TravelAdapter travelAdapter = new TravelAdapter(foreignInputPower);
        travelAdapter.IndianPlugin();
    }
}