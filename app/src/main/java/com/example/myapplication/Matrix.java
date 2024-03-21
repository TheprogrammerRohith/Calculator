package com.example.myapplication;

import android.os.Bundle;
import android.os.PersistableBundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
class Invalid_Operation extends Exception{
    public Invalid_Operation(String message) {
        super(message);
    }
}

public class Matrix extends AppCompatActivity {
    private static EditText edttxt1,edttxt2;
    private static Button add,sub,mul,ans,enter,clr;
    private static TextView txtview;
    private static String answer;
    private static float[][] matrix_A,matrix_B;
    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.matrix);
        edttxt1=findViewById(R.id.matrixA);
        edttxt2=findViewById(R.id.matrixB);
        add=findViewById(R.id.button39);
        sub=findViewById(R.id.button40);
        mul=findViewById(R.id.button41);
        ans=findViewById(R.id.button42);
        enter=findViewById(R.id.button43);
        clr=findViewById(R.id.button45);
        txtview=findViewById(R.id.result);
        enter.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                try {
                    String A = String.valueOf(edttxt1.getText());
                    String B = String.valueOf(edttxt2.getText());
                    String[] rows_A_A = A.split(";");
                    String[] rows_A_B = B.split(";");
                    int r = rows_A_A.length;
                    int r2 = rows_A_B.length;
                    matrix_A = new float[r][];
                    matrix_B = new float[r2][];
                    for (int i = 0; i < r; i++) {
                        String[] elements = rows_A_A[i].split(" ");
                        matrix_A[i] = new float[elements.length];
                        for (int j = 0; j < elements.length; j++) {
                            matrix_A[i][j] = Float.parseFloat(elements[j]);
                        }
                    }
                    for (int i = 0; i < r2; i++) {
                        String[] elements = rows_A_B[i].split(" ");
                        matrix_B[i] = new float[elements.length];
                        for (int j = 0; j < elements.length; j++) {
                            matrix_B[i][j] = Float.parseFloat(elements[j]);
                        }
                    }
                }
                catch(Exception e){
                    Toast.makeText(getApplicationContext(),"INVALID INPUT", Toast.LENGTH_SHORT);
                }
            }
        });
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder str=new StringBuilder();
                try{
                    float[][] result=evaluate(matrix_A,matrix_B,'+');
                    for(int i=0;i<result.length;i++){
                        for(int j=0;j<result[i].length;j++){
                            str.append(result[i][j]);
                            if(j<result[i].length-1) str.append(" ");
                        }
                        if(i<result.length-1) str.append(";");
                    }
                    answer=str.toString();
                }
                catch(Invalid_Operation e){
                    System.out.println(e.getMessage());
                }
                catch(Exception e){
                    return;
                }
            }
        });
        sub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder str=new StringBuilder();
                try{
                    float[][] result=evaluate(matrix_A,matrix_B,'-');
                    for(int i=0;i<result.length;i++){
                        for(int j=0;j<result[i].length;j++){
                            str.append(result[i][j]);
                            if(j<result[i].length-1) str.append(" ");
                        }
                        if(i<result.length-1) str.append(";");
                    }
                    answer=str.toString();
                }
                catch(Invalid_Operation e){
                    System.out.println(e.getMessage());
                }
                catch(Exception e){
                    return;
                }
            }
        });
        mul.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                StringBuilder str=new StringBuilder();
                try{
                    float[][] result=evaluate(matrix_A,matrix_B,'*');
                    for(int i=0;i<result.length;i++){
                        for(int j=0;j<result[i].length;j++){
                            str.append(result[i][j]);
                            if(j<result[i].length-1) str.append(" ");
                        }
                        if(i<result.length-1) str.append(";");
                    }
                    answer=str.toString();
                }
                catch(Invalid_Operation e){
                    txtview.setText(e.getMessage());
                }
                catch(Exception e){
                    return;
                }
            }
        });
        ans.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                txtview.setText(answer);
            }
        });
        clr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                edttxt1.setText("");
                edttxt2.setText("");
                txtview.setText("");
            }
        });
    }
    public static float[][] evaluate(float[][] A, float[][] B, char operator) throws Invalid_Operation{
        int rows_A=A.length;
        int cols_A=A[0].length;
        int rows_B=B.length;
        int cols_B=B[0].length;
        float[][] result=new float[rows_A][cols_B];
        switch(operator){
            case('+'):{
                if(rows_A!=rows_B || cols_A!=cols_B){
                    throw new Invalid_Operation("dimensions of the matrices are incompatible for addition");
                }
                for(int i=0;i<rows_A;i++){
                    for(int j=0;j<cols_B;j++){
                        result[i][j]=A[i][j]+B[i][j];
                    }
                }
                break;
            }
            case('-'):{
                if(rows_A!=rows_B || cols_A!=cols_B){
                    throw new Invalid_Operation("dimensions of the matrices are incompatible for subtraction");
                }
                for(int i=0;i<rows_A;i++){
                    for(int j=0;j<cols_B;j++){
                        result[i][j]=A[i][j]-B[i][j];
                    }
                }
                break;
            }
            case('*'):{
                if(cols_A!=rows_B){
                    throw new Invalid_Operation("dimensions of the matrices are incompatible for multiplication");
                }
                for(int i=0;i<rows_A;i++){
                    for(int j=0;j<cols_A;j++){
                        for(int k=0;k<cols_B;k++){
                            result[i][j]+=A[i][k]+B[k][j];
                        }
                    }
                }
                break;
            }
            default:{
                throw new Invalid_Operation("invalid Operator");
            }
        }
        return result;
    }
}
