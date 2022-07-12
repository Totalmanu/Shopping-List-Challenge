package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

public class SecondActivity extends AppCompatActivity {
    public static final String EXTRA_MESSAGE = "com.example.shoppinglist.extra.MESSAGE";


    String Buttons = "";

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_second);

    }

    public void launchMainActivity(View view) {

        Button button = (Button) view;

        Buttons = Buttons + button.getText().toString();

        Intent intent = new Intent(this, MainActivity.class);

        String message = button.getText().toString();

        intent.putExtra(EXTRA_MESSAGE, message);

        setResult(RESULT_OK, intent);

        finish();
    }
}