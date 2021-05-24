package com.example.justjava;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import java.text.NumberFormat;


public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    int no_of_coffee = 0;
    boolean chock;
    boolean cream;
    int price;
    int pricecup = 5;
    int total_price;
    String message;
    /**
     * this meathod is called when the button is clicked
     */

    public void submitOrder(View view){
        EditText namecu = (EditText) findViewById(R.id.namecust);
        String name = namecu.getText().toString();
        message = "Name:"+name+"\nAdd whipped cream?"+cream+"\nAdd chocolate?"+chock+"\nquantity:"+no_of_coffee+"\ntotal price:$"+total_price+"\nThank you";

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_EMAIL, "unspottedtech@gmail.com");
        intent.putExtra(Intent.EXTRA_SUBJECT, "order from just java coffee Application");
        intent.putExtra(Intent.EXTRA_TEXT, message);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }
    }

    public void increment(View view) {
        CheckBox chock_check = (CheckBox) findViewById(R.id.chocklate);
        chock = chock_check.isChecked();
        CheckBox cream_check = (CheckBox) findViewById(R.id.cream);
        cream = cream_check.isChecked();
        no_of_coffee = no_of_coffee+1;
        getDisplay(no_of_coffee);
        total_price=calculatePrice(no_of_coffee,chock,cream);
        displayPrice(total_price);

    }
    public void decrement(View view) {
        CheckBox chock_check = (CheckBox) findViewById(R.id.chocklate);
        chock = chock_check.isChecked();
        CheckBox cream_check = (CheckBox) findViewById(R.id.cream);
        cream = cream_check.isChecked();
        no_of_coffee = no_of_coffee-1;
        if (no_of_coffee<0){
            no_of_coffee=0;
        }
        getDisplay(no_of_coffee);
        total_price=calculatePrice(no_of_coffee,chock,cream);
        displayPrice(total_price);

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
    private int calculatePrice(int  no_of_coffee,boolean chock,boolean cream){
        if(chock && cream){
            price = pricecup +  3;
        }
        else if(cream){
            price = pricecup +2;
        }
        else if(chock){
            price = pricecup+1;
        }
        else {
            price = pricecup;
        }

        return (price)*no_of_coffee;
    }

}