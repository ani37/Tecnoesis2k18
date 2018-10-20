package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils;

import java.util.List;

public class TeamHeader {
    private String headerName;
    private List<TeamMember> teamList;

    public TeamHeader(String headerName, List<TeamMember> teamList) {
        this.headerName = headerName;
        this.teamList = teamList;
    }

    public String getHeaderName() {
        return headerName;
    }

    public List<TeamMember> getTeamList() {
        return teamList;
    }
}
