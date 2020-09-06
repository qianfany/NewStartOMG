public class JZ53IsNumeric {

    public boolean isNumeric (char[] str) {
        boolean signal = false, decimal = false, hasE = false;

        for (int i = 0; i < str.length; i++) {
            // cannot have two E
            if (str[i] == 'E' || str[i] == 'e') {
                if (i == str.length - 1) {
                    return false;
                }
                if (hasE) {
                    return false;
                }
                hasE = true;
            } else if (str[i] == '+' || str[i] == '-') {
                // did not occur at first time, only go after E
                if (signal && str[i-1] != 'E' && str[i -1] != 'e') {
                    return false;
                }
                // if occur first time but did not occur at begin
                if (!signal && i > 0 && str[i -1] != 'E' && str[i-1] != 'e') {
                    return false;
                }
                signal = true;
            } else if (str[i] == '.') {
                // cannot be decimal after E
                if (hasE) {
                    for (; i >= 0; i--) {
                        if (str[i] == 'e' || str[i] == 'E') {
                            return false;
                        }
                    }
                }
                if (decimal) {
                    return false;
                }
                decimal = true;
            } else if (str[i] < '0' || str[i] > '9') {
                // other than decimal E, .
                return false;
            }
        }
        return true;
    }
}
