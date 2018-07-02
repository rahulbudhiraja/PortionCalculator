package com.journaldev.retrofitintro.pojo;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Foods 
{

    @SerializedName("foods")
    
    public List<Food> foods = new ArrayList<Food>();



public class Food {

    @SerializedName("calories")
    
    public Integer calories;
    @SerializedName("carbs")
    
    public Integer carbs;
    @SerializedName("fat")
    
    public Integer fat;
    @SerializedName("id")
    
    public Integer id;
    @SerializedName("minportion")
    
    public Integer minportion;
    @SerializedName("name")
    
    public String name;
    @SerializedName("protein")
    
    public Integer protein;

}
}
