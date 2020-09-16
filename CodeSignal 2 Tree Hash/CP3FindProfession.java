public class CP3FindProfession {

    public String findProfession (int level, int pos) {
        boolean inverted = false;
        while ( level > 1) {
            if (pos % 2 == 0) {
                inverted = !inverted;
            }
            pos = (pos + 1) / 2;
            level--;
        }
        return inverted ? "Doctor" : "Engineer";
    }
}
