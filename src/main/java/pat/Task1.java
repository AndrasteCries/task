package pat;

import java.util.Scanner;

public class Task1 {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("Enter N:");
            int n = sc.nextInt();                           // take input
            if (n < 1) System.out.println("Invalid input"); // validate
            else findAnswer(n);
        }
    }

    static public void findAnswer(int N) {
        int[][] matrix = new int[N + 1][N + 1]; // common matrix for dynamic algorithm

        matrix[0][0] = 1; // common value for dynamic algorithm

        for (int i = 0; i < N + 1; i++) {                       // open brackets
            for (int j = 0; j < N + 1; j++) {                   // closed brackets

                if (i < j) continue;                            // if closed brackets > open, incorrect combination
                if (i > 0) matrix[i][j] += matrix[i - 1][j];    // if open brackets > 0 we can add similar answer
                if (j > 0) matrix[i][j] += matrix[i][j - 1];    // if closed brackets > 0 we can add similar answer
                System.out.println(matrix[i][j]);
             }
        }

        System.out.println("Answer: " + matrix[N][N]); // return our answer
    }
}