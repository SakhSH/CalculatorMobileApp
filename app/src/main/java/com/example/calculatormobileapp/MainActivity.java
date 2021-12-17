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

    private static final String NAME_SAVE = "saveTextView";

    private TextView textView;

    private boolean sumBoolean;

    private double numOne;
    private double numTwo;
    private double numSum;

    private int counter = 0;


    private Button sum, zero, plus, three, two, one,
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
        zero.setOnClickListener(view -> numberButtonClick("0"));
        plus.setOnClickListener(view -> plusButton());
        three.setOnClickListener(view -> numberButtonClick("3"));
        two.setOnClickListener(view -> numberButtonClick("2"));
        one.setOnClickListener(view -> numberButtonClick("1"));
        minus.setOnClickListener(view -> minusButton());
        six.setOnClickListener(view -> numberButtonClick("6"));
        five.setOnClickListener(view -> numberButtonClick("5"));
        four.setOnClickListener(view -> numberButtonClick("4"));
        multiply.setOnClickListener(view -> multiplyButton());
        nine.setOnClickListener(view -> numberButtonClick("9"));
        eight.setOnClickListener(view -> numberButtonClick("8"));
        seven.setOnClickListener(view -> numberButtonClick("7"));
        divideUp.setOnClickListener(view -> divideUpButton());
        clearText.setOnClickListener(view -> clearTextButton());
    }

    private void numberButtonClick(String number) {
        if(counter == 9){
            return;
        }

        if (sumBoolean){
            textView.setText("");
            sumBoolean = false;
        }
        textView.append(number);
        counter++;
    }

    private void clearTextButton() {
        textView.setText("");
        numTwo = 0;
        numOne = 0;
        numSum = 0;
        counter = 0;
    }

    private void divideUpButton() {

        if (textView.getText() == null | textView.getText().toString().contains("*") | textView.getText().toString().contains("/")
                | textView.getText().toString().contains("-") | textView.getText().toString().contains("+")) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
        } else {
            numOne = Double.parseDouble(textView.getText().toString().trim());
            textView.append("/");
        }

        sumBoolean = false;
        counter = 0;

    }

    private void multiplyButton() {
        if (textView.getText() == null | textView.getText().toString().contains("*") | textView.getText().toString().contains("/")
                | textView.getText().toString().contains("-") | textView.getText().toString().contains("+")) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
        } else {
            numOne = Double.parseDouble(textView.getText().toString().trim());
            textView.append("*");
        }

        sumBoolean = false;
        counter = 0;

    }

    private void minusButton() {
        if (textView.getText() == null | textView.getText().toString().contains("*") | textView.getText().toString().contains("/")
                | textView.getText().toString().contains("-") | textView.getText().toString().contains("+")) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
        } else {
            numOne = Double.parseDouble(textView.getText().toString().trim());
            textView.append("-");
        }

        sumBoolean = false;
        counter = 0;

    }

    private void plusButton() {
        if (textView.getText() == null | textView.getText().toString().contains("*") | textView.getText().toString().contains("/")
                | textView.getText().toString().contains("-") | textView.getText().toString().contains("+")) {
            Toast.makeText(this, "Введите число!", Toast.LENGTH_SHORT).show();
        } else {
            numOne = Double.parseDouble(textView.getText().toString().trim());
            textView.append("+");
        }

        sumBoolean = false;
        counter = 0;

    }

    private void sumButton() {

        String str = textView.getText().toString().trim();

        if (str.isEmpty()) { return; }

        if (str.contains("+")) {
            str = str.substring(str.indexOf("+") + 1);

            if(!str.isEmpty()){
                numTwo = Double.parseDouble(str);
                numSum = numOne + numTwo;
            }else {
                return;
            }
        } else if (str.contains("-")) {
            str = str.substring(str.indexOf("-") + 1);

            if(!str.isEmpty()) {
                numTwo = Double.parseDouble(str);
                numSum = numOne - numTwo;
            }else {
                return;
            }
        } else if (str.contains("*")) {
            str = str.substring(str.indexOf("*") + 1);

            if(!str.isEmpty()) {
                numTwo = Double.parseDouble(str);
                numSum = numOne * numTwo;
            }else {
                return;
            }
        } else if (str.contains("/")) {

            str = str.substring(str.indexOf("/") + 1);

            if(!str.isEmpty()) {
                numTwo = Double.parseDouble(str);

                if (numOne == 0 | numTwo == 0) {
                    Toast.makeText(this, "Произошел взрыв вселейнной!!!", Toast.LENGTH_SHORT).show();
                    clearTextButton();
                } else {
                    numSum = numOne / numTwo;
                }
            }else {
                return;
            }
        }

        numTwo = Double.parseDouble(str);

        if (numSum < 100000000000.0) {
            textView.append("=" + numSum);
            textView.setText(String.valueOf(numSum));
        } else {
            Toast.makeText(this, "Слишком большое число!", Toast.LENGTH_SHORT).show();
            textView.setText("");
        }

        numOne = numSum;
        numTwo = 0;
        numSum = 0;

        sumBoolean = true;
    }

    // сохранение состояния
    @Override
    protected void onSaveInstanceState(Bundle outState) {

        outState.putString(NAME_SAVE, textView.getText().toString().trim());
        super.onSaveInstanceState(outState);
    }
    // получение ранее сохраненного состояния
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        super.onRestoreInstanceState(savedInstanceState);

        String name;

        name = savedInstanceState.getString(NAME_SAVE);
        textView.setText(name);

        counter = 0;

    }

}