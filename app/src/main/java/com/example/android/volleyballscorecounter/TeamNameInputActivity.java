package com.example.android.volleyballscorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class TeamNameInputActivity extends AppCompatActivity {

    /**
     * Loads the activity's layout
     *
     * @param savedInstanceState Bundle for the current activity's state
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_name_input);
    }

    /**
     * Gets the team names from the user (or uses default names if none is entered),
     * and loads the score counting activity.
     *
     * @param v The button that called this method.
     */
    public void getTeamNames(View v) {
        EditText teamA = findViewById(R.id.teamA_name);
        EditText teamB = findViewById(R.id.teamB_name);
        String teamAName = teamA.getText().toString();
        String teamBName = teamB.getText().toString();

        if (teamAName.isEmpty() || teamAName.trim().length() == 0) {
            teamAName = "Team A";
        }
        if (teamBName.isEmpty() || teamBName.trim().length() == 0) {
            teamBName = "Team B";
        }

        Intent intent = new Intent(TeamNameInputActivity.this, ScoreCounterActivity.class);
        intent.putExtra("teamA", teamAName);
        intent.putExtra("teamB", teamBName);
        startActivity(intent);
    }
}
