package com.example.myapplication;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import java.lang.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CgpaCalculator extends AppCompatActivity {

    private Button btn1,btn2;
    @Override

    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgpcalculator);
        btn1=(Button) findViewById(R.id.button24);
        btn2=(Button) findViewById(R.id.button27);
        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CgpaCalculator.this,GpaCalc.class);
                startActivity(intent);
            }
        });
        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent=new Intent(CgpaCalculator.this,CgpaCalc.class);
                startActivity(intent);
            }
        });
    }
}
