package com.example.lab2_20125424;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.annotation.SuppressLint;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_20125424.bean.Persona;

public class MainActivity2 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        
        Button button = findViewById(R.id.buttonCalcular);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity2.this, MainActivity3.class);
            startActivity(intent);
            //para regresar al MainActivity ya creado
            //finish();
        });
    }
}