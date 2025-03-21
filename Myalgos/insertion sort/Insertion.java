
import java.util.Arrays;

public class Insertion {

    public static void main(String[] args) {
        int[] arr = {4, 8, 3, 4, 2, 7, 5, 6};
        for (int i = 1; i < arr.length; i++) {
            int cur = arr[i];
            int j = i - 1;
            while (j >= 0 && arr[j] > cur) {
                arr[j + 1] = arr[j];
                j--;
            }
            arr[j + 1] = cur;

        }
        System.out.println(Arrays.toString(arr));
    }
}
