package com.sandowcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.GridView;
import android.widget.Toast;

import java.util.ArrayList;

/*
Method for calculating ideal body measurements
There are various ways of calculating your ideal body measurements.
John McCallum's formula is the most widely-used method, let's see how it works.

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
    private static final double ARM_TO_CHEST = 0.36;
    private static final double FOREARM_TO_CHEST = 0.29;
    private static final double THIGH_TO_CHEST = 0.53;
    private static final double CALF_TO_CHEST = 0.34;
    private static final double WAIST_TO_CHEST = 0.7;
    private static final double NECK_TO_CHEST = 0.37;
    private static final double HIPS_TO_CHEST = 0.85;

    ArrayList<String> results = new ArrayList<>();
    EditText wristCircumference;
    Double wristCircumferenceValue;
    String metricSystemSuffix = " cm";

    Button calculateBtn;
    GridView gridView;

    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Log.d("Message","Application onCreate() executed");
        wristCircumference = findViewById(R.id.wristCircumference);
        calculateBtn = findViewById(R.id.calculateBtn);
        gridView = findViewById(R.id.gridView);

        calculateBtn.setOnClickListener(v -> {
            results.clear();
            this.saveData(wristCircumference.getText().toString());
            wristCircumferenceValue = Double.parseDouble(wristCircumference.getText().toString());


            results.add("Chest: " + String.valueOf(wristCircumferenceValue * WRIST_TO_CHEST) + metricSystemSuffix);
            results.add("Biceps: " + String.valueOf(calculateCircumference(ARM_TO_CHEST)) + metricSystemSuffix);
            results.add("Forearm: " + String.valueOf(calculateCircumference(FOREARM_TO_CHEST)) + metricSystemSuffix);
            results.add("Thigh: " + String.valueOf(calculateCircumference(THIGH_TO_CHEST)) + metricSystemSuffix);
            results.add("Calf: " + String.valueOf(calculateCircumference(CALF_TO_CHEST)) + metricSystemSuffix);
            results.add("Waist: " + String.valueOf(calculateCircumference(WAIST_TO_CHEST)) + metricSystemSuffix);
            results.add("Neck: " + String.valueOf(calculateCircumference(NECK_TO_CHEST)) + metricSystemSuffix);
            results.add("Hips: " + String.valueOf(calculateCircumference(HIPS_TO_CHEST)) + metricSystemSuffix);

            showCalculatedResults();
            Toast.makeText(this, "Done! Wrist circumference was saved also.", Toast.LENGTH_SHORT).show();
        });
    }

    public void saveData(String wristCircumferenceValue) {
        sharedPreferences = getSharedPreferences("saveData", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("wristCircumference", wristCircumferenceValue);
    }

    private void showCalculatedResults() {
        ResultsGridAdapter gridAdapter = new ResultsGridAdapter(this, results);
        gridView.setAdapter(gridAdapter);
    }

    @SuppressLint("DefaultLocale")
    private String calculateCircumference(double factor) {
        double chestCircumference = wristCircumferenceValue * WRIST_TO_CHEST;
        return String.format("%.1f", chestCircumference * factor);
    }
}