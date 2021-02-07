package com.project1.entity;

public class Orderlink {
    private Integer id;
    private String name;

    public Orderlink() {
    }

    @Override
    public String toString() {
        return "Orderlink{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Orderlink(Integer id, String name) {
        this.id = id;
        this.name = name;
    }
}
