import java.util.HashMap;

public class MinWindow {
    public static void main(String[] args) {
        String s="XDOBECODEBANC";
        String t="ECD";
        int minlen=Integer.MAX_VALUE;
        String ans="";
        int left=0;
        HashMap<Character,Integer> map=new HashMap<>();
        for (int i = 0; i < t.length(); i++) {
            
                map.putIfAbsent(t.charAt(i),0);
            
        }
        for(int right=0;right<s.length();right++){
            char cur=s.charAt(right);
            if(map.containsKey(cur)){
                map.put(cur,map.get(cur)+1);
                boolean allvalid=true;
                for(int value:map.values()){
                    if(value==0){
                        allvalid=false;
                    }
                }

                if(allvalid){
                    minlen=Math.min(minlen,right-left+1);
                    ans=s.substring(left,right);

                }
            }else if(right-left<1){
                left++;
            }

            if((right-left+1)>minlen){
                if(map.containsKey(s.charAt(left))){
                    map.put(s.charAt(left),map.get(s.charAt(left))-1);

                }
                left++;
            }

            while(!map.containsKey(s.charAt(left))){
                left++;
            }
            

        }
        System.out.println(ans);
    }
}
