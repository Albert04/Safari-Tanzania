package com.example.safari.dashboard;


public class Upload {
    private String name, image_url, key;

    public Upload(String name, String image_url, String key) {
        if (name.trim().equals("")){
            name = "No name";
        }
        this.name = name;
        this.image_url = image_url;
        this.key = key;
    }

    public Upload() {
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public String getKey() {
        return key;
    }

    public void setKey(String key) {
        this.key = key;
    }
}
