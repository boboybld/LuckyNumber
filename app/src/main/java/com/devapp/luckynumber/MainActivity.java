package com.devapp.luckynumber;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button getLuck;
    EditText enter_name;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        enter_name = findViewById(R.id.editext_enter_name);
        getLuck = findViewById(R.id.get_lucky_number);

        getLuck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // get value
                String username = enter_name.getText().toString();

                // Explicit Intent
                Intent intent = new Intent(getApplicationContext(), ResultActivity.class);

                intent.putExtra("username", username);
                startActivity(intent);
            }
        });
    }
}