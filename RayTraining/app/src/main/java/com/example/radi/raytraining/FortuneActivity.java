package com.example.radi.raytraining;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.androidanimations.library.Techniques;
import com.daimajia.androidanimations.library.YoYo;

import java.util.Random;

public class FortuneActivity extends AppCompatActivity {

    String fortuneList[] = {
            "Don’t count on it",
            "Ask again later",
            "You may rely on it",
            "Without a doubt",
            "Outlook not so good",
            "It's decidedly so",
            "Signs point to yes",
            "Yes definitely",
            "Yes",
            "My sources say NO"
    };

    TextView mFortuneText;
    ImageView mFortuneBallImage;
    Button mGenerateFortuneButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fortune);

        mFortuneText = (TextView) findViewById(R.id.tvFortune);
        mFortuneBallImage = (ImageView) findViewById(R.id.ivFortune);
        mGenerateFortuneButton = (Button) findViewById(R.id.btnFortune);

        mGenerateFortuneButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int index = new Random().nextInt(fortuneList.length);
                mFortuneText.setText(fortuneList[index]);
                YoYo.with(Techniques.Swing)
                        .duration(500)
                        .playOn(mFortuneBallImage);
            }
        });
    }


}
