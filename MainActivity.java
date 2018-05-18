package com.example.khanh.justjava;


import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.CheckBox;
import android.widget.TextView;

import java.text.NumberFormat;

/**
 * This app displays an order form to order coffee.
 */
public class MainActivity extends AppCompatActivity {

    int quantity = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    /**
     * This method is called when the plus button is clicked.
     */
    public void increment(View view) {
        quantity = quantity + 1;
        display(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * This method is called when the minus button is clicked.
     */
    public void decrement(View view) {
        quantity = quantity - 1;
        display(quantity);
        displayPrice(quantity * 5);
    }

    /**
     * This method is called when the order button is clicked.
     */
    public void submitBooking(View view) {
        int price = quantity * 5;
        String priceMessage = "Total: $" + price;
        priceMessage = priceMessage + "\nThank you!";
        displayMessage(priceMessage);
    }

    //does the user want whipped cream?
    CheckBox whippedCreamCheckBox = (CheckBox)findViewById(R.id.whipped_cream_checkbox);
    boolean hasWhippedCream = whippedCreamCheckBox.isChecked();

    //does the user want chocolate
    CheckBox chocolateCheckBox = (CheckBox)findViewById(R.id.chocolate_checkbox);
    boolean hasChocolate = chocolateCheckBox.isChecked();

    //calculation of additions to price
    int price = calculatePrice();
    String priceMessage = createOrderSummary(name, price, hasWhippedCream, hasChocolate);
    displayMessage(priceMessage);}

    /**
     * Creates summary of order.
     *@param price of order
     *@param addWhippedCream if user wants whipped cream
     *@param addChocolate if user wants to add chocolate
     *@return text summary
     */
    private String createOrderSummary(String name,int price,boolean addWhippedCream,boolean addChocolate){
        String priceMessage = "Name: ” + name ;
        priceMessage += "\nAdd whipped cream? ” +addWhippedCream;
        priceMessage += "\nAdd chocolate? ” + addChocolate;
        priceMessage += "\nQuantity: ” + quantity;
        priceMessage += "\nTotal: $ ” + price;
        priceMessage += "\nThank you!”;
        return priceMessage;
    }

    /**
     * Calculates the price of the order.
     *
     * @return for total price
     */
    private int calculatePrice() {
        return quantity * 5;

    }

    /**
     * This method displays the given quantity value on the screen.
     */
    private void display(int number) {
        TextView quantityTextView = (TextView) findViewById(R.id.quantity_text_view);
        quantityTextView.setText("" + number);
    }

    /**
     * This method displays the given price on the screen.
     */
    private void displayPrice(int number) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    /**
     * This method displays the given text on the screen.
     */
    private void displayMessage(String message) {
        TextView priceTextView = (TextView) findViewById(R.id.price_text_view);
        priceTextView.setText(message);
    }

}
