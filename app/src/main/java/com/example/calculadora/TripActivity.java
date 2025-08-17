package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;
import java.text.NumberFormat;
import java.util.Locale;

public class TripActivity extends AppCompatActivity implements View.OnClickListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trip);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnCalcular){
            calcular();
        }else{
            finish();
        }
    }

    private void calcular(){
        EditText txtDistancia = findViewById(R.id.txtDistancia);
        EditText txtPrecoCombustivel = findViewById(R.id.txtPrecoCombustivel);
        EditText txtConsumo = findViewById(R.id.txtConsumo);

        String distanciaStr = txtDistancia.getText().toString();
        String precoStr = txtPrecoCombustivel.getText().toString();
        String consumoStr = txtConsumo.getText().toString();

        if (distanciaStr.isEmpty() || precoStr.isEmpty() || consumoStr.isEmpty()) {
            Toast.makeText(this,
                    "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show();
        }

        try {
            double distancia = Double.parseDouble(distanciaStr);
            double preco = Double.parseDouble(precoStr);
            double consumo = Double.parseDouble(consumoStr);

            if (distancia <= 0 || preco <= 0 || consumo <= 0) {
                Toast.makeText(this, "Os valores devem ser maiores que zero.", Toast.LENGTH_SHORT).show();
                return;
            }

            double custoTotal = (distancia / consumo) * preco;
            NumberFormat formatoMoeda = NumberFormat.getCurrencyInstance(new Locale("pt", "BR"));

            Toast.makeText(this, "Custo total: " + formatoMoeda.format(custoTotal), Toast.LENGTH_LONG).show();
        } catch (NumberFormatException e) {
            Toast.makeText(this, "Por favor, insira valores numéricos válidos.", Toast.LENGTH_SHORT).show();
        }
    }
}