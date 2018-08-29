package com.example.tenx.test272.ListItems;

public class ResultListitem extends ListItem{
    private String name;

    public ResultListitem(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_EVENT;
    }
}
