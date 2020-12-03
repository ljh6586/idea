package vi;

import java.awt.image.BufferedImage;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;


public class Flish extends Thread{
    boolean catched;
    List<BufferedImage> animation=new ArrayList<>();
    List<BufferedImage> catchAnimation=new ArrayList<>();
    int catchNmu;
    BufferedImage img;
    int x,y;
    int width,height;
    Random rd=new Random();
    int index=rd.nextInt(9)+1;

    public Flish(){
        String fishName="/iamge/fish0"+index+"_";
        x=rd.nextInt(750);
        y=rd.nextInt(450);

        for(int i=0;i<10;i++){
            int fi=i+1;
            String prefix= (fi==10?"":"0")+fi;
            String imageName=fishName+prefix+".png";
            BufferedImage img=ImageUtil.getImg(imageName);
            animation.add(img);
        }
        catchNmu= index<=7?2:4;
        String catchName;
        for(int i=0;i<catchNmu;i++){
            int catchw=i+1;
            catchName= fishName+"catch_0"+ catchw+".png";
            BufferedImage img=ImageUtil.getImg(catchName);
            catchAnimation.add(img);
        }
        img= animation.get(0);
        width=img.getWidth();
        height=img.getHeight();
    }

    public void run(){
        while(true){
            if(catched){
                turnOver();
                getOut();
                catched=false;
            }
            move();
            try
            {
                Thread.sleep(100);

            }catch (Exception e){}
        }

    }
    public void turnOver(){
        for(int j=0;j<4;j++){
            for(int i=0;i<catchNmu;i++){
                img=catchAnimation.get(i);
                width=img.getWidth();
                height=img.getHeight();

                try {
                    Thread.sleep(20);
                }catch (Exception e){}

            }
        }

    }
    int step_num=0;
    public void move() {
        step_num++;
        img=(BufferedImage) animation.get(step_num%10);
        width=img.getWidth();
        height=img.getHeight();
        x-=3;
        if(x<=-width){
            getOut();
    }

    }
    private void getOut() {
        x=800;
        y=rd.nextInt(500);
    }

}
