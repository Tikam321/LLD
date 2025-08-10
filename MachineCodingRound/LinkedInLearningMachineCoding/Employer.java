package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.List;
import java.util.UUID;

public class Employer {

    private String name;
    private String employerid;

    public Employer(String name) {
        this.employerid = UUID.randomUUID().toString();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmployerid() {
        return employerid;
    }

    public void setEmployerid(String employerid) {
        this.employerid = employerid;
    }
}
