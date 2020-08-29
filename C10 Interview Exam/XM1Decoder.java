public class XM1Decoder {
    /*
                                    1121
                                  /		\
                               1			(11)
                         /       \   	       /           \
                    11     1(12)           (11)2       (11)(21)
                     /     \     /      \           /     \
                   112    11(21)  1(12)1 invalid
   	            /
             1121
        2 branches, left, add one, right, add number
        Time: O(2^n)
        Space: O(n)

     */

    public void decoder (String input) {
        if (input == null || input.length() == 0) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        dfs (input, 0, sb);
    }

    private void dfs (String input, int index, StringBuilder sb) {
        if (index >= input.length()) {
            System.out.println(sb.toString());
            return;
        }
        int num = input.charAt(index) - '0';
        if (num > 0 && num <= 26) {
            sb.append((char) ('A' + num - 1));
            dfs(input, index + 1, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
        if (index >= input.length() - 1) return;
        // invalid case with 1 element left to deal with add two.

        num = num * 10 + input.charAt(index + 1) - '0';
        if (input.charAt(index) != '0' && num > 0 && num <= 26) {     // zero case
            sb.append((char) ('A' + num - 1));
            dfs(input, index + 2, sb);
            sb.deleteCharAt(sb.length() - 1);
        }
    }

    public static void main (String[] args) {
        XM1Decoder sol = new XM1Decoder();
        String input = "1121";
        sol.decoder(input);
    }

}
