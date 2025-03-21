
import java.util.Arrays;

public class quicksort {

    static int getPivIndex(int[] arr, int l, int r) {
        int i = l - 1;
        int piv = arr[r];
        System.out.println(piv);
        for (int j = l; j < r; j++) {
            if (arr[j] < piv) {
                i++;
                int temp = arr[j];
                arr[j] = arr[i];
                arr[i] = temp;
            }

        }

        i++;
        arr[r] = arr[i];
        arr[i] = piv;
        return i;
    }

    static void quicksorting(int[] arr, int l, int r) {
        if (l >= r) {
            return;
        }

        int piv = getPivIndex(arr, l, r);
        System.out.println(piv);

        System.out.println("Left call " + Arrays.toString(arr) + l + " " + (piv - 1));
        quicksorting(arr, l, piv - 1);
        System.out.println("right call " + Arrays.toString(arr) + (piv + 1) + " " + r);
        quicksorting(arr, piv + 1, r);
    }

    public static void main(String[] args) {
        int[] arr = {5, 2, 9, 7, 3, 10, 45, 0, 6, 0, 0, 0, 5, 5, 5};
        System.out.println(Arrays.toString(arr));
        quicksorting(arr, 0, arr.length - 1);
        System.out.println(Arrays.toString(arr));
    }
}
