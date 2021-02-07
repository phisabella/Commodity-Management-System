package com.project1.entity;

public class Permission {
    public String getLevel() {
        return level;
    }

    public void setLevel(String level) {
        this.level = level;
    }

    public int getKan() {
        return kan;
    }

    public void setKan(int kan) {
        this.kan = kan;
    }

    public int getGai() {
        return gai;
    }

    public void setGai(int gai) {
        this.gai = gai;
    }

    public int getShan() {
        return shan;
    }

    public void setShan(int shan) {
        this.shan = shan;
    }

    private String level;
    private int kan;
    private int gai;
    private int shan;

}
