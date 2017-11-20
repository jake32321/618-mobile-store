package com.jak_reed.www.a618_mobile_store_client;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;


/**
 * Created by Jacob Reed on 11/11/2017.
 */

public class JuiceHolder extends RecyclerView.ViewHolder {

    private final ImageView juiceImage;
    private final TextView juiceName;
    private final TextView juiceSize;
    private Context context;

    public JuiceHolder(View view) {
        super(view);
        juiceName = (TextView) view.findViewById(R.id.juiceNameCard);
        juiceSize = (TextView) view.findViewById(R.id.juiceSizeCard);
        juiceImage = (ImageView) view.findViewById(R.id.juiceImage);
        this.context = view.getContext();
    }

    public void setName(String name){
        juiceName.setText(name);
    }

    public void setSize(String size) {
        juiceSize.setText(size+" ml");
    }

    public void setJuiceImage(String url) {
        Picasso.with(this.context).load(url).fit().centerCrop().into(this.juiceImage);
    }
}
