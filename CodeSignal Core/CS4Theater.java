public class CS4Theater {

    public int seatsInTheater (int nClos, int nRows, int col, int row) {
        return (nRows - row) * (nClos - col + 1);
    }
}
