package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener  {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        Button btnSoma = findViewById(R.id.btnSomar);
        btnSoma.setOnClickListener(this);

        Button btnSubtrair = findViewById(R.id.btnSubtrair);
        btnSubtrair.setOnClickListener(this);

        Button btnMultiplicar = findViewById(R.id.btnMultiplicar);
        btnMultiplicar.setOnClickListener(this);

        Button btnDividir = findViewById(R.id.btnDividir);
        btnDividir.setOnClickListener(this);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnVoltar){
            finish();
        }else{
            Intent calculator = new Intent(this, CalculatorActivity.class);
            if(view.getId() == R.id.btnSomar){
                calculator.putExtra("operacao", "Somar");
            } else if (view.getId() == R.id.btnSubtrair) {
                calculator.putExtra("operacao", "Subtrair");
            } else if (view.getId() == R.id.btnMultiplicar) {
                calculator.putExtra("operacao", "Multiplicar");
            }else{
                calculator.putExtra("operacao", "Dividir");
            }
            startActivity(calculator);
        }
    }
}