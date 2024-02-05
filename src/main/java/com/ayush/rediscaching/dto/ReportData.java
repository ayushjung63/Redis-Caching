package com.ayush.rediscaching.dto;

public class ReportData {
    private Integer id;
    private String data;
    private String fromDate;
    private String toDate;

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public ReportData(Integer id, String data, String fromDate, String toDate) {
        this.id = id;
        this.data = data;
        this.fromDate = fromDate;
        this.toDate = toDate;
    }

    public ReportData() {
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getData() {
        return data;
    }

    public void setData(String data) {
        this.data = data;
    }
}
