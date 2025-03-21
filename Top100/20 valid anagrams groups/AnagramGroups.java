import java.util.*;

public class AnagramGroups {
    public static void main(String[] args) {
        String[] s={"ate","stop","eat","post","tea","stope"};
        //using same char sum and same length are anagrams
        HashMap<Integer,ArrayList<String>> map=new HashMap<>();
        

        for(String a:s){
            int sum =calculateSum(a);
            if(map.containsKey(sum)){
                String b=map.get(sum).get(0);
                if(checkAnagram(a, b)){
                    map.get(sum).add(a);
                }

            }else{
                ArrayList<String> anas=new ArrayList<>();
                anas.add(a);
                map.put(sum,anas);
            }
        }
        for(ArrayList<String> arr:map.values()){
            System.out.println(arr);
        }


    }
    public static boolean checkAnagram(String s, String t){
        if(s.length()!=t.length()){
            return false;
        }
        
        HashMap<Character,Integer> map=new HashMap<>();
        for(int i=0;i<s.length();i++){
            map.put(s.charAt(i),map.getOrDefault(s.charAt(i),0)+1);
        }
        for(int i=0;i<t.length();i++){
            char c=t.charAt(i);
            int val= map.getOrDefault(c, -1);
            if(val>0){
                map.put(c,val-1);
            }else{
                return false;
            }
        }

        return true;
    }
    public static int calculateSum(String a){
        Map<Character,Integer> vals=Map.of('a',1,'t',20,'e',5,'s',19,'o',15,'p',16);
        int sum=0;
        for(int i=0;i<a.length();i++){
            sum+=vals.get(a.charAt(i));
        }
        return sum;
    }

}
