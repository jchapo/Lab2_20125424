package com.example.lab2_20125424;

import android.content.Intent;
import android.os.Bundle;
import android.provider.Settings;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;
import java.util.List;

public class MainActivity3 extends AppCompatActivity {

    private Button btnIqual, btnPlus, btnMinus, btnMult, btnDiv, btnCrl;
    private TextView textViewA, textViewB;
    private int numero1, numero2, resultado;
    private int fin = 0, igual = 0;
    private  String operacion, resultado_texto;
    private ArrayList<String> listaResultados = new ArrayList<>();



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);


        btnCrl = findViewById(R.id.buttonCRL);
        btnIqual = findViewById(R.id.buttonIqual);
        btnPlus = findViewById(R.id.buttonPlus);
        btnMinus = findViewById(R.id.buttonMinus);
        btnMult = findViewById(R.id.buttonMul);
        btnDiv = findViewById(R.id.buttonDiv);
        Button[] botones = new Button[10]; // Array para almacenar los botones del 0 al 9
        botones[0] = findViewById(R.id.button0);
        botones[1] = findViewById(R.id.button1);
        botones[2] = findViewById(R.id.button2);
        botones[3] = findViewById(R.id.button3);
        botones[4] = findViewById(R.id.button4);
        botones[5] = findViewById(R.id.button5);
        botones[6] = findViewById(R.id.button6);
        botones[7] = findViewById(R.id.button7);
        botones[8] = findViewById(R.id.button8);
        botones[9] = findViewById(R.id.button9);

        textViewA = findViewById(R.id.campoA);
        textViewB = findViewById(R.id.campoB);


        for (int i = 0; i < 10; i++) {
            final int finalI = i;
            botones[i].setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String textoExistente = textViewB.getText().toString();

                    if (textoExistente.equals("0") && igual == 0) {
                        textViewB.setText(String.valueOf(finalI));
                    } else if (igual == 0){
                        String nuevoTexto = textoExistente + String.valueOf(finalI);
                        textViewB.setText(nuevoTexto);
                    }
                }
            });
        }
        btnPlus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textoExistente = textViewB.getText().toString();
                if (textoExistente.equals("0")) {
                    textViewB.setText("0");
                } else if (igual == 0){
                    String nuevoTexto = textoExistente + " +";
                    textViewA.setText(nuevoTexto);
                    textViewB.setText("0");
                    operacion = "suma";
                    numero1 = Integer.parseInt(textoExistente);

                }
            }
        });

        btnMinus.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textoExistente = textViewB.getText().toString();
                if (textoExistente.equals("0")) {
                    textViewB.setText("0");
                } else if (igual == 0){
                    String nuevoTexto = textoExistente + " -";
                    textViewA.setText(nuevoTexto);
                    textViewB.setText("0");
                    operacion = "resta";
                    numero1 = Integer.parseInt(textoExistente);

                }
            }
        });

        btnMult.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textoExistente = textViewB.getText().toString();
                if (textoExistente.equals("0")) {
                    textViewB.setText("0");
                } else if (igual == 0){
                    String nuevoTexto = textoExistente + " ×";
                    textViewA.setText(nuevoTexto);
                    textViewB.setText("0");
                    operacion = "multiplicacion";
                    numero1 = Integer.parseInt(textoExistente);

                }
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textoExistente = textViewB.getText().toString();
                if (textoExistente.equals("0")) {
                    textViewB.setText("Error");
                } else if (igual == 0) {
                    String nuevoTexto = textoExistente + " ÷";
                    textViewA.setText(nuevoTexto);
                    textViewB.setText("0");
                    operacion = "division";
                    numero1 = Integer.parseInt(textoExistente);

                }
            }
        });

        btnIqual.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textoExistente2 = textViewB.getText().toString();
                String textoExistente = textViewA.getText().toString();
                if (textoExistente2.equals("0")) {
                    textViewB.setText("0");
                } else if (igual == 0){
                    String nuevoTexto = textoExistente + " " + textoExistente2;
                    textViewA.setText(nuevoTexto);
                    numero2 = Integer.parseInt(textoExistente2);
                    if (operacion.equals("suma")) {
                        resultado = numero1 + numero2;
                        resultado_texto = String.valueOf(resultado);
                    } else if (operacion.equals("resta")) {
                        resultado = numero1 - numero2;
                        resultado_texto = String.valueOf(resultado);
                    } else if (operacion.equals("multiplicacion")) {
                        resultado = numero1 * numero2;
                        resultado_texto = String.valueOf(resultado);
                    } else if (operacion.equals("division")) {
                        if (numero2 == 0 || numero1 % numero2 != 0) {
                            resultado_texto = "Error";
                        } else {
                            resultado = numero1 / numero2;
                            resultado_texto = String.valueOf(resultado);
                        }
                    }
                    fin = 1;
                    igual = 1;
                    textViewB.setText(resultado_texto);
                    listaResultados.add(resultado_texto);
                    System.out.println(listaResultados);

                }
            }
        });

        btnCrl.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                String textoExistente = textViewB.getText().toString();
                String textoExistente2 = textViewA.getText().toString();
                if (fin == 1) {
                    textViewA.setText("");
                    textViewB.setText("0");
                    fin = 0;
                    igual = 0;
                } else {
                    textViewB.setText("0");
                }
            }
        });



    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_historial,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int itemId = item.getItemId();
        if (itemId == R.id.history) {
            //Toast.makeText(this, "btn historial presionado", Toast.LENGTH_SHORT).show();
            Intent intent = new Intent(MainActivity3.this, MainActivity4.class);
            intent.putStringArrayListExtra("resultados", listaResultados);
            startActivity(intent);
        }
        return super.onOptionsItemSelected(item);
    }

}