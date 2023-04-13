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
        TextView output = findViewById(R.id.outputBatting);
        battingAverage_calc(v, output);
        onBasePercentage_calc(v, output);
        sluggingPercentage(v,output);
        onBasePlusSlugging(v,output);

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
            output.setText("BA: " + df.format(battingAverage) + "\n");
        }catch(NumberFormatException nfe){
            output.setText("Error calculating BA. Make sure values are valid." + "\n");
        }


    }

    public void onBasePercentage_calc(View v, TextView output){
        TextView atBats = findViewById(R.id.inputAtBats);
        TextView hits = findViewById(R.id.inputHits);
        TextView walks = findViewById(R.id.inputWalks);
        TextView hbp = findViewById(R.id.inputHBP);
        TextView sacFlies = findViewById(R.id.inputSacFlies);

        try{
            double input_atBats = Integer.parseInt(atBats.getText().toString());
            double input_hits = Integer.parseInt(hits.getText().toString());
            double input_walks = Integer.parseInt(walks.getText().toString());
            double input_hbp = Integer.parseInt(walks.getText().toString());
            double input_sacFlies = Integer.parseInt(sacFlies.getText().toString());
            double onBasePercentage = (input_hits + input_walks + input_hbp) / (input_atBats + input_walks + input_hbp + input_sacFlies);
            DecimalFormat df = new DecimalFormat("#.###");
            output.append("OBP: " + df.format(onBasePercentage) + "\n");
        }catch(NumberFormatException nfe){
            output.setText("Error calculating OBP. Make sure values are valid." + "\n");
        }
    }

    public void sluggingPercentage(View v, TextView output){
        TextView singles = findViewById(R.id.inputSingles);
        TextView doubles = findViewById(R.id.inputDoubles);
        TextView triples = findViewById(R.id.inputTriples);
        TextView hrs = findViewById(R.id.inputHRS);
        TextView abs = findViewById(R.id.inputAtBats);

        try{
            double input_singles= Integer.parseInt(singles.getText().toString());
            double input_doubles = Integer.parseInt(doubles.getText().toString());
            double input_triples = Integer.parseInt(triples.getText().toString());
            double input_hrs = Integer.parseInt(hrs.getText().toString());
            double input_abs = Integer.parseInt(abs.getText().toString());
            double sluggingPercentage = (input_singles + (2*input_doubles) + (3*input_triples)+(4*input_hrs))/input_abs;
            DecimalFormat df = new DecimalFormat("#.###");
            output.append("SLG: " + df.format(sluggingPercentage) + "\n");
        }
        catch(NumberFormatException nfe){
            output.append("Error calculating SLG. Make sure values are valid." + "\n");
        }
    }

    public void onBasePlusSlugging(View v, TextView output){
        TextView atBats = findViewById(R.id.inputAtBats);
        TextView hits = findViewById(R.id.inputHits);
        TextView walks = findViewById(R.id.inputWalks);
        TextView hbp = findViewById(R.id.inputHBP);
        TextView sacFlies = findViewById(R.id.inputSacFlies);

        TextView singles = findViewById(R.id.inputSingles);
        TextView doubles = findViewById(R.id.inputDoubles);
        TextView triples = findViewById(R.id.inputTriples);
        TextView hrs = findViewById(R.id.inputHRS);

        try{
            double input_atBats = Integer.parseInt(atBats.getText().toString());
            double input_hits = Integer.parseInt(hits.getText().toString());
            double input_walks = Integer.parseInt(walks.getText().toString());
            double input_hbp = Integer.parseInt(walks.getText().toString());
            double input_sacFlies = Integer.parseInt(sacFlies.getText().toString());
            double onBasePercentage = (input_hits + input_walks + input_hbp) / (input_atBats + input_walks + input_hbp + input_sacFlies);

            double input_singles= Integer.parseInt(singles.getText().toString());
            double input_doubles = Integer.parseInt(doubles.getText().toString());
            double input_triples = Integer.parseInt(triples.getText().toString());
            double input_hrs = Integer.parseInt(hrs.getText().toString());
            double sluggingPercentage = (input_singles + (2*input_doubles) + (3*input_triples)+(4*input_hrs))/input_atBats;

            double onBasePlusSluggingPercentage = onBasePercentage + sluggingPercentage;
            DecimalFormat df = new DecimalFormat("#.###");
            output.append("OPS: " + df.format(onBasePlusSluggingPercentage)+ "\n");
        }
        catch(NumberFormatException nfe){
            output.append("Error calculating OPS. Make sure values are valid." + "\n");
        }
    }


}