package vi;

import javax.swing.*;
import java.awt.*;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.ArrayList;

public class GamePanel extends JPanel {
    Image bg=ImageUtil.getImg("/iamge/bg.jpg");
    Flish fish;

    ArrayList<Flish> flishes=new ArrayList<>();
    int fishNmu=2;
    Net net=new Net();
    public GamePanel(){
        setBackground(Color.pink);
        for(int i=0;i<fishNmu;i++){
            flishes.add(new Flish());
        }
       createMouseListener();
    }
    public void createMouseListener(){
        MouseAdapter adapter=new MouseAdapter() {
            public void mouseMoved(MouseEvent e){
                int mx=e.getX();
                int my=e.getY();
                net.x=mx-net.width/2;
                net.y=my-net.height/2;
                repaint();
            }
           public void mouseClicked(MouseEvent e){
               int m=e.getModifiers();
                if(m==16){
                    catchFish();
                }else if(m==4){
                    changePower();
                    int mx=e.getX();
                    int my=e.getY();
                    net.x=mx-net.width/2;
                    net.y=my-net.height/2;

                }
                repaint();
           }
           public void mouseExited(MouseEvent e){
                net.show=false;
                repaint();
           }
            public void mouseEntered(MouseEvent e){
                net.show=true;
                repaint();
            }

        };
        addMouseMotionListener(adapter);
        addMouseListener(adapter);
    }
    int power=1;
    public void changePower(){
        power++;
        power= power>7? 1:power;
        net.change(power);
    }
    public synchronized void  catchFish(){
        for(int i=0;i<fishNmu;i++){
                Flish f=flishes.get(i);
            if(net.catchFish(f)){
               f.catched=true;
            }
        }
    }
    public void action(){
        for(int i=0;i<fishNmu;i++){
            fish=flishes.get(i);
            fish.start();
        }
        new Uppaint().start();

    }

    public void paint(Graphics g){

        g.drawImage(bg,0,0,null);
        g.setColor(Color.yellow);
        g.setFont(new Font("宋体",Font.BOLD,10));
        g.drawString("分数:0",20,30);
        g.drawString("子弹数:100",90,30);
        g.drawString("power:"+power,720,30);
        g.setColor(Color.red);
        g.drawString("右键调整火力值",700,45);
        for(int i=0;i<flishes.size();i++){
            fish=flishes.get(i);
            g.drawImage(fish.img,fish.x,fish.y,fish.width,fish.height,null);
        }
        if(net.show==true ){
            g.drawImage(net.img,net.x,net.y,net.width,net.height,null);
        }

    }
    class Uppaint extends Thread{
        public void run(){
            while(true){
                repaint();
                try{
                Thread.sleep(100);
                }catch (Exception e){}

            }
        }
    }

}
