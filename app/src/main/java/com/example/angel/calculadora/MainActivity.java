package com.example.angel.calculadora;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridLayout;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Arrays;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    GridLayout gridLayout;
    EditText edtNumber;
    ArrayList<Button> botones = new ArrayList<>();
    double n1, n2;
    String op = "Sin valor";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        gridLayout = findViewById(R.id.grLayout);
        edtNumber = (EditText)gridLayout.getChildAt(0);

        for (int i = 1; i < gridLayout.getChildCount(); i++){
            botones.add((Button) gridLayout.getChildAt(i));
            botones.get(botones.size()-1).setOnClickListener(this);
        }
    }

    @Override
    public void onClick(View v) {
        Button n = (Button)v;
        String s = (String) n.getText();
        double res;
        ArrayList<String> operaciones =
                new ArrayList<String>(Arrays.asList("+","-","*","/"));

        ArrayList<String> numeros =
                new ArrayList<String>(Arrays.asList("0","1","2","3","4","5","6","7","8","9","."));
        if (numeros.contains(s)) {
            if (edtNumber.getText().toString().equals("0")){
                edtNumber.setText(s);
            } else {
                edtNumber.setText(edtNumber.getText() + s);
            }
        }

        if (s.toUpperCase().equals("C")) {
            n1 = 0;
            n2 = 0;
        }

        if (s.toUpperCase().equals("DEL")) {
            edtNumber.setText("");
        }

        if (operaciones.contains(s)) {
                op = String.valueOf(s);
                n1 = Double.parseDouble(edtNumber.getText().toString());
                edtNumber.setText("");
        }

        if (s.equals("=")){
            n2 = Double.parseDouble(edtNumber.getText().toString());
            if (op.equals("+")){
                res = n1+n2;
                edtNumber.setText(String.valueOf(res));
            } else if (op.equals("-")){
                res = n1-n2;
                edtNumber.setText(String.valueOf(res));
            } else if (op.equals("*")){
                res = n1*n2;
                edtNumber.setText(String.valueOf(res));
            } else if (op.equals("/")){
                res = n1/n2;
                edtNumber.setText(String.valueOf(res));
            }
        }

        if (s.equals("OFF")){
            finish();
        }
    }

}
