package com.example.lab2_20125424;

import android.os.Bundle;
import android.widget.TextView;


import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main4);

        generarHistorial();

    }

    public void generarHistorial() {
        ArrayList<String> resultados = getIntent().getStringArrayListExtra("resultados");
        TextView textView = findViewById(R.id.textView2);
        if (resultados != null) {
            System.out.println(resultados);
            StringBuilder texto = new StringBuilder();

            for(int i = 0; i < resultados.size(); i++) {
                String resultado = resultados.get(i);
                texto.append("Resultado ").append(i + 1).append(": ").append(resultado).append("\n");
            }

            System.out.println(texto);
            textView.setText(texto.toString());
        } else {
            textView.setText("No hay resultados");
        }
    }
}