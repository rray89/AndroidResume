package rray.me.androidresume.models;

import java.util.Date;
import java.util.List;

/**
 * Created by RRay on 7/19/2017.
 */

public class WorkExperience {
    private String id;
    private String companyName;



    private String jobTitle;
    private Date startDate;
    private Date endDate;
    private List<String> jobDescription;

    public String getJobTitle() {
        return jobTitle;
    }

    public void setJobTitle(String jobTitle) {
        this.jobTitle = jobTitle;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getCompanyName() {
        return companyName;
    }

    public void setCompanyName(String companyName) {
        this.companyName = companyName;
    }

    public Date getStartDate() {
        return startDate;
    }

    public void setStartDate(Date startDate) {
        this.startDate = startDate;
    }

    public Date getEndDate() {
        return endDate;
    }

    public void setEndDate(Date endDate) {
        this.endDate = endDate;
    }

    public List<String> getJobDescription() {
        return jobDescription;
    }

    public void setJobDescription(List<String> jobDescription) {
        this.jobDescription = jobDescription;
    }
}
