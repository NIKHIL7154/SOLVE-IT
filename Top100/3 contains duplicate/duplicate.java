import java.util.*;


public class duplicate {
    public static void main(String[] args) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] arr={1,2,3,4,5,8,8};
        for(int i : arr){
            if(map.containsKey(i)){
                System.out.println("True");
                break;
            }
            map.put(i,i);
        }
        System.out.println("Checking completed");
    }
}
