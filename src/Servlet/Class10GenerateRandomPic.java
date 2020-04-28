package Servlet;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

/**
 * @author yhs
 * @date 2020/4/28 20:10
 * @description 生成随机图片 感觉这节没啥用
 */
@WebServlet(name = "Class10GenerateRandomPic",urlPatterns = "/randompic")
public class Class10GenerateRandomPic extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        //内存生成一张图片 宽80高20  类型是RGB
        BufferedImage bufferedImage = new BufferedImage(80,20,BufferedImage.TYPE_INT_RGB);

        //获得这张图片对象
        Graphics graphics = bufferedImage.getGraphics();

        //对图像进行绘制
        graphics.setColor(Color.white);
        graphics.setFont(new Font(null,Font.BOLD,20));

        //往图像上写信息
        //生成随机数 用于写在图片上
        Random random = new Random();
        String showInfo = String.valueOf(random.nextInt(10000000));
        graphics.drawString(showInfo,0,20);
        response.setHeader("ContentType","jpeg");
        ImageIO.write(bufferedImage,"jpeg",response.getOutputStream());
    }
}
