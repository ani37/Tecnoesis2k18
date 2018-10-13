package com.example.tenx.test272.ListItems;

public class EventItem extends ListItem{
    private String name;
    private String url;
    private String desc;
    private int imgRes;



    public EventItem(String name, String url) {
        this.name = name;
        this.url = url;
        imgRes = -1;
    }

    public EventItem(String name, String url, String desc, int imgRes) {
        this.name = name;
        this.url = url;
        this.desc = desc;
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public String getUrl() {
        return url;
    }
    public String getDesc() {
        return desc;
    }

    public int getImgRes() {
        return imgRes;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_EVENT;
    }
}