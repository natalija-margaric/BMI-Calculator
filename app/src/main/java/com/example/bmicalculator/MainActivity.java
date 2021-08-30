package com.example.bmicalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;
import android.widget.Toast;

import java.text.DecimalFormat;

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

    private void findViews() {
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
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double bmiResult = calculateBMI();
                String age = ageText.getText().toString();
                int age1 = Integer.parseInt(age);

                if (age1 >= 18) {
                    displayResult(bmiResult);
                }else {
                    displayGuidance(bmiResult);
                }
            }
        });

    }

    private double calculateBMI() {
        String feet = feetText.getText().toString();
        String inches = inchesText.getText().toString();
        String weight = weightText.getText().toString();

        //converting the number string into int variables
        int feet1 = Integer.parseInt(feet);
        int inches1 = Integer.parseInt(inches);
        int weight1 = Integer.parseInt(weight);

        int totalInches = (feet1 * 12) + inches1;

        //height in meters is the inches multiplied by 0.0254
        double heightInMeters = totalInches * 0.0254;

        //BMI formula = weight in kg divided by height in meters squared
        return weight1 / (heightInMeters * heightInMeters);
    }

    private void displayResult (double bmi) {
        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResult;
        if (bmi < 18.5) {
            fullResult = bmiTextResult + " You are underweight.";
        } else if (bmi > 25) {
            fullResult = bmiTextResult + " You are overweight.";
        } else {
            fullResult = bmiTextResult + " You are healthy weight";
        }
        resultText.setText(fullResult);
    }

    private void displayGuidance(double bmi) {

        DecimalFormat myDecimalFormatter = new DecimalFormat("0.00");
        String bmiTextResult = myDecimalFormatter.format(bmi);

        String fullResult;
        if (maleButton.isChecked()) {
            fullResult = bmiTextResult + " - As you are under 18, please consult your doctor for the healthy range for boys";

        }else if (femaleButton.isChecked()) {
            fullResult = bmiTextResult + " - As you are under 18, please consult your doctor for the healthy range for girls";
        }else {
            fullResult = bmiTextResult + " - As you are under 18, please consult your doctor for the healthy range";
        }
        resultText.setText(fullResult);
    }


}





