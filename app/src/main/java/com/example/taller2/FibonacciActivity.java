package com.example.taller2;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class FibonacciActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_fibonacci);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        Button btngenerar= findViewById(R.id.btngenerar);
        EditText Editxtcantidad= findViewById(R.id.text_cantidad);
        TextView respuesta= findViewById(R.id.txtrespuesta);

        btngenerar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String entrada = Editxtcantidad.getText().toString();

                if (!entrada.isEmpty()) {
                    int cantidad = Integer.parseInt(entrada);

                    if (cantidad > 0) {
                        StringBuilder resultado = new StringBuilder();
                        int a = 0, b = 1;

                        for (int i = 0; i < cantidad; i++) {
                            resultado.append(a);

                            if (i < cantidad - 1) {
                                resultado.append(", ");
                            }

                            int siguiente = a + b;
                            a = b;
                            b = siguiente;
                        }

                        respuesta.setText(resultado.toString());
                    } else {
                        respuesta.setText("Ingresa un número mayor que 0.");
                    }
                } else {
                    respuesta.setText("Por favor ingresa un número.");
                }
            }
        });

    }

}