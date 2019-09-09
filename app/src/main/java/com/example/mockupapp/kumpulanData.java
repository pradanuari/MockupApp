package com.example.mockupapp;

public class kumpulanData {
    String nama, url;

    public kumpulanData() {
    }

    public kumpulanData(String nama, String url) {
        this.nama = nama;
        this.url = url;
    }

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
