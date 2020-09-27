public class Y10ArrayIsMinheap {

    public boolean isMinHeap (int[] array) {
        for (int i = 0; i <= (array.length -2) / 2; i++) {
            if (array[2 * i + 1] < array[i]) {
                return false;
            }
            if (2 * i + 2 < array.length && array[2 * i + 2] < array[i]) {
                return false;
            }
        }
        return true;
    }
}
