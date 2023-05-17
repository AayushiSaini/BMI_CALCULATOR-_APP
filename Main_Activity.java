package com.example.bmiapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        EditText editWeight, editHeightFT,editHeightInt;
        Button btnCalculate;
        TextView txtResult;
        LinearLayout llMain;
        llMain=findViewById(R.id.llMain);

        editWeight=findViewById(R.id.hint_wt);
        editHeightFT=findViewById(R.id.hint_ht);
        editHeightInt=findViewById(R.id.hint_he);
        btnCalculate=findViewById(R.id.btn);
        txtResult=findViewById(R.id.text);

        btnCalculate.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View view) {
              int wt= Integer.parseInt(editWeight.getText().toString()) ;
                int ht= Integer.parseInt(editHeightFT.getText().toString()) ;
                int he=Integer.parseInt(editHeightInt.getText().toString());
               int totalIn =ht*12+he;
               double totalCm = totalIn*2.53;
               double totalM=totalCm/100;
               double bmi= wt/(totalM*totalM);
               if(bmi>25)
               {
                   txtResult.setText("you are overweight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorOw));
               }
               else if(bmi<18) {
                   txtResult.setText("you are underweight");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorUw));
               }
               else{
                   txtResult.setText("you are healthy");
                   llMain.setBackgroundColor(getResources().getColor(R.color.colorHe));
               }
            }
        });







    }
}