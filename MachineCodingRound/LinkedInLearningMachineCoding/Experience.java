package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.Date;

public class Experience {

    private String companyName;
    private Date startTime;
    private Date endTime;
    private String  description;

    public Experience(String companyName, Date startTime, Date endTime, String description) {
        this.companyName = companyName;
        this.startTime = startTime;
        this.endTime = endTime;
        this.description = description;
    }


    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndTime() {
        return endTime;
    }

    public void setEndTime(Date endTime) {
        this.endTime = endTime;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
