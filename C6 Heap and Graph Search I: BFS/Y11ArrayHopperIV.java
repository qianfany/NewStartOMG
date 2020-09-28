import java.util.*;

public class Y11ArrayHopperIV {

    public int minJump (int[] array, int index) {
        int min = 0;
        Queue<Integer> queue = new LinkedList<>();
        Set<Integer> set = new HashSet<>();
        queue.add(index);
        set.add(index);

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int j = 0; j < size; j++) {
                int cur = queue.poll();
                if (cur == array.length - 1) {
                    return min;
                }
                for (int i = 1; i <= array[cur]; i++) {
                    if (cur + i < array.length && !set.contains(cur + i)) {
                        queue.offer(cur + i);
                        set.add(cur + i);
                    }
                    if (cur - i >= 0 && !set.contains(cur - i)) {
                        queue.offer(cur - i);
                        set.add(cur - i);
                    }
                }
            }
            min++;
        }
        return -1;
    }
}
