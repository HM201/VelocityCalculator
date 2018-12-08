package com.example.android.velocitycalculator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {


    public float maxSpeed = 0;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void go(View view) {
        TextView textView = findViewById(R.id.max_speed_text_input);
        if(textView.getText()!="")
            maxSpeed = Float.parseFloat(textView.getText().toString());
        Intent intent = new Intent(this, Main2Activity.class);
        intent.putExtra("maxSpeed", maxSpeed);
        startActivity(intent);
    }


}
