
import java.util.Scanner;
public class Fibonacci {
    // Non-Recursive Method (Iterative)
    static void nonRecursive(int n) {
        int a = 0, b = 1, c;

        System.out.print("Non-Recursive Fibonacci: ");

        for (int i = 0; i < n; i++) {
            System.out.print(a + " ");
            c = a + b;
            a = b;
            b = c;
        }
        System.out.println();
    }

    // Recursive Method
    static int recursive(int n) {
        if (n == 0)
            return 0;

        if (n == 1)
            return 1;

        return recursive(n - 1) + recursive(n - 2);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of terms: ");
        int n = sc.nextInt();

        // Non-Recursive
        nonRecursive(n);

        // Recursive
        System.out.print("Recursive Fibonacci: ");

        for (int i = 0; i < n; i++) {
            System.out.print(recursive(i) + " ");
        }
        sc.close();
    }
}
