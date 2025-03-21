import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class twosum {
    public static int[] twoSum(int[] nums, int target) {
        Map<Integer,Integer> map=new HashMap<>();
        int[] result={0,0};
        for(int i=0;i<nums.length;i++){
            if(map.containsKey(target-nums[i])){
                result[0]=map.get(target-nums[i]);
                result[1]=i;
                break;
            }
            map.put(nums[i], i);
        }
        return result;
    }
    public static void main(String[] args) {
        int[] nums = {2, 7, 11, 15, 3, 6};
        int target = 10;
        int[] result = twoSum(nums,target);
        System.out.println(Arrays.toString(result));

        
    }
}
