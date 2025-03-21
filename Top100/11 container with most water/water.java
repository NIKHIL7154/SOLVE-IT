public class water {
    //two pointer approach
    public static void main(String[] args) {
        int[] arr={1,8,6,2,5,4,8,3,7};
        int i=0;
        int j=arr.length-1;
        int water=0;

        while(i<j){
            int h=Math.min(arr[i],arr[j]);
            water=Math.max(water,h*(j-i));
            if(arr[i]<arr[j]){
                i++;

            }else{
                j--;
            }
        }
        System.out.println(water);
    }
}
