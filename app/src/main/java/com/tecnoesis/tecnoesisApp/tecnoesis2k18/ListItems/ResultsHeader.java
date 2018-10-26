package com.tecnoesis.tecnoesisApp.tecnoesis2k18.ListItems;

public class ResultsHeader extends ListItem {
    private String name;
    private String eventName;

    public ResultsHeader(String name, String eventName) {
        this.name = name;
        this.eventName = eventName;
    }
    public ResultsHeader( String eventName) {
        this.name = "";
        this.eventName = eventName;
    }

    public String getName() {
        return name;

    }

    public String getEventName() {
        return eventName;
    }

    @Override
    public int getType() {
        return ListItem.TYPE_HEADER;
    }
}
