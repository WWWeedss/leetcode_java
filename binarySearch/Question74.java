package binarySearch;

public class Question74 {
    public boolean searchMatrix(int[][] matrix, int target) {
        int m = matrix.length, n = matrix[0].length;
        int left = 0, right = m * n - 1;
        while(left <= right) {
            int mid = left + (right - left) / 2;
            int x = mid / n;
            int y = mid % n;
            if (matrix[x][y] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        if (left >= m * n) {
            return false;
        }
        int x = left / n, y = left % n;
        return matrix[x][y] == target;
    }

    public static void main(String[] args) {
        int[][] matrix = new int[][]{{1, 1}};
        System.out.println(new Question74().searchMatrix(matrix, 2));
    }
}
