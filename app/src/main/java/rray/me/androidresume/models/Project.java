package rray.me.androidresume.models;

import java.sql.Date;
import java.util.List;

/**
 * Created by RRay on 7/20/2017.
 */

public class Project {
    private String id;
    private String project_name;
    private Date startDate;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getProject_name() {
        return project_name;
    }

    public void setProject_name(String project_name) {
        this.project_name = project_name;
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

    public List<String> getProject_details() {
        return project_details;
    }

    public void setProject_details(List<String> project_details) {
        this.project_details = project_details;
    }

    private Date endDate;
    private List<String> project_details;
}
