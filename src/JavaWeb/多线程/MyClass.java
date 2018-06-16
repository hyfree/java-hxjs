package JavaWeb.多线程;

import javax.security.auth.callback.*;

public class MyClass implements Callback{
    public static void main(String[] args) {
        HelloWord helloWord=new HelloWord("you");
        Thread thread=new Thread(helloWord);
         thread.start();
        Thread th2=Thread.currentThread();
        System.out.println("主线程："+th2.getName());
    }
    public static void Show(){
        System.out.println("MyClass----end");
        Thread th2=Thread.currentThread();
        System.out.println("进入静态方法："+th2.getName());
    }

}
class HelloWord implements Runnable,Callback {
    private String conTest;
    public HelloWord(String str){
        this.conTest=str;
    }
    @Override
    public void run() {
        System.out.println("hello word");
        Thread th=Thread.currentThread();
        System.out.println("hello的当前线程为："+th.getName());
        MyClass.Show();
        try {
            Thread.sleep(1000);

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("Hello Word---end");

    }
}
