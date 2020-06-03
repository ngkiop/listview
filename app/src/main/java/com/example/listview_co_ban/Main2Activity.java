package com.example.listview_co_ban;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView txtInRa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        txtInRa = (TextView) findViewById(R.id.textViewInRa);

        Intent intent = getIntent();

        String noiDung = intent.getStringExtra("key1");

        txtInRa.setText(noiDung);
    }
}
