package xyz.hyfree.image;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.*;
import java.io.IOException;
import java.util.*;
import javax.imageio.*;
import javax.servlet.http.HttpSession;

public class DrawImage {
    public static String code = "abcdefghijklmnopqrstuvwxyz0123456789ABCDEFGHIJKLMNOPQRSTUVWXYZ";

    static Color getRandColor(int fc, int bc) {//给定范围获得随机颜色
        Random random = new Random();
        if (fc > 255) fc = 255;
        if (bc > 255) bc = 255;
        int r = fc + random.nextInt(bc - fc);
        int g = fc + random.nextInt(bc - fc);
        int b = fc + random.nextInt(bc - fc);
        return new Color(r, g, b);
    }

    public static void MyDraw(HttpServletRequest request, HttpServletResponse response) {

        //out.clear();//这句针对resin服务器，如果是tomacat可以不要这句
//设置页面不缓存
        response.setHeader("Pragma", "No-cache");
        response.setHeader("Cache-Control", "no-cache");
        response.setDateHeader("Expires", 0);
// 在内存中创建图象,设置图片的显示大小
        int width = 60, height = 20;
        BufferedImage image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);
// 获取图形上下文
        Graphics g = image.getGraphics();
//生成随机类
        Random random = new Random();
// 设定背景色
        g.setColor(getRandColor(200, 250));
        g.fillRect(0, 0, width, height);
//设定字体
        g.setFont(new Font("Lnk Free", Font.PLAIN, 18));
//画边框
//g.setColor(new Color());
//g.drawRect(0,0,width-1,height-1);
// 随机产生155条干扰线，使图象中的认证码不易被其它程序探测到

        for (int i = 0; i < 50; i++) {
            g.setColor(getRandColor(0, 255));
            int x = random.nextInt(width);
            int y = random.nextInt(height);
            int xl = random.nextInt(12);
            int yl = random.nextInt(12);
            g.drawLine(x, y, x + xl, y + yl);
        }
// 取随机产生的认证码(由数字和字母组长的)
        String sRand = "";
        for (int i = 0; i < 4; i++) {
            int rand = random.nextInt(62);
            sRand += String.valueOf(code.charAt(rand));
// 将认证码显示到图象中
            g.setColor(new Color(20 + random.nextInt(110), 20 + random.nextInt(110), 20 + random.nextInt(110)));// 调用函数出来的颜色相同，可能是因为种子太接近，所以只能直接生成
            g.drawString(String.valueOf(code.charAt(rand)), 13 * i + 6, 16);
        }
// 将认证码存入SESSION
        HttpSession session=request.getSession();
        session.setAttribute("rand", sRand);
// 图象生效
        g.dispose();
// 输出图象到页面
        try {
            ImageIO.write(image, "JPEG", response.getOutputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}