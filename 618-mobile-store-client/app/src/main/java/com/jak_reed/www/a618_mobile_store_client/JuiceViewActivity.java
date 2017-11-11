package com.jak_reed.www.a618_mobile_store_client;

import android.content.Intent;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import android.widget.VideoView;

import com.firebase.ui.database.FirebaseRecyclerAdapter;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

public class JuiceViewActivity extends AppCompatActivity {

    VideoView vapeVideo;
    TextView storeName;
    RecyclerView juiceRecView;
    FirebaseDatabase db;
    DatabaseReference dbRef;

    final String TAG = "JuiceViewActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_juice_view);

        Bundle sentData = getIntent().getExtras();
        String store = sentData.getString("store");

        vapeVideo = (VideoView) findViewById(R.id.vapeVideoView);
        storeName = (TextView) findViewById(R.id.storeName);
        juiceRecView = (RecyclerView) findViewById(R.id.juiceRec);
        db = FirebaseDatabase.getInstance();

        if (store != null) {
            if (store.equals("carbondale")){
                storeName.setText("Carbondale, IL");
            } else {
                storeName.setText("Anna, IL");
            }
        } else {
            Toast.makeText(this, "Error: Could not find the store named " + store,
                    Toast.LENGTH_LONG).show();
        }

        dbRef = db.getReference("juice").child(store);

        Uri uri = Uri.parse("android.resource://"+getPackageName()+"/"+R.raw.vape);

        vapeVideo.setVideoURI(uri);
        vapeVideo.start();

        vapeVideo.setOnPreparedListener(new MediaPlayer.OnPreparedListener() {
            @Override
            public void onPrepared(MediaPlayer mp) {
                mp.setLooping(true);
            }
        });

        dbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                for(DataSnapshot ds : dataSnapshot.getChildren()) {
                    Log.d(TAG, "onDataChange: " + ds.getValue());
                }
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(JuiceViewActivity.this,
                        "Error: Could not gather data from Firebase!",
                        Toast.LENGTH_LONG).show();
            }
        });
    }

    @Override
    public void onBackPressed(){
        startActivity(new Intent(this, SelectStore.class));
    }
}
