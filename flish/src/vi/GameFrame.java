package vi;

import javax.swing.*;

public class GameFrame extends JFrame {
    public GameFrame()
    {
        setTitle("捕鱼达人");

        setBounds(400,100,800,500);

        setResizable(false);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
    public static void main(String  args[])
    {
        GameFrame frame=new GameFrame();
        GamePanel panel=new GamePanel();
        panel.action();
        frame.add(panel);

        frame.setVisible(true);
    }
}
