package com.example.a20190322_bisratfeleke_nycschools.model;


import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class SchoolResponse {


    @SerializedName("dbn")
    @Expose
    private String dbn;

    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("primary_address_line_1")
    @Expose
    private String primaryAddressLine1;

    @SerializedName("school_name")
    @Expose
    private String schoolName;
    public String getDbn() {
        return dbn;
    }

    public void setDbn(String dbn) {
        this.dbn = dbn;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getPrimaryAddressLine1() {
        return primaryAddressLine1;
    }

    public void setPrimaryAddressLine1(String primaryAddressLine1) {
        this.primaryAddressLine1 = primaryAddressLine1;
    }
    public String getSchoolName() {
        return schoolName;
    }

    public void setSchoolName(String schoolName) {
        this.schoolName = schoolName;
    }
}


