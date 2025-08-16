package com.example.calculadora;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnEntrar = findViewById(R.id.btnEntrar);
        btnEntrar.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view){
                Intent telaHome = new Intent(MainActivity.this, HomeActivity.class);
                startActivity(telaHome);
                finish();
            }
        });
    }
}