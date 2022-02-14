package com.jhonssantiago.imc_aplicativo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private EditText nome;
    private EditText peso;
    private EditText altura;
    private Button botao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nome = findViewById(R.id.txtNome);
        peso = findViewById(R.id.txtPeso);
        altura = findViewById(R.id.txtAltura);
        botao = findViewById(R.id.btnCalcular);

        botao.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
               String stringPeso = peso.getText().toString();
               String stringAltura = altura.getText().toString();
               String stringnome = nome.getText().toString();
               String calculo = "";
               double intPeso = Double.parseDouble(stringPeso);
               double intAltura = Double.parseDouble(stringAltura);
               double resultado = intPeso/(intAltura * intAltura);

               double imc = (double) (Math.round(resultado*10.0)/10.0);

               if (imc < 18.5)
                   calculo = "Magreza";
               if (imc >= 18.5 && imc <= 24.9)
                   calculo = "Saudável";
               if (imc >= 25 && imc <= 29.9)
                   calculo = "Sobrepeso";
               if (imc >= 30 && imc <= 34.9)
                   calculo = "Obesidade Grau I";
               if (imc >= 35 && imc <= 39.9)
                   calculo = "Obesidade Severa Grau II";
               if (imc >= 40)
                   calculo = "Obesidade Mórbida Grau III";


                Intent it = new Intent(MainActivity.this, ActivityResult.class);
               it.putExtra("dados", calculo);
               it.putExtra("imc", String.valueOf(imc));
               it.putExtra("nome", stringnome);
               startActivity(it);
            }//onClick
        });

    }//onCreate

}//class