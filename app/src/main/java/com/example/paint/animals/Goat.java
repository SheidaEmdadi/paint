package com.example.paint.animals;


import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.paint.R;

public class Goat extends AppCompatActivity {


    ImageView imgShow, imgMusic;
    Button btnPrev, btnNext, btnStart;
    TextView txtStep, txtStepShow;

    Boolean mute = false;

    public MediaPlayer music;


    int IDs[] = {
            R.drawable.goat_1,
            R.drawable.goat_2,
            R.drawable.goat_3,
            R.drawable.goat_4,
    };

    int motion = 0;
    int qty;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_goat);

        music = MediaPlayer.create(this, R.raw.music);
        music.start();

        findViews();
        picsQty();
        imgShow.setImageResource(R.drawable.goat_4_a);
        // imgShow.setImageDrawable(ContextCompat.getDrawable(getApplicationContext(),R.drawable.goat_4));

        //Typeface font = Typeface.createFromAsset(getAssets(),"fonts/brush.TTF");
        // txtStep.setTypeface(font);

        btnPrev.setVisibility(View.INVISIBLE);
        btnNext.setVisibility(View.INVISIBLE);
        txtStep.setVisibility(View.INVISIBLE);
        txtStepShow.setVisibility(View.INVISIBLE);

        btnNext.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                motion++;
                if (motion >= qty)
                    motion = 0;

                imgShow.setImageResource(IDs[motion]);

                txtStepShow.setText(motion + 1 + " از " + qty);
            }
        });

        btnPrev.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                motion--;

                if (motion < 0)
                    motion = qty - 1;

                imgShow.setImageResource(IDs[motion]);

                txtStepShow.setText(motion + 1 + " از " + qty);
            }
        });
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                btnPrev.setVisibility(View.VISIBLE);
                btnNext.setVisibility(View.VISIBLE);
                txtStep.setVisibility(View.VISIBLE);
                txtStepShow.setVisibility(View.VISIBLE);

                imgShow.setImageResource(IDs[motion]);

                txtStepShow.setText(motion + 1 + " از " + qty);

                btnStart.setVisibility(View.INVISIBLE);
            }
        });

        imgMusic.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                if (!mute) {
                    music.pause();
                    imgMusic.setImageResource(R.drawable.music_on);
                    mute = true;
                } else if (mute) {
                    music.start();
                    imgMusic.setImageResource(R.drawable.music_off);
                    mute = false;
                }

            }
        });
    }

    void findViews() {

        imgShow = findViewById(R.id.img_show);
        imgMusic = findViewById(R.id.img_Music);
        btnPrev = findViewById(R.id.btn_prev);
        btnNext = findViewById(R.id.btn_next);
        btnStart = findViewById(R.id.btn_start);
        txtStepShow = findViewById(R.id.txt_stepshow);
        txtStep = findViewById(R.id.txt_step);
    }

    void picsQty() {
        qty = IDs.length;
        imgShow.setImageResource(IDs[motion]);

    }


    @Override
    protected void onPause() {
        super.onPause();

        music.release();

    }
}
