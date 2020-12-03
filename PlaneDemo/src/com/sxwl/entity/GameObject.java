package com.sxwl.entity;

import java.awt.*;

public abstract class GameObject {

    public int x,y,width,height;
    public abstract void drawMe(Graphics g);
    public abstract Rectangle getRect();
}
