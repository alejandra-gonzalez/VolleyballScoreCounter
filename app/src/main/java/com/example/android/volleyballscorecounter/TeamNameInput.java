package com.example.android.volleyballscorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.EditText;

public class TeamNameInput extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_team_name_input);
    }

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

        Intent intent = new Intent(TeamNameInput.this, ScoreCounter.class);
        intent.putExtra("teamA", teamAName);
        intent.putExtra("teamB", teamBName);
        startActivity(intent);
    }
}
