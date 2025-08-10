package MachineCodingRound.UberMachineCoding.Model;

import java.util.UUID;

public class Rider {
    private String rider_id;
    private String name;

    public Rider(String name) {
        this.rider_id = UUID.randomUUID().toString();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getRider_id() {
        return rider_id;
    }

    public void setRider_id(String rider_id) {
        this.rider_id = rider_id;
    }
}
