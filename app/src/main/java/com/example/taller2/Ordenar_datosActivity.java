package com.example.taller2;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Ordenar_datosActivity extends AppCompatActivity {
    EditText entradaNumeros;
    RadioGroup radioGroupOrden;
    RadioButton rbAscendente, rbDescendente;
    Button btnOrdenar;
    TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_ordenar_datos);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        entradaNumeros = findViewById(R.id.entradaNumeros);
        radioGroupOrden = findViewById(R.id.radioGroupOrden);
        rbAscendente = findViewById(R.id.rbAscendente);
        rbDescendente = findViewById(R.id.rbDescendente);
        btnOrdenar = findViewById(R.id.btnOrdenar);
        textResultado = findViewById(R.id.textResultado);

        btnOrdenar.setOnClickListener(view -> {
            String texto = entradaNumeros.getText().toString().trim();
            if (texto.isEmpty()) {
                textResultado.setText("Por favor ingresa algunos números.");
                return;
            }

            String[] numerosStr = texto.split(",");
            List<Integer> numeros = new ArrayList<>();

            try {
                for (String num : numerosStr) {
                    numeros.add(Integer.parseInt(num.trim()));
                }
            } catch (NumberFormatException e) {
                textResultado.setText("Verifica que todos los valores sean números.");
                return;
            }

            boolean asc = rbAscendente.isChecked();

            if (asc) {
                Collections.sort(numeros);
            } else {
                Collections.sort(numeros, Collections.reverseOrder());
            }

            textResultado.setText("Resultado: " + numeros.toString());
        });
    }
}