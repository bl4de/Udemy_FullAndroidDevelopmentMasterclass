package com.sandowcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

/*
Method for calculating ideal body measurements
There are various ways of calculating your ideal body measurements. John McCallum's formula is the most widely-used method, let's see how it works.

This formula uses the wrist measurement to work out the measurements for other parts of the body:

chest = wrist x 6.5
arm = chest x 0.36
forearm = chest x 0:29
leg = chest x 0.53
calf = chest x 0.34
waist = chest x 0.7
neck = chest x 0.37
hips = chest x 0.85
 */
public class MainActivity extends AppCompatActivity {

    private static final double WRIST_TO_CHEST = 6.5;

    EditText wristCircumference;
    Double wristCircumferenceValue;

    TextView chestResult;
    Button calculateBtn;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        wristCircumference = findViewById(R.id.wristCircumference);
        calculateBtn = findViewById(R.id.calculateBtn);

        chestResult = findViewById(R.id.chestResult);

        calculateBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                wristCircumferenceValue = Double.parseDouble(wristCircumference.getText().toString());

                chestResult.setText(chestResult.getText() + " " + String.valueOf(calculateChestCircumference()) + " cm.");
            }
        });
    }

    private double calculateChestCircumference() {
        return wristCircumferenceValue * MainActivity.WRIST_TO_CHEST;
    }
}