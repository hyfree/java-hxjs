package Console;

import org.fusesource.jansi.Ansi;

public class JConsole {
    public static void main(String[] args) {

    }
    public static void println(Ansi.Color color,String s) {
        System.out.println( Ansi.ansi().eraseScreen().fg(color).a(s).reset() );
    }
    public static void print(Ansi.Color color,String s) {
        System.out.println( Ansi.ansi().eraseScreen().fg(color).a(s).reset() );
    }
    public static String getStr(Ansi.Color color,String s) {
        return Ansi.ansi().eraseScreen().fg(color).a(s).reset().toString();
    }

}
