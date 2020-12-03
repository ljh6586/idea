package com.sxwl.entity;

import com.sxwl.view.GamePanel;
import javafx.beans.property.ReadOnlyMapProperty;

import java.util.ArrayList;
import java.util.Queue;
import java.util.Random;

public class CreateEnemy extends Thread{
    Random random=new Random();
    public void run()
    {
        for(int i=0;i<1;i++)
        {
            try
            {
                EnemyPlane e=new EnemyPlane();
                e.x=random.nextInt(500)+100;
                e.y=-150;
                GamePanel.EnemyPlanearrayList.add(e);
                Thread.sleep(900);
               // System.out.println("zhix");
            } catch (InterruptedException e) { }
        }
    }
}
