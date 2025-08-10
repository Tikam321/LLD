package MachineCodingRound.LinkedInLearningMachineCoding;

public class Profile {
    String headline;
    String summary;
    private Experience experience;
    private Education education;

    public Profile(String headline, String summary, Experience experience, Education education) {
        this.headline = headline;
        this.summary = summary;
        this.experience = experience;
        this.education = education;
    }

    public String getHeadline() {
        return headline;
    }

    public void setHeadline(String headline) {
        this.headline = headline;
    }

    public String getSummary() {
        return summary;
    }

    public void setSummary(String summary) {
        this.summary = summary;
    }

    public Experience getExperience() {
        return experience;
    }

    public void setExperience(Experience experience) {
        this.experience = experience;
    }

    public Education getEducation() {
        return education;
    }

    public void setEducation(Education education) {
        this.education = education;
    }

}
