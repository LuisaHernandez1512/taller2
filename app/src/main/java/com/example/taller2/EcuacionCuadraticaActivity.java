package com.example.taller2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class EcuacionCuadraticaActivity extends AppCompatActivity {

    EditText valorA, valorB, valorC;
    Button calcular;
    TextView respuesta_1, respuesta_2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ecuacion_cuadratica);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        valorA=findViewById(R.id.text_num_a);
        valorB=findViewById(R.id.text_num_b);
        valorC=findViewById(R.id.txt_num_c);
        calcular=findViewById(R.id.btn_calcular);
        respuesta_1=findViewById(R.id.respuesta_1);
        respuesta_2=findViewById(R.id.respuesta_2);

        calcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularFormulaGeneral();
            }
        });

    }

    private void calcularFormulaGeneral(){
        double a =Double.parseDouble(valorA.getText().toString());
        double b =Double.parseDouble(valorB.getText().toString());
        double c =Double.parseDouble(valorC.getText().toString());

        double sub= (b*b)-(4*a*c);

        if (sub>0){
            double x1=(-b + Math.sqrt(sub)) / (2*a);
            double x2=(-b - Math.sqrt(sub)) / (2*a);

            respuesta_1.setText("Valor x1= "+x1);
            respuesta_2.setText("Valor x2= "+x2);

        } else if (sub==0) {
            double x= -b/2*a;

            respuesta_1.setText("Valor x= "+x);
            respuesta_2.setText("");

        } else {
            respuesta_1.setText("No hay Valores reales");
            respuesta_2.setText("");

        }


    }



}