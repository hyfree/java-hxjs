package Test;

import java.io.IOException;
import java.io.OutputStream;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class MyServer {
    public static void main(String[] args) {
        try {
            ServerSocket serverSocket=new ServerSocket(13);
            Socket connection=serverSocket.accept();
            OutputStream outputStream=connection.getOutputStream();
            Writer writer= new OutputStreamWriter(outputStream,"UTF-8");
            Date now =new Date();
            writer.write("现在时间是："+now.toString());
            writer.flush();

            System.out.println("端口："+connection.getPort());
            System.out.println("远程地址："+connection.getInetAddress().getHostAddress());

            //关闭
            writer.close();
            outputStream.close();
            serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
