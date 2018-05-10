package com.example.narupak.recycleview_insignia;

import com.google.gson.annotations.SerializedName;

/**
 * Created by Narupak on 4/5/2561.
 */

public class ApproveList {

    @SerializedName("ps_fname")
    private String ps_fname;

    @SerializedName("ps_lname")
    private String ps_lname;

    @SerializedName("leave_name")
    private String leave_name;

    @SerializedName("pf_name")
    private String pf_name;

    public String getPs_fname() {
        return ps_fname;
    }

    public void setPs_fname(String ps_fname) {
        this.ps_fname = ps_fname;
    }

    public String getPs_lname() {
        return ps_lname;
    }

    public void setPs_lname(String ps_lname) {
        this.ps_lname = ps_lname;
    }

    public String getLeave_name() {
        return leave_name;
    }

    public void setLeave_name(String leave_name) {
        this.leave_name = leave_name;
    }

    public String getPf_name() {
        return pf_name;
    }

    public void setPf_name(String pf_name) {
        this.pf_name = pf_name;
    }
}
