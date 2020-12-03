package com.sxwl.utils;

import javax.swing.*;
import java.awt.*;

public class PUtils{

    public static Image getImage(String url)  {
          ImageIcon icon=new ImageIcon(PUtils.class.getClassLoader().getResource
                  (url));
          return icon.getImage();
        }


}
