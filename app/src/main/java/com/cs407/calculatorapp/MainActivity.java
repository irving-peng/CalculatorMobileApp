package com.cs407.calculatorapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.text.InputFilter;
import android.text.Spanned;
import android.view.View;
import android.widget.EditText;

import java.util.regex.Pattern;

public class MainActivity extends AppCompatActivity {
    InputFilter filter = new InputFilter() {
        public CharSequence filter(CharSequence source, int start, int end, Spanned dest, int dstart, int dend) {
            // Iterate through each character in the source text
            for (int i = start; i < end; i++) {
                char character = source.charAt(i);

                // Check if the character is not a digit and not a minus sign (for negative numbers)
                if (!Character.isDigit(character) && character != '-') {
                    return "";
                }
            }

            return null; // Accept the input
        }
    };
    public void clickFunctionPlus(View view){
        EditText editText1 = (EditText) findViewById(R.id.editTextText);
        editText1.setFilters(new InputFilter[]{filter});
        EditText editText2 = (EditText) findViewById(R.id.editTextText2);
        editText2.setFilters(new InputFilter[]{filter});
        String text1 = editText1.getText().toString();
        Integer num1 = Integer.parseInt(text1);
        String text2 = editText2.getText().toString();
        Integer num2 = Integer.parseInt(text2);
        Integer result = num1 + num2 ;
        goToActivity(result);
    }
    public void clickFunctionMinus(View view){
        EditText editText1 = (EditText) findViewById(R.id.editTextText);
        editText1.setFilters(new InputFilter[]{filter});
        EditText editText2 = (EditText) findViewById(R.id.editTextText2);
        editText2.setFilters(new InputFilter[]{filter});
        String text1 = editText1.getText().toString();
        Integer num1 = Integer.parseInt(text1);
        String text2 = editText2.getText().toString();
        Integer num2 = Integer.parseInt(text2);
        Integer result = num1 - num2;
        goToActivity(result);
    }
    public void clickFunctionTimes(View view){
        EditText editText1 = (EditText) findViewById(R.id.editTextText);
        editText1.setFilters(new InputFilter[]{filter});
        EditText editText2 = (EditText) findViewById(R.id.editTextText2);
        editText2.setFilters(new InputFilter[]{filter});
        String text1 = editText1.getText().toString();
        Integer num1 = Integer.parseInt(text1);
        String text2 = editText2.getText().toString();
        Integer num2 = Integer.parseInt(text2);
        Integer result = num1 * num2;
        goToActivity(result);
    }
    public void clickFunctionDivide(View view){
        EditText editText1 = (EditText) findViewById(R.id.editTextText);
        editText1.setFilters(new InputFilter[]{filter});
        EditText editText2 = (EditText) findViewById(R.id.editTextText2);
        editText2.setFilters(new InputFilter[]{filter});
        String text1 = editText1.getText().toString();
        Integer num1 = Integer.parseInt(text1);
        String text2 = editText2.getText().toString();
        Integer num2 = Integer.parseInt(text2);
        if (num2 == 0 ){
            goToActivity(null);
        }
        Integer result = num1 / num2;
        goToActivity(result);
    }

    public void goToActivity(Integer i){
        Intent intent = new Intent (this,Output.class);
        if(i == null){
            intent.putExtra("message","ERROR");
        }
        else {
            intent.putExtra("message", i.toString());
        }
        startActivity(intent);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editText1 = findViewById(R.id.editTextText);
        editText1.setFilters(new InputFilter[]{filter});
        EditText editText2 = findViewById(R.id.editTextText2);
        editText2.setFilters(new InputFilter[]{filter});
    }
}