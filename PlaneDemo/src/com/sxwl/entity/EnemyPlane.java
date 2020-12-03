package com.sxwl.entity;

//import com.sxwl.utils.PUtils;

//import com.sxwl.utils.PUtils;

import com.sxwl.utils.P;
import com.sxwl.utils.PUtils;

import java.awt.*;
import java.util.ArrayList;


public class EnemyPlane extends GameObject {

   public static Image dj= PUtils.getImage("images/dj.png");

    boolean flage=true;
    public EnemyPlane(){

        width=120;
        height=120;


    }
    @Override
    public void drawMe(Graphics g) {
        g.drawImage(dj,x,y,width,height,null);
        y+=1;
        if(y> P.height/2+200){
            y=-150;
        }
    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(x,y,width,height);
    }


}
