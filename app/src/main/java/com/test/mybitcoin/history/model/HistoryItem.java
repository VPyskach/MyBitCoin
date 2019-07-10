package com.test.mybitcoin.history.model;

public class HistoryItem {

    private int status;
    private String date;
    private String number;
    private String received;
    private String cost;

    public HistoryItem(int status, String date, String number, String received, String cost) {
        this.status = status;
        this.date = date;
        this.number = number;
        this.received = received;
        this.cost = cost;
    }

    public int getStatus() {
        return status;
    }

    public String getDate() {
        return date;
    }

    public String getNumber() {
        return number;
    }

    public String getReceived() {
        return received;
    }

    public String getCost() {
        return cost;
    }
}
