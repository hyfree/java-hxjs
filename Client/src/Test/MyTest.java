package Test;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.ConnectException;
import java.net.Socket;
import java.net.SocketTimeoutException;

public class MyTest {
    public static void main(String[] args) {
        Socket socket=null;
        InputStream inputStream=null;
        InputStreamReader inputStreamReader;
        try {
            socket=new Socket("127.0.0.1",13);
            socket.setSoTimeout(1500);
            inputStream=socket.getInputStream();
            StringBuilder time=new StringBuilder();
            inputStreamReader =new InputStreamReader(inputStream,"UTF-8");
            for (int c=inputStreamReader.read();c!=-1;c=inputStreamReader.read()){
                time.append((char)c);
            }
            System.out.println(time);
            inputStream.close();
            socket.close();
        } catch (SocketTimeoutException e){

        }catch (ConnectException  e){

        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (socket!=null)
            try {
                socket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }

    }
}
