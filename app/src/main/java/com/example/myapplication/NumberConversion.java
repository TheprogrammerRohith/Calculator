package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

public class NumberConversion extends AppCompatActivity {
    private static TextView binary_tv,decimal_tv,octal_tv,hexadecimal_tv;
    private static EditText bin,dec,oct,hex,inp;
    private static Button bin_btn,dec_btn,oct_btn,hex_btn,clear,result;
    public static StringBuilder convertDecimal(int decimal){
        StringBuilder str=new StringBuilder();
        int n1=decimal;
        int[] binary=new int[100];
        int i=0;
        while(n1!=0){
            int r=n1%2;
            binary[i]=r;
            n1=n1/2;
            i++;
        }
        for(int j=i;j>=0;j--){
            str.append(String.valueOf(binary[j]));
        }
        return str;
    }
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.numberconnversion);
        binary_tv=findViewById(R.id.binary_tv);
        decimal_tv=findViewById(R.id.decimal_tv);
        octal_tv=findViewById(R.id.octal_tv);
        hexadecimal_tv=findViewById(R.id.hexadecimal_tv);
        bin=findViewById(R.id.binary);
        dec=findViewById(R.id.decimal);
        oct=findViewById(R.id.octal);
        hex=findViewById(R.id.hexadecimal);
        inp=findViewById(R.id.editTextNumber4);
        bin_btn=findViewById(R.id.button33);
        dec_btn=findViewById(R.id.button34);
        oct_btn=findViewById(R.id.button35);
        hex_btn=findViewById(R.id.button36);
        result=findViewById(R.id.button37);
        clear=findViewById(R.id.button38);
        bin_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String s=String.valueOf(inp.getText());
                    int decimal=Integer.valueOf(s,2);
                    String octal=Integer.toOctalString(decimal);
                    String hexadecimal=Integer.toHexString(decimal);
                    binary_tv.setVisibility(View.VISIBLE);
                    bin.setVisibility(View.VISIBLE);
                    bin.setText(s);
                    result.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            decimal_tv.setVisibility(View.VISIBLE);
                            dec.setVisibility(View.VISIBLE);
                            octal_tv.setVisibility(View.VISIBLE);
                            oct.setVisibility(View.VISIBLE);
                            hexadecimal_tv.setVisibility(View.VISIBLE);
                            hex.setVisibility(View.VISIBLE);
                            dec.setText(String.valueOf(decimal));
                            oct.setText(octal);
                            hex.setText(hexadecimal);
                        }
                    });
                }
                catch(Exception e){
                    return;
                }
            }
        });
        dec_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String s=String.valueOf(inp.getText());
                    int decimal=Integer.valueOf(s);
                    StringBuilder binary=convertDecimal(decimal);
                    String octal=Integer.toOctalString(decimal);
                    String hexadecimal=Integer.toHexString(decimal);
                    decimal_tv.setVisibility(View.VISIBLE);
                    dec.setVisibility(View.VISIBLE);
                    dec.setText(s);
                    result.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            binary_tv.setVisibility(View.VISIBLE);
                            bin.setVisibility(View.VISIBLE);
                            octal_tv.setVisibility(View.VISIBLE);
                            oct.setVisibility(View.VISIBLE);
                            hexadecimal_tv.setVisibility(View.VISIBLE);
                            hex.setVisibility(View.VISIBLE);
                            bin.setText(binary.toString());
                            oct.setText(octal);
                            hex.setText(hexadecimal);
                        }
                    });
                }
                catch(Exception e){
                    return;
                }
            }
        });
        oct_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    String s=String.valueOf(inp.getText());
                    int decimal=Integer.parseInt(s,8);
                    StringBuilder binary=convertDecimal(decimal);
                    String hexadecimal=Integer.toHexString(decimal);
                    octal_tv.setVisibility(View.VISIBLE);
                    oct.setVisibility(View.VISIBLE);
                    oct.setText(s);
                    result.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            binary_tv.setVisibility(View.VISIBLE);
                            bin.setVisibility(View.VISIBLE);
                            decimal_tv.setVisibility(View.VISIBLE);
                            dec.setVisibility(View.VISIBLE);
                            hexadecimal_tv.setVisibility(View.VISIBLE);
                            hex.setVisibility(View.VISIBLE);
                            bin.setText(binary.toString());
                            dec.setText(String.valueOf(decimal));
                            hex.setText(hexadecimal);
                        }
                    });
                }
                catch(Exception e){
                    return;
                }
            }
        });
        hex_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try{
                    
                    String s=String.valueOf(inp.getText());
                    int decimal=Integer.parseInt(s,16);
                    StringBuilder binary=convertDecimal(decimal);
                    String octal=Integer.toOctalString(decimal);
                    hexadecimal_tv.setVisibility(View.VISIBLE);
                    hex.setVisibility(View.VISIBLE);
                    hex.setText(s);
                    result.setOnClickListener(new View.OnClickListener() {
                        @Override
                        public void onClick(View view) {
                            binary_tv.setVisibility(View.VISIBLE);
                            bin.setVisibility(View.VISIBLE);
                            decimal_tv.setVisibility(View.VISIBLE);
                            dec.setVisibility(View.VISIBLE);
                            octal_tv.setVisibility(View.VISIBLE);
                            oct.setVisibility(View.VISIBLE);
                            bin.setText(binary.toString());
                            dec.setText(String.valueOf(decimal));
                            oct.setText(octal);
                        }
                    });
                }
                catch(Exception e){
                    return;
                }
            }
        });
        clear.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                inp.setText("");
                bin.setText("");
                dec.setText("");
                oct.setText("");
                hex.setText("");
                binary_tv.setVisibility(View.INVISIBLE);
                bin.setVisibility(View.INVISIBLE);
                decimal_tv.setVisibility(View.INVISIBLE);
                dec.setVisibility(View.INVISIBLE);
                octal_tv.setVisibility(View.INVISIBLE);
                oct.setVisibility(View.INVISIBLE);
                hexadecimal_tv.setVisibility(View.INVISIBLE);
                hex.setVisibility(View.INVISIBLE);
            }
        });
    }
}
