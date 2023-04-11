package com.example.stats_app;

import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.os.Bundle;
import android.widget.TextView;
import java.text.DecimalFormat;
public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    public void calculate(View v){
        battingAverage_calc(v);
    }

    public void battingAverage_calc(View v){
        TextView output = findViewById(R.id.output);
        TextView atBats = findViewById(R.id.inputAtBats);
        TextView hits = findViewById(R.id.inputHits);
        //fetch inputs and calculate the batting average

        try{
            double input_atBats = Integer.parseInt(atBats.getText().toString());
            double input_hits = Integer.parseInt(hits.getText().toString());
            double battingAverage = input_hits / input_atBats;
            DecimalFormat df = new DecimalFormat("#.###");
            output.setText("BATTING AVERAGE: " + df.format(battingAverage));
        }catch(NumberFormatException nfe){
            output.setText("Invalid input. Try again.");
        }


    }
}