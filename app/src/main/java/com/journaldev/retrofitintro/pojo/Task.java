package com.journaldev.retrofitintro.pojo;
import com.google.gson.annotations.SerializedName;

public class Task {

    @SerializedName("id")

    public Integer id;
    @SerializedName("title")

    public String title;
    @SerializedName("description")

    public String description;
    @SerializedName("done")

    public Boolean done;

}
