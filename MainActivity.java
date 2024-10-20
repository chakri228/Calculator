package com.example.myapp01;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements OnClickListener {
    Button buttonAdd, buttonSub, buttonMul, buttonDiv;
    EditText editTextN1, editTextN2;
    TextView textview;
    int num1, num2;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        buttonAdd = findViewById(R.id.btn_add);
        buttonSub = findViewById(R.id.btn_sub);
        buttonMul = findViewById(R.id.btn_mul);
        buttonDiv = findViewById(R.id.btn_div);
        editTextN1 = findViewById(R.id.number1);
        editTextN2 = findViewById(R.id.number2);
        textview = findViewById(R.id.answer);

        buttonAdd.setOnClickListener(this);
        buttonSub.setOnClickListener(this);
        buttonMul.setOnClickListener(this);
        buttonDiv.setOnClickListener(this);
    }

    public int getIntFromEditText(EditText editText) {
        if (Objects.equals(editText.getText().toString(), "")) {
            Toast.makeText(this, "Enter number", Toast.LENGTH_SHORT).show();
            return 0;
        } else
            return Integer.parseInt(editText.getText().toString());
    }
    @SuppressLint({"DefaultLocale", "SetTextI18n"})
    @Override
    public void onClick(View view) {
        num1 = getIntFromEditText(editTextN1);
        num2 = getIntFromEditText(editTextN2);
        if (view.getId() == R.id.btn_add) {
            textview.setText(String.format("Answer = %d", num1 + num2));
        } else if (view.getId() == R.id.btn_sub) {
            textview.setText(String.format("Answer = %d", num1 - num2));
        } else if (view.getId() == R.id.btn_mul) {
            textview.setText(String.format("Answer = %d", num1 * num2));
        } else if (view.getId() == R.id.btn_div) {
            if (num2 == 0) {
                Toast.makeText(this, "Cannot divide by zero", Toast.LENGTH_SHORT).show();
                textview.setText("Undefined");
            } else {
                double result = (double) num1 / num2;
                textview.setText(String.format("Answer = %.2f", result));
            }
        } else {
            throw new IllegalStateException("Unexpected value: " + view.getId());
        }
    }
}
