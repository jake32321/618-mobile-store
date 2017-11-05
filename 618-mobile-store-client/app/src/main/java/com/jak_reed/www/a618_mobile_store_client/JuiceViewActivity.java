package com.jak_reed.www.a618_mobile_store_client;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.VideoView;

public class JuiceViewActivity extends AppCompatActivity {

    VideoView vapeVideo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_view);

        vapeVideo = (VideoView) findViewById(R.id.vapeVideoView);
        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vape);

        vapeVideo.setVideoURI(uri);
        vapeVideo.start();

        vapeVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, SelectStore.class));
    }
}
