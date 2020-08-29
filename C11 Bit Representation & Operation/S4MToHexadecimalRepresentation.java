public class S4MToHexadecimalRepresentation {
    /*
    take off the leading zero
    binary representation 4 bits == 1 bits in hex

     */
    public String hex (int number) {
        char[] base = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A',
        'B', 'C', 'D', 'E', 'F'};
        if (number == 0) {
            return "0x0";
        }
        boolean isLeading = true;
        StringBuilder sb = new StringBuilder("0x");
        for (int mask_end = 28; mask_end >= 0; mask_end -= 4) {
            char digit = base[(number >> mask_end) & 0xF];
            if (digit != '0' || !isLeading) {
            sb.append(digit);
            isLeading = false;
            }
        }
        return sb.toString();
    }
}
