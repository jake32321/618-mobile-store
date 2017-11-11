package com.jak_reed.www.a618_mobile_store_client;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.net.URI;

/**
 * Created by Jacob Reed on 11/11/2017.
 */

public class JuiceHolder extends RecyclerView.ViewHolder {

    private final TextView juiceName;
    private final TextView juiceSize;
    private final ImageView juiceImage;
    private Context context;

    public JuiceHolder(View view) {
        super(view);
        this.juiceName = (TextView) view.findViewById(R.id.juiceNameCard);
        this.juiceSize = (TextView) view.findViewById(R.id.juiceSizeCard);
        this.juiceImage = (ImageView) view.findViewById(R.id.juiceImage);
        this.context = view.getContext();
    }

    public void bind(Juice juice){
        setName(juice.getName());
        setSize(juice.getjSize());
        setImage(juice.getJuiceURL());
    }

    private void setName(String name){
        this.juiceName.setText(name);
    }

    private void setSize(String size){
        this.juiceSize.setText(size+" ml");
    }

    private  void setImage(String url){
        Picasso.with(this.context).load(url).into(this.juiceImage);
    }
}
