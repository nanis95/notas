package com.example.diana.notas;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.icu.text.DecimalFormat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class Notas extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notas);
    }

    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_ppal,menu);
        return true;
    }

    public boolean onOptionsItemSelected(MenuItem item){
        switch (item.getItemId()){
            case R.id.mat1:
                mat1();
                return true;
            case R.id.mat2:
                mat2();
                return true;
            case R.id.mat3:
                mat3();
                return true;
            case  R.id.mat4:
                mat4();
                return true;
            case R.id.mat5:
                mat5();
                return true;
            case R.id.about:
                informacion();
                return true;
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    public void informacion(){
        Intent i = new Intent(this,about.class);
        startActivity(i);
    }

    public void mat1(){
        Intent i = new Intent(this,mat1.class);
        startActivity(i);
    }

    public void mat2(){
        Intent i = new Intent(this,mat2.class);
        startActivity(i);
    }

    public void mat3(){
        Intent i = new Intent(this,mat3.class);
        startActivity(i);
    }

    public void mat4(){
        Intent i = new Intent(this,mat4.class);
        startActivity(i);
    }

    public void mat5(){
        Intent i = new Intent(this,mat5.class);
        startActivity(i);
    }

    public void promFinal(View view){
        SharedPreferences prefe = getSharedPreferences("datos", Context.MODE_PRIVATE);
        double n1 = Double.valueOf(prefe.getString("nota1","0"))*0.30;
        double n2 = Double.valueOf(prefe.getString("nota2","0"))*0.30;
        double n3 = Double.valueOf(prefe.getString("nota3","0"))*0.40;
        double final1 = n1+n2+n3;

        double n4 = Double.valueOf(prefe.getString("nota4","0"))*0.30;
        double n5 = Double.valueOf(prefe.getString("nota5","0"))*0.30;
        double n6 = Double.valueOf(prefe.getString("nota6","0"))*0.40;
        double final2 = n4+n5+n6;

        double n7 = Double.valueOf(prefe.getString("nota7","0"))*0.30;
        double n8 = Double.valueOf(prefe.getString("nota8","0"))*0.30;
        double n9 = Double.valueOf(prefe.getString("nota9","0"))*0.40;
        double final3 = n7+n8+n9;

        double n10 = Double.valueOf(prefe.getString("nota10","0"))*0.30;
        double n11 = Double.valueOf(prefe.getString("nota11","0"))*0.30;
        double n12 = Double.valueOf(prefe.getString("nota12","0"))*0.40;
        double final4 = n10+n11+n12;

        double n13 = Double.valueOf(prefe.getString("nota13","0"))*0.30;
        double n14 = Double.valueOf(prefe.getString("nota14","0"))*0.30;
        double n15 = Double.valueOf(prefe.getString("nota15","0"))*0.40;
        double final5 = n13+n14+n15;

        double nf = (final1+final2+final3+final4+final5)/5;

        DecimalFormat formato = new DecimalFormat("#.##");
        String nota = formato.format(nf);


        Toast msg = Toast.makeText(getApplicationContext(),getResources().getString(R.string.toast) + " " + nota, Toast.LENGTH_SHORT);
        msg.show();
    }
}
