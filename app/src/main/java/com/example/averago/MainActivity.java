package com.example.averago;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // Declare UI elements
    private EditText firstPurchaseUnitsEditText, firstPurchasePriceEditText, secondPurchaseUnitsEditText, secondPurchasePriceEditText;
    private TextView resultTextView, totalInvestedFirstTextView, totalInvestedSecondTextView, totalUnitsTextView, totalAmountTextView;
    private Button calculateButton, clearButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Initialize UI elements
        firstPurchaseUnitsEditText = findViewById(R.id.first_purchase_units);
        firstPurchasePriceEditText = findViewById(R.id.first_purchase_price);
        secondPurchaseUnitsEditText = findViewById(R.id.second_purchase_units);
        secondPurchasePriceEditText = findViewById(R.id.second_purchase_price);
        resultTextView = findViewById(R.id.result_text);
        totalInvestedFirstTextView = findViewById(R.id.total_invested_first);
        totalInvestedSecondTextView = findViewById(R.id.total_invested_second);
        totalUnitsTextView = findViewById(R.id.total_units_text);
        totalAmountTextView = findViewById(R.id.total_amount_text);
        calculateButton = findViewById(R.id.calculate_button);
        clearButton = findViewById(R.id.clear_button);

        // Set OnClickListener for the Calculate button
        calculateButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    // Get input values
                    double firstPurchaseUnits = Double.parseDouble(firstPurchaseUnitsEditText.getText().toString());
                    double firstPurchasePrice = Double.parseDouble(firstPurchasePriceEditText.getText().toString());
                    double secondPurchaseUnits = Double.parseDouble(secondPurchaseUnitsEditText.getText().toString());
                    double secondPurchasePrice = Double.parseDouble(secondPurchasePriceEditText.getText().toString());

                    // Calculate total invested and average price
                    double totalInvestedFirst = firstPurchaseUnits * firstPurchasePrice;
                    double totalInvestedSecond = secondPurchaseUnits * secondPurchasePrice;
                    double totalUnits = firstPurchaseUnits + secondPurchaseUnits;
                    double totalAmount = totalInvestedFirst + totalInvestedSecond;
                    double averagePrice = totalAmount / totalUnits;

                    // Display results
                    resultTextView.setText("Average Price: " + averagePrice);
                    totalInvestedFirstTextView.setText("Total Invested in 1st Purchase: " + totalInvestedFirst);
                    totalInvestedSecondTextView.setText("Total Invested in 2nd Purchase: " + totalInvestedSecond);
                    totalUnitsTextView.setText("Total Units: " + totalUnits);
                    totalAmountTextView.setText("Total Amount: " + totalAmount);

                } catch (NumberFormatException e) {
                    // Handle exception if inputs are invalid
                    Toast.makeText(MainActivity.this, "Please enter valid numbers", Toast.LENGTH_SHORT).show();
                }
            }
        });

        // Set OnClickListener for the Clear button
        clearButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Clear all input fields and result TextViews
                firstPurchaseUnitsEditText.setText("");
                firstPurchasePriceEditText.setText("");
                secondPurchaseUnitsEditText.setText("");
                secondPurchasePriceEditText.setText("");
                resultTextView.setText("Average Price: ");
                totalInvestedFirstTextView.setText("Total Invested in 1st Purchase: ");
                totalInvestedSecondTextView.setText("Total Invested in 2nd Purchase: ");
                totalUnitsTextView.setText("Total Units: ");
                totalAmountTextView.setText("Total Amount: ");
            }
        });
    }
}
