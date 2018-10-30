package com.ricardogwill.jsonparsingapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

// Tutorial URL for help with this: "https://www.youtube.com/watch?v=Vcn4OuV4Ixg"

public class MainActivity extends AppCompatActivity {

    Button jsonButton;
    public static TextView jsonTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        jsonButton = findViewById(R.id.json_button);
        jsonTextView = findViewById(R.id.json_textView);

        jsonButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                FetchData processFetchData = new FetchData();
                processFetchData.execute();
            }
        });

    }
}
