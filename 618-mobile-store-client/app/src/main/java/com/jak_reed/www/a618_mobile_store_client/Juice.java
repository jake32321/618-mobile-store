package com.jak_reed.www.a618_mobile_store_client;

import java.net.URI;
import java.net.URL;

/**
 * Created by Jacob Reed on 11/8/2017.
 */

public class Juice {

    private String jName;
    private String jSize;
    private String juicePictureURL;

    public Juice(String name, String size, String uri){
        this.jName = name;
        this.jSize = size;
        this.juicePictureURL = uri;
    }

    public String getName() {
        return this.jName;
    }

    public String getjSize(){
        return this.jSize;
    }

    public String getJuiceURL() { return  this.juicePictureURL; }
}
