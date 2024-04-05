package com.example.lab2_20125424;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.graphics.Color;
import android.view.View;
import android.widget.Button;
import android.view.MenuItem;
import android.widget.TextView;
import android.view.ContextMenu;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    TextView teleMath;
    Button buttonIndicaciones;
    public static String TAG = "MAINACTDEBUG";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "oncreate");

        teleMath = findViewById(R.id.TeleMAth);
        registerForContextMenu(teleMath);

        Button button = findViewById(R.id.irAIndicaciones);
        button.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity2.class);
            startActivity(intent);
        });

        Button button2 = findViewById(R.id.irACalcular);
        button2.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            startActivity(intent);
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.context_menu, menu);
    }

    @SuppressLint("NonConstantResourceId")
    public boolean onContextItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id == R.id.red_color) {
            teleMath.setTextColor(Color.RED);
            return true;
        } else if (id == R.id.blue_color) {
            teleMath.setTextColor(Color.BLUE);
            return true;
        } else if (id == R.id.green_color) {
            teleMath.setTextColor(Color.GREEN);
            return true;
        } else {
            return super.onContextItemSelected(item);
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_act,menu);
        return true;
    }


    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onstart");
    }


}