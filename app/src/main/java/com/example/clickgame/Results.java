package com.example.clickgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

public class Results extends AppCompatActivity {
    TextView tv1, tv2, winner;
    int shortClickRes;
    int longClickRes;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_results);
        tv1 = (TextView) findViewById(R.id.resOne);
        tv2 = (TextView) findViewById(R.id.resTwo);
        winner = (TextView) findViewById(R.id.winner);
        getIntentInfo();
    }

    public void getIntentInfo()
    {
        Intent gi = getIntent();

        shortClickRes = gi.getIntExtra("num1", 0);
        longClickRes = gi.getIntExtra("num2", 0);
        String shortString = Integer.toString(shortClickRes);
        String longString = Integer.toString(longClickRes);

        tv1.setText("player 1: " + shortString + " points");
        tv2.setText("player 2: " + longString + " points");

        if(shortClickRes > longClickRes)
        {
            winner.setText("Player 1 wins!!!!");
        }
        else if(shortClickRes == longClickRes)
        {
            winner.setText("Tie!");
        }
        else
        {
            winner.setText("Player 2 wins!!!!");
        }
    }

    public void returnToMain(View view)
    {
        Intent si = new Intent(this,MainActivity.class);
        startActivity(si);
    }
}