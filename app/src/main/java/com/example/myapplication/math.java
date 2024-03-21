package com.example.myapplication;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class math extends AppCompatActivity {
    private StringBuilder str=new StringBuilder();
    private TextView txtview;
    private int a=0,b=0,c=0,d=0,e=0,f=0,g=0;
    private double result;
    private static Button btn,sin,cos,tan,sqrt,log,ln,exp;
    int check=0;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.math);
        txtview=findViewById(R.id.textView5);
        btn=findViewById(R.id.button47);
        sin=findViewById(R.id.button17);
        sqrt=findViewById(R.id.button13);
        log=findViewById(R.id.button16);
        tan=findViewById(R.id.button18);
        exp=findViewById(R.id.button21);
        cos=findViewById(R.id.button32);
        ln=findViewById(R.id.button14);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                check++;
                if(check%2!=0){
                    sin.setText("asin");
                    sin.setTextSize(15);
                    cos.setText("acos");
                    cos.setTextSize(15);
                    tan.setText("atan");
                    tan.setTextSize(15);
//                    sqrt.setText("/");
//                    log.setText("*");
//                    ln.setText("+");
//                    exp.setText("-");
                    btn.setText("<-");
                }
                else{
                    back();
                }
            }
        });
        sin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check%2==0){
                    str.append("sin(");
                    txtview.setText(str.toString());
                    f=1;
                }
                else{
                    str.append("asin(");
                    txtview.setText(str.toString());
                    f=2;
                }
            }
        });
        cos.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check%2==0){
                    str.append("cos(");
                    txtview.setText(str.toString());
                    c=1;
                }
                else{
                    str.append("acos(");
                    txtview.setText(str.toString());
                    c=2;
                }
            }
        });
        tan.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(check%2==0){
                    str.append("tan(");
                    txtview.setText(str.toString());
                    g=1;
                }
                else{
                    str.append("atan(");
                    txtview.setText(str.toString());
                    g=2;
                }
            }
        });
    }
    public static void back(){
        sin.setText("sin");
        sin.setTextSize(15);
        cos.setText("cos");
        cos.setTextSize(15);
        tan.setText("tan");
        tan.setTextSize(15);
//        sqrt.setText("sqrt");
//        log.setText("log");
//        ln.setText("ln");
//        exp.setText("e");
        btn.setText("->");
    }
    public void onbtnclick27(View view) {
        str.append("1");
        txtview.setText(str.toString());
    }
    public static String getString(String str){
        StringBuilder input=new StringBuilder();
        for(int i=0;i<str.length();i++){
            char c=str.charAt(i);
            if(Character.isDigit(c) || c=='.'){
                input.append(c);
            }
        }
        String a=input.toString();
        return a;
    }

    public void onbtnclick28(View view) {
        String q=txtview.getText().toString();
        String s=getString(q);
        float input=Float.parseFloat(s);
        double radians=Math.toRadians(input);
        //Log.d("TAG",s);
        if(a==1){
            result=Math.exp(input);
        }
        if(b==1){
            result=Math.log(input);
        }
        if(c==1){
            result=Math.cos(radians);
        }
        else if(c==2){
            double r=Math.acos(input);
            result=Math.toDegrees(r);
        }
        if(d==1){
            result=Math.sqrt(input);
        }
        if(e==1){
            result=Math.log10(input);
        }
        if(f==1){
            result=Math.sin(radians);
        }
        else if(f==2){
            double r=Math.asin(input);
            result=Math.toDegrees(r);
        }
        if(g==1){
            result=Math.tan(radians);
        }
        else if(g==2){
            double r=Math.atan(input);
            result=Math.toDegrees(r);
        }
        result=(double)Math.round(result*10000)/10000;
        String r=String.valueOf(result);
        txtview.setText(r);
    }

    public void onbtnclick29(View view) {
        str.append("0");
        txtview.setText(str.toString());
    }

    public void onbtnclick30(View view) {
        str.append("5");
        txtview.setText(str.toString());
    }

    public void onbtnclick31(View view) {
        str.append("2");
        txtview.setText(str.toString());
    }

    public void onbtnclick32(View view) {
        str.append("8");
        txtview.setText(str.toString());
    }

    public void onbtnclick33(View view) {
        str.append("9");
        txtview.setText(str.toString());
    }

    public void onbtnclick34(View view) {
        str.append("3");
        txtview.setText(str.toString());
    }

    public void onbtnclick35(View view) {
        str.append("6");
        txtview.setText(str.toString());
    }

    public void onbtnclick36(View view) {
        str.deleteCharAt(str.length()-1);
        txtview.setText(str.toString());
    }

    public void onbtnclick37(View view) {
        str.append("e^(");
        txtview.setText(str.toString());
        a=1;
    }

    public void onbtnclick38(View view) {
        str.append("ln(");
        txtview.setText(str.toString());
        b=1;
    }

    public void onbtnclick40(View view) {
        str.append(".");
        txtview.setText(str.toString());
    }

    public void onbtnclick41(View view) {
        str.append("sqrt(");
        txtview.setText(str.toString());
        d=1;
    }

    public void onbtnclick42(View view) {
        str.append("log(");
        txtview.setText(str.toString());
        e=1;
    }

    public void onbtnclick45(View view) {
        str.delete(0,str.length());
        txtview.setText("");
        result=0;
        a=0;b=0;c=0;d=0;e=0;f=0;g=0;
    }

    public void onbtnclick46(View view) {
        str.append("(");
        txtview.setText(str.toString());
    }

    public void onbtnclick47(View view) {
        str.append(")");
        txtview.setText(str.toString());
    }

    public void onbtnclick48(View view) {
        str.append("4");
        txtview.setText(str.toString());
    }

    public void onbtnclick49(View view) {
        str.append("7");
        txtview.setText(str.toString());
    }
}
