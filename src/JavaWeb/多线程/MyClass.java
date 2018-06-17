package JavaWeb.多线程;

import javax.security.auth.callback.*;

public class MyClass implements Callback{
    private static int a=3;
    public static void main(String[] args) throws InterruptedException {
        HelloWord helloWord=new HelloWord("you");
        Thread thread=new Thread(helloWord);
         thread.start();
         thread.join();
         MyClass.Show();
        Thread th2=Thread.currentThread();
        System.out.println("主线程："+th2.getName());
    }
    public static void Show(){
        a++;
        System.out.println("MyClass----end");
        Thread th2=Thread.currentThread();
        System.out.println("进入静态方法："+th2.getName()+"标志变量="+a);
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
