package JavaWeb.IO;

import java.io.*;

public class FileText {
    public static void main(String[] args) {
        try {
            wirte();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    public static void wirte() throws IOException {
        FileOutputStream fileOutputStream=new FileOutputStream("D:\\test.txt");
        OutputStreamWriter outputStreamWriter=new OutputStreamWriter(fileOutputStream);
        BufferedWriter bufferedWriter=new BufferedWriter(outputStreamWriter);
        bufferedWriter.write("测试");
        bufferedWriter.flush();
        bufferedWriter.close();
        outputStreamWriter.close();
        fileOutputStream.close();


    }
}
