package com.example.hellotoast;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private int counter = 0;
    private Button count;
    private Button toast;
    private TextView show_count;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        show_count = (TextView) findViewById(R.id.show_count);

        if(savedInstanceState !=null){
            counter = savedInstanceState.getInt("counter");
            show_count.setText(String.valueOf(counter));
        }

        count = (Button) findViewById(R.id.button_count);
        count.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                counter = counter+1;
                show_count.setText(String.valueOf(counter));
            }
        });

        toast = (Button) findViewById(R.id.button_toast);
        toast.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(getApplicationContext(),"The actual value of counter is: "+String.valueOf(counter), Toast.LENGTH_SHORT).show();
            }
        });

    }
    @Override
    public void onSaveInstanceState(Bundle savedInstanceState){
        super.onSaveInstanceState(savedInstanceState);
        savedInstanceState.putInt("counter",counter);
    }
}