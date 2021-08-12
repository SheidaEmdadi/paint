package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import cn.pedant.SweetAlert.SweetAlertDialog;

public class MainActivity extends AppCompatActivity {

    Button btnMenu, btnAbout, btnHelp;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnAbout = findViewById(R.id.btn_About);
        btnMenu = findViewById(R.id.btn_menu);
        btnHelp = findViewById(R.id.btn_help);


        btnMenu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(MainActivity.this, Menu.class);
                startActivity(myIntent);
            }
        });


        btnAbout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setCustomImage(R.drawable.ic_love)
                        .setTitleText("تهیه شده توسط: زینب امدادی")
                        .setContentText("لطفا اگر انتقاد یا پیشنهادی دارید باهام در میون بذارید *_*" + "\n" +
                                "email: zeinabemdadi88@gmail.com")
                        .show();

            }
        });

        btnHelp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                new SweetAlertDialog(MainActivity.this, SweetAlertDialog.CUSTOM_IMAGE_TYPE)
                        .setTitleText("راهنما")
                        .setContentText("شما عزیزان میتوانید با کلیک روی دکمه ی فهرست، لیست آموزش های موجود را مشاهده بفرمایید")
                        .setCustomImage(R.drawable.ic_customer_support)
                        .show();
            }
        });





        Animation anim = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_trans);
        Animation anim2 = AnimationUtils.loadAnimation(MainActivity.this, R.anim.anim_trans2);
        btnMenu.startAnimation(anim);
        btnHelp.startAnimation(anim);
        btnAbout.startAnimation(anim2);
    }

    @Override
    public void onBackPressed() {

        exit_dialog();
    }


    public void exit_dialog() {

        new SweetAlertDialog(this, SweetAlertDialog.WARNING_TYPE)
                .setTitleText("واقعا میخوای بری؟")
                .setCancelText("نه نمیرم")
                .setConfirmText("بلی")
                .showCancelButton(true)
                .setConfirmClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        finish();
                    }
                })
                .setCancelClickListener(new SweetAlertDialog.OnSweetClickListener() {
                    @Override
                    public void onClick(SweetAlertDialog sDialog) {
                        sDialog.cancel();
                    }
                }).show();


    }
}