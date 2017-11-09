package com.example.oliver.animacionframes;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button button,button1;
    private ImageView imageView;
    private AnimationDrawable vegetaAnimation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageView = (ImageView) findViewById(R.id.animation);
        button = (Button) findViewById(R.id.btnRun);
        button1 = (Button) findViewById(R.id.btnClear);

        if (imageView == null) throw new AssertionError();

        imageView.setVisibility(View.INVISIBLE);
        imageView.setBackgroundResource(R.drawable.vegeta_animation);

        vegetaAnimation = (AnimationDrawable) imageView.getBackground();
        vegetaAnimation.setOneShot(true);

        onStartBtnClick();
        onStopBtnClick();
    }

    public void onStartBtnClick() {
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                imageView.setVisibility(View.VISIBLE);
                if (vegetaAnimation.isRunning()) {
                    vegetaAnimation.stop();
                }
                vegetaAnimation.start();
            }
        });
    }

    public void onStopBtnClick() {
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                vegetaAnimation.stop();
            }
        });
    }

}
