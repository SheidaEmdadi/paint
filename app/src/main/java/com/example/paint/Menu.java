package com.example.paint;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;

import com.example.paint.animals.Frog;
import com.example.paint.animals.Giraffe;
import com.example.paint.animals.Goat;
import com.example.paint.animals.Kitty;
import com.example.paint.animals.Ostrich;
import com.example.paint.animals.Rabbit;

public class Menu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_menu);

        ImageButton ImgbBoz, ImgbOstrich, ImgbGirrafe, ImgbKitty, ImgbRabbit, ImgbFrog;


        ImgbBoz = findViewById(R.id.boz);
        ImgbOstrich = findViewById(R.id.imgb_ostrich);
        ImgbGirrafe = findViewById(R.id.imgb_giraffe);
        ImgbKitty = findViewById(R.id.imgb_kitty);
        ImgbRabbit = findViewById(R.id.imgb_rabbit);
        ImgbFrog = findViewById(R.id.imgb_frog);




        Animation anim = AnimationUtils.loadAnimation(Menu.this, R.anim.anim_rotat);
        ImgbBoz.startAnimation(anim);
        ImgbOstrich.startAnimation(anim);
        ImgbGirrafe.startAnimation(anim);
        ImgbKitty.startAnimation(anim);
        ImgbFrog.startAnimation(anim);
        ImgbRabbit.startAnimation(anim);



        ImgbBoz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Menu.this, Goat.class);
                startActivity(myIntent);
            }
        });

        ImgbOstrich.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Menu.this, Ostrich.class);
                startActivity(myIntent);
            }
        });
        ImgbGirrafe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Menu.this, Giraffe.class);
                startActivity(myIntent);
            }
        });
        ImgbKitty.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Menu.this, Kitty.class);
                startActivity(myIntent);
            }
        });
        ImgbRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Menu.this, Rabbit.class);
                startActivity(myIntent);
            }
        });
        ImgbRabbit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent myIntent = new Intent(Menu.this, Frog.class);
                startActivity(myIntent);
            }
        });
    }
}
