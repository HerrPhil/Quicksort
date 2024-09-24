# Quicksort

Review the quicksort algorithm.

## Source

[Geeks for Geeks article to teach me quicksort, after 30 years](https://www.geeksforgeeks.org/quick-sort-algorithm/)

## Highlights of the algorithm

Remember back in the day when we thought bubblesort and quicksort were all you needed to wow in an interview?

Well, they're back.

### How does Quicksort Algorithm work?

There are, mainly, three steps in the algorithm.

1. Choose a pivot. The expected list is unsorted. This choice is arbitrary.
2. Partition the array around the pivot value. After partition,
it is ensured that all elements less than the pivot are to its left,
and all elements greater than the pivot are to the right of it.
3. We get the index of the end point of the smaller elements.
4. The left and right partitions may not be sorted individually.
5. Recursively call for the two partitioned left and right subarrays.
6. We stop recursion when there is only one element left.

### Choice of pivot

There are many different choices for picking pivots.

* Always pick the first (or last) element as a pivot. Note that picking the last element when the array is sorted results in the worst case O(n^2).
* Pick a random element as a pivot. This is preferred to avoid the worst case.
* Pick the median element as the pivot. This is an ideal approach in terms of time complexity.
We can find the median in linear time, and the partition function will always divide the input array into two halves.
But it is low on average as median finding has high constants.

### Partition Algorithm

The key process in **quicksort** is a **partition()**. There are three common algorithms to partition.
All these algorithms have O(n) time complexity.

1. Naive Partition: Here we create a copy of the array. First put all smaller elements in the array.
Then put all greater elements in the array. Finally we copy the temporary array back to the original array.
This requires O(n) extra space.
2. Lomuto Partition: We have used this partition in this article. This is a simple algorithm,
we keep track of index of smaller elements and keep swapping. We have used it here in this article
because of its simplicity.
