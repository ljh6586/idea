package vi;

import java.awt.image.BufferedImage;

public class Net  {
    BufferedImage img;
    int x,y,width,height;
    boolean show;
    public Net(){

        img =ImageUtil.getImg("/iamge/net_1.png");
        width=img.getWidth();
        height=img.getHeight();
        x=200;
        y=200;
    }
    public void change(int power){
        img =ImageUtil.getImg("/iamge/net_"+power+".png");
        width=img.getWidth();
        height=img.getHeight();
    }
    boolean catchFish(Flish f){
        boolean hit= f.x<=x + width && f.x>=x-f.width&&
                f.y<=y+height && f.y>=y-f.height;
        return hit;
    }



}
