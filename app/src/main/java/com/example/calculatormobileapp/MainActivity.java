package com.example.calculatormobileapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private TextView textView;

    private double numOne;
    private double numTwo;
    private double numSum;


    private Button sum, zero, twoZeros, plus, three, two, one,
            minus, six, five, four, multiply, nine, eight, seven, divideUp,
            clearText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        textView = findViewById(R.id.textView);

        sum = findViewById(R.id.sum);
        zero = findViewById(R.id.zero);
        twoZeros = findViewById(R.id.twoZeros);
        plus = findViewById(R.id.plus);
        three = findViewById(R.id.three);
        two = findViewById(R.id.two);
        one = findViewById(R.id.one);
        minus = findViewById(R.id.minus);
        six = findViewById(R.id.six);
        five = findViewById(R.id.five);
        four = findViewById(R.id.four);
        multiply = findViewById(R.id.multiply);
        nine = findViewById(R.id.nine);
        eight = findViewById(R.id.eight);
        seven = findViewById(R.id.seven);
        divideUp = findViewById(R.id.divideUp);
        clearText = findViewById(R.id.clearText);

        sum.setOnClickListener(view -> sumButton());
        zero.setOnClickListener(view -> zeroButton());
        twoZeros.setOnClickListener(view -> twoZerosButton());
        plus.setOnClickListener(view -> plusButton());
        three.setOnClickListener(view -> threeButton());
        two.setOnClickListener(view -> twoButton());
        one.setOnClickListener(view -> oneButton());
        minus.setOnClickListener(view -> minusButton());
        six.setOnClickListener(view -> sixButton());
        five.setOnClickListener(view -> fiveButton());
        four.setOnClickListener(view -> fourButton());
        multiply.setOnClickListener(view -> multiplyButton());
        nine.setOnClickListener(view -> nineButton());
        eight.setOnClickListener(view -> eightButton());
        seven.setOnClickListener(view -> sevenButton());
        divideUp.setOnClickListener(view -> divideUpButton());
        clearText.setOnClickListener(view -> clearTextButton());
    }

    private void clearTextButton() {
        textView.setText("");
        numTwo = 0;
        numOne = 0;
        numSum = 0;
    }

    private void divideUpButton() {

        if (textView.length() < 1 | textView.getText().toString().contains("/") | textView.getText().toString().contains("*")
                | textView.getText().toString().contains("-") | textView.getText().toString().contains("+")) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
        } else {
            numOne = Double.parseDouble(textView.getText().toString().trim());
            textView.append("/");
        }
    }

    private void sevenButton() {
        textView.append("7");

    }

    private void eightButton() {
        textView.append("8");
    }

    private void nineButton() {
        textView.append("9");
    }

    private void multiplyButton() {
        if (textView.length() < 1 | textView.getText().toString().contains("*") | textView.getText().toString().contains("/")
                | textView.getText().toString().contains("-") | textView.getText().toString().contains("+")) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
        } else {
            numOne = Double.parseDouble(textView.getText().toString().trim());
            textView.append("*");
        }
    }

    private void fourButton() {
        textView.append("4");
    }

    private void fiveButton() {
        textView.append("5");
    }

    private void sixButton() {
        textView.append("6");
    }

    private void minusButton() {
        if (textView.length() < 1 | textView.getText().toString().contains("*") | textView.getText().toString().contains("/")
                | textView.getText().toString().contains("-") | textView.getText().toString().contains("+")) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
        } else {
            numOne = Double.parseDouble(textView.getText().toString().trim());
            textView.append("-");
        }
    }

    private void oneButton() {
        textView.append("1");
    }

    private void twoButton() {
        textView.append("2");
    }

    private void threeButton() {
        textView.append("3");
    }

    private void plusButton() {
        if (textView.length() < 1 | textView.getText().toString().contains("*") | textView.getText().toString().contains("/")
                | textView.getText().toString().contains("-") | textView.getText().toString().contains("+")) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
        } else {
            numOne = Double.parseDouble(textView.getText().toString().trim());
            textView.append("+");
        }
    }

    private void twoZerosButton() {
        textView.append("00");
    }

    private void zeroButton() {
        textView.append("0");
    }

    private void sumButton() {

        String str = textView.getText().toString().trim();

        if (str.contains("+")) {
            str = str.substring(str.indexOf("+") + 1);
            numTwo = Double.parseDouble(str);
            numSum = numOne + numTwo;
        } else if (str.contains("-")) {
            str = str.substring(str.indexOf("-") + 1);
            numTwo = Double.parseDouble(str);
            numSum = numOne - numTwo;
        } else if (str.contains("*")) {
            str = str.substring(str.indexOf("*") + 1);
            numTwo = Double.parseDouble(str);
            numSum = numOne * numTwo;
        } else if (str.contains("/")) {

            str = str.substring(str.indexOf("/") + 1);
            numTwo = Double.parseDouble(str);

            if (numOne == 0 | numTwo == 0) {
                Toast.makeText(this, "Произошел взрыв вселейнной!", Toast.LENGTH_SHORT).show();
                clearTextButton();
            } else {
                numSum = numOne / numTwo;
            }
        }

        numTwo = Double.parseDouble(str);


        if (numSum < 100000000000.0) {
            textView.append("=" + numSum);
            textView.setText(String.valueOf(numSum));

            numOne = numSum;
            numTwo = 0;
            numSum = 0;
        } else {
            Toast.makeText(this, "Слишком большое число!", Toast.LENGTH_SHORT).show();
            textView.setText("");

            numOne = numSum;
            numTwo = 0;
            numSum = 0;
        }


    }
}