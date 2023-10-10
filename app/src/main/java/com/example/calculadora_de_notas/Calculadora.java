package com.example.calculadora_de_notas;


import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import org.mariuszgromada.math.mxparser.Expression;




public class Calculadora extends Fragment {



    public Calculadora() {
        // Required empty public constructor
    }


//    public static Calculadora newInstance(String param1, String param2) {
//        Calculadora fragment = new Calculadora();
//        Bundle args = new Bundle();
//        args.putString(ARG_PARAM1, param1);
//        args.putString(ARG_PARAM2, param2);
//        fragment.setArguments(args);
//        return fragment;
//    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
    View viewF = inflater.inflate(R.layout.fragment_calculadora, container, false);



        //pegando os botões pela id
        Button button1 =  viewF.findViewById(R.id.button1);
        Button button2 =  viewF.findViewById(R.id.button2);
        Button button3 =   viewF.findViewById(R.id.button3);
        Button button4 =   viewF.findViewById(R.id.button4);
        Button button5 =   viewF.findViewById(R.id.button5);
        Button button6 =   viewF.findViewById(R.id.button6);
        Button button7 =   viewF.findViewById(R.id.button7);
        Button button8 =   viewF.findViewById(R.id.button8);
        Button button9 =   viewF.findViewById(R.id.button9);
        Button button0 =   viewF.findViewById(R.id.button0);
        Button buttonPlus =   viewF.findViewById(R.id.buttonPlus);
        Button buttonMinus =   viewF.findViewById(R.id.buttonMinus);
        Button buttonDiv =   viewF.findViewById(R.id.buttonDiv);
        Button buttonMulti =   viewF.findViewById(R.id.buttonMulti);
        Button buttonDel =   viewF.findViewById(R.id.buttonDEL);
        Button buttonResult =   viewF.findViewById(R.id.buttonResult);



        //adicionando onClick nos botões
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("1", true,viewF);
            }
        });

        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("2", true,viewF);
            }
        });

        button3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("3", true,viewF);
            }
        });

        button4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("4", true,viewF);
            }
        });

        button5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("5", true,viewF);
            }
        });

        button6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("6", true,viewF);
            }
        });

        button7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("7", true,viewF);
            }
        });

        button8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("8", true,viewF);
            }
        });

        button9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("9", true,viewF);
            }
        });

        button0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("0", true,viewF);
            }
        });

        //operators
        buttonPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("+", false,viewF);
            }
        });

        buttonMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("-", false,viewF);
            }
        });

        buttonDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("/", false,viewF);
            }
        });

        buttonMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                addExpression("*", false,viewF);
            }
        });

        //pegando os textViews pelos ids
        TextView expression = (TextView)  viewF.findViewById(R.id.expression);
        TextView result = (TextView)  viewF.findViewById(R.id.result);



        buttonDel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String cast = expression.getText().toString();

                if(!cast.isEmpty()){
                    expression.setText(cast.substring(0,cast.length()-1));
                }
                result.setText(" ");
            }
        });


        //criação do toast
      Toast invalid =  Toast.makeText(getActivity(),"Operação Não Permitida",Toast.LENGTH_LONG);

        buttonResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Expression expressao = new Expression(expression.getText().toString());
                double resultado = expressao.calculate();


                if(Double.isNaN(resultado)){
                   invalid.show();
                    result.setText(" ");
                }
                else{
                    result.setText((CharSequence) String.valueOf(resultado));
                }

            }
        });


        // Inflate the layout for this fragment
        return viewF;
    }
    public void addExpression(String string, Boolean dado , View view){


         TextView expression = view.findViewById(R.id.expression);
         TextView result = view.findViewById(R.id.result);


        if(result.getText().equals("")){
            expression.setText(" ");
        }
        if(dado){
            result.setText(" ");
            expression.append(string);
        }
        else{
            expression.append(result.getText());
            expression.append(string);
            result.setText(" ");
        }
    }
}