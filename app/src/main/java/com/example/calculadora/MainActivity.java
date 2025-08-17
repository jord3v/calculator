package com.example.calculadora;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(this);

        Button btnViagem = findViewById(R.id.btnViagem);
        btnViagem.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        Intent calculator = new Intent(MainActivity.this, HomeActivity.class);
        Intent trip = new Intent(MainActivity.this, TripActivity.class);
        if(view.getId() == R.id.btnEntrar){
            startActivity(calculator);
        }else{
            startActivity(trip);
        }
    }
}