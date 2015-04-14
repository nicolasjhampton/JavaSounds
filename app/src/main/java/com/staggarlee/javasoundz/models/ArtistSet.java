package com.staggarlee.javasoundz.models;

import android.os.ParcelFormatException;
import android.os.Parcelable;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * Created by nicolas on 4/11/15.
 */
public class ArtistSet {

    private String mArtist;
    private String mSlideFile;
    private List<Track> mTracks;
    private SimpleDateFormat mSetTimeFormat;
    private Date mSetTime;


    public ArtistSet (String artist) {

        mArtist = artist;

        mTracks = new ArrayList<Track>();

        mSetTimeFormat = new SimpleDateFormat("mm:ss");

        mSetTime = null;

    }

    public String getSetTime() {
        return mSetTimeFormat.format(mSetTime);
    }

    public void setSetTime(String setTime) throws ParseException {
        mSetTime = mSetTimeFormat.parse(setTime);
    }

    public String getArtist() {
        return mArtist;
    }

    public void setArtist(String artist) {
        mArtist = artist;
    }

    public String getSlideFile() {
        return mSlideFile;
    }

    public void setSlideFile(String slideFile) {
        mSlideFile = slideFile;
    }

    public Track getTrack(int index) {
        return mTracks.get(index);
    }

    public void setTrack() {
        mTracks.add(new Track(getArtist()));
    }

    public List<Track> getTracks() {
        return mTracks;
    }

    public void setTracks(List<Track> tracks) {
        mTracks = tracks;
    }

    @Override
    public String toString() {
        return mArtist + " - " + getSetTime();
    }

}
