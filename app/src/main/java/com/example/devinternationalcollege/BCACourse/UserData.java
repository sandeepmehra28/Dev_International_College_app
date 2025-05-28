package com.example.devinternationalcollege.BCACourse;

import com.google.gson.annotations.SerializedName;

public class UserData {
    @SerializedName("ID")
    private String id;

    @SerializedName("FIRST-NAME")
    private String fname;

    @SerializedName("LAST-NAME")
    private String lname;

    @SerializedName("EMAIL")
    private String email;

    @SerializedName("MOBILE-NUMBER")
    private String mnumber;

    @SerializedName("ADDRESS")
    private String address;

    @SerializedName("SKILLS")
    private String skills;

    public String getId() { return id; }
    public String getFname() { return fname; }
    public String getLname() { return lname; }
    public String getEmail() { return email; }
    public String getMnumber() { return mnumber; }
    public String getAddress() { return address; }
    public String getSkills() { return skills; }
}
