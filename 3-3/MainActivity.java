//2019038045 조민재
package com.example.week3_3;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView text1, text2;
    CheckBox chkAgree;
    RadioGroup rGroup1;
    RadioButton btndog,btnSquirrel,btnPenguin;
    Button btnOK;
    ImageView imgPet;

    public MainActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("애완동물 사진 보기");

        init();
        initLr();
    }


    public void init() {

        text1 = findViewById(R.id.text1);
        text2 = findViewById(R.id.text2);
        chkAgree = findViewById(R.id.chkAgree);
        rGroup1 = (RadioGroup) findViewById(R.id.Rgroup1);
        btndog = (RadioButton)findViewById(R.id.RdoDog);
        btnSquirrel = (RadioButton)findViewById(R.id.RdoSquirrel);
        btnPenguin = (RadioButton)findViewById(R.id.RdoPenguin);
        btnOK = findViewById(R.id.BtnOK);
        imgPet = findViewById(R.id.ImgPet);

    }


    public void initLr() {
        chkAgree.setOnCheckedChangeListener(
                (buttonView, isChecked) -> {
                    if(chkAgree.isChecked()){
                        text2.setVisibility(android.view.View.VISIBLE);
                        rGroup1.setVisibility(android.view.View.VISIBLE);
                        btnOK.setVisibility(android.view.View.VISIBLE);
                        imgPet.setVisibility(android.view.View.VISIBLE);
                    } else {
                        text1.setVisibility(android.view.View.INVISIBLE);
                        rGroup1.setVisibility(android.view.View.INVISIBLE);
                        btnOK.setVisibility(android.view.View.INVISIBLE);
                        imgPet.setVisibility(android.view.View.INVISIBLE);
                    }
                }
        );
        btnOK.setOnClickListener(arg0 -> {
            switch (rGroup1.getCheckedRadioButtonId()) {
                case R.id.RdoDog:
                    imgPet.setImageResource(R.drawable.dog);
                    break;
                case R.id.RdoSquirrel:
                    imgPet.setImageResource(R.drawable.squirrel);
                    break;
                case R.id.RdoPenguin:
                    imgPet.setImageResource(R.drawable.penguin);
                    break;
                default:
                    Toast.makeText(getApplicationContext(), "동물 먼저 선택하세요",
                            Toast.LENGTH_SHORT).show();
            }
        });
    }
}