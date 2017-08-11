package com.example.q1.calculator;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.Editable;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int result = 0;
    boolean add = false;
    boolean sub = false;
    boolean div = false;
    boolean mul = false;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void Add(View v) {
        add = true;
        sub = div = mul = false;
    }

    public void Div(View v) {
        div = true;
        sub = add = mul = false;
    }

    public void Sub(View v) {
        sub = true;
        add = div = mul = false;
    }

    public void Mul(View v) {
        mul = true;
        sub = div = add = false;

    }

    public void CalculateResult(View V) {
        EditText number1 = (EditText) findViewById(R.id.textbox_num1);
        Editable num1 = number1.getText();

        EditText number2 = (EditText) findViewById(R.id.textbox_num2);
        Editable num2 = number2.getText();
        if (add == true)
            result = Integer.parseInt(num2.toString()) + Integer.parseInt(num1.toString());
        else if (sub == true)
            result = Integer.parseInt(num2.toString()) - Integer.parseInt(num1.toString());
        else if (mul == true)
            result = Integer.parseInt(num2.toString()) * Integer.parseInt(num1.toString());
        else if (div == true)
        {
            if(Integer.parseInt(num2.toString())!=0)
            result = Integer.parseInt(num1.toString()) / Integer.parseInt(num2.toString());
            else
            {
                Toast.makeText(this,"You can't Divide By Zero",Toast.LENGTH_SHORT);
                return;
            }
        }
        Display();
    }

    public void Display() {
        TextView res = (TextView) findViewById(R.id.result_text_box);
        res.setText("" + result);
    }
}
