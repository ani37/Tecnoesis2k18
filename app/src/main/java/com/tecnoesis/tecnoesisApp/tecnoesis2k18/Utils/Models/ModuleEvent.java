package com.tecnoesis.tecnoesisApp.tecnoesis2k18.Utils.Models;

public class ModuleEvent {
    private String name, desc, pstat, contact1,contact2, contact3,pdfLink,registerLink, prizeMoney, m1header, m1desc, m2header, m2desc;

    public ModuleEvent(String name, String desc, String pstat, String contact1, String contact2, String pdfLink, String registerLink, String prizeMoney) {
        this.name = name;
        this.prizeMoney = prizeMoney;
        this.desc = desc;
        this.pstat = pstat;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.pdfLink = pdfLink;
        this.registerLink = registerLink;
        m1desc = "";
        m1header = "";
        m2desc = "";
        m2header = "";
        contact3 = "";
    }

    public ModuleEvent(String name, String desc, String pstat, String contact1, String contact2, String pdfLink, String registerLink, String prizeMoney, String m1header, String m1desc, String m2header, String m2desc) {
        this.name = name;
        this.desc = desc;
        this.pstat = pstat;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.pdfLink = pdfLink;
        this.registerLink = registerLink;
        this.prizeMoney = prizeMoney;
        this.m1header = m1header;
        this.m1desc = m1desc;
        this.m2header = m2header;
        this.m2desc = m2desc;
        contact3 = "";
    }


    public ModuleEvent(String name, String desc, String pstat, String contact1, String contact2, String contact3, String pdfLink, String registerLink, String prizeMoney) {
        this.name = name;
        this.desc = desc;
        this.pstat = pstat;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.contact3 = contact3;
        this.pdfLink = pdfLink;
        this.registerLink = registerLink;
        this.prizeMoney = prizeMoney;
        m1desc = "";
        m1header = "";
        m2desc = "";
        m2header = "";

    }

    public ModuleEvent(String name, String desc, String pstat, String contact1, String contact2, String contact3, String pdfLink, String registerLink, String prizeMoney, String m1header, String m1desc, String m2header, String m2desc) {
        this.name = name;
        this.desc = desc;
        this.pstat = pstat;
        this.contact1 = contact1;
        this.contact2 = contact2;
        this.contact3 = contact3;
        this.pdfLink = pdfLink;
        this.registerLink = registerLink;
        this.prizeMoney = prizeMoney;
        this.m1header = m1header;
        this.m1desc = m1desc;
        this.m2header = m2header;
        this.m2desc = m2desc;
    }

    public String getContact3() {
        return contact3;
    }

    public String getM1header() {
        return m1header;
    }

    public String getM1desc() {
        return m1desc;
    }

    public String getM2header() {
        return m2header;
    }

    public String getM2desc() {
        return m2desc;
    }

    public ModuleEvent(String name, String desc) {
        this.name = name;
        this.desc = desc;
        pstat = "";
        contact1 = "";
        contact2 = "";
        pdfLink = "";
        registerLink = "";
        prizeMoney = "";
    }

    public  String getPrizeMoney() {
        return prizeMoney;
    }

    public  String getName() {
        return name;
    }

    public  String getDesc() {
        return desc;
    }

    public  String getPstat() {
        return pstat;
    }

    public  String getContact1() {
        return contact1;
    }

    public String getContact2() {
        return contact2;
    }

    public  String getPdfLink() {
        return pdfLink;
    }

    public  String getRegisterLink() {
        return registerLink;
    }
}
