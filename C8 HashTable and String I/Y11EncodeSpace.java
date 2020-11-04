public class Y11EncodeSpace {
    /*
    replace space with "20%"
     */
    public String encode (String input) {
        if (input == null || input.length() == 0) {
            return input;
        }
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < input.length(); i++) {
            if (input.charAt(i) == ' ') {
                sb.append("20%");
            }
            else {
                sb.append(input.charAt(i));
            }
        }
        return sb.toString();
    }

    public static void main (String[] args) {
        Y11EncodeSpace sol = new Y11EncodeSpace();
        String input = "google flo";
        System.out.println(sol.encode(input));
    }
}
