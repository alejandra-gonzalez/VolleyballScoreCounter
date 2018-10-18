package com.example.android.volleyballscorecounter;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ScoreCounterActivity extends AppCompatActivity {

    private int scoreTeamA;
    private int scoreTeamB;

    @BindView(R.id.teamA_score)
    TextView teamScoreA;
    @BindView(R.id.teamB_score)
    TextView teamScoreB;

    @BindView(R.id.teamA_label)
    TextView teamNameA;
    @BindView(R.id.teamB_label)
    TextView teamNameB;

    private String scoreKeyA = "scoreA";
    private String scoreKeyB = "scoreB";

    /**
     * Places team names in their proper TextViews.
     *
     * @param savedInstanceState Bundle containing team names and scores
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_score_counter);
        ButterKnife.bind(this);

        Intent intent = getIntent();
        final String textViewALabel = intent.getStringExtra("teamA");
        final String textViewBLabel = intent.getStringExtra("teamB");
        teamNameA.setText(textViewALabel);
        teamNameB.setText(textViewBLabel);
    }

    /**
     * Updates the TextView for Team A's score with Team A's current score.
     */
    public void updateTeamAScore() {
        teamScoreA.setText(String.valueOf(scoreTeamA));
    }

    /**
     * Updates the TextView for Team B's score with Team B's current score.
     */
    public void updateTeamBScore() {
        teamScoreB.setText(String.valueOf(scoreTeamB));
    }

    /**
     * Adds a point to the team's score and updates its corresponding TextView.
     *
     * @param v The button that called this method.
     */
    public void servePoints(View v) {
        if (v.getId() == R.id.teamA_serve) {
            scoreTeamA++;
            updateTeamAScore();
        } else if (v.getId() == R.id.teamB_serve) {
            scoreTeamB++;
            updateTeamBScore();
        }
    }

    /**
     * Adds 2 points to the team's score and updates its corresponding TextView.
     *
     * @param v The button that called this method.
     */
    public void missPoints(View v) {
        if (v.getId() == R.id.teamA_miss) {
            scoreTeamA += 2;
            updateTeamAScore();
        } else if (v.getId() == R.id.teamB_miss) {
            scoreTeamB += 2;
            updateTeamBScore();
        }
    }

    /**
     * Adds 3 points to the team's score and updates its corresponding TextView.
     *
     * @param v The button that called this method.
     */
    public void faultPoints(View v) {
        if (v.getId() == R.id.teamA_fault) {
            scoreTeamA += 3;
            updateTeamAScore();
        } else if (v.getId() == R.id.teamB_fault) {
            scoreTeamB += 3;
            updateTeamBScore();
        }
    }

    /**
     * Sets the scores of both teams to 0 and updates both TextViews.
     *
     * @param v The button that called this method.
     */
    public void resetPoints(View v) {
        scoreTeamA = 0;
        scoreTeamB = 0;
        updateTeamAScore();
        updateTeamBScore();
    }

    /**
     * This stores the teams' scores in case of orientation change.
     */
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState) {
        savedInstanceState.putInt(scoreKeyA, scoreTeamA);
        savedInstanceState.putInt(scoreKeyB, scoreTeamB);
        super.onSaveInstanceState(savedInstanceState);
    }

    /**
     * This restores the teams' scores when the device's orientation changes.
     */
    @Override
    public void onRestoreInstanceState(Bundle savedInstanceState) {
        scoreTeamA = savedInstanceState.getInt(scoreKeyA);
        scoreTeamB = savedInstanceState.getInt(scoreKeyB);
        updateTeamAScore();
        updateTeamBScore();
    }
}
