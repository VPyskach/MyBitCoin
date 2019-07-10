package com.test.mybitcoin.office.model;

public class OfficeItem {

    private String title;
    private String reserve;
    private String course;

    public OfficeItem(String title, String reserve, String course) {
        this.title = title;
        this.reserve = reserve;
        this.course = course;
    }

    public String getTitle() {
        return title;
    }

    public String getReserve() {
        return reserve;
    }

    public String getCourse() {
        return course;
    }
}
