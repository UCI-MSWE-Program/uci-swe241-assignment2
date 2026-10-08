public class Task2 {

    /**
     * Searches for {@code target} in {@code matrix}, where each row is sorted
     * in ascending order and the first element of each row is greater than the
     * last element of the previous row. The matrix is treated as a single
     * sorted sequence of rows laid end to end.
     *
     * <p>Time complexity: O(log(r * c)), where r and c are the number of rows
     * and columns respectively. Space complexity: O(1).
     *
     * @param matrix the 2D matrix to search
     * @param target the value to search for
     * @return true if {@code target} is present in the matrix, otherwise false
     */
    public static boolean search(int[][] matrix, int target) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return false;
        }

        int rowCount = matrix.length;
        int columnCount = matrix[0].length;

        // Binary search over the flattened matrix indices.
        int low = 0;
        int high = rowCount * columnCount - 1;

        while (low <= high) {
            int middleIndex = (low + high) >>> 1;
            int middleRow = middleIndex / columnCount;
            int middleColumn = middleIndex % columnCount;
            int middleValue = matrix[middleRow][middleColumn];

            if (middleValue == target) {
                return true;
            }
            if (middleValue < target) {
                low = middleIndex + 1;
            } else {
                high = middleIndex - 1;
            }
        }

        return false;
    }

}
