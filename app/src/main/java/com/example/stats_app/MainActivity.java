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
        TextView output = findViewById(R.id.output);
        battingAverage_calc(v, output);
        onBasePercentage_calc(v, output);
    }

    public void battingAverage_calc(View v, TextView output){
        TextView atBats = findViewById(R.id.inputAtBats);
        TextView hits = findViewById(R.id.inputHits);
        //fetch inputs and calculate the batting average

        try{
            double input_atBats = Integer.parseInt(atBats.getText().toString());
            double input_hits = Integer.parseInt(hits.getText().toString());
            double battingAverage = input_hits / input_atBats;
            DecimalFormat df = new DecimalFormat("#.###");
            output.setText("BATTING AVERAGE: " + df.format(battingAverage) + "\n");
        }catch(NumberFormatException nfe){
            output.setText("Error calculating BA. Make sure values are valid." + "\n");
        }


    }

    public void onBasePercentage_calc(View v, TextView output){
        TextView atBats = findViewById(R.id.inputAtBats);
        TextView hits = findViewById(R.id.inputHits);
        TextView walks = findViewById(R.id.Walks);
        TextView hbp = findViewById(R.id.HBP);

        try{
            double input_atBats = Integer.parseInt(atBats.getText().toString());
            double input_hits = Integer.parseInt(hits.getText().toString());
            double input_walks = Integer.parseInt(walks.getText().toString());
            double input_hbp = Integer.parseInt(walks.getText().toString());
            double onBasePercentage = (input_hits + input_walks + input_hbp) / (input_atBats + input_walks + input_hbp);
            DecimalFormat df = new DecimalFormat("#.###");
            output.append("OBP: " + df.format(onBasePercentage) + "\n");
        }catch(NumberFormatException nfe){
            output.setText("Error calculating OBP. Make sure values are valid." + "\n");
        }
    }
}