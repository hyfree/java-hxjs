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
        ServerSocket serverSocket = null;
        Socket connection = null;
        OutputStream outputStream = null;
        Writer writer = null;
        try {
            serverSocket = new ServerSocket(13);
            connection = serverSocket.accept();
            outputStream = connection.getOutputStream();
            writer = new OutputStreamWriter(outputStream, "UTF-8");
            Date now = new Date();
            writer.write("现在时间是：" + now.toString());
            writer.flush();

            System.out.println("端口：" + connection.getPort());
            System.out.println("远程地址：" + connection.getInetAddress().getHostAddress());

            //关闭
            writer.close();
            outputStream.close();
            serverSocket.close();


        } catch (IOException e) {
            e.printStackTrace();
        } finally {

            try {
                connection.close();
                writer.close();
                serverSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
    }
}
