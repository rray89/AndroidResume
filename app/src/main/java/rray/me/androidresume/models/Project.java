package rray.me.androidresume.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;
import java.util.UUID;

/**
 * Created by RRay on 7/20/2017.
 */

public class Project implements Parcelable{

    private String id;
    private String project_name;
    private Date startDate;
    private Date endDate;
    private List<String> project_details;

    public Project () {
        id = UUID.randomUUID().toString();
    }

    protected Project(Parcel in) {
        id = in.readString();
        project_name = in.readString();
        startDate = new Date(in.readLong());
        endDate = new Date(in.readLong());
        project_details = in.createStringArrayList();
    }

    public static final Creator<Project> CREATOR = new Creator<Project>() {
        @Override
        public Project createFromParcel(Parcel in) {
            return new Project(in);
        }

        @Override
        public Project[] newArray(int size) {
            return new Project[size];
        }
    };

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


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(project_name);
        dest.writeLong(startDate.getTime());
        dest.writeLong(endDate.getTime());
        dest.writeStringList(project_details);
    }
}
