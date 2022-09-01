public class L744FindSmallestLetterGreaterThanTarget {

    /*
    Binary Search
    how to compare between character


     */
    public char nextGreatestLetter(char[] letters, char target) {
        int left = 0, right = letters.length - 1;

        while (left < right - 1) {
            int mid = left + (right - left) / 2;
            if (letters[mid] <= target) {
                left = mid + 1;
            } else {
                right = mid;
            }
        }
        if (letters[left] > target) {
            return letters[left];
        } else if (letters[right] > target){
            return letters[right];
        } else {
            return letters[0];
        }
    }

    public static void main(String[] args) {
        L744FindSmallestLetterGreaterThanTarget sol = new L744FindSmallestLetterGreaterThanTarget();
        char[] letter = {'e', 'e', 'e', 'n', 'n', 'n', 'n'};
        char target = 'n';
        System.out.println(sol.nextGreatestLetter(letter, target));
    }
}
