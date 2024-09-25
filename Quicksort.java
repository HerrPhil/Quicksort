import java.util.*;
import java.util.function.Predicate;
import java.util.stream.*;
import java.math.BigInteger;

public class Quicksort {

    public static void main(String [] args) {
        System.out.printf("Hello Quicksort Solution%n");
        if (args != null && args.length == 1 && args[0].toLowerCase().equals("-usage")) {
            System.out.printf("java Quicksort%n");
            return;
        }

        // sample test
        int [] sample = new int [] {10, 80, 30, 90, 40};

        Quicksort quicksort = new Quicksort(sample);

        int [] result = quicksort.solution();

        for (int i = 0; i < result.length; i++) {
            System.out.printf(" %d", result[i]);
        }
        System.out.printf("%n");

    }

    private int [] original;

    public Quicksort(int [] original) {

        this.original = original;

    }

    public int [] solution() {

        // TODO - more

        int N = this.original.length;

        System.out.printf("the number of elements to sort is %d%n", N);

        quicksort(0, N - 1);

        return this.original;
    }


    private void quicksort(int low, int high) {

        System.out.printf("quicksort() on low %d and high %d%n", low, high);

        int partitionIndex = partition(low, high);

        System.out.printf("quicksort() partition index = %d%n", partitionIndex);
    }

    private int partition(int low, int high) {

        System.out.printf("partition() on low %d and high %d%n", low, high);

        // Choosing the pivot value - pick high
        int pivot = original[high];
        
        // Index of smaller element and indicates the
        // right (future) position of pivot found so far

        int smallerElement = (low - 1);

        // Notice the very first i value when low is 0;
        // it is -1. Then it increments to 0 prior to swap()
        System.out.printf("partition() initialize smaller element location %d%n", smallerElement);

        int highBeforePivot = high - 1;

        System.out.printf("partition() the index of high before the pivot (high) %d%n", highBeforePivot);

        for (int currentElement = low; currentElement <= highBeforePivot; currentElement++) {

            System.out.printf("partition() for every current element index %d%n", currentElement);

            // A note here about what we are not doing.
            // When the current element value is greater than or equal to pivot value,
            // then skip the swap.
            // Leave the same or bigger behind.
            // This sets it up for the next swap.

            // TODO - the real stuff
        }

        return -1;
    }

}
