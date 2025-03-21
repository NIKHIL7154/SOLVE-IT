
import java.util.Arrays;

public class Selection {

    public static void main(String[] args) {

        int[] arr = {1, 8, 3, 4, 5, 0, 7, 6};

        for (int i = 0; i < arr.length; i++) {
            int sm = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[sm]) {
                    sm = j;
                }

            }
            int temp = arr[i];
            arr[i] = arr[sm];
            arr[sm] = temp;
        }
        System.out.println(Arrays.toString(arr));
    }
}
