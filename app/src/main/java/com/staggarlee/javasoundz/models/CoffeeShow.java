package com.staggarlee.javasoundz.models;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.TimeZone;


/**
 * Created by nicolas on 4/11/15.
 */
public class CoffeeShow {

    private String mLocation;
    private String mDateStamp;
    private List<ArtistSet> mSetList;
    private String mShowDirectory;

    public CoffeeShow(String location) {
        mLocation = location;
        SimpleDateFormat yearMonthDay = new SimpleDateFormat("YYYY-MM-DD");
        yearMonthDay.setTimeZone(TimeZone.getDefault());
        mDateStamp = yearMonthDay.format(new Date().getTime() * 1000);
        mSetList = new ArrayList<ArtistSet>();

    }

    public String getLocation() {
        return mLocation;
    }

    public void setLocation(String location) {
        mLocation = location;
    }

    public String getDate() {
        return mDateStamp;
    }

    public void setDate(String year, String month, String day) {
        String yearMonthDay = year + "-" + month + "-" + day;
        mDateStamp = yearMonthDay;
    }

    public ArtistSet getArtistSet(int index) {
        return mSetList.get(index);
    }

    public void addArtistSet(String artist) {
        mSetList.add(new ArtistSet(artist));
    }

    public List<ArtistSet> getSetList() {
        return mSetList;
    }

    public void setSetList(List<ArtistSet> setList) {
        mSetList = setList;
    }
}
