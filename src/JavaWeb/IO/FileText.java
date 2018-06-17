package JavaWeb.IO;

import java.io.*;

public class FileText {
    public static void main(String[] args) {
        String fileName = "D:\\test.txt";
//        writeTestByLine(fileName,"true",true);
        String readTe = readTextByLine(fileName);
        System.out.println(readTe);

    }

    public static void Textwirte() {
        FileOutputStream fileOutputStream = null;
        OutputStreamWriter outputStreamWriter = null;
        BufferedWriter bufferedWriter = null;
        try {
            fileOutputStream = new FileOutputStream("D:\\test.txt");
            outputStreamWriter = new OutputStreamWriter(fileOutputStream);
            bufferedWriter = new BufferedWriter(outputStreamWriter);
            bufferedWriter.write("测试");
            bufferedWriter.flush();
        } catch (IOException e) {

        } finally {
            try {
                bufferedWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                outputStreamWriter.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
            try {
                fileOutputStream.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }


    }

    /**
     * 逐行写文本到文件中
     */
    public static void writeTestByLine(String fileName, String content, boolean append) {
        // 方法一：获取系统的分行符号，在每次写入文本后，再写入一次分行符号
        String str = System.getProperty("line.separator");
        try {
            FileWriter fw = new FileWriter(fileName, append);
            fw.write(content);
            fw.write(str);//增加换行符
            fw.flush();
            fw.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static String readTextByLine(String fileName) {
        String sep = System.getProperty("line.separator");
        FileReader fr = null;
        BufferedReader bufferedReader = null;
        StringBuilder stringBuilder = null;
        try {
            fr = new FileReader(fileName);
            bufferedReader = new BufferedReader(fr);
            String str = "";
            stringBuilder = new StringBuilder();
            while ((str = bufferedReader.readLine()) != null) {
                stringBuilder.append(str);
                stringBuilder.append(sep);
            }

        } catch (IOException e) {

        } finally {
            try {
                bufferedReader.close();
                fr.close();
            } catch (IOException e) {
                e.printStackTrace();
            }

        }
        return stringBuilder.toString();
    }
}
