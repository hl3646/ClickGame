package com.example.clickgame;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnLongClickListener {
    Button shortClick, longClick;
    int shortClickCounter, longClickCounter;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        shortClick = (Button) findViewById(R.id.shortClick);
        longClick = (Button) findViewById(R.id.longClick);
        shortClickCounter = 0;
        longClickCounter = 0;

        shortClick.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                shortClickCounter++;
            }
        });

        longClick.setOnLongClickListener(this);

    }

    @Override
    public boolean onLongClick(View view) {
        longClickCounter += 2;
        return false;
    }

    public void getResults(View view)
    {
        Intent si = new Intent(this,Results.class);
        si.putExtra("num1", shortClickCounter);
        si.putExtra("num2", longClickCounter);
        startActivity(si);

        Intent gi = getIntent();
        longClickCounter = 0;
        shortClickCounter = 0;
    }
}