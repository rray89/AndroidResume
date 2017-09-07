package rray.me.androidresume.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by RRay on 7/19/2017.
 */

public class WorkExperience implements Parcelable {
    private String id;
    private String companyName;
    private String jobTitle;
    private Date startDate;
    private Date endDate;
    private List<String> jobDescription;

    public WorkExperience() {
        id = UUID.randomUUID().toString();
    }

    protected WorkExperience(Parcel in) {
        id = in.readString();
        companyName = in.readString();
        jobTitle = in.readString();
        startDate = new Date(in.readLong());
        endDate = new Date(in.readLong());
        jobDescription = in.createStringArrayList();
    }

    public static final Creator<WorkExperience> CREATOR = new Creator<WorkExperience>() {
        @Override
        public WorkExperience createFromParcel(Parcel in) {
            return new WorkExperience(in);
        }

        @Override
        public WorkExperience[] newArray(int size) {
            return new WorkExperience[size];
        }
    };

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

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(companyName);
        dest.writeString(jobTitle);
        dest.writeLong(startDate.getTime());
        dest.writeLong(endDate.getTime());
        dest.writeStringList(jobDescription);
    }
}
