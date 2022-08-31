import javax.swing.plaf.synth.SynthTextAreaUI;
import java.util.Arrays;

public class Q2CountNumberOfWordsInString {


    /*
    Can you please introduce yourself


    Count number of words in a string
    Given a string, can you try to find out how many words are in this string

    ex 1:
    "If you really want to hear about it, the first thing you’ll probably want to know is where I was born, and what my lousy childhood was like, and how my parents were occupied and all before they had me, and all that David Copperfield kind of crap, but I don’t feel like going into it, if you want to know the truth."

    ex 2:
    "In my younger and more vulnerable years my father gave me some advice that I've been turning over in my mind ever since. Whenever you feel like criticizing anyone, he told me, just remember that all the people in this world haven't had the advantages that you've had."

    Clarification:

    Assumption:
    single space between each word
    No leading or trailing spaces
    No double spaces
     */
    // counting for spaces
    public void wordCountSpace(String str) {
        if (str == null || str.isEmpty()) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == ' ') {
                count++;
            }
        }
        System.out.println(count + 1);
    }

    /*
    Follow up:
    single space between each word is not guaranteed
    "If you  really  .  want to  hear about it, the  first  thing you’ll probably want to know is where I  was born, and what my  lousy childhood was like, and how my parents were occupied and all before they had me, and all that David Copperfield kind of crap, but I don’t feel like going into it, if you want to know the truth."
     */
    // set a flag to check if its a word
    public void wordCountII(String str) {
        int wordCount = 0;
        boolean word = false;
        int endOfLine = str.length() - 1;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ' && i < endOfLine) {
                word = true;
            } else if (str.charAt(i) == ' ' && word) {
                wordCount++;
                word = false;
            } else if (str.charAt(i) != ' ' && i == endOfLine) {
                wordCount++;
            }
        }
        System.out.println(wordCount);
    }

    // counting by words
    public void wordCountIII(String str) {
        if(str == null || str.isEmpty()) {
            System.out.println(0);
            return;
        }
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) != ' ') {
                count++;
                while(str.charAt(i) != ' ' && i < str.length() - 1) {
                    i++;
                }
            }
        }
        System.out.println(count);
    }

    public static void main(String[] args) {
        Q2CountNumberOfWordsInString sol = new Q2CountNumberOfWordsInString();
        String withSpace = "  If you  really    want to  hear about it, the  first  thing you’ll probably want to know is where I  was born, and what my  lousy childhood was like, and how my parents were occupied and all before they had me, and all that David Copperfield kind of crap, but I don’t feel like going into it, if you want to know the truth.   ";

        System.out.println(Arrays.toString(withSpace.split("\\s+")).length());

//        String str = "If you really want to hear about it, the first thing you’ll probably want to know is where I was born, and what my lousy childhood was like, and how my parents were occupied and all before they had me, and all that David Copperfield kind of crap, but I don’t feel like going into it, if you want to know the truth.";
//        sol.wordCountIII(withSpace);
    }
}
