package com.example.a22847.mysqlite;

/**
 * Created by 22847 on 2017/4/16.
 */

public class SpinnerContent {
    private String key  ;
    private String value;

    public SpinnerContent(String key, String value) {
        this.key = key;
        this.value = value;
    }
    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
