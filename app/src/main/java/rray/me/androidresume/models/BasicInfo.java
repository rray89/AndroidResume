package rray.me.androidresume.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

/**
 * Created by RRay on 7/19/2017.
 */

public class BasicInfo implements Parcelable{

    private String name;
    private String email;
    private String personal_site;
    private Uri imageUri;


    public BasicInfo() { }

    protected BasicInfo(Parcel in) {
        name = in.readString();
        email = in.readString();
        personal_site = in.readString();
        imageUri = in.readParcelable(Uri.class.getClassLoader());

    }

    public static final Creator<BasicInfo> CREATOR = new Creator<BasicInfo>() {
        @Override
        public BasicInfo createFromParcel(Parcel in) {
            return new BasicInfo(in);
        }

        @Override
        public BasicInfo[] newArray(int size) {
            return new BasicInfo[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPersonal_site() {
        return personal_site;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setPersonal_site(String personal_site) {
        this.personal_site = personal_site;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(personal_site);
        dest.writeParcelable(imageUri, flags);

    }
}
