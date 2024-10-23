package com.example.lab2flag;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Switch;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_relative); 

        Button button = findViewById(R.id.button);
        Switch switch1 = findViewById(R.id.switch1);

        button.setOnClickListener(v -> {
            String message = getResources().getString(R.string.toast_message);
            Toast.makeText(MainActivity.this, message, Toast.LENGTH_LONG).show();
        });

        switch1.setOnCheckedChangeListener((buttonView, isChecked) -> {
            String message = getResources().getString(R.string.switch_on_off) + (isChecked ? " on" : " off");
            Snackbar snackbar = Snackbar.make(buttonView, message, Snackbar.LENGTH_LONG);
            snackbar.setAction(getResources().getString(R.string.undo_action), v -> switch1.setChecked(!isChecked));
            snackbar.show();
        });
    }
}