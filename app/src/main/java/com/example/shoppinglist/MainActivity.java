package com.example.shoppinglist;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.HashMap;

public class MainActivity extends AppCompatActivity {

    public static final int TEXT_REQUEST = 1;

    private ButtonList items = new ButtonList ();

    public MainActivity (){

    }



    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        Intent intent = getIntent();

        if ((savedInstanceState!=null)&&(savedInstanceState.getSerializable("list")!=null)){

            HashMap <String,Integer> buttonlist =(HashMap<String, Integer>)savedInstanceState.getSerializable("list");

            TextView textView = findViewById(R.id.textView);

            textView.setText("");

            for (String goods: buttonlist.keySet()){

                String shopping = buttonlist.get(goods).toString()+ "" + goods + "\n";

                textView.setText(textView.getText() + shopping);

                for(int i = 0; i<buttonlist.get(goods);i++);

                items.addItem(goods);}


            }

        }



    public void launchSecondActivity(View view) {

        Intent intent = new Intent(this, SecondActivity.class);

        startActivityForResult(intent, TEXT_REQUEST);
    }

    @Override

    protected void onSaveInstanceState (Bundle savedInstanceState){

        super.onSaveInstanceState(savedInstanceState);

        savedInstanceState.putSerializable("list", items.getItems());
    }

    @Override

    public void onActivityResult (int requestCode, int resultCode, Intent data){

        super.onActivityResult(requestCode, resultCode, data);

        if (requestCode == TEXT_REQUEST){

            if (resultCode == RESULT_OK);

            String item = data.getStringExtra(SecondActivity.EXTRA_MESSAGE);

            items.addItem(item);
        }

        drawView();
    }

    private void drawView() {

        HashMap<String,Integer> buttonlist = items.getItems();

        TextView textView = findViewById(R.id.textView);

        textView.setText("");

        for (String goods: buttonlist.keySet()){

            String shopping = buttonlist.get(goods).toString() + "" + goods + "\n";

            textView.setText(textView.getText() + shopping);


        }

    }



}
