package MachineCodingRound.LinkedInLearningMachineCoding;

import java.util.Date;

public class Education {

    private String universityName;
    private Date startTime;
    private Date endDate;
    private double cgpa;

    public Education(String universityName, Date startTime, Date endDate, double cgpa) {
        this.universityName = universityName;
        this.startTime = startTime;
        this.endDate = endDate;
        this.cgpa = cgpa;
    }

    public String getUniversityName() {
        return universityName;
    }

    public void setUniversityName(String universityName) {
        this.universityName = universityName;
    }

    public Date getStartTime() {
        return startTime;
    }

    public void setStartTime(Date startTime) {
        this.startTime = startTime;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public double getCgpa() {
        return cgpa;
    }

    public void setCgpa(Long cgpa) {
        this.cgpa = cgpa;
    }
}
