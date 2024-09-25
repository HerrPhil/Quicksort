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
        // int [] sample = new int [] {10, 80, 30, 90, 40};
        // int [] sample = new int [] {10, 80, 30, 90, 40, 50, 70};
        int [] sample = new int [] {50, 80, 40, 90, 30, 10, 70};

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

        int N = this.original.length;

        System.out.printf("the number of elements to sort is %d%n", N);

        quicksort(0, N - 1);

        return this.original;
    }


    private void quicksort(int low, int high) {

        System.out.printf("quicksort() on low %d and high %d%n", low, high);

        int partitionIndex = partition(low, high);

        System.out.printf("quicksort() partition index = %d%n", partitionIndex);

        System.out.printf("quicksort() continue sorting before partition%n");
        quicksort(low, partitionIndex - 1);

        System.out.printf("quicksort() continue sorting after partition%n");
        quicksort(partitionIndex + 1, high);
    }

    /**
      * partition() sorts data in the sense that the end result
      * is that smaller values are to the left of the pivot value
      * and the larger values are to the right of the pivot value.
      *
      * The sample data sets in the article already have values partly sorted.
      * I created a data set with more unsorted values to make it easier to see partition behaviour.
      * It might get a few values sorted.
      * However, its single job (SOLID design) is to partition around pivot.
      *
      * The article describes it like:
      * This function takes the last element as the pivot value,
      * places the pivot element at its correct position
      * in the sorted array, and places all smaller elements to the left
      * of the pivot value and all larger elements to the right of the pivot value.
      *
      */
    private int partition(int low, int high) {

        System.out.printf("partition() on low %d and high %d%n", low, high);

        System.out.printf("partition() initial state of array is %s%n", Arrays.toString(original));

        // Choosing the pivot value - pick high
        int pivot = original[high];

        System.out.printf("partition() the pivot index is high%n");
        System.out.printf("partition() the pivot value is %d%n", pivot);
        
        // Index of smaller element and indicates the
        // right (future) position of pivot found so far

        int smallerElement = (low - 1);

        // Notice the very first smaller element index is -1 when low is 0.
        // Then it increments to 0 prior to swap()
        System.out.printf("partition() initialize smaller element index %d%n", smallerElement);

        int highBeforePivot = high - 1;

        System.out.printf("partition() the index of high before the pivot (high) %d%n", highBeforePivot);

        // Iterate over all values before high pivot value
        for (int currentElement = low; currentElement <= highBeforePivot; currentElement++) {

            System.out.printf("partition() for the current element index %d%n", currentElement);

            // A note here about what we are not doing.
            // When the current element value is greater than or equal to the pivot value,
            // then skip incrementing the smaller element index and skip the swap.
            // Leave the same or bigger behind.
            // This sets it up for the next swap.
            if (original[currentElement] >= pivot) {
                System.out.printf("partition() the current element value %d is greater than or equal to the pivot value%n", original[currentElement]);
                System.out.printf("partition() retain smaller element index %d%n", smallerElement);
                System.out.printf("partition() Skip swap%n");
            }

            // When the current element value is less than the pivot value,
            // then do the swap.
            // It is hard to see, but this covers the edge case there smaller element index + 1 = 0
            // and currentElement = 0. It does a swap in place.
            // Based on the skip logic above, we know the skipped values are greater than or equal to pivot.
            // Therefore they can be swapped with the smaller value at the current element index.
            if (original[currentElement] < pivot) {

                System.out.printf("partition() the current element value %d is less than the pivot value%n", original[currentElement]);

                // Increment the index of the smaller element
                System.out.printf("partition() increment smaller element index%n");
                smallerElement++;

                System.out.printf("partition() Do swap of values of smaller element index %d and current element index %d%n", smallerElement, currentElement);
                swap(smallerElement, currentElement);
            }

            System.out.printf("partition() current state of array is %s%n", Arrays.toString(original));

        }

        // Make the final move.
        // The logic above guarantees that the value at smaller element index + 1
        // is greater than or equal to the pivot.
        // This is the new location of the pivot.
        // This also puts the bigger value from the left-side partition in the right-side partition with other bigger values.
        System.out.printf("partition() finally swap values at positions %d and %d to put pivot value in final position%n", smallerElement + 1, high);
        swap(smallerElement + 1, high);

        System.out.printf("partition() final state of array is %s%n", Arrays.toString(original));

        return (smallerElement + 1);
    }

    private void swap(int smallerElement, int currentElement) {
        // Store the bigger value at smaller element index
        int temp = original[smallerElement];
        // Move the smaller value that is less than pivot to the smaller element index
        original[smallerElement] = original[currentElement];
        // Move the bigger value to the current element index
        original[currentElement] = temp;
    }

}
