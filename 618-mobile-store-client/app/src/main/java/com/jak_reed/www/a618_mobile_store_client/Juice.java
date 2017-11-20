package com.jak_reed.www.a618_mobile_store_client;

import java.net.URI;
import java.net.URL;

/**
 * Created by Jacob Reed on 11/8/2017.
 */

public class Juice {

    private String name;
    private String size;
    private String pictureURL;

    public Juice() {}

    public Juice(String name, String size, String pictureURL){
        this.name = name;
        this.size = size;
        this.pictureURL = pictureURL;
    }

    public String getName() {
        return this.name;
    }

    public String getSize(){
        return this.size;
    }

    public  String getPictureURL() { return this.pictureURL; }
}
