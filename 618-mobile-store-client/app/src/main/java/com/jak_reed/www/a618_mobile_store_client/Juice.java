package com.jak_reed.www.a618_mobile_store_client;

/**
 * Created by Jacob Reed on 11/8/2017.
 */

public class Juice {

    private String jName;
    private String jSize;

    public Juice(String name, String size){
        jName = name;
        jSize = size;
    }

    public String getName() {
        return jName;
    }

    public String getjSize(){
        return jSize;
    }
}
