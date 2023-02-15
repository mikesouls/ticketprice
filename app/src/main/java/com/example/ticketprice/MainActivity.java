package com.example.ticketprice;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //vars
    double costPer = 87.54, // cost per ticket
            totalCost; // hold cost overall
    int numOfTickets; // user's input for number of tickets
    String groupChoice; // what band the user picked

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        EditText ticketNum = (EditText)findViewById(R.id.textTickets);
        Spinner group = (Spinner)findViewById(R.id.txtGroup);
        Button cost = (Button)findViewById(R.id.findCost);
        TextView result = (TextView)findViewById(R.id.textResults);

        cost.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Clicked!", Toast.LENGTH_LONG).show();
                numOfTickets = Integer.parseInt(ticketNum.getText().toString());
                totalCost = (numOfTickets * costPer);
                DecimalFormat df = new DecimalFormat("$###,###.##");
                groupChoice = group.getSelectedItem().toString();
                result.setText("Cost for " + groupChoice + " is " + df.format(totalCost));
            }
        });

    }
}