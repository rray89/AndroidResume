package rray.me.androidresume.models;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.Date;
import java.util.List;

import rray.me.androidresume.util.DateUtils;

/**
 * Created by RRay on 7/19/2017.
 */

public class Education implements Parcelable{
    private String id;
    private String institutionName;
    private String degree;
    private Date startDate;
    private Date endDate;
    private List<String> courses;

    public Education() { }

    protected Education(Parcel in) {
        id = in.readString();
        institutionName = in.readString();
        degree = in.readString();
        startDate = DateUtils.stringToDate(in.readString());
        endDate = DateUtils.stringToDate(in.readString());
        courses = in.createStringArrayList();

    }

    public static final Creator<Education> CREATOR = new Creator<Education>() {
        @Override
        public Education createFromParcel(Parcel in) {
            return new Education(in);
        }

        @Override
        public Education[] newArray(int size) {
            return new Education[size];
        }
    };

    public String getDegree() {
        return degree;
    }

    public void setDegree(String degree) {
        this.degree = degree;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
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

    public List<String> getCourses() {
        return courses;
    }

    public void setCourses(List<String> courses) {
        this.courses = courses;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(id);
        parcel.writeString(institutionName);
        parcel.writeString(degree);
        parcel.writeString(DateUtils.dateToString(startDate));
        parcel.writeString(DateUtils.dateToString(endDate));
        parcel.writeStringList(courses);

    }
}
