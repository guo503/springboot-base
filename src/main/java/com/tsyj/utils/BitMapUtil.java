package com.tsyj.utils;

import javax.imageio.ImageIO;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.awt.image.MemoryImageSource;
import java.awt.image.PixelGrabber;
import java.io.File;
import java.io.IOException;
import java.net.URL;

/**
 * bitMap工具类
 *
 * @author: guos
 * @date: 2019/10/9 15:46
 **/
public class BitMapUtil {


    public static void main(String[] args) throws Exception {
        String url1 = "http://wx.qlogo.cn/mmhead/ver_1/goibpuy7iboqh2F3d5ZibHpg0g1xXq5XhZv3a4AtzjZT5xDNWuQRS5VIRxgsBlCMZzRHic3j9DVJAJ0dYqGciaaVD7D8Aia97zow6VuR1Sl19u708/132";
        String imageName1 = "D:/test1";
        image2RGBBmp(new URL(url1), imageName1);
        String url2 = "http://thirdwx.qlogo.cn/mmopen/vi_32/3uLVPNOwriaqkGSWWictpPVjAXsd5IKiavBuAq2O9cXuYkGOSwRUfot6IdibNBXqfeicA5wfHVCBvfmb6GjafmxEwXQ/132";
        String imageName2 = "D:/test2";
        image2RGBBmp(new URL(url2), imageName2);
    }


    /**
     * 网络图片转bmp文件
     *
     * @param url      网络图片路径
     * @param destPath 保存路径
     * @return
     * @author guos
     * @date 2019/10/9 15:47
     **/
    public static void image2RGBBmp(URL url, String destPath) {
        try {
            BufferedImage sourceImg = ImageIO.read(url);
            int h = sourceImg.getHeight(), w = sourceImg.getWidth();
            int[] pixel = new int[w * h];
            PixelGrabber pixelGrabber = new PixelGrabber(sourceImg, 0, 0, w, h, pixel, 0, w);
            pixelGrabber.grabPixels();

            MemoryImageSource m = new MemoryImageSource(w, h, pixel, 0, w);
            Image image = Toolkit.getDefaultToolkit().createImage(m);
            BufferedImage buff = new BufferedImage(w, h, BufferedImage.TYPE_3BYTE_BGR);
            buff.createGraphics().drawImage(image, 0, 0, null);
            ImageIO.write(buff, "bmp", new File(destPath));
        } catch (InterruptedException | IOException e) {
            e.printStackTrace();
        }
    }
}
