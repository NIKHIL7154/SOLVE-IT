

import java.util.*;

//o(n * k)
public class AnagramGroupOptimized {
    public static void main(String[] args) {
        String[] s={"ate","stop","eat","post","tea","stope"};
        HashMap<String,ArrayList<String>> map =new HashMap<>();
        for(String cur:s){
            String key=generateKey(cur);
            map.putIfAbsent(key, new ArrayList<>());
            map.get(key).add(cur);
        }

        for(ArrayList<String> cur:map.values()){
            System.out.println(cur);
        }
        
    }

    public static String generateKey(String s){
        int[] arr=new int[26];
        for(char c:s.toCharArray()){
            arr[c-'a']+=1;
        }
        return Arrays.toString(arr);
    }
}
