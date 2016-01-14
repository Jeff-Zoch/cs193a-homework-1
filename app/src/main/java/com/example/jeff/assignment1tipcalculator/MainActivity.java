package com.example.jeff.assignment1tipcalculator;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private double tipPercent = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void setPercent(View view) {
        int id = view.getId();
        if(id == R.id.fifteenButton){
            tipPercent = .15;
        }
        else if(id == R.id.eighteenButton){
            tipPercent = .18;
        }
        else if(id == R.id.twentyButton){
            tipPercent = .2;
        }
    }

    public void tip(View view) {
        if(tipPercent == 0) {
            EditText customTip = (EditText) findViewById(R.id.customTip);
            if(customTip.getText().length() != 0)
                tipPercent = Double.parseDouble(customTip.getText().toString()) / 100;
        }
        EditText costInput = (EditText) findViewById(R.id.EnterCostInput);
        double cost = 0;
        if(costInput.getText().length() == 0) cost = 0;
        else cost = Double.parseDouble(costInput.getText().toString());
        double tip = cost * tipPercent;
        double total = cost + tip;

        TextView tipOutput = (TextView) findViewById(R.id.tipTotalText);
        TextView totalOutput = (TextView) findViewById(R.id.TotalCostText);
        tipOutput.setText(Double.toString(tip));
        totalOutput.setText(Double.toString(total));
        tipPercent = 0;
    }
}
