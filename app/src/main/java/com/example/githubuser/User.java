package com.example.githubuser;

import android.os.Parcel;
import android.os.Parcelable;

import java.util.ArrayList;

public class User extends ArrayList<Parcelable> implements Parcelable {
    private Integer photo;
    private String username, name, followers, following, company, location, repository;

    public User() {

    }

    protected User(Parcel in) {
        if (in.readByte() == 0) {
            photo = null;
        } else {
            photo = in.readInt();
        }
        username = in.readString();
        name = in.readString();
        followers = in.readString();
        following = in.readString();
        company = in.readString();
        location = in.readString();
        repository = in.readString();
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        if (photo == null) {
            dest.writeByte((byte) 0);
        } else {
            dest.writeByte((byte) 1);
            dest.writeInt(photo);
        }
        dest.writeString(username);
        dest.writeString(name);
        dest.writeString(followers);
        dest.writeString(following);
        dest.writeString(company);
        dest.writeString(location);
        dest.writeString(repository);
    }

    @Override
    public int describeContents() {
        return 0;
    }

    public static final Creator<User> CREATOR = new Creator<User>() {
        @Override
        public User createFromParcel(Parcel in) {
            return new User(in);
        }

        @Override
        public User[] newArray(int size) {
            return new User[size];
        }
    };

    public Integer getPhoto() {
        return photo;
    }

    public void setPhoto(Integer photo) {
        this.photo = photo;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFollowers() {
        return followers;
    }

    public void setFollowers(String followers) {
        this.followers = followers;
    }

    public String getFollowing() {
        return following;
    }

    public void setFollowing(String following) {
        this.following = following;
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getRepository() {
        return repository;
    }

    public void setRepository(String repository) {
        this.repository = repository;
    }
}
