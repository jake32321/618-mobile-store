package com.jak_reed.www.a618_mobile_store_client;

import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class SelectStore extends AppCompatActivity {

    private VideoView vapeVideo;
    private TextView whichStore;
    private Button aILButton, cILButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_select_store);
        this.getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setIcon(R.drawable.logo);

        vapeVideo = (VideoView) findViewById(R.id.videoView);
        whichStore = (TextView) findViewById(R.id.whichStoreText);
        aILButton = (Button) findViewById(R.id.annaButton);
        cILButton = (Button) findViewById(R.id.carbondaleButton);

        Typeface typeface = Typeface.createFromAsset(getAssets(), "fonts/Roboto-Light.ttf");
        whichStore.setTypeface(typeface);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vapevidback);

        vapeVideo.setVideoURI(uri);
        vapeVideo.start();

        vapeVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        aILButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });

        cILButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                
            }
        });
    }
}
