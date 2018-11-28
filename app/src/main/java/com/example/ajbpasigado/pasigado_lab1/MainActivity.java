package com.example.ajbpasigado.pasigado_lab1;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    int prev = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onStart() {
        super.onStart();
    }

    @Override
    protected void onRestart() {
        super.onRestart();
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    public void ClickBTN(View v){
        TextView tv = findViewById(R.id.tv_equation);

        TextView result = findViewById(R.id.tv_result);

        int ret = GetNumber(v.getId());
        if (ret != -3 && !(ret == -2 && prev == -2)){
            if (!tv.getText().toString().equals("0")){
                if (ret != -2){
                    tv.setText(tv.getText().toString() + ret);
                } else if (prev != -2){
                    tv.setText(tv.getText().toString() + " + ");
                }
            } else if (ret != -2 && ret != -3){
                tv.setText(Integer.toString(ret));
            }
        } else if (ret == -3){
            if (tv.getText().toString() != "0"){
                Long sum = GetSum(tv.getText().toString());
                result.setText(Long.toString(sum));
                tv.setText("0");
            }
        } else if (ret == -2 && prev == -2){
            tv.setText("0");
            result.setText("0");
        }

        prev = ret;
    }

    public long GetSum(String text){
        Long ret = 0l;
        String[] numbers = text.replace("\n", "").split(" \\+ ");

        for (String num : numbers) {
            try {
                ret += Long.parseLong(num);
            } catch (Exception e){
                Toast.makeText(this, "Number too large", Toast.LENGTH_LONG).show();
            }
        }
        return ret;
    }

    public int GetNumber(int ID){
        int ret = -1;
        switch(ID){
            case R.id.btn_one:
                ret = 1;
                break;
            case R.id.btn_two:
                ret = 2;
                break;
            case R.id.btn_three:
                ret = 3;
                break;
            case R.id.btn_four:
                ret = 4;
                break;
            case R.id.btn_five:
                ret = 5;
                break;
            case R.id.btn_six:
                ret = 6;
                break;
            case R.id.btn_seven:
                ret = 7;
                break;
            case R.id.btn_eight:
                ret = 8;
                break;
            case R.id.btn_nine:
                ret = 9;
                break;
            case R.id.btn_zero:
                ret = 0;
                break;
            case R.id.btn_plus:
                ret = -2;
                break;
            case R.id.btn_equal:
                ret = -3;
                break;
        }
        return ret;
    }


}
