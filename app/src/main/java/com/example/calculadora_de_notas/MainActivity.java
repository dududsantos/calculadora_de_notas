package com.example.calculadora_de_notas;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;


public class MainActivity extends AppCompatActivity {

    private Calculadora fragment1;
    private Notas fragment2;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        fragment1 = new Calculadora();
        fragment2 = new Notas();



        }

        public void iniciarCalculadora(View v){
            FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.frame,fragment1);
            fm.commit();


        }

        public void inciarNotas(View v){
            FragmentTransaction fm = getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.frame,fragment2);
            fm.commit();


        }




}