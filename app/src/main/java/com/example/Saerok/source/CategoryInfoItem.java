package com.example.Saerok.source;

public class CategoryInfoItem {
    int num;
    String name;
    int type;

    public CategoryInfoItem(int num) {
        this.num=num;
    }

    public CategoryInfoItem(int num, String name, int type) {
        this.num=num;
        this.name=name;
        this.type=type;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setType(int type) {
        this.type = type;
    }

    public int getNum() {
        return num;
    }

    public String getName() {
        return name;
    }

    public int getType() {
        return type;
    }
}
