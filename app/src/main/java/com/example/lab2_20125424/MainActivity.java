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
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;
import android.view.ContextMenu;

import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.appcompat.app.AppCompatActivity;

import com.example.lab2_20125424.bean.Persona;

public class MainActivity extends AppCompatActivity {

    TextView teleMath;
    public static String TAG = "MAINACTDEBUG";

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
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "oncreate");

        teleMath = findViewById(R.id.TeleMAth);
        registerForContextMenu(teleMath);

        /*Button button = findViewById(R.id.button2);
        button.setOnClickListener(view -> {
            TextView textView = findViewById(R.id.contadorEnVista);
            String contadorStr = textView.getText().toString();
            int contador = Integer.parseInt(contadorStr);
            textView.setText(String.valueOf(++contador));

        });*/

        Button button3 = findViewById(R.id.button3);
        button3.setOnClickListener(view -> {
            Intent intent = new Intent(MainActivity.this, MainActivity3.class);
            launcher.launch(intent);
        });

    }

    public void incrementarContador (View view) {
        TextView textView = findViewById(R.id.contadorEnVista);
        String contadorStr = textView.getText().toString();
        int contador = Integer.parseInt(contadorStr);
        contador++;
        Log.d ("contador", "" +  String.valueOf(contador));
        textView.setText(String.valueOf(contador));
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main_act,menu);
        return true;
    }

    /*
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.wifi) {
            Toast.makeText(this, "btn wifi presionado", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.add) {
            Toast.makeText(this, "btn add presionado", Toast.LENGTH_SHORT).show();
        } else if (itemId == R.id.notify) {
            //Toast.makeText(this, "btn notify presionado", Toast.LENGTH_SHORT).show();
            Log.d ("msgOptAppBar", "App Bar onclik");
            View menuItemView = findViewById(R.id.notify);
            PopupMenu popupMenu =  new PopupMenu(this, menuItemView);
            popupMenu.getMenuInflater().inflate(R.menu.menu_popup, popupMenu.getMenu());
            popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
                @Override
                public boolean onMenuItemClick(MenuItem item) {
                    if (item.getItemId() == R.id.reply_all) {
                        Log.d ("msgPopup", "replyAll");
                        return true;
                    } else if (item.getItemId() == R.id.forward) {
                        Log.d ("msgPopup", "forward");
                        return true;
                    } else {
                        return false;
                    }
                }
            });
            popupMenu.show();
        }

        return super.onOptionsItemSelected(item);
    }

    public void wifiBtn(MenuItem menuItem){
        Toast.makeText(this, "btn wifi presionado", Toast.LENGTH_SHORT).show();
    }

    public void addBtn(MenuItem menuItem){
        Toast.makeText(this, "btn add presionado", Toast.LENGTH_SHORT).show();
    }

    public void notifyBtn(MenuItem menuItem){
        Toast.makeText(this, "btn notify presionado", Toast.LENGTH_SHORT).show();
    }*/

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "onstart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "onresumed");
    }

    public void irAIndicaciones(View view) {


        Persona persona = new Persona("Claudia");

        Intent intent = new Intent(this, MainActivity2.class);
        //se envia un objeto
        intent.putExtra("alumna", persona);
        startActivity(intent);

    }

    /*
        El callback (lo que ejecutará al regreso)
     */
    ActivityResultLauncher<Intent> launcher = registerForActivityResult(
            new ActivityResultContracts.StartActivityForResult(),
            result -> {
                //aquí llegamos luego del setResult(RESULT_OK,intent);
                if (result.getResultCode() == RESULT_OK) {
                    Intent data = result.getData();
                    String apellido = data.getStringExtra("apellido");
                    Toast.makeText(MainActivity.this,
                            "el apellido recibido es: " + apellido,
                            Toast.LENGTH_SHORT).show();
                }
            }
    );

}