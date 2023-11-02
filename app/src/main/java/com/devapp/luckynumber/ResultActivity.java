package com.devapp.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.util.Random;

public class ResultActivity extends AppCompatActivity {

    TextView luckyNumberTxt;
    Button shareLuckNumber;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);


        luckyNumberTxt = findViewById(R.id.lucky_number_text_v);
        shareLuckNumber = findViewById(R.id.share_lucky);

        // Receiving data from Main Activity
        Intent intent = getIntent();
        String userName = intent.getStringExtra("username");


        // Generating Random Numbers
        int random_num = generatedRandomNumber();
        luckyNumberTxt.setText(" "+random_num);

        shareLuckNumber.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareData(userName, random_num);
            }
        });
    }

    public int generatedRandomNumber() {
        Random random = new Random();
        int upper_limit = 1000;

        return random.nextInt(upper_limit);
    }

    public void shareData(String username, int random_num) {
        // implicit Intent
        Intent intent = new Intent(Intent.ACTION_SEND);

        intent.setType("text/plain");

        // Additionnal Info
        intent.putExtra(Intent.EXTRA_SUBJECT, username + "got lucky today");
        intent.putExtra(Intent.EXTRA_TEXT, "His lucky number is: " +random_num);

        // dialog
        startActivity(Intent.createChooser(intent, "Choose a platform "));

    }
}