package com.staggarlee.javasoundz.models;

import android.media.MediaRecorder;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;

/**
 * Created by nicolas on 4/11/15.
 */
public class SetRecorder {

    private CoffeeShow mShow;
    private String mDirectory = "";
    private MediaRecorder mRecorder;
    private int mTrackNumber;
    private ArtistSet mArtist;
    private int mSetNumber;




    public SetRecorder(CoffeeShow show) {


        mSetNumber = 0;
        mShow = show;
        mArtist = mShow.getArtistSet(mSetNumber);
        mDirectory = mShow.getLocation() + "/";
        mTrackNumber = 0;




    }

    public ArtistSet getArtist() {
        return mArtist;
    }

    public void setArtist(ArtistSet artist) {
        mArtist = artist;
    }

    public int getSetNumber() {
        return mSetNumber;
    }

    public void setSetNumber(int setNumber) {
        mSetNumber = setNumber;
    }

    public int getTrackNumber() {
        return mTrackNumber;
    }

    public void setTrackNumber(int trackNumber) {
        mTrackNumber = trackNumber;
    }

    public CoffeeShow getShow() {
        return mShow;
    }

    public void setShow(CoffeeShow show) {
        mShow = show;
    }

    public MediaRecorder getRecorder() {
        return mRecorder;
    }

    public String getDirectory() {
        return mDirectory;
    }

    public void setDirectory() {
        // make the path for the current show location and date
        mDirectory.concat(mShow.getDate());
    }

    public void setRecorder() {
        mRecorder = new MediaRecorder();
        // mRecorder.setAudioSource(MediaRecorder.AudioSource.MIC);
        // mRecorder.setOutputFormat(MediaRecorder.OutputFormat.MPEG_4);
    }

    public void prepareOutput() throws IOException {
        mArtist.setTrack();
        mRecorder.setOutputFile(mArtist.getTrack(mTrackNumber).toString());
        //getDirectory() + "/" + mArtist.getArtist() + "/" +


        mRecorder.setAudioEncoder(MediaRecorder.AudioEncoder.VORBIS);
        mRecorder.prepare();
    }

    public void startRec() {
        mRecorder.start();
    }

    public void nextTrack() {
        mRecorder.stop();
        mRecorder.release();
        mTrackNumber++;
    }

    public void nextArtist(){
        if(mShow.getArtistSet(mSetNumber + 1) != null) {
            mRecorder.stop();
            mRecorder.release();
            mSetNumber++;
            mShow.getArtistSet(mSetNumber);
            mTrackNumber = 0;
        } else {
            mRecorder.stop();
            mRecorder.release();
        }
    }

    /*public void continueRec() throws IOException {
        int temp;
        prepareOutput();
        FileOutputStream tempFile = new FileOutputStream("~/final.mp4");
        FileInputStream firstFile = new FileInputStream(getDirectory() + "/" +
                mArtist.getArtist() + "/" +
                mArtist.getTrack(mTrackNumber)
                        .toString());
        FileInputStream currentInstance = new FileInputStream(mRecorder);
        while((temp = firstFile.read()) != -1) {

        }


        FileInputStream newFile = new FileInputStream()

    }

    */



   // public void addArtist(String name) {
   //     ArtistSet artist = new ArtistSet(name);
   //     mShow.getSetList().add(artist);
    //
   // }
}
