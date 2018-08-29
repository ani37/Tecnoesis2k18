package com.example.tenx.test272.ListItems;

public abstract class ListItem {
    public static int TYPE_HEADER=0;
    public static int TYPE_EVENT=1;
    public static int TYPE_EVENT2=2;

    public abstract int getType();
}
