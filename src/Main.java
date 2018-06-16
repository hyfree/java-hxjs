import Console.JConsole;
import org.fusesource.jansi.Ansi;

public class Main {

    public static void main(String[] args) {
//        System.out.println("Hello World!");
//        System.out.println( Ansi.ansi().eraseScreen().fg(Ansi.Color.RED).a("Hello").fg(Ansi.Color.GREEN).a(" World").reset() );
//        System.out.println(JConsole.getStr(Ansi.Color.GREEN,"aa"));
        JConsole.println(Ansi.Color.RED,"五颜六色的文字");
        JConsole.println(Ansi.Color.GREEN,"五颜六色的文字");
        JConsole.println(Ansi.Color.BLACK,"五颜六色的文字");
        JConsole.println(Ansi.Color.BLUE,"五颜六色的文字");
        JConsole.println(Ansi.Color.CYAN,"五颜六色的文字");
        JConsole.println(Ansi.Color.DEFAULT,"五颜六色的文字");
        JConsole.println(Ansi.Color.MAGENTA,"五颜六色的文字");
        JConsole.println(Ansi.Color.WHITE,"五颜六色的文字");
        JConsole.println(Ansi.Color.YELLOW,"五颜六色的文字");
        JConsole.println(Ansi.Color.DEFAULT,"五颜六色的文字");
    }
}
