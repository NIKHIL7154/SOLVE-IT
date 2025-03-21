
public class best {
    public static void main(String[] args) {
        int[] arr={7,1,5,3,6,4};
        int sm=Integer.MAX_VALUE;
        int sum=0;

        for(int i=0;i<arr.length;i++){
            sm=Math.min(sm,arr[i]);
            if(arr[i]>sm){
                sum=Math.max(sum,arr[i]-sm);
            }
        }
        System.out.println(sum);
    }
}
