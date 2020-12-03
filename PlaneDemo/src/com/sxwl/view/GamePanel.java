package com.sxwl.view;

import com.sxwl.entity.CreateEnemy;
import com.sxwl.entity.EnemyPlane;
import com.sxwl.entity.FightePlane;
import com.sxwl.utils.P;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    public  static ArrayList<EnemyPlane>  EnemyPlanearrayList =new ArrayList<>();

    private  FightePlane fightePlane;

    public GamePanel(FightePlane fightePlane){
        this.fightePlane=fightePlane;
        new UpdateGame().start();
        new CreateEnemy().start();
    }

    boolean flage=true;
    public void paint(Graphics g){
        g.setColor(Color.darkGray);
        g.fillRect(0,0, P.width/2,P.height/2+200);

        if(fightePlane!=null)
        {
            fightePlane.drawMe(g);

       }

        for(int i=0;i<EnemyPlanearrayList.size();i++){

            EnemyPlanearrayList.get(i).drawMe(g);

        }

    }
    class UpdateGame extends Thread{
        public void run(){
            while(flage){
                try {
                    //Thread.sleep(100);
                    repaint();
                }catch (Exception e){}

            }
        }

    }
}
