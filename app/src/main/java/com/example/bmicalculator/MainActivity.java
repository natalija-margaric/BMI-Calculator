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




        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "this is working, jeeeeej", Toast.LENGTH_LONG).show();
            }
        });


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

}


