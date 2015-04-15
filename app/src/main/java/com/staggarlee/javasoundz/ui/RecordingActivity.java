package com.staggarlee.javasoundz.ui;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import com.staggarlee.javasoundz.R;
import butterknife.ButterKnife;
import butterknife.InjectView;

public class RecordingActivity extends ActionBarActivity {


    @InjectView(R.id.artistImage) ImageView mArtistImage;
    @InjectView(R.id.nextArtistButton) Button mNextArtistButton;
    @InjectView(R.id.artistListView) ListView mArtistListView;


    @InjectView(R.id.pausePlayButton) Button mPausePlayButton;
    @InjectView(R.id.newTrackButton) Button mNewTrackButton;
    @InjectView(R.id.setTimeLeft) TextView mSetTimeLeft;
    @InjectView(R.id.currentArtistText) TextView mCurrentArtist;
    @InjectView(R.id.trackNumberText) TextView mTrackNumberText;
    @InjectView(R.id.trackTimeText) TextView mTrackTimeText;

    private SimpleAdapter simpleAdpt;
    private int i = 0;
    private int mTrackIndex = 1;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recording);

        ButterKnife.inject(this);

        // Creating our new simple adapter
        simpleAdpt = new SimpleAdapter(RecordingActivity.this,
                CreateSetActivity.currentShow.getSetList(), android.R.layout.simple_list_item_1,
                new String[] {getString(R.string.artists_label)},
                new int[] {android.R.id.text1});

        // Set the listView of the show
        mArtistListView.setAdapter(simpleAdpt);
        mCurrentArtist.setText(CreateSetActivity.currentShow.getArtistSet(i).getArtist());
        mTrackNumberText.setText("Track " + Integer.toString(mTrackIndex));
        // mTrackTimeText.setText();




    }







}
