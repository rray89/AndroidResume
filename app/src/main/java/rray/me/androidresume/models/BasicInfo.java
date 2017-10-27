/*
 * Class BasicInfo implements Parcelable
 *
 * Including 4 parameters:
 * String name: user's name
 * String email: user's email
 * String personalSite: user's personal site
 * Uri imageUri: user portrait's URI
 */

package rray.me.androidresume.models;

import android.net.Uri;
import android.os.Parcel;
import android.os.Parcelable;

public class BasicInfo implements Parcelable{

    private String name;
    private String email;
    private String personalSite;
    private Uri imageUri;


    public BasicInfo() { }

    protected BasicInfo(Parcel in) {
        name = in.readString();
        email = in.readString();
        personalSite = in.readString();
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

    public String getPersonalSite() {
        return personalSite;
    }

    public void setImageUri(Uri imageUri) {
        this.imageUri = imageUri;
    }

    public Uri getImageUri() {
        return imageUri;
    }

    public void setPersonalSite(String personalSite) {
        this.personalSite = personalSite;
    }


    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(name);
        dest.writeString(email);
        dest.writeString(personalSite);
        dest.writeParcelable(imageUri, flags);

    }
}
