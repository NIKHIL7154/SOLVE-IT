
import java.util.Arrays;

public class merge {

    static void mergeit(int[] arr, int l, int mid, int r) {
        System.out.println(Arrays.toString(arr));

        int ind1 = l;
        int ind2 = mid + 1;
        int[] res = new int[r - l + 1];
        int x = 0;
        while (ind1 <= mid && ind2 <= r) {
            if (arr[ind1] < arr[ind2]) {
                res[x++] = arr[ind1++];
            } else {
                res[x++] = arr[ind2++];
            }
        }

        while (ind1 <= mid) {
            res[x++] = arr[ind1++];
        }
        while (ind2 <= r) {
            res[x++] = arr[ind2++];
        }
        x = 0;
        for (int k = l; k <= r; k++) {
            arr[k] = res[x++];
        }

    }

    static void divide(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int mid = l + (r - l) / 2;
        divide(arr, l, mid);
        divide(arr, mid + 1, r);
        mergeit(arr, l, mid, r);
    }

    public static void main(String[] args) {
        int[] arr = {4, 8, 2, 3, 4, 7, 3, 7};
        divide(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
