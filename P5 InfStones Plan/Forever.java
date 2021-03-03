import java.io.Console;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Forever {


    /*
    for minitor part
        1. create a hashMap with <count, input>
        2. every time when I wake up the monitor, delete the process in the hashmap
        3. counter increments, with process = to the the previous deleted forever input value
        4. then restart it again
     */

    public static void main(String[] args) {

        Console console = System.console();

        String input = "";
        int count = 0;
        Map<Integer, String> map = new HashMap<>();
        while (!"q".equalsIgnoreCase(input)) {

            if (!input.startsWith("k")) {
                count++;
                input = console.readLine();
                map.put(count, input);
                System.out.println("pid_" + count + "  forever  " + input);
            }
//            else if (input.startsWith("k")){
//                char[] array = input.toCharArray();
//                count++;
//                int num = (int)(array[input.length() -1]);
//                String output = map.get(num);
//                map.remove(num);
//                map.put(count, output);
//                for (Map.Entry<Integer, String> entry : map.entrySet()) {
//                    System.out.println("pid_" + entry.getKey() + " forever " + entry.getValue() );
//                }
//            }
        }

        System.out.println("bye bye!");
    }
}
