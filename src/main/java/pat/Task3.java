package pat;

import java.math.BigInteger;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(sumNumbers());
    }

    static int sumNumbers() {
        int sum = 0;
        BigInteger fact = BigInteger.ONE;

        for (int i = 1; i <= 100; i++) { // iteration method factorial
            fact = fact.multiply(BigInteger.valueOf(i)); // multiply
        }

        String factString = fact.toString(); // BigInteger to string, because we need process numbers one by one
        for (int i = 0; i < factString.length(); i++) {
            sum += Integer.parseInt(factString.charAt(i) + ""); // increase sum
        }

        return sum;
    }

}
