package com.tecnoesis.tecnoesisApp.tecnoesis2k18.ListItems;

public class ResultListItemII extends ListItem{
    @Override
    public int getType() {
        return ListItem.TYPE_EVENT2;
    }
    private String mPlace;
    private String name;

    public ResultListItemII(String mPlace, String name) {
        this.mPlace = mPlace;
        this.name = name;
    }

    public String getmPlace() {
        return mPlace;
    }

    public String getName() {
        return name;
    }
}
