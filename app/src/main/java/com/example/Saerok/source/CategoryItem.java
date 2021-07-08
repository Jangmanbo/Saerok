package com.example.Saerok.source;

import android.graphics.Color;

public class CategoryItem {
    String name;
    Color color;
    int resId;

    public CategoryItem(String name, Color color, int resId) {
        this.name=name;
        this.color=color;
        this.resId=resId;
    }

    public String getName() {
        return name;
    }

    public Color getColor() {
        return color;
    }

    public int getResId() {
        return resId;
    }
}
