public class M4MPrintAllIfBlocks {

//  Base case: left remaining { == 0 and right remaining } == 0
//              print the blocks and return
//  2 * n  levels
//  2 branches
//  time : O(2 ^ (2n))
//  space: O(n)
//
//                    /      \
//                  {
//                 /  \
//                {{    {}
//              /  \      /
//            {{{  {{}
//
    public void printAllIfBlock (int n) {
        if (n <= 0) {
            return;
        }
        char[] array = new char[2 * n];
        helper(array, 0, n, n);
    }

    private void helper (char[] array, int index, int left, int right) {
        if (left == 0 && right == 0) {
            print(array);
            return;
        }
        if (left > 0) {
            array[index] = '{';
            helper(array, index + 1, left - 1, right);
        }
        if (right > 0 && right > left) {
            array[index] = '}';
            helper(array, index + 1, left, right - 1);
        }
    }

    private void print (char[] array) {
        int space = 0;
        for (int i = 0; i < array.length; i++) {
            if (array[i] == '{') {
                printSpace(space);
                System.out.println("if{");
                space += 2;
            } else {
                space -= 2;
                printSpace(space);
                System.out.println("}");
            }
        }
        System.out.println();
    }

    private void printSpace (int space) {
        for (int i = 0; i < space; i++) {
            System.out.print(" ");
        }
    }

    public static void main (String[] args) {
        M4MPrintAllIfBlocks sol = new M4MPrintAllIfBlocks();
        sol.printAllIfBlock(3);
    }
}
