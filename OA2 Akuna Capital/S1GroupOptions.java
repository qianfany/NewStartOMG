public class S1GroupOptions {
    /*
    N = 8 & K = 4   output 5
    [1, 1, 1, 5]    [1, 1, 2, 4]
    [1, 1, 3, 3]    [1, 2, 2, 3]    [2, 2, 2, 2]

                    (8)
                  /||||||\
                 1 (7)
               /
             1(6)
            /
          1(5)
         /||||\
        1 234  5(0)

        Time: O(N^k)
        Space: O(k)
     */

    public int countWaysToDivideI (int n, int k) {
        return find(0, 1, n, k);
    }
    private int find (int pos, int prev, int left, int k) {
        if (pos == k) {
            if (left == 0) {
                return 1;
            }
            else {
                return 0;
            }
        }
        if (left == 0) {
            return 0;
        }
        int answer = 0;

        for (int i = prev; i <= left; i++) {
            answer += find(pos + 1, i, left - i, k);
        }
        return answer;
    }

    public static void main (String[] args) {
        S1GroupOptions test = new S1GroupOptions();
        int n = 24; int k = 5;
        System.out.println(test.countWaysToDivideI(n, k));
    }
}
