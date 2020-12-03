package com.sxwl.controller;

import com.sxwl.entity.FightePlane;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class PlaneController implements KeyListener {
    FightePlane fightePlane;
    public PlaneController( FightePlane fightePlane){
        this.fightePlane=fightePlane;
    }

    public void diretion(int code){
        switch(code){
            case 37:
                fightePlane.x-=5;
                break;
            case 38:
                fightePlane.y-=5;
                break;
            case 39:
                fightePlane.x+=5;
                break;

            case 40:
                fightePlane.y+=5;
                break;
        }
    }

    @Override
    public void keyTyped(KeyEvent e) {
    }

    @Override
    public void keyPressed(KeyEvent e) {
            diretion(e.getKeyCode());

    }

    @Override
    public void keyReleased(KeyEvent e) {
    }
}
