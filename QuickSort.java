
import java.util.Scanner;
import java.util.Random;

public class QuickSort {

    static Random r = new Random();

    // Partition Method
    static int partition(int a[], int low, int high, boolean random) {

        int p;

        if (random)
            p = low + r.nextInt(high - low + 1);
        else
            p = high;

        // Swap pivot with last element
        int temp = a[p];
        a[p] = a[high];
        a[high] = temp;

        int pivot = a[high];
        int i = low - 1;

        for (int j = low; j < high; j++) {

            if (a[j] <= pivot) {
                i++;

                temp = a[i];
                a[i] = a[j];
                a[j] = temp;
            }
        }

        temp = a[i + 1];
        a[i + 1] = a[high];
        a[high] = temp;

        return i + 1;
    }

    // Quick Sort Method
    static void quickSort(int a[], int low, int high, boolean random) {

        if (low < high) {

            int p = partition(a, low, high, random);

            quickSort(a, low, p - 1, random);
            quickSort(a, p + 1, high, random);
        }
    }

    // Display Array
    static void display(int a[]) {
        for (int x : a)
            System.out.print(x + " ");
        System.out.println();
    }

    public static void main(String args[]) {

        Scanner sc = new Scanner(System.in);

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        int a[] = new int[n];

        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++)
            a[i] = sc.nextInt();

        int b[] = a.clone();

        // Deterministic Quick Sort
        long start = System.nanoTime();

        quickSort(a, 0, n - 1, false);

        long end = System.nanoTime();

        System.out.println("\nDeterministic Quick Sort:");
        display(a);

        System.out.println("Execution Time: " + (end - start) + " ns");

        // Randomized Quick Sort
        start = System.nanoTime();

        quickSort(b, 0, n - 1, true);

        end = System.nanoTime();

        System.out.println("\nRandomized Quick Sort:");
        display(b);

        System.out.println("Execution Time: " + (end - start) + " ns");

        sc.close();
    }
}
