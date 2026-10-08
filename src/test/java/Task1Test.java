import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertArrayEquals;

class Task1Test {

    @Test
    void sampleAssignmentTests() {
        // Example 1: target occurs twice in the middle of the array.
        assertArrayEquals(new int[]{4, 5}, Task1.search(new int[]{4, 9, 10, 13, 17, 17, 19, 21}, 17));

        // Example 2: target is not present in the array.
        assertArrayEquals(new int[]{-1, -1}, Task1.search(new int[]{2, 4, 6, 8, 10, 14, 16}, 12));

        // Example 3: empty array.
        assertArrayEquals(new int[]{-1, -1}, Task1.search(new int[]{}, 0));
    }

    @Test
    void emptyArrayReturnsNotFound() {
        assertArrayEquals(new int[]{-1, -1}, Task1.search(new int[]{}, 5));
    }

    @Test
    void singleElementArrayReturnsItsPosition() {
        assertArrayEquals(new int[]{0, 0}, Task1.search(new int[]{5}, 5));
    }

    @Test
    void singleOccurrenceReturnsItsPosition() {
        assertArrayEquals(new int[]{1, 1}, Task1.search(new int[]{1, 2, 3, 4}, 2));
    }

    @Test
    void twoElementArrayWithTargetAtStartReturnsItsPosition() {
        assertArrayEquals(new int[]{0, 0}, Task1.search(new int[]{2, 3}, 2));
    }

    @Test
    void twoElementArrayWithTargetAtEndReturnsItsPosition() {
        assertArrayEquals(new int[]{1, 1}, Task1.search(new int[]{1, 2}, 2));
    }

    @Test
    void twoEqualElementsReturnsRange() {
        assertArrayEquals(new int[]{0, 1}, Task1.search(new int[]{7, 7}, 7));
    }

    @Test
    void duplicatesAtStartReturnsRange() {
        assertArrayEquals(new int[]{0, 1}, Task1.search(new int[]{2, 2, 3, 4}, 2));
    }

    @Test
    void duplicatesAtEndReturnsRange() {
        assertArrayEquals(new int[]{2, 3}, Task1.search(new int[]{0, 1, 2, 2}, 2));
    }

    @Test
    void duplicatesInMiddleReturnsRange() {
        assertArrayEquals(new int[]{1, 2}, Task1.search(new int[]{1, 2, 2, 3}, 2));
    }

    @Test
    void allElementsEqualTargetReturnsFullRange() {
        assertArrayEquals(new int[]{0, 3}, Task1.search(new int[]{2, 2, 2, 2}, 2));
    }

    @Test
    void targetSmallerThanAllElementsReturnsNotFound() {
        assertArrayEquals(new int[]{-1, -1}, Task1.search(new int[]{1, 2, 2, 3}, 0));
    }

    @Test
    void targetLargerThanAllElementsReturnsNotFound() {
        assertArrayEquals(new int[]{-1, -1}, Task1.search(new int[]{1, 2, 2, 3}, 9));
    }

    @Test
    void negativeNumbersReturnRange() {
        assertArrayEquals(new int[]{0, 2}, Task1.search(new int[]{-5, -5, -5}, -5));
    }

    @Test
    void negativeTargetNotPresentReturnsNotFound() {
        assertArrayEquals(new int[]{-1, -1}, Task1.search(new int[]{-3, -2, -2, -1}, -5));
    }

    @Test
    void largeArrayWithManyDuplicatesReturnsRange() {
        int[] numbers = new int[1000];
        for (int i = 0; i < numbers.length; i++) {
            numbers[i] = i / 100;
        }
        assertArrayEquals(new int[]{700, 799}, Task1.search(numbers, 7));
    }

}
