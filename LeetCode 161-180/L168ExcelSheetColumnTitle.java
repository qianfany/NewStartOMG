public class L168ExcelSheetColumnTitle {
    /**
     * 26       A
     * 26^2     AA
     * 26^3     AAA
     * @param n
     * @return
     */
    public String convertToTitle (int n) {
        StringBuilder sb = new StringBuilder();
        while (n > 0) {
            char tmp = (char) ((n % 26 == 0 ? 26 : n % 26) + 64);
            sb.append(tmp);
            n = (n % 26 == 0 ? n /26 -1 : n / 26);
        }
        return sb.reverse().toString();
    }

    public String convert (int n) {
        StringBuilder result = new StringBuilder();
        while (n > 0) {
            n--;
            result.insert(0, (char) ('A' + n % 26));
            n /= 26;
        }
        return result.toString();
    }
}
