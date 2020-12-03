package com.sxwl.view;

import com.sxwl.controller.PlaneController;
import com.sxwl.entity.EnemyPlane;
import com.sxwl.entity.FightePlane;
import com.sxwl.utils.P;

import javax.swing.*;

public class FrameWindow extends JFrame {
    public FrameWindow()
    {
        launch();;
    }
    public void launch()
    {
        FightePlane fightePlane=new FightePlane();
        GamePanel gamePanel=new GamePanel(fightePlane);
        PlaneController controller=new PlaneController(fightePlane);
        JFrame jFrame=new JFrame();
        jFrame.add(gamePanel);
        jFrame.addKeyListener(controller);;
        jFrame.setTitle("飞机大战");
        jFrame.setSize(P.width/2,P.height/2+200);
        jFrame.setLocation(P.width/2-300,P.height/2-300);
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.setResizable(false);
        jFrame.setVisible(true);

    }
}
