package com.example.appnhac.Model;

import com.google.gson.annotations.SerializedName;

public class APIResponse {
    @SerializedName("status")
    private String status;
    @SerializedName("result_code")
    private int resultCode;
    @SerializedName("username")
    private String username;

    public String getStatus(){
        return status;
    }

    public int getResultCode() {
        return resultCode;
    }

    public String getUsername() {
        return username;
    }
}
