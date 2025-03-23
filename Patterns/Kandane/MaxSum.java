import java.util.Arrays;

public class MaxSum {
    int[] arr;

    // int[] arr = { 2, 4, -5, -10, 2, 6, -3 };
    public MaxSum(int[] arr) {
        this.arr = arr;
    }

    public void maxSumSubarray() {
        int glob = arr[0];
        int curmax = 0;
        for (int i = 0; i < arr.length; i++) {
            curmax = Math.max(curmax + arr[i], arr[i]);
            glob = Math.max(glob, curmax);
        }
        System.out.println("Maximum sum : " + glob);
    }

    public void maxSumCircular() {
        int globmax = arr[0];
        int curmax = 0;
        int curmin = 0;
        int globmin = arr[0];
        int total = 0;
        for (int i = 0; i < arr.length; i++) {
            curmax = Math.max(curmax + arr[i], arr[i]);
            curmin = Math.min(curmin + arr[i], arr[i]);
            total += arr[i];

            globmax = Math.max(curmax, globmax);
            globmin = Math.min(curmin, globmin);

        }
        if (globmax < 0) {
            System.out.println("Maximum in circular is : " + globmax);
        } else {
            System.out.println("Maximum in circular is : " + Math.max(total - globmin, globmax));

        }

    }

    public static void main(String[] args) {
        int[] arr = { 2, 4, -5, -10, 2, 6, -3 };
        MaxSum s = new MaxSum(arr);
        s.maxSumSubarray();
        s.maxSumCircular();

    }
}
