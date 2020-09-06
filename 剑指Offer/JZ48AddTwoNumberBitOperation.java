public class JZ48AddTwoNumberBitOperation {
    /*
    5 + 7 = 12
    101 XOR 111 = 010       101 & 111 = 101 left shift 1 bit   get carry bit   1010
    010 ^ 1010 = 1000       010 & 1010 = 1010 left shift 1 bit get carry bit 100
    1000 ^ 100 = 1100       1000 & 100 = 0000

    bit operation
     */
    public int add (int num1, int num2) {
        while (num2 != 0) {
            int tmp = num1 ^ num2;
            num2 = (num1 & num2) << 1;
            num1 = tmp;
        }
        return num1;
    }
}
