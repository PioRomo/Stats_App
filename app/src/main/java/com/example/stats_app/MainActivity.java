package com.example.stats_app;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
public class MainActivity extends AppCompatActivity {

    TextView output = findViewById(R.id.output);
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View v){
        TextView atBats = findViewById(R.id.inputAtBats);
        TextView hits = findViewById(R.id.inputHits);
        int input_atBats = Integer.parseInt(atBats.getText().toString());
        int input_hits = Integer.parseInt(hits.getText().toString());
        int battingAverage = input_hits / input_atBats;
        output.setText("BATTING AVERAGE: " + battingAverage);




    }
}