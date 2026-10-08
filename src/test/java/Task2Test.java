import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

class Task2Test {

    @Test
    void sampleAssignmentTests() {
        int[][] matrix = {{1, 3, 5, 7}, {10, 11, 16, 20}, {23, 30, 34, 60}};

        // Example 1: target is present in the matrix.
        assertTrue(Task2.search(matrix, 3));

        // Example 2: target is not present in the matrix.
        assertFalse(Task2.search(matrix, 13));
    }

    @Test
    void emptyMatrixReturnsFalse() {
        assertFalse(Task2.search(new int[][]{}, 1));
    }

    @Test
    void matrixWithEmptyRowReturnsFalse() {
        assertFalse(Task2.search(new int[][]{{}}, 1));
    }

    @Test
    void singleElementMatrixContainsTarget() {
        assertTrue(Task2.search(new int[][]{{5}}, 5));
    }

    @Test
    void singleElementMatrixDoesNotContainTarget() {
        assertFalse(Task2.search(new int[][]{{5}}, 4));
    }

    @Test
    void singleRowContainsTarget() {
        assertTrue(Task2.search(new int[][]{{1, 3, 5, 7}}, 5));
    }

    @Test
    void singleRowDoesNotContainTarget() {
        assertFalse(Task2.search(new int[][]{{1, 3, 5, 7}}, 4));
    }

    @Test
    void singleColumnContainsTarget() {
        assertTrue(Task2.search(new int[][]{{1}, {3}, {5}, {7}}, 3));
    }

    @Test
    void singleColumnDoesNotContainTarget() {
        assertFalse(Task2.search(new int[][]{{1}, {3}, {5}, {7}}, 2));
    }

    @Test
    void targetAtFirstPosition() {
        assertTrue(Task2.search(new int[][]{{1, 3, 5}, {7, 9, 11}}, 1));
    }

    @Test
    void targetAtLastPosition() {
        assertTrue(Task2.search(new int[][]{{1, 3, 5}, {7, 9, 11}}, 11));
    }

    @Test
    void targetInMiddleOfMatrix() {
        assertTrue(Task2.search(new int[][]{{1, 3, 5}, {7, 9, 11}}, 7));
    }

    @Test
    void targetSmallerThanAllElementsReturnsFalse() {
        assertFalse(Task2.search(new int[][]{{1, 3, 5}, {7, 9, 11}}, 0));
    }

    @Test
    void targetLargerThanAllElementsReturnsFalse() {
        assertFalse(Task2.search(new int[][]{{1, 3, 5}, {7, 9, 11}}, 12));
    }

    @Test
    void targetBetweenRowsReturnsFalse() {
        assertFalse(Task2.search(new int[][]{{1, 3, 5}, {7, 9, 11}}, 6));
    }

    @Test
    void nonSquareMatrixContainsTarget() {
        assertTrue(Task2.search(new int[][]{{1, 2, 3, 4}, {5, 6, 7, 8}}, 6));
    }

    @Test
    void negativeNumbersContainTarget() {
        assertTrue(Task2.search(new int[][]{{-10, -5, 0}, {5, 10, 15}}, -5));
    }

    @Test
    void largeMatrixContainsTarget() {
        int[][] matrix = new int[100][100];
        int value = 0;
        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {
                matrix[row][col] = value++;
            }
        }
        assertTrue(Task2.search(matrix, 9999));
        assertFalse(Task2.search(matrix, 10000));
    }

}
