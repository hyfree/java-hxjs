package Test;

public class mian {
    public static void main(String[] args) {
      String a="abcdefg@#$%单位";
        byte[] bytes=a.getBytes();
        String b=new String(bytes);
        byte[] abytes=b.getBytes();
        System.out.println(a.equals(b));
        System.out.println(bytes.equals(abytes));
    }
}
class F{
    private final int a=7;
    public void show(){
        System.out.println(a);

    }
    @Override
    public String toString() {
        // return super.toString();
        return  "hello word";
    }
}
class Son extends  F{
    private int a=5;

    @Override
    public void show() {
        System.out.println("Son");
        System.out.println(a);
        //super.show();
    }


}
