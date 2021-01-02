import java.util.ArrayList;
import java.util.List;

public class TwoDices {

    public List<Integer> rollTwoDices () {
        List<Integer> list = new ArrayList<>();
        int get1 = (int) (Math.random()*6) + 1;
        int get2 = (int) (Math.random()*6) + 1;
        list.add(get1);
        list.add(get2);
        return list;
    }



    public static void main (String[] args) {
        String s1 = "uml";
        String s2 = "uml";
        String s3 = new String("uml");
        String s4 = new String("uml");
        System.out.println(s1 == s2);
        System.out.println(s3 == s4);
        System.out.println(s1.equals(s3));
    }
}
