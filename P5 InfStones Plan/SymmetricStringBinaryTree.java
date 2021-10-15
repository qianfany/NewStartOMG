public class SymmetricStringBinaryTree {

    public String symmetricStringBinaryTree (String[] strArr) {
        int level = 0;
        while (Math.pow(2, level) < strArr.length) {
            level++;
        }
        String[] newArr = new String[((int) Math.pow(2, level) - 1)];
        for (int i = 0; i < strArr.length; i++) {
            newArr[i] = strArr[i];
        }
        for (int i = strArr.length; i < newArr.length; i++) {
            newArr[i] = "#";
        }
        int cur = 0;
        int index = 0;
        while (cur < newArr.length - 1) {
            int start = cur;
            int end = cur + (int) Math.pow(2, index);
            if (!check (newArr, start, end)) {
                return "false";
            }
            cur = end;
            index++;
        }
        return "true";
    }

    private boolean check (String[] newArr, int start, int end) {
        while (start < end) {
            if (!newArr[start].equals(newArr[end - 1])) {
                return false;
            }
            start++;
            end--;
        }
        return true;
    }

    public static void main (String[] args) {
        SymmetricStringBinaryTree sol = new SymmetricStringBinaryTree();
        String [] newStr = {"4", "3", "4"};
        String [] newStr2 = {"10", "2", "2", "#", "1", "1", "#"};
        String [] newStr3 = {"10", "2", "2", "7", "2", "2", "7", "#", "#", "2", "7", "7", "2"};
        System.out.println(sol.symmetricStringBinaryTree(newStr));
        System.out.println(sol.symmetricStringBinaryTree(newStr2));
        System.out.println(sol.symmetricStringBinaryTree(newStr3));
    }
}
