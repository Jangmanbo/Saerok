package com.example.Saerok.source;

import android.graphics.Color;

public class CategoryItem {
    String name;
    String color;
    int resId;

    public CategoryItem(String name, String color, int resId) {
        this.name=name;
        this.color=color;
        this.resId=resId;
    }

    public String getName() {
        return name;
    }

    public String getColor() {
        return color;
    }

    public int getResId() {
        return resId;
    }
}
