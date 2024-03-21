package com.example.myapplication;

import static androidx.core.content.ContextCompat.startActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Stack;

public class Calculator extends AppCompatActivity {
    private static TextView txtview,txtview2;
    static StringBuilder str=new StringBuilder();
    static String answer="";

    //Bundle extras;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.calculator);
        txtview=findViewById(R.id.textView);
        txtview2=findViewById(R.id.textView4);
        //extras = getIntent().getExtras();
        
    }

    public void onbtnclick(View view) {
        str.append("1");
        txtview.setText(str);
    }
    public void onbtnclick2(View view) {
        str.append("2");
        txtview.setText(str);
    }
    public void onbtnclick3(View view) {
        str.append("3");
        txtview.setText(str);
    }
    public void onbtnclick4(View view) {
        str.append("4");
        txtview.setText(str);
    }
    public void onbtnclick5(View view) {
        str.append("5");
        txtview.setText(str);
    }
    public void onbtnclick6(View view) {
        str.append("6");
        txtview.setText(str);
    }
    public void onbtnclick7(View view) {
        str.append("7");
        txtview.setText(str);
    }
    public void onbtnclick8(View view) {
        str.append("8");
        txtview.setText(str);
    }
    public void onbtnclick9(View view) {
        str.append("9");
        txtview.setText(str);
    }
    public void onbtnclick10(View view) {
        str.append("0");
        txtview.setText(str);
    }
    public void onbtnclick14(View view) {
        str.append("+");
        txtview.setText(str);
    }
    public void onbtnclick15(View view) {
        str.append("-");
        txtview.setText(str);
    }
    public void onbtnclick16(View view) {
        str.append("*");
        txtview.setText(str);
    }
    public void onbtnclick12(View view) {
        int size=str.length();
        if(str.length()==0){
            txtview.setText("");
        }
        else {
            str.deleteCharAt(size-1);
            txtview.setText(str);
        }
    }
    public void onbtnclick17(View view) {
        str.append("/");
        txtview.setText(str);
    }
    public void onbtnclick18(View view) {
        str.append("(");
        txtview.setText(str);
    }
    public void onbtnclick19(View view) {
        str.append(")");
        txtview.setText(str);
    }
    public void onbtnclick20(View view) {
        str.delete(0,str.length());
        txtview.setText(str);
        txtview2.setText("");
        if(str.length()==0){
            txtview.setText("");
        }
    }
    public void onbtnclick21(View view){
        str.append(".");
        txtview.setText(str);
    }
    public void onbtnclick22(View view){
        str.append("^");
        txtview.setText(str);
    }
    public void onbtnclick23(View view) {
        str.delete(0,str.length());
        str.append(answer);
        txtview.setText(answer);
    }
    public static int check(String string){
        String[] digit=string.split(" ");
        int c=0;
        for(String i:digit){
            if(i.matches(".*\\d.*")) c++;
        }
        return c;
    }
    public void onbtnclick13(View view){
        Stack<Character> stack = new Stack<>();
        StringBuilder postfix = new StringBuilder();
        for (int i = 0; i < str.length(); i++) {
            char a = str.charAt(i);
            if (Character.isDigit(a)) {
                while (i < str.length() && (Character.isDigit(str.charAt(i))|| str.charAt(i)=='.')) {
                    postfix.append(str.charAt(i));
                    i++;
                }
                postfix.append(' ');
                i--;
            } else if (a == '(') {
                stack.push(a);
            } else if (a == ')') {
                while (!stack.isEmpty() && stack.peek() != '(') {
                    postfix.append(stack.pop());
                    postfix.append(' ');
                }
                stack.pop();
            } else {
                while (!stack.isEmpty() && precedence(stack.peek()) >= precedence(a)) {
                    postfix.append(stack.pop());
                    postfix.append(' ');
                }
                stack.push(a);
            }
        }
        while (!stack.isEmpty()) {
            postfix.append(stack.pop());
            postfix.append(' ');
        }
        String pf = postfix.toString();
        int no_digits=check(pf);
        if(no_digits<2) return;
        //txtview.setText(pf);
        Stack<String> stack2 = new Stack<>();
        String[] digits=pf.split(" ");
        for(String c:digits){
            if(c.equals("+")){
                String a=stack2.pop();
                String b=stack2.pop();
                String s;
                if(a.matches("\\d+")){
                    int x=Integer.valueOf(a);
                    if(b.matches("\\d+")){
                        int y=Integer.valueOf(b);
                        s=String.valueOf(x+y);
                    }
                    else{
                        float y=Float.parseFloat(b);
                        s=String.valueOf(x+y);
                    }
                }
                else{
                    float x=Float.parseFloat(a);
                    if(b.matches("\\d*[.]\\d+")){
                        float y=Float.parseFloat(b);
                        s=String.valueOf(x+y);
                    }
                    else{
                        int y=Integer.valueOf(b);
                        s=String.valueOf(x+y);
                    }
                }
                stack2.push(s);
            }
            else if(c.equals("-")){
                String a=stack2.pop();
                String b=stack2.pop();
                String s;
                if(a.matches("\\d+")){
                    int x=Integer.valueOf(a);
                    if(b.matches("\\d+")){
                        int y=Integer.valueOf(b);
                        s=String.valueOf((-1)*(x-y));
                    }
                    else{
                        float y=Float.parseFloat(b);
                        s=String.valueOf((-1)*(x-y));
                    }
                }
                else{
                    float x=Float.parseFloat(a);
                    if(b.matches("\\d*[.]\\d+")){
                        float y=Float.parseFloat(b);
                        s=String.valueOf((-1)*(x-y));
                    }
                    else{
                        int y=Integer.valueOf(b);
                        s=String.valueOf((-1)*(x-y));
                    }
                }
                stack2.push(s);
            }
            else if(c.equals("*")){
                String a=stack2.pop();
                String b=stack2.pop();
                String s;
                if(a.matches("\\d+")){
                    int x=Integer.valueOf(a);
                    if(b.matches("\\d+")){
                        int y=Integer.valueOf(b);
                        s=String.valueOf(x*y);
                    }
                    else{
                        float y=Float.parseFloat(b);
                        s=String.valueOf(x*y);
                    }
                }
                else{
                    float x=Float.parseFloat(a);
                    if(b.matches("\\d*[.]\\d+")){
                        float y=Float.parseFloat(b);
                        s=String.valueOf(x*y);
                    }
                    else{
                        int y=Integer.valueOf(b);
                        s=String.valueOf(x*y);
                    }
                }
                stack2.push(s);
            }
            else if(c.equals("/")){
                String a=stack2.pop();
                String b=stack2.pop();
                String s;
                try{
                    if(a.matches("\\d+")){
                        int x=Integer.valueOf(a);
                        if(b.matches("\\d+")){
                            int y=Integer.valueOf(b);
                            s=String.valueOf((float)y/x);
                        }
                        else{
                            float y=Float.parseFloat(b);
                            s=String.valueOf(y/x);
                        }
                    }
                    else{
                        float x=Float.parseFloat(a);
                        if(b.matches("\\d*[.]\\d+")){
                            float y=Float.parseFloat(b);
                            s=String.valueOf(y/x);
                        }
                        else{
                            int y=Integer.valueOf(b);
                            s=String.valueOf(y/x);
                        }
                    }
                    stack2.push(s);
                }
                catch(Exception e){
                    txtview.setText(e.toString());
                }
            }
            else if(c.equals("^")){
                String a=stack2.pop();
                String b=stack2.pop();
                String s;
                if(a.matches("\\d+")){
                    int x=Integer.valueOf(a);
                    if(b.matches("\\d+")){
                        int y=Integer.valueOf(b);
                        int z=(int)Math.pow(y,x);
                        s=String.valueOf(z);
                    }
                    else{
                        float y=Float.parseFloat(b);
                        float z=(float)Math.pow(y,x);
                        s=String.valueOf(z);
                    }
                }
                else{
                    float x=Float.parseFloat(a);
                    if(b.matches("\\d*[.]\\d+")){
                        float y=Float.parseFloat(b);
                        float z=(float)Math.pow(y,x);
                        s=String.valueOf(z);
                    }
                    else{
                        int y=Integer.valueOf(b);
                        float z=(float)Math.pow(y,x);
                        s=String.valueOf(z);
                    }
                }
                stack2.push(s);
            }
            else{
                stack2.push(c);
            }
        }
        answer=stack2.peek();
        txtview2.setText(answer);
        //txtview.setText(str);

    }
    public static int precedence(char opr){
        switch(opr){
            case('^'):{
                return 5;
            }
            case('/'):{
                return 4;
            }
            case('*'):{
                return 3;
            }
            case('+'):{
                return 2;
            }
            case('-'):{
                return 1;
            }
            default:{
                return 0;
            }
        }
    }


    public void onbtnclick24(View view) {
        Intent intent=new Intent(Calculator.this,NumberConversion.class);
        startActivity(intent);
    }

    public void onbtnclick27(View view) {
        Intent intent=new Intent(Calculator.this, math.class);
        startActivity(intent);
    }
}
