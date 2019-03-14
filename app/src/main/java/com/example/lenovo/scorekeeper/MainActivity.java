package com.example.lenovo.scorekeeper;

import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.app.AppCompatDelegate;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    //variable for holding the score
    private int mScore1;
    private int mScore2;

    //variabel for the two score TextView elements
    private TextView mScoreText1;
    private TextView mScoreText2;



    static final String STATE_SCORE_1 = "Team Score 1";
    static final String STATE_SCORE_2 = "Team Score 2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Find the TextView by ID
        mScoreText1 = (TextView)findViewById(R.id.score_1);
        mScoreText2 = (TextView)findViewById(R.id.score_2);

        if (savedInstanceState != null){
            mScore1 = savedInstanceState.getInt(STATE_SCORE_1);
            mScore2 = savedInstanceState.getInt(STATE_SCORE_2);

            mScoreText1.setText(String.valueOf(mScore1));
            mScoreText2.setText(String.valueOf(mScore2));
        }
    }

    public void decreaseScore(View view) {
    //Get the ID of the button that was clicked
    int viewID = view.getId();
    switch (viewID){
        //if it was on team 1
        case R.id.decreaseTeam1:
            mScore1--;
            mScoreText1.setText(String.valueOf(mScore1));
            break;
        //if it was on team 2
        case R.id.decreaseTeam2:
            mScore2--;
            mScoreText2.setText(String.valueOf(mScore2));
    }
    }


    public void increaseScore(View view) {
    //Get the ID of the button that was clicked
    int viewID = view.getId();
    switch (viewID){
        //if it was on Team 1
        case R.id.increaseTeam1:
            mScore1++;
            mScoreText1.setText(String.valueOf(mScore1));
            break;
        //if it was team 2
        case R.id.increaseTeam2:
            mScore2++;
            mScoreText2.setText(String.valueOf(mScore2));
    }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main_menu, menu);
        //change label
        int nightMode = AppCompatDelegate.getDefaultNightMode();
        if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
            menu.findItem(R.id.night_mode).setTitle(R.string.day_mode);
        }
        else {
            menu.findItem(R.id.night_mode).setTitle(R.string.night_mode);
        }
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId()==R.id.night_mode){
            int nightMode = AppCompatDelegate.getDefaultNightMode();
            if (nightMode == AppCompatDelegate.MODE_NIGHT_YES){
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
            }
            else {
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            }
            recreate();
        }

        return true;
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        outState.putInt(STATE_SCORE_1, mScore1);
        outState.putInt(STATE_SCORE_2, mScore2);
        super.onSaveInstanceState(outState);
    }
}
