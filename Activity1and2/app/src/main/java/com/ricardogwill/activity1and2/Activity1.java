package com.ricardogwill.activity1and2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

//https://www.youtube.com/watch?v=bgIUdb-7Rqo

public class Activity1 extends AppCompatActivity {

    private Button btnGoTo2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_1);

        btnGoTo2 = (Button) findViewById(R.id.btnGoTo2);
        btnGoTo2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openActivity2();
            }
        });
    }

    public void openActivity2() {
        Intent intent = new Intent(this, Activity2.class);
        startActivity(intent);
    }

}
