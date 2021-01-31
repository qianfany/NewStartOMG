import java.util.Scanner;

public class N001水瓶子换 {

    public int change (int bottle, int total) {
        int res = 0;
        while (total > bottle - 1) {
            int remainder = total % bottle;
            total = total / bottle;
            res = res + total;
            total = total + remainder;
        }
        if (total == bottle - 1) {
            return res + 1;
        }
        return res;
    }

    public static void main (String[] args) {

        N001水瓶子换 sol = new N001水瓶子换();
        Scanner cin = new Scanner(System.in);
        int N = cin.nextInt();
        for (int i = 0; i < N; i++) {
            int total = cin.nextInt();
            System.out.println(sol.change(3, total));
        }
    }
}


//    水瓶子换 sol = new 水瓶子换();
//        System.out.println(sol.change(3, 10));
//                System.out.println(sol.change(3, 81));