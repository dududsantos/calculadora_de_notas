package com.example.calculadora_de_notas;

import android.annotation.SuppressLint;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


public class Notas extends Fragment {


    public Notas() {
        // Required empty public constructor
    }


    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_notas, container, false);


        TextView nota01 = (EditText) view.findViewById(R.id.nota01);
        TextView nota02 = (EditText) view.findViewById(R.id.nota02);
        TextView nota03 = (EditText) view.findViewById(R.id.nota03);



        Button calc = (Button) view.findViewById(R.id.calcular);
        TextView situacao = (TextView) view.findViewById(R.id.situationText);
        TextView description = (TextView) view.findViewById(R.id.description);



        calc.setOnClickListener(new View.OnClickListener() {
            @SuppressLint("SetTextI18n")
            @Override
            public void onClick(View view) {
                double n01 = 0;
                double n02 = 0;
                double n03 = 0;

                if(!nota01.getText().toString().isEmpty()) {
                     n01 = Double.parseDouble(nota01.getText().toString());
                }
                if(!nota02.getText().toString().isEmpty()) {
                     n02 = Double.valueOf(nota02.getText().toString());
                }

                if(!nota03.getText().toString().isEmpty()) {
                     n03 = Double.valueOf(nota03.getText().toString());
                }



                double mediaAluno = (n01 + n02 + n03) /3;
                String mediaTratada = String.format("%.1f", mediaAluno);

                description.setText(" ");

               if (mediaAluno>=7){
                    situacao.setText("APROVADO POR MÉDIA COM: " + mediaTratada);
                   Toast.makeText(getActivity(),"Aprovado por Média!",Toast.LENGTH_LONG).show();
                }
               if (mediaAluno>= 5 && mediaAluno <7 ) {
                    situacao.setText("APROVADO POR NOTA COM: " + mediaTratada);
                   Toast.makeText(getActivity(),"Aprovado por Nota!",Toast.LENGTH_LONG).show();
               }
               else {
                   situacao.setText("REPROVADO COM: " + mediaTratada);
                   Toast.makeText(getActivity(),"Reprovado :(",Toast.LENGTH_LONG).show();
               }
            }
        });


        nota01.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!nota01.getText().toString().isEmpty()) {
                    double notaApvMedia = 21 - Double.valueOf(nota01.getText().toString());
                    String notaApvMediaTratada = String.format("%.1f", notaApvMedia / 2);

                    double notaApvNota = 15 - Double.valueOf(nota01.getText().toString());
                    String notaApvNotaTratada = String.format("%.1f", notaApvNota / 2);

                    if(Double.valueOf(nota01.getText().toString()) >=1) {
                        description.setText("Você precisa de: " + notaApvMediaTratada + " na U2, e de: " + notaApvMediaTratada + " na U3 para ser aprovado por média");
                    }
                    description.append("\n");
                    description.append("E precisa de: " + notaApvNotaTratada + " na U2, e de: " + notaApvNotaTratada + " na U3 para ser aprovado por Nota");
                }
                else {
                    description.setText(" ");
                }
            }

            @Override
            public void afterTextChanged(Editable editable) {
                situacao.setText(" ");

            }
        });

        nota02.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {

            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {

                if (!nota01.getText().toString().isEmpty() && !nota02.getText().toString().isEmpty()) {
                    double notaApvMedia = 21 - Double.valueOf(nota01.getText().toString()) - Double.valueOf(nota02.getText().toString());
                    String notaApvMediaTratada = String.format("%.1f", notaApvMedia );

                    double notaApvNota = 15 - Double.valueOf(nota01.getText().toString()) - Double.valueOf(nota02.getText().toString());
                    String notaApvNotaTratada = String.format("%.1f", notaApvNota );

                    if(Double.valueOf(nota01.getText().toString()) >=1) {
                        description.setText("Você precisa de: " + notaApvMediaTratada + " na U3 para ser aprovado por média");
                    }
                    description.append("\n");
                    description.append("E precisa de: " + notaApvNotaTratada + " na U3 para ser aprovado por Nota");
                }
                else {
                    description.setText(" ");
                }

            }

            @Override
            public void afterTextChanged(Editable editable) {
                situacao.setText(" ");
            }
        });


        return view;
    }


}

