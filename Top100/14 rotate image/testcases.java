import java.util.Arrays;

public class testcases {

    static void inplaceTranspose(int[][] arr) {
        int i = 0, j = 0;
        int n = arr.length;
        while (i < n && j < n) {
            for (int k = i + 1; k < n; k++) {
                int temp = arr[i][k];
                arr[i][k] = arr[k][j];
                arr[k][j] = temp;
            }
            i++;
            j++;
        }
    }

    static void reverseEachRow(int[][] arr) {
        for (int[] row : arr) {
            int i = 0;
            int j = row.length - 1;
            while (i < j) {
                int temp = row[i];
                row[i] = row[j];
                row[j] = temp;
                i++;
                j--;
            }
        }
    }

    static int[][] rotateMatrixCorrectly(int[][] arr) {
        int n = arr.length;
        int[][] rotated = new int[n][n];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                rotated[j][n - 1 - i] = arr[i][j];
            }
        }
        return rotated;
    }

    static boolean compareMatrices(int[][] a, int[][] b) {
        if (a.length != b.length || a[0].length != b[0].length) return false;
        for (int i = 0; i < a.length; i++) {
            if (!Arrays.equals(a[i], b[i])) return false;
        }
        return true;
    }

    static void testMatrixRotation(int[][] matrix) {
        int[][] original = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++)
            original[i] = matrix[i].clone();

        // Apply your method
        inplaceTranspose(matrix);
        reverseEachRow(matrix);

        // Compute correct rotation
        int[][] expected = rotateMatrixCorrectly(original);

        // Print results
        System.out.println("Original Matrix:");
        for (int[] row : original) System.out.println(Arrays.toString(row));

        System.out.println("\nYour Rotated Matrix:");
        for (int[] row : matrix) System.out.println(Arrays.toString(row));

        System.out.println("\nExpected Rotated Matrix:");
        for (int[] row : expected) System.out.println(Arrays.toString(row));

        if (compareMatrices(matrix, expected)) {
            System.out.println("\n✅ Your implementation works correctly!\n");
        } else {
            System.out.println("\n❌ Your implementation is incorrect!\n");
        }
    }

    public static void main(String[] args) {
        int[][][] testCases = {
            { // 4x4 square matrix
                {1, 2, 3, 4},
                {5, 6, 7, 8},
                {9, 10, 11, 12},
                {13, 14, 15, 16}
            },
            { // 3x3 square matrix
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },
            { // 2x2 matrix
                {1, 2},
                {3, 4}
            },
            { // 5x5 matrix with negative numbers
                {-1, -2, -3, -4, -5},
                {-6, -7, -8, -9, -10},
                {-11, -12, -13, -14, -15},
                {-16, -17, -18, -19, -20},
                {-21, -22, -23, -24, -25}
            }
        };

        for (int[][] testCase : testCases) {
            testMatrixRotation(testCase);
            System.out.println("--------------------------------------------------");
        }
    }
}
