package com.jhonssantiago.imc_aplicativo1;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class ActivityResult extends AppCompatActivity {
    private TextView resultado;
    private TextView viewNome;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);
        resultado = findViewById(R.id.txtViewResultado);
        viewNome = findViewById(R.id.txtViewNome);

        Intent i = getIntent();
        String dados = i.getStringExtra("dados");
        String imc = i.getStringExtra("imc");
        String nome = i.getStringExtra("nome");
        viewNome.setText(nome +", Seu IMC é: "+ imc);
        resultado.setText(dados);
    }
}