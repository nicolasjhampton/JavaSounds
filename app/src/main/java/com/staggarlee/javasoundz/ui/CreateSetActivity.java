package com.staggarlee.javasoundz.ui;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.SimpleAdapter;
import android.widget.TextView;
import android.widget.Toast;

import com.staggarlee.javasoundz.R;
import com.staggarlee.javasoundz.models.ArtistSet;
import com.staggarlee.javasoundz.models.CoffeeShow;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import butterknife.ButterKnife;
import butterknife.InjectView;

public class CreateSetActivity extends ActionBarActivity {


    @InjectView(R.id.inputArtistName) EditText mArtistInput;
    @InjectView(R.id.addArtist) Button mAddArtist;
    @InjectView(R.id.listView) ListView mSetList;
    @InjectView(R.id.venueView) TextView mVenueView;
    @InjectView(R.id.startButton) Button mStartButton;
    @InjectView(R.id.inputSetTime) EditText mInputSetTime;

    // We're going to use the artistList and simpleAdpt across the Activities
    // so we declare them protected so all members of this package can access them.

    protected static CoffeeShow currentShow;
    private SimpleAdapter simpleAdpt;
    private List<Map<String, ArtistSet>> artistList = new ArrayList<Map<String,ArtistSet>>();

    // I'm declaring an ArtistSet private here so we can create one,
    // load it into the list, and reclaim the resource at the end of the Activity.




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_set);

        ButterKnife.inject(this);

        // Obtaining the location from the previous activity and displaying it
        final String locationLabel = getString(R.string.location);
        final String location = getIntent().getStringExtra(locationLabel);
        mVenueView.setText(location);

        // Initializing the simple adapter (Took this from outside of the createArtist method)
        simpleAdpt = new SimpleAdapter(CreateSetActivity.this,
                artistList, android.R.layout.simple_list_item_1,
                new String[] {getString(R.string.artists_label)},
                new int[] {android.R.id.text1});





        mAddArtist.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // adding the artist and set time to the artist list
                // then passing the list to the adapter to display

                try{


                    artistList.add(createArtist());
                    artistList.get(artistList.size()-1).get("Artists")
                            .setSetTime(mInputSetTime.getText().toString());

                } catch (ParseException | NullPointerException n) {
                    Toast.makeText(CreateSetActivity.this, "Incorrect time format", Toast.LENGTH_LONG).show();
                    artistList.remove(artistList.size()-1);
                }


                mSetList.setAdapter(simpleAdpt);
                mArtistInput.setText("");
            }
        });

        // Start Show button
        mStartButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // starting the next activity
                currentShow = new CoffeeShow(artistList, location);
                Intent intent = new Intent(CreateSetActivity.this, RecordingActivity.class);

                startActivity(intent);

            }
        });

    }


    // Creating a new artist
    public HashMap<String, ArtistSet> createArtist() {
        // Creating a hashmap to store entry for the adapter
        HashMap<String, ArtistSet> hashMap = new HashMap<String, ArtistSet>();
        ArtistSet artist = new ArtistSet(mArtistInput.getText().toString());

        // Create a new ArtistSet with the artist from the EditText

        hashMap.put(getString(R.string.artists_label), artist);
        return hashMap;



        // matching the ArtistSet with the keylabel in the string
        // resource file and putting it into a hashMap entry

        // This hashMap only ever has one entry. We're using it
        // to format our entry into the simple adapter.

        // We will create the adapter here. We've declared it's resource outs




    }





}
