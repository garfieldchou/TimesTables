package com.garfieldchou.timestables;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SeekBar;

import java.util.ArrayList;

import static java.util.Arrays.asList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final SeekBar mySeekBar = (SeekBar) findViewById(R.id.mySeekBar);
        final ListView timestables = (ListView) findViewById(R.id.timesTables);
        mySeekBar.setMax(20);
        mySeekBar.setProgress(10);

        final ArrayList<String> arrayTimesRes = new ArrayList<String>(asList("0", "0", "0", "0", "0", "0", "0", "0", "0"));
        final ArrayAdapter arrayAdapter = new ArrayAdapter(this, android.R.layout.simple_list_item_1, arrayTimesRes);
        timestables.setAdapter(arrayAdapter);

        mySeekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int i, boolean b) {
                int min = 1;
                int timesTable;

                if (i < min) {
                    timesTable = min;
                    mySeekBar.setProgress(min);
                } else {
                    timesTable = i;
                }
                Log.i("base", Integer.toString(timesTable));
                for(int j = 0; j < arrayTimesRes.size(); j++) {
                    arrayTimesRes.set(j, Integer.toString(timesTable * (j+1)));
                }
                timestables.setAdapter(arrayAdapter);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

}
