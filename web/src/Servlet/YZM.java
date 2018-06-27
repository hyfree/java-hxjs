package Servlet;

import Domain.func.DrawYzm;
import xyz.hyfree.image.DrawImage;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet("/YZM")
public class YZM extends HttpServlet {
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    doGet(request,response);
    }

    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
        DrawYzm drawYzm=new DrawYzm();
        //drawYzm.getCode(request,response);
        DrawImage.MyDraw(request,response);
        request.setAttribute("yzm",drawYzm);
        request.getRequestDispatcher("yzmimg").forward(request, response);

    }
}
