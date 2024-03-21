package com.example.myapplication;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import java.lang.*;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class GpaCalc extends AppCompatActivity {
    private static EditText edttxt;
    private EditText subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9,subject10;
    private EditText grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9,grade10;

    private static TextView txtview;
    private Button etr,cmpt;
    private static ScrollView scrollView;
    private static float[] credits;
    private static char[] grades;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.gpa);
        scrollView = findViewById(R.id.scrollview);
        edttxt=findViewById(R.id.editTextNumber);
        txtview=findViewById(R.id.textView2);
        subject1 = findViewById(R.id.subject1);
        subject2 = findViewById(R.id.subject2);
        subject3 = findViewById(R.id.subject3);
        subject4 = findViewById(R.id.subject4);
        subject5 = findViewById(R.id.subject5);
        subject6 = findViewById(R.id.subject6);
        subject7 = findViewById(R.id.subject7);
        subject8 = findViewById(R.id.subject8);
        subject9 = findViewById(R.id.subject9);
        subject10=findViewById(R.id.subject10);
        grade1 = findViewById(R.id.grade1);
        grade2 = findViewById(R.id.grade2);
        grade3 = findViewById(R.id.grade3);
        grade4 = findViewById(R.id.grade4);
        grade5 = findViewById(R.id.grade5);
        grade6 = findViewById(R.id.grade6);
        grade7 = findViewById(R.id.grade7);
        grade8 = findViewById(R.id.grade8);
        grade9 = findViewById(R.id.grade9);
        grade10=findViewById(R.id.grade10);
        etr=findViewById(R.id.enter);
        cmpt=findViewById(R.id.button46);
        final int[] n = new int[1];
        etr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtview.setText("");
                try {
                    n[0] = Integer.valueOf(String.valueOf(edttxt.getText()));
                    if (n[0] > 10) {
                        Toast.makeText(getApplicationContext(), "Maximum no of subjects is 10", Toast.LENGTH_LONG).show();
                        return;
                    }
                } catch (Exception e) {
                    return;
                }
                credits = new float[n[0]];
                grades = new char[n[0]];
                EditText[] subjectEditTexts = {subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9,subject10};
                EditText[] gradeEditTexts = {grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9,grade10};
                int i=0;
                for (EditText subjectEditText : subjectEditTexts) {
                    i++;
                    if(i<=n[0]) {
                        subjectEditText.setVisibility(View.VISIBLE);
                    }
                    else if(i>n[0]) {
                        subjectEditText.setVisibility(View.INVISIBLE);
                    }
                }
                int j=0;
                for (EditText gradeEditText : gradeEditTexts) {
                    j++;
                    if(j<=n[0]) {
                        gradeEditText.setVisibility(View.VISIBLE);
                    }
                    else if(j>n[0]) {
                        gradeEditText.setVisibility(View.INVISIBLE);
                    }
                }
                cmpt.setVisibility(View.VISIBLE);
                //scrollView.fullScroll(View.FOCUS_DOWN);
            }
        });
        cmpt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {

                    EditText[] subjectEditTexts = {subject1, subject2, subject3, subject4, subject5, subject6, subject7, subject8, subject9,subject10};
                    EditText[] gradeEditTexts = {grade1, grade2, grade3, grade4, grade5, grade6, grade7, grade8, grade9,grade10};
                    int i = 0;
                    for (EditText subject : subjectEditTexts) {
                        if (subject != null) {
                            float a = Float.parseFloat(subject.getText().toString());
                            if (a > 5) {
                                Toast.makeText(getApplicationContext(), "Maximum no of credits for each subject is 5", Toast.LENGTH_LONG).show();
                                return;
                            }
                            credits[i] = a;
                            i++;
                            if (i == n[0]) break;
                        }
                    }
                    int j = 0;
                    for (EditText grade : gradeEditTexts) {
                        if (grade != null) {
                            if (j == n[0]) {
                                break;
                            } else {
                                String text = grade.getText().toString();
                                if (!text.isEmpty()) {
                                    char b = text.charAt(0);
                                    grades[j] = b;
                                    j++;
                                }
                            }
                        }
                    }
                    int x=0;
                    for (EditText subjectEditText : subjectEditTexts) {
                        x++;
                        subjectEditText.setVisibility(View.INVISIBLE);
                        if(x==n[0]) break;
                    }
                    int y=0;
                    for (EditText gradeEditText : gradeEditTexts) {
                        y++;
                        gradeEditText.setVisibility(View.INVISIBLE);
                        if(y==n[0]) break;
                    }
                    float gpa = gpa(credits, grades);
                    txtview.setVisibility(View.VISIBLE);
                    String s = String.valueOf(gpa+"\n"+"your rocking"+"\n"+"Keep doing👍👍");
                    txtview.setText(s);
                    edttxt.setText("");
                    credits = new float[0];
                    grades = new char[0];
                    int g=0;
                    for (EditText subjectEditText : subjectEditTexts) {
                        g++;
                        subjectEditText.setText("");
                        if(g==n[0]) break;
                    }
                    int f=0;
                    for (EditText gradeEditText : gradeEditTexts) {
                        f++;
                        gradeEditText.setText("");
                        if(f==n[0]) break;
                    }
                }
                catch(Exception e){
                    return;
                }
            }
        });

    }
    private float gpa(float[] credits, char[] grades) {
        float sum=0;
        try{
            sum=evaluate(credits,grades);
        }
        catch(Exception e){
            System.out.println();
        }
        float total_credits=0;
        for(float x:credits){
            total_credits+=x;
        }
        float result=sum/total_credits;
        return result;
   }
    private float evaluate(float[] credits, char[] grades) {
        float total=0;
        for(int j=0;j<credits.length;j++){
            switch(grades[j]){
                case('S'):{
                    total+=credits[j]*10;
                    break;
                }
                case('A'):{
                    total+=credits[j]*9;
                    break;
                }
                case('B'):{
                    total+=credits[j]*8;
                    break;
                }
                case('C'):{
                    total+=credits[j]*7;
                    break;
                }
                case('D'):{
                    total+=credits[j]*6;
                    break;
                }
                case('E'):{
                    total+=credits[j]*5;
                    break;
                }
                case('F'):{
                    total+=credits[j]*0;
                    break;
                }
                default:{
                    break;
                }
            }
        }
        return total;
    }
}


