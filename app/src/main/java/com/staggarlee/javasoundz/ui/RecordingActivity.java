package com.staggarlee.javasoundz.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.staggarlee.javasoundz.R;
import com.staggarlee.javasoundz.models.SetRecorder;

import java.io.IOException;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecordingActivity extends ActionBarActivity {


    @InjectView(R.id.artistImage) ImageView mArtistImage;
    @InjectView(R.id.nextArtistButton) Button mNextArtistButton;
    @InjectView(R.id.artistListView) ListView mArtistListView;


    @InjectView(R.id.pauseRecButton) Button mPauseRecButton;
    @InjectView(R.id.newTrackButton) Button mNewTrackButton;
    @InjectView(R.id.setTimeLeft) TextView mSetTimeLeft;
    @InjectView(R.id.currentArtistText) TextView mCurrentArtist;
    @InjectView(R.id.trackNumberText) TextView mTrackNumberText;
    @InjectView(R.id.trackTimeText) TextView mTrackTimeText;

    private SimpleAdapter simpleAdpt;
    private SetRecorder mRecorder;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);

        ButterKnife.inject(this);

        // Set the show to the SetRecorder
        mRecorder = new SetRecorder(CreateSetActivity.currentShow);
        mRecorder.setRecorder();

        // Creating our new simple adapter
        simpleAdpt = new SimpleAdapter(RecordingActivity.this,
                CreateSetActivity.currentShow.getSetList(), android.R.layout.simple_list_item_1,
                new String[] {getString(R.string.artists_label)},
                new int[] {android.R.id.text1});

        // Set the listView of the show
        mArtistListView.setAdapter(simpleAdpt);
        mCurrentArtist.setText(CreateSetActivity.currentShow
                               .getArtistSet(mRecorder.getSetNumber())
                               .getArtist());
        mTrackNumberText.setText("Track " + Integer.toString(mRecorder.getTrackNumber() + 1));
        // mTrackTimeText.setText();


        mNextArtistButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mRecorder.nextArtist();
                try{
                    mRecorder.prepareOutput();
                    mRecorder.startRec();
                } catch (IOException e) {
                    Toast.makeText(RecordingActivity.this,
                            "Recording preparation failed",
                            Toast.LENGTH_LONG).show();
                }

            }
        });

        mNewTrackButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                mRecorder.nextTrack();

            }
        });

        mPauseRecButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                try{
                mRecorder.prepareOutput();
                mRecorder.startRec();
                } catch (IOException e) {
                    Toast.makeText(RecordingActivity.this,
                                   "Recording preparation failed",
                                   Toast.LENGTH_SHORT).show();
                }


            }
        });



    }











}
