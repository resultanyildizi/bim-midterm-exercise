package com.example.bookapplication.activities;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;
import android.widget.Toast;

import com.example.bookapplication.R;

public class DummyActivity extends AppCompatActivity {
    TextView tvBookName;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dummy);

        String name = getIntent().getStringExtra("name");
        String author = getIntent().getStringExtra("author");

        tvBookName = findViewById(R.id.tvBookName);
        tvBookName.setText(name);

        Toast.makeText(this, author, Toast.LENGTH_LONG).show();
    }
}