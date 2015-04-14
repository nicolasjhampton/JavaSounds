package com.staggarlee.javasoundz.models;

/**
 * Created by nicolas on 4/11/15.
 */
public class SetRecorder {
    private CoffeeShow mShow;
    private String mDirectory = "";

    public void createShow(String location) {

    }



    public String getDirectory() {
        return mDirectory;
    }

    public void setDirectory(String directory) {
        mDirectory = directory;
    }

    public void addArtist(String name) {
        ArtistSet artist = new ArtistSet(name);
        mShow.getSetList().add(artist);

    }
}
