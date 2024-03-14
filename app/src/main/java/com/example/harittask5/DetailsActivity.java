package com.example.harittask5;

import androidx.appcompat.app.AppCompatActivity;
import  com.example.harittask5.databinding.ActivityDetailsBinding;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;

public class DetailsActivity extends AppCompatActivity {

    ActivityDetailsBinding binding;
    SharedPreferences sharedPreferences;
    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //Binding details activity with view
        binding = ActivityDetailsBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        // Getting shared preference variable
        sharedPreferences = getSharedPreferences("product_details",MODE_PRIVATE);

        // Adding value from shared preferences to text view
        binding.tvProductInfo.setText("Code : "+sharedPreferences.getString("PRODUCT_CODE",null)+
                "\nName : "+sharedPreferences.getString("PRODUCT_NAME",null)+
                "\nPrice : "+sharedPreferences.getString("PRODUCT_PRICE",null));
    }
}