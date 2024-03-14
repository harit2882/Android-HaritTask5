package com.example.harittask5;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.harittask5.databinding.ActivityMainBinding;

import java.util.Objects;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    ActivityMainBinding binding;
    SharedPreferences sharedPreferences;
    Intent intent;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        //Binding main activity with view
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = binding.getRoot();
        setContentView(view);

        //initializing onClickListeners
        binding.btSubmit.setOnClickListener(this);
        //initializing SharedPreferences
        sharedPreferences = getSharedPreferences("product_details",MODE_PRIVATE);
    }

    @Override
    public void onClick(View v) {

        if(binding.btSubmit.getId() == v.getId()){

            // Check if text field is empty or not
            if(!Objects.requireNonNull(binding.etProductCode.getText()).toString().isEmpty() &&
                    !Objects.requireNonNull(binding.etProductName.getText()).toString().isEmpty() &&
                    !Objects.requireNonNull(binding.etProductPrice.getText()).toString().isEmpty()){

                // assigning intent
                intent = new Intent(this, DetailsActivity.class);

                // adding product value to shared preference
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putString("PRODUCT_CODE",binding.etProductCode.getText().toString().trim());
                editor.putString("PRODUCT_NAME",binding.etProductName.getText().toString().trim());
                editor.putString("PRODUCT_PRICE",binding.etProductPrice.getText().toString().trim());
                editor.apply();

                // starting product details activity
                startActivity(intent);

            }else{
                // Error message for filling all the details
                Toast.makeText(this, "Fill All The Details", Toast.LENGTH_LONG).show();
            }
        }

    }
}