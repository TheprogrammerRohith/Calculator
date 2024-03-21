package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class CgpaCalc extends AppCompatActivity {

    private static float[] sem_credits=new float[2];
    private static float[] sem_gpa=new float[2];
    private static EditText edttxt1,edttxt2,edttxt3,edttxt4;
    private static Button btn,btn2;
    private static TextView txtview1,txtview2,txtview3,txtview4,txtview5;
    private float result;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.cgpa);
        btn=findViewById(R.id.button48);
        btn2=findViewById(R.id.button49);
        edttxt1=findViewById(R.id.editTextText3);
        edttxt2=findViewById(R.id.editTextText4);
        edttxt3=findViewById(R.id.editTextText5);
        edttxt4=findViewById(R.id.editTextText6);
        txtview1=findViewById(R.id.textView10);
        txtview2=findViewById(R.id.textView6);
        txtview3=findViewById(R.id.textView7);
        txtview4=findViewById(R.id.textView8);
        txtview5=findViewById(R.id.textView9);
        TextView[] txtviews={txtview2,txtview3,txtview4,txtview5};
        EditText[] editTexts={edttxt1,edttxt2,edttxt3,edttxt4};
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    float a = Float.parseFloat(edttxt1.getText().toString());
                    if (a > 10) {
                        Toast.makeText(getApplicationContext(), "Maximum CGPA are 10", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        sem_gpa[0] = a;
                    }

                    float b = Float.parseFloat(edttxt2.getText().toString());
                    if (b > 200) {
                        Toast.makeText(getApplicationContext(), "Maximum credits are 200", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        sem_credits[0] = b;
                    }

                    float c = Float.parseFloat(edttxt3.getText().toString());
                    if (c > 10) {
                        Toast.makeText(getApplicationContext(), "Maximum GPA are 10", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        sem_gpa[1] = c;
                    }

                    float d = Float.parseFloat(edttxt4.getText().toString());
                    if (d > 50) {
                        Toast.makeText(getApplicationContext(), "Maximum credits are 50", Toast.LENGTH_SHORT).show();
                        return;
                    } else {
                        sem_credits[1] = d;
                    }
                    btn.setVisibility(View.INVISIBLE);
                    for (TextView t : txtviews) {
                        t.setVisibility(View.INVISIBLE);
                    }

                    for (EditText e : editTexts) {
                        e.setVisibility(View.INVISIBLE);
                        e.setText("");
                    }

                    result = cgpa(sem_credits, sem_gpa);
                    txtview1.setVisibility(View.VISIBLE);
                    btn2.setVisibility(View.VISIBLE);
                    String s = String.valueOf(result+"\n"+"Excellent"+"\n"+"Keep rocking👍👍👍");
                    txtview1.setText(s);
                } catch (Exception e) {
                    Toast.makeText(getApplicationContext(), "An error occurred.", Toast.LENGTH_SHORT).show();
                }
            }
        });

        btn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                result = 0;
                for (TextView t : txtviews) {
                    t.setVisibility(View.VISIBLE);
                }
                for (EditText e : editTexts) {
                    e.setVisibility(View.VISIBLE);
                }
                txtview1.setVisibility(View.INVISIBLE);
                btn2.setVisibility(View.INVISIBLE);
                btn.setVisibility(View.VISIBLE);
            }
        });

    }
        private float cgpa(float[] semCredits, float[] semGpa) {
        float total=0;
        float sum=0;
        for(float n:semCredits){
            total+=n;
        }
        for(int i=0;i<semCredits.length;i++){
            sum+=semCredits[i]*semGpa[i];
        }
        return (float)sum/total;
    }
}

