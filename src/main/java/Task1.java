/**
 * Task 1: locate the first and last position of a target value in an
 * integer array sorted in non-decreasing order.
 *
 * <p>The search is performed with two binary searches over the same array,
 * so the runtime complexity is O(log n) and the space complexity is O(1).
 * If the target is not present, {@code search} returns {@code {-1, -1}}.
 */
public class Task1 {

    /**
     * Finds the first and last index of {@code target} within the sorted
     * array {@code numbers}.
     *
     * <p>First a binary search locates the leftmost occurrence of the
     * target; if one exists, a second binary search starting from that
     * position locates the rightmost occurrence.
     *
     * <p>Time complexity: O(log n). Space complexity: O(1).
     *
     * @param numbers the sorted array to search (may contain duplicates)
     * @param target  the value whose occurrences are being searched for
     * @return an array containing the first and last index of {@code target},
     *         or {@code {-1, -1}} if {@code target} is not present
     */
    public static int[] search(int[] numbers, int target) {
        int firstOccurrence = findFirstOccurrence(numbers, target);
        if (firstOccurrence == -1) {
            return new int[]{-1, -1};
        }

        int lastOccurrence = findLastOccurrence(numbers, target, firstOccurrence);

        return new int[]{firstOccurrence, lastOccurrence};
    }

    /**
     * Locates the leftmost occurrence of {@code target} in the sorted array
     * using binary search.
     *
     * <p>When a match is found the search continues in the left half so that
     * earlier duplicates are not missed.
     *
     * <p>Time complexity: O(log n). Space complexity: O(1).
     *
     * @param numbers the sorted array to search
     * @param target  the value to search for
     * @return the index of the first occurrence of {@code target}, or -1 if
     *         it is not present
     */
    private static int findFirstOccurrence(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;
        int firstPosition = -1;

        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (numbers[middle] == target) {
                firstPosition = middle;
                right = middle - 1;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return firstPosition;
    }

    /**
     * Locates the rightmost occurrence of {@code target} in the sorted array
     * using binary search.
     *
     * <p>When a match is found the search continues in the right half so that
     * later duplicates are not missed. The search starts at {@code startingIndex}
     * because every element before it is known to be smaller than {@code target}.
     *
     * <p>Time complexity: O(log n). Space complexity: O(1).
     *
     * @param numbers       the sorted array to search
     * @param target        the value to search for
     * @param startingIndex the left bound of the search range, guaranteed to be
     *                      a valid occurrence of {@code target}
     * @return the index of the last occurrence of {@code target}
     */
    private static int findLastOccurrence(int[] numbers, int target, int startingIndex) {
        int left = startingIndex;
        int right = numbers.length - 1;
        int lastPosition = startingIndex;

        while (left <= right) {
            int middle = (left + right) >>> 1;
            if (numbers[middle] == target) {
                lastPosition = middle;
                left = middle + 1;
            } else if (numbers[middle] < target) {
                left = middle + 1;
            } else {
                right = middle - 1;
            }
        }

        return lastPosition;
    }

}
