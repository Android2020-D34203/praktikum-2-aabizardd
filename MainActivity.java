package com.example.praktikum2;

import androidx.appcompat.app.AppCompatActivity;
import java.util.Arrays;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Array;

public class MainActivity extends AppCompatActivity {
    private Button btnHitung;
    private EditText angka1, angka2, operasi;
    private TextView hasil,errorText;
    private double d_angka1, d_angka2;
    private String o_operasi, str_a1, str_a2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        init();
    }


    public void init(){
        btnHitung = findViewById(R.id.btn_hitung);
        angka1 = findViewById(R.id.et_angka1);
        angka2 = findViewById(R.id.et_angak2);
        operasi = findViewById(R.id.et_operasi);
        hasil = findViewById(R.id.tv_hasil);
        errorText = findViewById(R.id.tv_error);

    }



    public void setData(View v){

        String[] list_op = {
                "+",
                "-",
                "*",
                "×",
                "x",
                "/",
                "%",
                "÷"
        };

        o_operasi = operasi.getText().toString();
        str_a1 = angka1.getText().toString();
        str_a2 = angka2.getText().toString();

        d_angka1 = Double.valueOf(str_a1).doubleValue();
        d_angka2 = Double.valueOf(str_a2).doubleValue();


        if (Arrays.asList(list_op).contains(o_operasi)) {
            errorText.setText("");
            double result = 0.0;
            if(o_operasi.equals(list_op[0])) {

                result = d_angka1 + d_angka2;
            }
            else if(o_operasi.equals(list_op[1])){
                result = d_angka1 - d_angka2;
            }
            else if(Arrays.asList(Arrays.copyOfRange(list_op, 2, 5)).contains(o_operasi)){
                result = d_angka1 * d_angka2;
            }
            else if(o_operasi.equals(list_op[6])){
                result = d_angka1 % d_angka2;
            }
            else{
                result = d_angka1 / d_angka2;
            }

            String finalResult = new Double(result).toString();
            hasil.setText(finalResult);

        }
        else{
            errorText.setText("OPERASI ARITMATIK TIDAK SESUAI");
            hasil.setText("-");
        }

        angka2.onEditorAction(EditorInfo.IME_ACTION_DONE);
        angka1.onEditorAction(EditorInfo.IME_ACTION_DONE);
        operasi.onEditorAction(EditorInfo.IME_ACTION_DONE);

    }

}