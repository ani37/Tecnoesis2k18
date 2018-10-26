package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils;

public class TeamMember {
    private String name;
    private String memberRole;
    private int imgRes;

    public TeamMember(String name, String memberRole, int imgRes) {
        this.name = name;
        this.memberRole = memberRole;
        this.imgRes = imgRes;
    }

    public String getName() {
        return name;
    }

    public int getImgRes() {
        return imgRes;
    }

    public String getMemberRole() {
        return memberRole;
    }
}
