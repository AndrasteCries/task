package pat;

import java.math.BigInteger;

public class Task3 {
    public static void main(String[] args) {
        System.out.println(sumNumbers());
    }

    static int sumNumbers() {
        int sum = 0;
        BigInteger fact = BigInteger.ONE;

        for (int i = 1; i <= 100; i++) {
            fact = fact.multiply(BigInteger.valueOf(i));
        }

        String factString = fact.toString();
        for (int i = 0; i < factString.length(); i++) {
            sum += Integer.parseInt(factString.charAt(i) + "");
        }

        return sum;
    }

}
