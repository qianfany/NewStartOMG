import java.io.IOException;
import java.util.Arrays;
import java.util.List;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class JavaStreams1 {

    public static void main (String[] args) throws IOException {

        List<String> people = Arrays.asList("Al", "Ankit", "Brent", "Sarika", "amanda", "Hans");
        people
                .stream()
                .map(String::toLowerCase)
                .filter(x -> x.startsWith("a"))
                .forEach(System.out::println);
    }
}
