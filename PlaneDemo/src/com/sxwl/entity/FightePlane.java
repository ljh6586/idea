package com.sxwl.entity;



import com.sxwl.utils.PUtils;
import com.sxwl.view.GamePanel;

import java.awt.*;
import java.util.ArrayList;


public class FightePlane extends GameObject {
    ArrayList<Bullet> arrayList =new ArrayList<>();
   public static Image image= PUtils.getImage("images/zdj.png");
    public static Image zd= PUtils.getImage("images/zd.png");
    boolean flage=true;
    public FightePlane(){
        x=300;
        y=600;
        width=120;
        height=120;
       new CrateBullet().start();

    }
    @Override
    public void drawMe(Graphics g) {
        g.drawImage(image,x,y,width,height,null);
        for(int i=0;i<arrayList.size();i++){
            for(int j=0;j<GamePanel.EnemyPlanearrayList.size();j++){
                if(GamePanel.EnemyPlanearrayList.get(j).getRect().intersects(arrayList.get(i).getRect()))
                {

                    break;
                } else if(arrayList.get(i).y<30)
                    {
                    arrayList.remove(i);
                    break;
                    }else{
                    arrayList.get(i).drawMe(g);
                    }
            }


        }

    }

    @Override
    public Rectangle getRect() {
        return new Rectangle(x,y,width,height);
    }

    class Bullet extends GameObject{
        public Bullet(){

            width=30;
            height=80;
        }
        @Override
        public void drawMe(Graphics g) {
             g.drawImage(zd,x,y,width,height,null);
             y-=2;
        }

        @Override
        public Rectangle getRect() {
            return new Rectangle(x,y,width,height);
        }

    }
    class CrateBullet extends Thread{
        public void run(){
            while(true){
                try{
                    Bullet bullet=new Bullet();
                    bullet.x= x+45;
                    bullet.y= y-10;
                    arrayList.add(bullet);
                    Thread.sleep(800);
                }catch(Exception e){}
            }
        }
    }
}
