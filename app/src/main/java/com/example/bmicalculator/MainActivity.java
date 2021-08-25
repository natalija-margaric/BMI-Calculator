package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
        //fields or class variables
    private TextView resultText;
    private RadioButton maleButton;
    private RadioButton femaleButton;
    private EditText ageText;
    private EditText feetText;
    private EditText inchesText;
    private EditText weightText;
    private Button calculateButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        findViews();
        setupButtonClickListener();
    }

    private void findViews(){
        //to make field, shortcut is ctrl+alt+F
        resultText = findViewById(R.id.text_view_result);
        maleButton = findViewById(R.id.radio_button_male);
        femaleButton = findViewById(R.id.radio_button_female);
        ageText = findViewById(R.id.edit_text_age);
        feetText = findViewById(R.id.edit_text_feet);
        inchesText = findViewById(R.id.edit_text_inches);
        weightText = findViewById(R.id.edit_text_weight);
        calculateButton = findViewById(R.id.button_calculate);
    }

    private void setupButtonClickListener() {
        calculateButton.setOnClickListener(v -> calculateBMI());
    }

    private void calculateBMI() {
        String age = ageText.getText().toString();
        String feet = feetText.getText().toString();
        String inches = inchesText.getText().toString();
        String weight = weightText.getText().toString();

        //converting the number string into int variables
        int age1 = Integer.parseInt(age);
        int feet1 = Integer.parseInt(feet);
        int inches1 = Integer.parseInt(inches);
        int weight1 = Integer.parseInt(weight);

        int totalInches = (feet1 * 12) + inches1;

        //height in meters is the inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.254;

        //BMI formula = weight in kg divided by height in meters squared
        double bmi = weight1 / (heightInMeters * heightInMeters);

        //we must convert the decimal/double into a string for our textViews
        String bmiTextResult = String.valueOf(bmi);


        resultText.setText(bmiTextResult);
    }


}


