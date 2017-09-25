package rray.me.androidresume.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.List;
import java.util.UUID;

/*
 * Created by RRay on 7/20/2017.
 */

public class Project implements Parcelable {

    private String id;
    private String projectName;
//    private String project_role;
//    private Date startDate;
//    private Date endDate;
    private List<String> projectDetails;

    public Project () {
        id = UUID.randomUUID().toString();
    }

    protected Project(Parcel in) {
        id = in.readString();
        projectName = in.readString();

        projectDetails = in.createStringArrayList();
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

    public String getProjectName() {
        return projectName;
    }

    public void setProjectName(String projectName) {
        this.projectName = projectName;
    }

//    public Date getStartDate() {
//        return startDate;
//    }
//
//    public void setStartDate(Date startDate) {
//        this.startDate = startDate;
//    }
//
//    public Date getEndDate() {
//        return endDate;
//    }
//
//    public void setEndDate(Date endDate) {
//        this.endDate = endDate;
//    }

    public List<String> getProjectDetails() {
        return projectDetails;
    }

    public void setProjectDetails(List<String> projectDetails) {
        this.projectDetails = projectDetails;
    }

//    public String getProject_role() {
//        return project_role;
//    }
//
//    public void setProject_role(String project_role) {
//        this.project_role = project_role;
//    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(id);
        dest.writeString(projectName);
//        dest.writeString(project_role);
//        dest.writeLong(startDate.getTime());
//        dest.writeLong(endDate.getTime());
        dest.writeStringList(projectDetails);
    }


}
