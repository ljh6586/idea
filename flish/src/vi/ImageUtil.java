package vi;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;


public class ImageUtil {
    public static BufferedImage getImg(String path) {
        try {
            BufferedImage img= ImageIO.read(ImageUtil.class.getResource(path));
            return img;
        }catch (Exception e){}

        return null;
    }
}
