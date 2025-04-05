package com.example.taller2;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        ImageView imageView = findViewById(R.id.imagen1);
        imageView.setImageResource(R.drawable.imgprincipal2);

        Button fibonacci= findViewById(R.id.btnfibonacci);
        Button ecuacionC=findViewById(R.id.btnEcuacionc);
        Button ordenarD= findViewById(R.id.btnOrdenard);
        fibonacci.setOnClickListener(this);
        ecuacionC.setOnClickListener(this);
        ordenarD.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        Intent i;
        if(v.getId()==R.id.btnfibonacci){
            i = new Intent(this, FibonacciActivity.class);
            startActivity(i);

        }
        else{
            if(v.getId()==R.id.btnEcuacionc){
                i = new Intent(this, EcuacionCuadraticaActivity.class);
                startActivity(i);

            }
            else{
                if(v.getId()==R.id.btnOrdenard){
                    i = new Intent(this, Ordenar_datosActivity.class);
                    startActivity(i);

                }
            }
        }
    }





}