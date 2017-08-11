package com.example.q1.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    double result = 0;
    boolean add_ = false;
    boolean sub_ = false;
    boolean div_ = false;
    boolean mul_ = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void add(View v) {
        add_ = true;
        sub_ = div_ = mul_ = false;
    }

    public void div(View v) {
        div_ = true;
        sub_ = add_ = mul_ = false;
    }

    public void sub(View v) {
        sub_ = true;
        add_ = div_ = mul_ = false;
    }

    public void mul(View v) {
        mul_ = true;
        sub_ = div_ = add_ = false;

    }

    public void calculateResult(View V) {
        EditText number1 = (EditText) findViewById(R.id.et_number1);
        Editable num1 = number1.getText();

        EditText number2 = (EditText) findViewById(R.id.et_number2);
        Editable num2 = number2.getText();
        if (add_ == true && num2.length() != 0 && num1.length() != 0)
            result = Double.parseDouble(num1.toString()) + Double.parseDouble(num2.toString());
        else if (sub_ == true && num2.length() != 0 && num1.length() != 0)
            result = Double.parseDouble(num1.toString()) - Double.parseDouble(num2.toString());
        else if (mul_ == true && num1.length() != 0 && num2.length() != 0)
            result = Double.parseDouble(num2.toString()) * Double.parseDouble(num1.toString());
        else if (div_ == true && num2.length() != 0 && num1.length() != 0) {
            if (Double.parseDouble(num2.toString()) != 0)
                result = Double.parseDouble(num1.toString()) / Double.parseDouble(num2.toString());
            else {
                Toast.makeText(this, "You can't Divide By Zero", Toast.LENGTH_SHORT).show();
            }
        } else {
            Toast.makeText(this,"Please Check That You Entered Both Numbers",Toast.LENGTH_SHORT).show();
            return;
        }
        display();
    }

    public void display() {
        TextView res = (TextView) findViewById(R.id.tv_result);
        res.setText("" + result);
    }
}
