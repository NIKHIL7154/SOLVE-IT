import java.util.HashMap;

public class Anagram {
    public static void main(String[] args) {
        String s="eate";
        String t="ate";
        System.out.println(checkAnagram(s, t));


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
}
