public class BUHUIS7HCompressStringII {
    /*
    s: the letters to the left of s (not including s) are the processed letters
    that should be kept
    f: the character being processed

    Initialization: s = f = 0
    for each step:
    f_begin = f
    keep moving f until a[f] != a[f_begin]
    Compress a[f_begin...f]
        a[s] = a[f_begin], s++
        copy f-f_begin as a string to a[s]

    need to care two cases: become longer / shorter


     */
    public String compress (String input) {
        return " ";
    }
}
