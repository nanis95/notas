package com.example.diana.notas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class mat4 extends AppCompatActivity {

    public EditText num1,num2,num3;
    public TextView nfinal;
    public double nota1,nota2,nota3,notaf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_mat4);

        num1 = (EditText) findViewById(R.id.notadmin1);
        num2 = (EditText) findViewById(R.id.notadmin2);
        num3 = (EditText) findViewById(R.id.notadmin3);
        nfinal = (TextView) findViewById(R.id.finaladmin);

        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        num1.setText(prefe.getString("nota10",""));
        num2.setText(prefe.getString("nota11",""));
        num3.setText(prefe.getString("nota12",""));

        num1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                nfinal.setText(notadmin(num1.getText().toString(), num2.getText().toString(), num3.getText().toString()));
                almacenar();
            }
        });

        num2.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                nfinal.setText(notadmin(num1.getText().toString(), num2.getText().toString(), num3.getText().toString()));
                almacenar();
            }
        });

        num3.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void afterTextChanged(Editable editable) {
                nfinal.setText(notadmin(num1.getText().toString(), num2.getText().toString(), num3.getText().toString()));
                almacenar();
            }
        });

        calculo();
    }

    public String notadmin(String valor1, String valor2, String valor3){
        if (valor1.equals("") || valor2.equals("") || valor3.equals("")){
            return ("");
        }
        else {
            nota1 = Double.valueOf(valor1)*0.30;
            nota2 = Double.valueOf(valor2)*0.30;
            nota3 = Double.valueOf(valor3)*0.40;

            notaf = nota1+nota2+nota3;

            DecimalFormat formato = new DecimalFormat("#.##");
            String v_nota = formato.format(notaf);

            return (v_nota);
        }
    }

    public void almacenar(){
        SharedPreferences preferencias = getSharedPreferences("datos", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=preferencias.edit();
        editor.putString("nota10", num1.getText().toString());
        editor.putString("nota11", num2.getText().toString());
        editor.putString("nota12", num3.getText().toString());
        editor.commit();
    }

    public void calculo(){
        nfinal.setText(notadmin(num1.getText().toString(), num2.getText().toString(), num3.getText().toString()));
    }

    public void about4(View view){
        Intent i = new Intent(this,Notas.class);
        startActivity(i);
    }
}
