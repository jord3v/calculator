package com.example.calculadora;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class CalculatorActivity extends AppCompatActivity implements View.OnClickListener {

    private String operacao = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calculator);

        Button btnVoltar = findViewById(R.id.btnVoltar);
        btnVoltar.setOnClickListener(this);

        Button btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setOnClickListener(this);

        TextView tvTitle = findViewById(R.id.tvTitle);

        String title = getIntent().getStringExtra("operacao");
        operacao = title;
        tvTitle.setText(title.concat(" números"));
    }

    @Override
    public void onClick(View view) {
        if(view.getId() == R.id.btnVoltar){
            finish();
        }else if(view.getId() == R.id.btnCalcular){
            calcular();
        }
    }

    private void calcular(){
        EditText txtNumber1 = findViewById(R.id.txtNumber1);
        EditText txtNumber2 = findViewById(R.id.txtNumber2);

        int n1 = Integer.parseInt(txtNumber1.getText().toString());
        int n2 = Integer.parseInt(txtNumber2.getText().toString());

        int resultado = 0;
        switch (operacao){
            case "Somar":
                resultado = n1 + n2;
                break;
            case "Subtrair":
                resultado = n1 - n2;
                break;
            case "Multiplicar":
                resultado = n1 * n2;
                break;
            case "Dividir":
                resultado = n1 / n2;
                break;
            default:
        }
        Toast.makeText(CalculatorActivity.this,
                "Resultado: ".concat(String.valueOf(resultado)),
                Toast.LENGTH_LONG)
                .show();

    }
}