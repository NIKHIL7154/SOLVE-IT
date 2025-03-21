
import java.util.Arrays;

public class product {

    public static void main(String[] args) {
        int[] arr = {1, 2, 3, 4};
        // here methods can be different but a simple method you can follow is get the product of whole array and then for every 
        //specific value you can divide the whole product with ith element to get product without i
        //now key considerations are if there is 0 then above method will not work
        // second is that if the array is very big it may cause integer overflow
        // for all this we will use prefix product and suffix product
        int[] prefix = new int[arr.length];
        int[] suffix = new int[arr.length];

        for (int i = 0; i < arr.length; i++) {
            prefix[i] = 1;
            suffix[i] = 1;
        }

        for (int i = 1; i < arr.length; i++) {
            prefix[i] = prefix[i - 1] * arr[i - 1];

        }
        for (int i = arr.length - 2; i >= 0; i--) {
            suffix[i] = suffix[i + 1] * arr[i + 1];
        }

        System.out.println(Arrays.toString(prefix) + " d " + Arrays.toString(suffix));
        int[] res = new int[arr.length];
        for (int i = 0; i < arr.length; i++) {
            res[i] = prefix[i] * suffix[i];

        }

        System.out.println(Arrays.toString(res));

    }
}
