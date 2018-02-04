package com.example.android.quidditchscorecounter;

import android.content.Intent;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    int scoreGryffindor = 0;
    int scoreSlytherin = 0;
    int goalPoints = 10;
    int snitchPoints = 150;

    static final String STATE_GRYFFINDOR = String.valueOf(R.string.score_gryffindor);
    static final String STATE_SLYTHERIN = String.valueOf(R.string.score_slytherin);

    private TextView scoreViewG, scoreViewS;
    private Button goalG, goalS, snitchG, snitchS, resetButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        scoreViewG = (TextView) findViewById(R.id.gryffindor_score);
        scoreViewS = (TextView) findViewById(R.id.slytherin_score);
        goalG = (Button) findViewById(R.id.goal_gryffindor);
        goalS = (Button) findViewById(R.id.goal_slytherin);
        snitchG = (Button) findViewById(R.id.snitch_gryffindor);
        snitchS = (Button) findViewById(R.id.snitch_slytherin);
        resetButton = (Button) findViewById(R.id.reset_button);

        initControl();

        if (savedInstanceState == null) {
            displayForGryffindor(0);
            displayForSlytherin(0);
        } else {
            displayForGryffindor(scoreGryffindor);
            displayForSlytherin(scoreSlytherin);
        }
    }

    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        // Save the user's current score state
        savedInstanceState.putInt(STATE_GRYFFINDOR, scoreGryffindor);
        savedInstanceState.putInt(STATE_SLYTHERIN, scoreSlytherin);

        // Always call the superclass so it can save the view hierarchy state
        super.onSaveInstanceState(savedInstanceState);
    }

    private void initControl () {
        goalG.setOnClickListener(this);
        goalS.setOnClickListener(this);
        snitchG.setOnClickListener(this);
        snitchS.setOnClickListener(this);
        resetButton.setOnClickListener(this);
    }

    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.goal_gryffindor:
                scoreGryffindor = scoreGryffindor + goalPoints;
                displayForGryffindor(scoreGryffindor);
                break;
            case R.id.goal_slytherin:
                scoreSlytherin = scoreSlytherin + goalPoints;
                displayForSlytherin(scoreSlytherin);
                break;
            case R.id.snitch_gryffindor:
                scoreGryffindor = scoreGryffindor + snitchPoints;
                displayForGryffindor(getString(R.string.won));
                scoreSlytherin = 0;
                scoreGryffindor = 0;
                displayForSlytherin(scoreSlytherin);
                scoreViewS.setVisibility(scoreViewS.INVISIBLE);
                goalG.setVisibility(goalG.GONE);
                goalS.setVisibility(goalS.GONE);
                snitchS.setVisibility(snitchS.GONE);
                snitchG.setVisibility(snitchG.GONE);
                break;
            case R.id.snitch_slytherin:
                scoreSlytherin = scoreSlytherin + snitchPoints;
                displayForSlytherin(getString(R.string.won));
                scoreSlytherin = 0;
                scoreGryffindor = 0;
                displayForGryffindor(scoreGryffindor);
                scoreViewG.setVisibility(scoreViewG.INVISIBLE);
                goalG.setVisibility(goalG.GONE);
                goalS.setVisibility(goalS.GONE);
                snitchS.setVisibility(snitchS.GONE);
                snitchG.setVisibility(snitchG.GONE);
                break;
            case R.id.reset_button:
                scoreGryffindor = 0;
                displayForGryffindor(scoreGryffindor);
                scoreSlytherin = 0;
                displayForSlytherin(scoreSlytherin);
                scoreViewS.setVisibility(scoreViewS.VISIBLE);
                scoreViewG.setVisibility(scoreViewG.VISIBLE);
                goalG.setVisibility(goalG.VISIBLE);
                goalS.setVisibility(goalS.VISIBLE);
                snitchS.setVisibility(snitchS.VISIBLE);
                snitchG.setVisibility(snitchG.VISIBLE);
                break;
        }
    }

    /**
     * Displays the given score for Gryffindor.
     */
    public void displayForGryffindor(int score) {
        scoreViewG.setText(String.valueOf(score));
    }
    public void displayForGryffindor(String text) {
        scoreViewG.setText(text);
    }

    /**
     * Displays the given score for Slytherin.
     */
    public void displayForSlytherin(int score) {
        scoreViewS.setText(String.valueOf(score));
    }
    public void displayForSlytherin(String text) {
        scoreViewS.setText(text);
    }
}


//    /**
//     * Increase the score for Gryffindor by 10 points.
//     */
//    public void addTenForGryffindor(View v) {
//        scoreGryffindor = scoreGryffindor + 10;
//        displayForGryffindor(scoreGryffindor);
//    }
//
//    /**
//     * Increase the score for Slytherin by 10 point.
//     */
//    public void addTenForSlytherin(View v) {
//        scoreSlytherin = scoreSlytherin + 10;
//        displayForSlytherin(scoreSlytherin);
//    }
//
//    /**
//     * Game won by Gryffindor.
//     */
//    public void add150ForGryffindor(View v) {
//        scoreGryffindor = scoreGryffindor + 150;
//        displayForGryffindor(getString(R.string.won));
//        scoreSlytherin = 0;
//        scoreGryffindor = 0;
//        displayForSlytherin(scoreSlytherin);
//    }
//
//    /**
//     * Game won by Slytherin
//     */
//    public void add150ForSlytherin(View v) {
//        scoreSlytherin = scoreSlytherin + 150;
//        displayForSlytherin(getString(R.string.won));
//        scoreSlytherin = 0;
//        scoreGryffindor = 0;
//        displayForGryffindor(scoreGryffindor);
//    }
//
//    /**
//     * Reset the score for Gryffindor and Slytherin to 0 points each.
//     */
//    public void resetToZero(View v) {
//        scoreGryffindor = 0;
//        displayForGryffindor(scoreGryffindor);
//        scoreSlytherin = 0;
//        displayForSlytherin(scoreSlytherin);
//    }