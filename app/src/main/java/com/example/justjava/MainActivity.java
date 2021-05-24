package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;
import java.lang.Math;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int no_of_coffee = 2;

    /**
     * this meathod is called when the button is clicked
     */

    public void submitOrder(View view){
        
    }

    public void increment(View view) {
        no_of_coffee = no_of_coffee+1;
        getDisplay(no_of_coffee);
        calculatePrice(no_of_coffee);
    }
    public void decrement(View view) {
        no_of_coffee = no_of_coffee-1;
        if (no_of_coffee<0){
            no_of_coffee=0;
            getDisplay(no_of_coffee);
            displayPrice(no_of_coffee*5);
        }
        else {
            getDisplay(no_of_coffee);
            displayPrice(no_of_coffee*5);
        }

    }
    /**
     * this meathod displays the quantity value on the screen
     */
    @SuppressLint("SetTextI18n")
    private void getDisplay(int number){
        TextView quantityview = (TextView) findViewById(R.id.quantity_text_view);
        quantityview.setText("" +number);
    }
    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }
    private void calculatePrice(int  no_of_coffee){
        int price = no_of_coffee*5;
        displayPrice(price);
    }

}