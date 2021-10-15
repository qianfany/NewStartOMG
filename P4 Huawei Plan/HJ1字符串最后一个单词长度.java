import java.util.Scanner;

public class HJ1字符串最后一个单词长度 {

    public int lengthOfLast (String str) {
        String[] s = str.split(" ");
        return s[s.length - 1].length();
    }

    public static void main (String[] args) {
        Scanner scan = new Scanner(System.in);
        HJ1字符串最后一个单词长度 sol = new HJ1字符串最后一个单词长度();
        while (scan.hasNext()) {
            String str = scan.nextLine();
            System.out.println(sol.lengthOfLast(str));
        }
    }
}
